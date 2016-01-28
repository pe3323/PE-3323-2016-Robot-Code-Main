package org.usfirst.frc.team3323.robot.interfaces;

public interface DriveSystem {
    public void tankDrive(double leftDriveMotor, double rightDriveMotor);
    public void slowFWDLeft();
    public void slowFWDRight();
}
