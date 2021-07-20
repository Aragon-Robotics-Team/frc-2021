// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class FindMiddleCell extends CommandBase {

  /** Creates a new FindMiddleCell. */
  public FindMiddleCell() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.drivetrain, Robot.limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Robot.limelight.previousAngle >= 0) {
      Robot.drivetrain.setLeftMotor(-Constants.CERTAIN_SPEED);
      Robot.drivetrain.setRightMotor(Constants.CERTAIN_SPEED);
    } else {
      Robot.drivetrain.setLeftMotor(Constants.CERTAIN_SPEED);
      Robot.drivetrain.setRightMotor(-Constants.CERTAIN_SPEED);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setLeftMotor(0);
    Robot.drivetrain.setRightMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (!Robot.limelight.tv)
      return false;
    else {
      // check for jump
      return Robot.limelight.deltaTx > Constants.JUMP_SIGNAL;

      // if jump, return true
      // if no jump, return false (continue the command)
    }
  }
}
