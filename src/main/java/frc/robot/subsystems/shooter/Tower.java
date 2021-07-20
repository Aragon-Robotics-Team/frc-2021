package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tower extends SubsystemBase {
    
    private TalonSRX towerMotor = new TalonSRX(Constants.TOWER_PORT);
    
    public Tower() {
        
    }

    public void setZero() {
        towerMotor.set(TalonSRXControlMode.PercentOutput, 0);
    }
    
    public void setIn() {
        towerMotor.set(TalonSRXControlMode.PercentOutput, Constants.TOWER_SPEED);
    }

    public void setReverse() {
        towerMotor.set(TalonSRXControlMode.PercentOutput, -Constants.TOWER_SPEED);
    }
}
