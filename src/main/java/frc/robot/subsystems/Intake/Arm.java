// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Intake;

import java.util.HashMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  public DoubleSolenoid solenoidLeft;
  public DoubleSolenoid solenoidRight;

  public static enum Position {
    In, Out
  }

  private HashMap<Position, Value> posMap = new HashMap<Position, Value>();

  /** Creates a new Arm. */
  public Arm() {
    solenoidLeft = new DoubleSolenoid(Constants.pcmId, Constants.solenoidLeftFwd, Constants.solenoidLeftRev);
    solenoidRight = new DoubleSolenoid(Constants.pcmId, Constants.solenoidRightFwd, Constants.solenoidLeftRev);

    posMap.put(Position.In, Value.kReverse);
    posMap.put(Position.Out, Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(Position pos) {
    solenoidLeft.set(posMap.get(pos));
    solenoidRight.set(posMap.get(pos));
  }

  public Command armOut() {
    return new InstantCommand(() -> set(Position.Out), this);
  }

  public Command armIn() {
    return new InstantCommand(() -> set(Position.In), this);
  }
}
