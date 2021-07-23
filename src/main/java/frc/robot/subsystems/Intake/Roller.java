// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Roller extends SubsystemBase {
    private CANSparkMax motor;

    public Roller() {
        motor = new CANSparkMax(Constants.ROLLER_MOTOR, MotorType.kBrushless);

        motor.setInverted(true);

        motor.setOpenLoopRampRate(Constants.RAMP_TIME);
        motor.setClosedLoopRampRate(Constants.RAMP_TIME);

        motor.setIdleMode(IdleMode.kCoast);
    }

    public void setOn() {
        motor.setVoltage(Constants.VOLTS_FULL);
    }

    public void setOff() {
        motor.setVoltage(0);
    }
}
