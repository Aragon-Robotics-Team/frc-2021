package frc.robot.subsystems.shooter;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Funnel extends SubsystemBase {
    private CANSparkMax leftWheels = new CANSparkMax(Constants.LEFT_FUNNEL_PORTS, MotorType.kBrushless);
    private CANSparkMax rightWheels = new CANSparkMax(Constants.RIGHT_FUNNEL_PORTS, MotorType.kBrushless);

    public Funnel() {
        leftWheels.setInverted(true);
    }
    
    public void setZero() {
        leftWheels.setVoltage(0);
        rightWheels.setVoltage(0);
    }
    
    public void setIn() {
        leftWheels.setVoltage(Constants.FUNNEL_SPEED);
        rightWheels.setVoltage(Constants.FUNNEL_SPEED);
    }

    public void setReverse() {
        leftWheels.setVoltage(-Constants.FUNNEL_SPEED);
        rightWheels.setVoltage(-Constants.FUNNEL_SPEED);
    }
}
