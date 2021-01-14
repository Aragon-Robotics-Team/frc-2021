package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private CANSparkMax leftMotorSlave;
    private CANSparkMax rightMotorSlave;
    private CANSparkMax leftMotorMaster;
    private CANSparkMax rightMotorMaster;

    public Drivetrain() {
        // Create motors
        leftMotorMaster = new CANSparkMax(Constants.LEFT_MOTOR_MASTER, MotorType.kBrushless);
        rightMotorMaster = new CANSparkMax(Constants.RIGHT_MOTOR_MASTER, MotorType.kBrushless);
        leftMotorSlave = new CANSparkMax(Constants.LEFT_MOTOR_SLAVE, MotorType.kBrushless);
        rightMotorSlave = new CANSparkMax(Constants.RIGHT_MOTOR_SLAVE, MotorType.kBrushless);

        // Add following
        leftMotorSlave.follow(leftMotorMaster);
        rightMotorSlave.follow(rightMotorMaster);
    }

    public void setLeftMotor(double speed) {
        leftMotorMaster.set(speed);
    }

    public void setRightMotor(double speed) {
        rightMotorMaster.set(speed);
    }
}
