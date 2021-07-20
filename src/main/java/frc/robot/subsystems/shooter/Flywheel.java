// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

public class Flywheel extends SubsystemBase {

    public TalonSRX flyMotorMaster = new TalonSRX(Constants.FLY_MOTOR_PORT);
    private TalonSRX flyMotorSlave = new TalonSRX(Constants.FLY_MOTOR_PORT_SLAVE);
    public int shootIteration = 1;

    /** Creates a new Flywheel. */
    public Flywheel() {
        flyMotorMaster.setInverted(false);
        flyMotorSlave.setInverted(true);
        flyMotorMaster.setNeutralMode(NeutralMode.Coast);
        flyMotorSlave.setNeutralMode(NeutralMode.Coast);
        flyMotorSlave.follow(flyMotorMaster);
    }

    public void setOn() {
        flyMotorMaster.set(TalonSRXControlMode.PercentOutput, Constants.FLY_VOLTAGE);
    }

    public void setVolt(double flyVoltage) {
        flyMotorMaster.set(TalonSRXControlMode.PercentOutput, flyVoltage);
    }

    public void setOff() {
        flyMotorMaster.set(TalonSRXControlMode.PercentOutput, 0);
    }

    public void setOnTrigger(double triggerInput) {
        flyMotorMaster.set(TalonSRXControlMode.PercentOutput, triggerInput);
    }

    public final double getRPM() {
        return (-(flyMotorMaster.getSelectedSensorVelocity()) * 5 * Constants.GEAR_RATIO / Constants.ENCODER_RES)
                * 60.0;
    }

    public void setAtRPM(double rpm) {
        // rpm = how does one do this
        /*
         * seqCommandGroup:
         * 
         * Initialize: setAtRPM(100000) isFinished: return getRPM() > k;
         * 
         * Do other stuff and turn off motors
         */
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
};