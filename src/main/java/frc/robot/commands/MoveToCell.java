// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MoveToCell extends CommandBase {
  public MoveToCell() {
    addRequirements(Robot.limelight);
    addRequirements(Robot.drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    Robot.limelight.previousTx = Robot.limelight.tx;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    double horizOffset = Robot.limelight.tx;
    double baseSpeed = Robot.limelight.getEstimatedDistance() * Constants.KSPEED;

    if (Math.abs(horizOffset) < Constants.MIN_HORIZ_OFFSET) {
      Robot.drivetrain.setLeftMotor(baseSpeed);
      Robot.drivetrain.setRightMotor(-baseSpeed);
    } else if (horizOffset < 0) {
      Robot.drivetrain.setLeftMotor(baseSpeed + horizOffset * Constants.KTURNSPEED);
      Robot.drivetrain.setRightMotor(-(baseSpeed - horizOffset * Constants.KTURNSPEED));
    } else {
      Robot.drivetrain.setRightMotor(-(baseSpeed + horizOffset * Constants.KTURNSPEED));
      Robot.drivetrain.setLeftMotor(baseSpeed - horizOffset * Constants.KTURNSPEED);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return Robot.limelight.getEstimatedDistance() <= Constants.FINAL_DISTANCE;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setLeftMotor(0);
    Robot.drivetrain.setRightMotor(0);
  }
}
