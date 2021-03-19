// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.shooter.Shooter;

public class TestRunFlywheel extends CommandBase {
  /** Creates a new RunFlywheel. */
  public TestRunFlywheel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Shooter.flywheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = Robot.joystick.getRawAxis(Constants.TRIGGER_AXIS) * Constants.FLY_TRIGGER_CONSTANT;

    Shooter.flywheel.setOnTrigger(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.flywheel.setOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
