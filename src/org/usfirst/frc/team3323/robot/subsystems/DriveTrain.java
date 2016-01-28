/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3323.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3323.robot.Robot;
import org.usfirst.frc.team3323.robot.RobotMap;
import org.usfirst.frc.team3323.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team3323.robot.interfaces.DriveSystem;


/**
 *
 * @author ssavard16
 */
public class DriveTrain extends Subsystem implements DriveSystem {
    
    private Jaguar jagLeft;
    private Jaguar jagRight;
	private Robot robot;
    
    public DriveTrain(Robot robot){
    	this.robot = robot;
        jagLeft = new Jaguar(RobotMap.leftDriveMotor);
        jagRight = new Jaguar(RobotMap.rightDriveMotor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks( robot.getDrive(), robot.getOperatorControls() ));
    }
    
	private void setDefaultCommand(DriveWithJoysticks driveWithJoysticks){
	}

	public void tankDrive(double leftDriveMotor, double rightDriveMotor){
        jagLeft.set(rightDriveMotor);
        jagRight.set(leftDriveMotor);
    }
    
    public void off(){
        tankDrive(0.0, 0.0);
    }

	public void slowFWDLeft() {
		tankDrive(0.5,-0.25);
	}

	public void slowFWDRight() {
		tankDrive(.25,-.5);
	}
}