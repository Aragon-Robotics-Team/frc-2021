// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.shooter.Shooter;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RunFlywheel extends CommandBase {
  /** Creates a new RunFlywheel. */
  private double initTime;
  private double desiredRPM;

  private Button incrementButton; 
  private Button decrementButton;
  
  public RunFlywheel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Shooter.flywheel);
    incrementButton = new JoystickButton(Robot.joystick, Constants.TEST_FLYWHEEL_UP);
    decrementButton = new JoystickButton(Robot.joystick, Constants.TEST_FLYWHEEL_DOWN);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initTime = Timer.getFPGATimestamp();
    desiredRPM = 6000; //For shooting tests, change RPM
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //If statement to increment RPM for testing without restarting robot - ONLY FOR TESTING - Needs to be able to be run in between shooting balls? -> Repeat ShootCell
    if (incrementButton.get()) {
      desiredRPM += 50;
    } else if (decrementButton.get()) {
      desiredRPM -= 50;
    }

    double voltage = 0.01 + 0.01 * (Timer.getFPGATimestamp() - initTime);

    Shooter.flywheel.setVolt(voltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Shooter.flywheel.getRPM() >= desiredRPM;
  }
}
