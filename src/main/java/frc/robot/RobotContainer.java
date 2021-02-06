// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }
  
  public static Command getAutonomousCommand(Trajectory trajectory) {
    TrajectoryConfig config = new TrajectoryConfig(
        Units.feetToMeters(2.0), Units.feetToMeters(2.0));
    config.setKinematics(Robot.drivetrain.getKinematics());

    RamseteCommand Command = new RamseteCommand(
        trajectory,
        Robot.drivetrain::getPose,
        new RamseteController(2, .7),
        Robot.drivetrain.getFeedforward(),
        Robot.drivetrain.getKinematics(),
        Robot.drivetrain::getSpeeds,
        Robot.drivetrain.getLeftPIDController(),
        Robot.drivetrain.getRightPIDController(),
        Robot.drivetrain::setOutputVolts,
        Robot.drivetrain
    );

    return Command.andThen(() -> Robot.drivetrain.setOutputVolts(0, 0));
  }

  public void reset() {
    Robot.drivetrain.reset();
  }
  

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }
}
