package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Tower extends SubsystemBase {
    
    //  use WPI_TalonSRX
    private WPI_TalonSRX towerMotor = new WPI_TalonSRX(Constants.TOWER_PORT);
    
    public Tower() {
        
    }
}
