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

  private TalonSRX flyMotorMaster = new TalonSRX(Constants.FLY_MOTOR_PORT);
  private TalonSRX flyMotorSlave = new TalonSRX(Constants.FLY_MOTOR_PORT_SLAVE);

  /** Creates a new Flywheel. */
  public Flywheel() {
    flyMotorMaster.setInverted(false);
    flyMotorSlave.setInverted(false);
    flyMotorMaster.setNeutralMode(NeutralMode.Brake);
    flyMotorSlave.setNeutralMode(NeutralMode.Brake);
    flyMotorSlave.follow(flyMotorMaster);
  }

  public void setOn() {
    flyMotorMaster.set(TalonSRXControlMode.PercentOutput, Constants.FLY_VOLTAGE);
  }

  public void setOff() {
    flyMotorMaster.set(TalonSRXControlMode.PercentOutput, 0);
  }

  public void setAtRPM(int rpm) {
    // rpm = how does one do this
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
