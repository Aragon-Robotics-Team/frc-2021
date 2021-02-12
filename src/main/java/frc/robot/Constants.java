// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Almost all values are placeholders

    // Constants for ArcadeDrive & PID

    public static final int LEFT_MOTOR_SLAVE = 1;
    public static final int RIGHT_MOTOR_SLAVE = 5;
    public static final int LEFT_MOTOR_MASTER = 8;
    public static final int RIGHT_MOTOR_MASTER = 2;

    public static final int JOYSTICK_PORT = 4;

    public static final double SPEED_MULT = 0.6;
    public static final double TURN_MULT = 0.3;

    public static final double TICKS_TO_FEET = 1.0 / 128 * 6 * Math.PI / 12;
    public static final double KP = 10;
    public static final double KI = 10;
    public static final double KD = 10;
    public static final double I_LIMIT = 1;

    public static final int PID_STOP_TIME = 1;
    public static final double PID_TIMER_START = 0.05;

    // Constants for AutoNav

    public static final double kS = 1.0;
    public static final double kV = 1.0;
    public static final double kA = 1.0;

    public static final double kTrackwidthMeters = 0.69;
    public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
            kTrackwidthMeters);
    public static final double kGearRatio = 3;
    public static final double kWheelRadiusInches = 3.0;

    // Limelight
    public static final double MOUNTING_ANGLE = 0;
    public static final double MOUNTING_HEIGHT = 1;
    public static final double TARGET_HEIGHT = 7.0 / 12.0;

    // FindMiddleCell
    public static final double JUMP_SIGNAL = 5.0;

    // MoveToCell
    public static final double KSPEED = 0.6 / 15.0;
    public static final double MIN_HORIZ_OFFSET = 1.5;
    public static final double KTURNSPEED = 0.4 / 27.0;
    public static final double FINAL_DISTANCE = 9.0 / 12.0; // 9/12 is 9 inches (9/12 feet)

    // finclell
    public static final double LOWER_BOUND = -25.0;
    public static final double UPPER_BOUND = 25.0;
    public static final double CERTAIN_SPEED = 0.6;

    // Flywheel
    public static final int MOTOR_PORT = 1;
    public static final int MOTOR_PORT_SLAVE = 1;
    public static final boolean INVERT_ALL = false;
    public static final boolean INVERT_SLAVE = true;

    //Fun-elle
    public static final int LEFT_FUNNEL_PORTS = 3;
    public static final int RIGHT_FUNNEL_PORTS = 6;
    public static final double FUNNEL_SPEED = 0.7;

    //t o w e r
    public static final int TOWER_PORT = 7;
    public static final double TOWER_SPEED = 0.5;
    public static final double FOUR = 4.0;

    // INTAKEEEE
    // arm
    public static final int solenoidLeftFwd = 0;
    public static final int solenoidLeftRev = 7;
    public static final int solenoidRightFwd = 1;
    public static final int solenoidRightRev = 6;
    public static final int pcmId = 2;
    // rollerrrrrr
    public static final int ROLLER_MOTOR = 4;
    public static final int VOLTS_FULL = 12;
    public static final int RAMP_TIME = 1;
    public static final double ROLL_TIME = 2.0;

    // SHOOTEer
    public static final int hSolenoidLeftFwd = 2;
    public static final int hSolenoidLeftRev = 3;
    public static final int hSolenoidRightFwd = 4;
    public static final int hSolenoidRightRev = 5;

    // Autonav constants
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    // placeholder ports
    public static final double kLeftMotor1Port = 1;
    public static final double kLeftMotor2Port = 1;
    public static final double kRightMotor1port = 1;
    public static final double kRightMotor2port = 1;

    public static final int[] kLeftEncoderPorts = { 0, 1 };
    public static final boolean kLeftEncoderReversed = false;
    public static final int[] kRightEncoderPorts = { 0, 1 };
    public static final boolean kRightEncoderReversed = true;
    public static final double ksVolts = 0;
    public static double kEncoderDistancePerPulse = 1;
    public static double kaVoltSecondsSquaredPerMeter;
    public static double kPDriveVel;
    public static double kvVoltSecondsPerMeter;

}
