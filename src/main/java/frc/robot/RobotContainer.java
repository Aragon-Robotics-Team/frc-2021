// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.List;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import frc.robot.subsystems.Drivetrain;

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

    // public Command getAutonomousCommand() {
    // final Drivetrain m_robotDrive;

    // // Create a voltage constraint to ensure we don't accelerate too fast
    // var autoVoltageConstraint = new DifferentialDriveVoltageConstraint(new
    // SimpleMotorFeedforward(Constants.ksVolts,
    // Constants.kvVoltSecondsPerMeter, Constants.kaVoltSecondsSquaredPerMeter),
    // Constants.kDriveKinematics,
    // 10);

    // // Create config for trajectory
    // TrajectoryConfig config = new
    // TrajectoryConfig(Constants.kMaxSpeedMetersPerSecond,
    // Constants.kMaxAccelerationMetersPerSecondSquared)
    // // Add kinematics to ensure max speed is actually obeyed
    // .setKinematics(Constants.kDriveKinematics)
    // // Apply the voltage constraint
    // .addConstraint(autoVoltageConstraint);

    // // An example trajectory to follow. All units in meters.
    // Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
    // // Start at the origin facing the +X direction
    // new Pose2d(0, 0, new Rotation2d(0)),
    // // Pass through these two interior waypoints, making an 's' curve path
    // List.of(new Translation2d(1, 1), new Translation2d(2, -1)),
    // // End 3 meters straight ahead of where we started, facing forward
    // new Pose2d(3, 0, new Rotation2d(0)),
    // // Pass config
    // config);

    // RamseteCommand ramseteCommand = new RamseteCommand(
    // exampleTrajectory,
    // m_robotDrive::getPose,
    // new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
    // new SimpleMotorFeedforward(Constants.ksVolts,
    // Constants.kvVoltSecondsPerMeter,
    // Constants.kaVoltSecondsSquaredPerMeter),
    // Constants.kDriveKinematics,
    // m_robotDrive::getWheelSpeeds,
    // new PIDController(Constants.kPDriveVel, 0, 0, 0, null, null),
    // new PIDController(Constants.kPDriveVel, 0, 0, 0, null, null),
    // // RamseteCommand passes volts to the callback
    // m_robotDrive::tankDriveVolts,
    // m_robotDrive
    // );

    // // Reset odometry to the starting pose of the trajectory.
    // m_robotDrive.resetOdometry(exampleTrajectory.getInitialPose());

    // // Run path following command, then stop at the end.
    // return ramseteCommand.andThen(() -> m_robotDrive.tankDriveVolts(0, 0));
    // }

    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
    }
}
