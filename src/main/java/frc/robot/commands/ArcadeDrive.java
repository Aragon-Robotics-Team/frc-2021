// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ArcadeDrive extends CommandBase {
    public ArcadeDrive() {
        addRequirements(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        double speed = -Robot.joystick.getRawAxis(1) * Constants.SPEED_MULT;
        double turn = Robot.joystick.getRawAxis(0) * Constants.TURN_MULT;

        // Quick maths to get left and right
        double left = speed + turn;
        double right = speed - turn;

        Robot.drivetrain.setLeftMotor(left);
        Robot.drivetrain.setRightMotor(right);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.setLeftMotor(0);
        Robot.drivetrain.setRightMotor(0);
    }
}
