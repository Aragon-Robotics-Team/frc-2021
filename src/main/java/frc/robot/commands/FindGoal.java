// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class FindGoal extends CommandBase {
    /** Creates a new FindGoal. */
    // For now this turns with drivetrain, but it would be better with turret
    public FindGoal() {
        addRequirements(Robot.limelight, Robot.drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (Robot.limelight.tv) { //Does it see target?
            if (Robot.limelight.tx > 0) { //Target on right -> turn right
                Robot.drivetrain.setLeftMotor(Constants.CERTAIN_SPEED);
                Robot.drivetrain.setRightMotor(-Constants.CERTAIN_SPEED);
            } else if (Robot.limelight.tx < 0) { //Target on left -> turn left
                Robot.drivetrain.setLeftMotor(-Constants.CERTAIN_SPEED);
                Robot.drivetrain.setRightMotor(Constants.CERTAIN_SPEED);
            }
        } else { //Don't see target? Turn right until target is in sight
            Robot.drivetrain.setLeftMotor(Constants.CERTAIN_SPEED);
            Robot.drivetrain.setRightMotor(-Constants.CERTAIN_SPEED);
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      Robot.drivetrain.setLeftMotor(0);
      Robot.drivetrain.setRightMotor(0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() { //If target is close enough to aligned, turn off motors and go to next shoot command
        return Robot.limelight.tv
        && (-0.25 <= Robot.limelight.tx && Robot.limelight.tx <= 0.25);
    }
}
