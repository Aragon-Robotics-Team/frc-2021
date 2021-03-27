// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;

public class RampDownFlywheel extends CommandBase {
  private double initTime;
  private double desiredRPM;
  /** Creates a new RampDownFlywheel. */
  public RampDownFlywheel() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Shooter.flywheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initTime = Timer.getFPGATimestamp();
    desiredRPM = 100; // low enough that we can immediately turn flywheel off after it ramps down to this rpm
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double voltage = 0.1 + 0.01 * (Timer.getFPGATimestamp() - initTime);

    Shooter.flywheel.setVolt(RunFlywheel.endVoltage - voltage);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.flywheel.setOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Shooter.flywheel.getRPM() <= desiredRPM;
  }
}
