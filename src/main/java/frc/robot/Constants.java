// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
    public static final int LEFT_MOTOR_SLAVE = 0;
    public static final int RIGHT_MOTOR_SLAVE = 1;
    public static final int LEFT_MOTOR_MASTER = 2;
    public static final int RIGHT_MOTOR_MASTER = 3;

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
}
