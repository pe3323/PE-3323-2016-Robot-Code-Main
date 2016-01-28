/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3323.robot.commands;

import org.usfirst.frc.team3323.robot.OI;
import org.usfirst.frc.team3323.robot.subsystems.DriveTrain;

public class DriveWithJoysticks extends CommandBase {
    
    private OI operatorControls;
	private DriveTrain drivey;

	public DriveWithJoysticks( DriveTrain drivey, OI operatorControls ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.operatorControls = operatorControls;
    	this.drivey = drivey;
        requires(drivey);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftSpeed = 0;
    	double rightSpeed = 0;

        drivey.tankDrive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
