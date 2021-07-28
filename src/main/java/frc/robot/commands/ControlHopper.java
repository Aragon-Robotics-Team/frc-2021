// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.shooter.Hopper;
import frc.robot.subsystems.shooter.Shooter;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class ControlHopper extends CommandBase {
    private Button shootButton;
    private Button offButton;

    public ControlHopper() {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(Hopper.tower, Hopper.funnel);
        shootButton = new JoystickButton(Robot.joystick, Constants.SHOOT_CELL_BUTTON);
        offButton = new JoystickButton(Robot.joystick, Constants.FUNNEL_BUTTON);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        System.out.println("Shooter Iteration: " + Shooter.flywheel.shootIteration);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if (Math.abs(RunFlywheel.desiredRPM - Shooter.flywheel.getRPM()) <= 1000)
            if (shootButton.get()) {
                Hopper.tower.setIn();
                Hopper.funnel.setReverse();
            } else {
                Hopper.tower.setZero();
                Hopper.funnel.setZero();
            }
        else {
            Hopper.tower.setZero();
            Hopper.funnel.setZero();
        }
        // System.out.println("RPM: " + Shooter.flywheel.getRPM());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        System.out.println("Ramping down and turning off");
        Hopper.funnel.setZero();
        Hopper.tower.setZero();
        Shooter.flywheel.shootIteration += 1;
        System.out.println("Shooter Iteration: " + Shooter.flywheel.shootIteration);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return offButton.get();
    }
}