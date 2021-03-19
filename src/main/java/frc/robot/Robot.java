// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.border.SoftBevelBorder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.RunFlywheel;
import frc.robot.commands.ShootCell;
import frc.robot.commands.TestRollFunnel;
import frc.robot.commands.TestRollTower;
import frc.robot.commands.TestRunFlywheel;
import frc.robot.commands.TestRunIntake;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Intake.Intake;
import frc.robot.subsystems.shooter.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    // Subsystems:
    public static Drivetrain drivetrain = new Drivetrain();
    public static Limelight limelight = new Limelight();

    // Commands:
    private ArcadeDrive arcadeDrive;
    private ShootCell shootCell;

    // OI:
    public static Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);

    public Button intakeButton = new JoystickButton(joystick, Constants.INTAKE_BUTTON);
    public Button funnelButton = new JoystickButton(joystick, Constants.FUNNEL_BUTTON);
    public Button towerButton = new JoystickButton(joystick, Constants.TOWER_BUTTON);
    public Button flywheelButton = new JoystickButton(joystick, Constants.FLYWHEEL_BUTTON);
    // public Button hoodInButton = new JoystickButton(joystick, Constants.HOOD_IN_BUTTON);
    // public Button hoodOutButton = new JoystickButton(joystick, Constants.HOOD_OUT_BUTTON);

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        // drivetrain.resetEncoder();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler. This is responsible for polling buttons, adding
        // newly-scheduled
        // commands, running already-scheduled commands, removing finished or
        // interrupted commands,
        // and running subsystem periodic() methods. This must be called from the
        // robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /** This function is called once each time the robot enters Disabled mode. */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command selected by your
     * {@link RobotContainer} class.
     */
    @Override
    public void autonomousInit() {

        // drivetrain.resetEncoder();
    }

    @Override
    public void teleopInit() {
        // drivetrain.resetEncoder();
        // arcadeDrive = new ArcadeDrive();
        // arcadeDrive.schedule();
        shootCell = new ShootCell();
        shootCell.schedule();

        intakeButton.toggleWhenPressed(new TestRunIntake());
        funnelButton.toggleWhenPressed(new TestRollFunnel());
        towerButton.toggleWhenPressed(new TestRollTower());
        // flywheelButton.toggleWhenPressed(new TestRunFlywheel());
        
        /** 
        testRunFlywheel = new TestRunFlywheel();
        testRunFlywheel.schedule();
        hoodInButton.whenPressed(Shooter.hood.hoodIn());
        hoodOutButton.whenPressed(Shooter.hood.hoodOut());
        **/
    }

    /** This function is called periodically during operator control. */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /** This function is called periodically during test mode. */
    @Override
    public void testPeriodic() {
    }
}
