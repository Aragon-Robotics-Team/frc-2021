package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;

//Auto nav improts imports

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax leftMotorSlave = new CANSparkMax(Constants.LEFT_MOTOR_SLAVE, MotorType.kBrushless);
    private CANSparkMax rightMotorSlave = new CANSparkMax(Constants.RIGHT_MOTOR_SLAVE, MotorType.kBrushless);
    private CANSparkMax leftMotorMaster = new CANSparkMax(Constants.LEFT_MOTOR_MASTER, MotorType.kBrushless);
    private CANSparkMax rightMotorMaster = new CANSparkMax(Constants.RIGHT_MOTOR_MASTER, MotorType.kBrushless);
    private Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);

    // Roshi + Luke's thing for autonav
    final SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(leftMotorMaster, leftMotorSlave);
    final SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(rightMotorMaster, rightMotorSlave);

    final DifferentialDrive m_drive = new DifferentialDrive(leftMotorMaster, rightMotorMaster);

    private final Encoder m_leftEncoder = new Encoder(Constants.kLeftEncoderPorts[0], Constants.kLeftEncoderPorts[1],
            Constants.kLeftEncoderReversed);

    private final Encoder m_rightEncoder = new Encoder(Constants.kRightEncoderPorts[0], Constants.kRightEncoderPorts[1],
            Constants.kRightEncoderReversed);

    private final Gyro m_gyro = new ADXRS450_Gyro();

    //private final DifferentialDriveOdometry m_odometry;

    // Add following
    // leftMotorSlave.follow(leftMotorMaster);
    // rightMotorSlave.follow(rightMotorMaster);

    public Drivetrain() {
        leftMotorSlave.setInverted(true);
        leftMotorMaster.setInverted(true);
    }

    public void setLeftMotor(double speed) {
        leftMotorMaster.set(speed);
    }

    public void setRightMotor(double speed) {
        rightMotorMaster.set(speed);
    }

    public double getEncoderPos() {
        return encoder.get() * Constants.TICKS_TO_FEET;
    }

    public void resetEncoder() {
        encoder.reset();
    }
}
