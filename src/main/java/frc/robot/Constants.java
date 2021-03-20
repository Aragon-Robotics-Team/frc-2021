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

    public static final int LEFT_X_AXIS = 1;
    public static final int RIGHT_X_AXIS = 4;

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
    // public static final DifferentialDriveKinematics kDriveKinematics = new
    // DifferentialDriveKinematics(
    // kTrackwidthMeters);

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
    public static final int ROLL_TIME = 2;

    // Autonav constants
    public static final double kMaxSpeedMetersPerSecond = 3;
    public static final double kMaxAccelerationMetersPerSecondSquared = 3;
    public static final double kRamseteB = 2;
    public static final double kRamseteZeta = 0.7;

    // placeholder ports
    // public static final double kLeftMotor1Port = 1;
    // public static final double kLeftMotor2Port = 1;
    // public static final double kRightMotor1port = 1;
    // public static final double kRightMotor2port = 1;

    // public static final int[] kLeftEncoderPorts = { 0, 1 };
    // public static final boolean kLeftEncoderReversed = false;
    // public static final int[] kRightEncoderPorts = { 0, 1 };
    // public static final boolean kRightEncoderReversed = true;
    public static final double ksVolts = 0;
    public static double kEncoderDistancePerPulse = 1;
    public static double kaVoltSecondsSquaredPerMeter;
    public static double kPDriveVel;
    public static double kvVoltSecondsPerMeter;

    // tower aka tunnel aka french pyramid
    //                () <-- small person
    //               /\
    //              |==|
    //              ====
    //               XX
    //              xXXx
    //              XXXX
    //              XXXX
    //              XXXX
    //             xXXXXx
    //             XXXXXX
    //             XXXXXX
    //            xXXXXXXx
    //            XXXXXXXX
    //           xXXXXXXXXx
    //           XXXXXXXXXX
    //          XXXXX  XXXXX
    //         xXXXX"  "XXXXx
    //        XXXXXxxxxxxXXXXX
    //      xXXXXX""""""""XXXXXx
    //    xXXXXXX"        "XXXXXXx
    // xxXXXXXXX            XXXXXXXxx

    public static final int TOWER_PORT = 1;
    public static final double TOWER_SPEED = 0.5;
    public static final double FOUR = 4.0;

    // the wheel flys
    public static final int FLY_MOTOR_PORT = 5;
    public static final int FLY_MOTOR_PORT_SLAVE = 7;
    public static final double FLY_VOLTAGE = 0.6;
    public static final double FLY_TRIGGER_CONSTANT = 0.8;
    public static final int TRIGGER_AXIS = 3;
    public static final double MAX_RPM = 6000;
    public static final double ENCODER_RES = 4096.0;
    public static final double GEAR_RATIO = 1.0;
    
    //Fun-elle
    public static final int LEFT_FUNNEL_PORTS = 6;
    public static final int RIGHT_FUNNEL_PORTS = 7;
    public static final double FUNNEL_SPEED = 0.7;



    /*
    Button Layout: https://lh3.googleusercontent.com/proxy/4yxUw9HDilB3aXxwCBah5cEqYzxUmfjy8SinOk6YDfjythu9zwu0d1L2G3VlhRRYZNajZn8tlqefoYg066u8VogdlhkxIhQerXLhNC6UfKqipMiXQ9LEgrzOlI8CB700HRklZMxHS5dCVwnkp2zQ0Q
        4
      3   2
        1
    
    5, 6: lb and rb
    7, 8: middle two buttons
    */
    public static final int INTAKE_BUTTON = 1;
    public static final int FUNNEL_BUTTON = 2;
    public static final int TOWER_BUTTON = 3;
    public static final int FLYWHEEL_BUTTON = 4;
    // public static final int HOOD_IN_BUTTON = 5;
    // public static final int HOOD_OUT_BUTTON = 7;
    public static final int SHOOT_CELL_BUTTON = 5;
    public static final int STOP_HOPP_AND_ROLL_BUTTON = 7; //turns off flywheel and hopper in ShootCell
    public static final int START_SHOOT_BUTTON = 8;
    public static final int TEST_FLYWHEEL_DOWN = 9;
    public static final int TEST_FLYWHEEL_UP = 10;
}
