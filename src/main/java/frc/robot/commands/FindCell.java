// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class FindCell extends CommandBase {
  /** Creates a new FindCell. */
  public FindCell() {
    addRequirements(Robot.limelight, Robot.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // For now, we'll turn right but things change sometimes and everything is
    // changing all the time ayayyayayy
    if (Robot.limelight.previousTx >= 0) {
      Robot.drivetrain.setLeftMotor(-Constants.CERTAIN_SPEED);
      Robot.drivetrain.setRightMotor(Constants.CERTAIN_SPEED);

    } else {
      Robot.drivetrain.setLeftMotor(Constants.CERTAIN_SPEED);
      Robot.drivetrain.setRightMotor(-Constants.CERTAIN_SPEED);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { // more commonly known as execite
    // Execute is useless here
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
    return Robot.limelight.tv
        && (Constants.LOWER_BOUND <= Robot.limelight.tx && Robot.limelight.tx <= Constants.UPPER_BOUND);
  }
}
