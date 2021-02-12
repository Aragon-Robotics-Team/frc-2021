package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.util.Units;

//Auto nav improts imports

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax leftMotorSlave = new CANSparkMax(Constants.LEFT_MOTOR_SLAVE, MotorType.kBrushless);
    private CANSparkMax rightMotorSlave = new CANSparkMax(Constants.RIGHT_MOTOR_SLAVE, MotorType.kBrushless);
    private CANSparkMax leftMotorMaster = new CANSparkMax(Constants.LEFT_MOTOR_MASTER, MotorType.kBrushless);
    private CANSparkMax rightMotorMaster = new CANSparkMax(Constants.RIGHT_MOTOR_MASTER, MotorType.kBrushless);
    private Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);
    DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(28));
    PIDController leftPIDController = new PIDController(2.95, 0, 0);
    PIDController rightPIDController = new PIDController(2.95, 0, 0);
    SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0.3, 1.96, 0.06);
    
    // Roshi + Luke's thing for autonav
    final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(leftMotorMaster, leftMotorSlave);
    final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(rightMotorMaster, rightMotorSlave);

    final DifferentialDrive m_drive = new DifferentialDrive(leftMotorMaster, rightMotorMaster);

    private final Encoder m_leftEncoder = new Encoder(Constants.kLeftEncoderPorts[0], Constants.kLeftEncoderPorts[1],
            Constants.kLeftEncoderReversed);

    private final Encoder m_rightEncoder = new Encoder(Constants.kRightEncoderPorts[0], Constants.kRightEncoderPorts[1],
            Constants.kRightEncoderReversed);

    private final Gyro m_gyro = new ADXRS450_Gyro();

    private final DifferentialDriveOdometry m_odometry;

    // Add following
    // leftMotorSlave.follow(leftMotorMaster);
    // rightMotorSlave.follow(rightMotorMaster);

    public Drivetrain() {
        leftMotorSlave.setInverted(true);
        leftMotorMaster.setInverted(true);

        m_leftEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);
        m_rightEncoder.setDistancePerPulse(Constants.kEncoderDistancePerPulse);

        resetEncoder();
        m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());

    }

    public void setLeftMotor(double speed) {
        leftMotorMaster.set(speed);
    }

    public void setRightMotor(double speed) {
        rightMotorMaster.set(speed);
    }

    @Override
    public void periodic() {
        // Update the odometry in the periodic block
        m_odometry.update(m_gyro.getRotation2d(), m_leftEncoder.getDistance(), m_rightEncoder.getDistance());
    }

    public void setBrake(boolean brakeOn) {
        if (brakeOn) {
            leftMotorMaster.setIdleMode(IdleMode.kBrake);
            leftMotorSlave.setIdleMode(IdleMode.kBrake);
            rightMotorMaster.setIdleMode(IdleMode.kBrake);
            rightMotorSlave.setIdleMode(IdleMode.kBrake);
        }
        else {
            leftMotorMaster.setIdleMode(IdleMode.kCoast);
            leftMotorSlave.setIdleMode(IdleMode.kCoast);
            rightMotorMaster.setIdleMode(IdleMode.kCoast);
            rightMotorSlave.setIdleMode(IdleMode.kCoast);
        }
    } 

    public Pose2d getPose() {
        return m_odometry.getPoseMeters();
    }

    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(m_leftEncoder.getRate(), m_rightEncoder.getRate());
    }

    public void resetEncoders() {
        m_leftEncoder.reset();
        m_rightEncoder.reset();
    }

    public void resetOdometry(Pose2d pose) {
        resetEncoders();
        m_odometry.resetPosition(pose, m_gyro.getRotation2d());
    }

    public void arcadeDrive(double fwd, double rot) {
        m_drive.arcadeDrive(fwd, rot);
    }

    public void tankDriveVolts(double leftVolts, double rightVolts) {
        m_leftMotors.setVoltage(leftVolts);
        m_rightMotors.setVoltage(-rightVolts);
        m_drive.feed();
    }

    public double getAverageEncoderDistance() {
        return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
    }

    public Encoder getLeftEncoder() {
        return m_leftEncoder;
    }

    public Encoder getRightEncoder() {
        return m_rightEncoder;
    }

    public void setMaxOutput(double maxOutput) {
        m_drive.setMaxOutput(maxOutput);
    }

    public void zeroHeading() {
        m_gyro.reset();
    }

    public double getHeading() {
        return m_gyro.getRotation2d().getDegrees();
    }

    public Rotation2d getHeading2() {
        return Rotation2d.fromDegrees(-m_gyro.getAngle());
    }

    public double getTurnRate() {
        return -m_gyro.getRate();
    }

    public double getEncoderPos() {
        return encoder.get() * Constants.TICKS_TO_FEET;
    }

    public void resetEncoder() {
        encoder.reset();

    }

    public DifferentialDriveKinematics getKinematics() {
        return kinematics;
      }

	public SimpleMotorFeedforward getFeedforward() {
        return feedforward;
	}

	public PIDController getLeftPIDController() {
		return leftPIDController;
    }
    
    public PIDController getRightPIDController() {
		return rightPIDController;
    }
    public DifferentialDriveWheelSpeeds getSpeeds() {
        return new DifferentialDriveWheelSpeeds(
            leftMotorMaster.getEncoder().getVelocity() / Constants.kGearRatio * 2 * Math.PI * Units.inchesToMeters(Constants.kWheelRadiusInches) / 60,
            rightMotorMaster.getEncoder().getVelocity() / Constants.kGearRatio * 2 * Math.PI * Units.inchesToMeters(Constants.kWheelRadiusInches) / 60
        );
      }
    
    public void setOutputVolts(double leftVolts, double rightVolts) {
        leftMotorMaster.set(leftVolts / 12);
        rightMotorMaster.set(rightVolts / 12);
      }

      public void reset() {
        m_odometry.resetPosition(new Pose2d(), getHeading2());
      }

}
