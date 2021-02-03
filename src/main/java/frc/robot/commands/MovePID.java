package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class MovePID extends CommandBase {
    private double setPoint;
    private double errorSum;
    private double lastTimestamp;
    private double lastError;
    private double correctionStartTimestamp;

    public MovePID(double inputSetPoint) {
        setPoint = inputSetPoint;

        addRequirements(Robot.drivetrain);
    }

    @Override
    public void initialize() {
        errorSum = 0;
        lastError = 0;
        lastTimestamp = Timer.getFPGATimestamp();
    }

    // @Override
    // public void execute() {
    // double encoderPos = Robot.drivetrain.getEncoderPos();

    // double error = setPoint - encoderPos;
    // double deltaTime = Timer.getFPGATimestamp() - lastTimestamp;

    // Stop "I" value early to stop staggering
    // if (Math.abs(error) < Constants.I_LIMIT) {
    // errorSum += error * deltaTime;
    // }

    // double errorRate = (error - lastError) / deltaTime;
    // double outputSpeed = Constants.KP * error + Constants.KI * errorSum +
    // Constants.KD * errorRate;

    // Robot.drivetrain.setLeftMotor(outputSpeed);
    // Robot.drivetrain.setRightMotor(-outputSpeed);

    // lastTimestamp = Timer.getFPGATimestamp();
    // lastError = error;

    // if (error <= Constants.PID_TIMER_START) {
    // correctionStartTimestamp = Timer.getFPGATimestamp();
    // }
    // }

    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - correctionStartTimestamp >= Constants.PID_STOP_TIME;
    }

    @Override
    public void end(boolean interrupted) {
        Robot.drivetrain.setLeftMotor(0);
        Robot.drivetrain.setRightMotor(0);
    }
}