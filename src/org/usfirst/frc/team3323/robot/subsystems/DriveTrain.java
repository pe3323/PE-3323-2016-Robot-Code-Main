/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3323.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc.team3323.robot.Diagnostic;
import org.usfirst.frc.team3323.robot.Robot;
import org.usfirst.frc.team3323.robot.RobotMap;
import org.usfirst.frc.team3323.robot.commands.DriveWithJoysticks;
import org.usfirst.frc.team3323.robot.interfaces.DriveSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ssavard16
 */
public class DriveTrain extends RobotPart implements DriveSystem
{
  private SpeedController leftMotor;
  private SpeedController rightMotor;
  private Robot robot;

  public DriveTrain(Robot robot)
  {
    super("DriveTrain");
    this.robot = robot;
    leftMotor = new Jaguar(RobotMap.leftDriveMotor);
    rightMotor = new Jaguar(RobotMap.rightDriveMotor);
  }

  public void initDefaultCommand()
  {
    setDefaultCommand(new DriveWithJoysticks(robot.getDriveTrain(), robot.getOperatorControls()));
  }

  public void tankDrive(double leftDriveMotor, double rightDriveMotor)
  {
    leftMotor.set(rightDriveMotor);
    rightMotor.set(leftDriveMotor);
  }

  public void off()
  {
    tankDrive(0.0, 0.0);
  }

  public void slowFWDLeft()
  {
    tankDrive(0.5, -0.25);
  }

  public void slowFWDRight()
  {
    tankDrive(.25, -.5);
  }

  public List<Diagnostic> getDiagnostics()
  {
    List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
    diagnostics.add( new Diagnostic( "leftMotor", leftMotor.get() ) );
    diagnostics.add( new Diagnostic( "leftInverted", leftMotor.getInverted() ) );
    diagnostics.add( new Diagnostic( "rightMotor", rightMotor.get() ) );
    diagnostics.add( new Diagnostic( "rightInverted", rightMotor.getInverted() ) );
    return diagnostics;
  }
}