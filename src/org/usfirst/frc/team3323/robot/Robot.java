package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3323.robot.subsystems.Arm;
import org.usfirst.frc.team3323.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3323.robot.subsystems.RobotPart;

import java.util.ArrayList;
import java.util.List;

public class Robot extends IterativeRobot
{
  private DriveTrain driveTrain;
  private OI operatorControls;
  private Arm humerus;
  private Arm radius;
  private List<RobotPart> robotParts = new ArrayList();

  /**
   * construct the robot
   */
  public void robotInit()
  {
    //Construct drive train
    driveTrain = new DriveTrain(this);

    //Construct operator controls
    operatorControls = new OI(this);

    //Construct the humerus part of the arm
    SpeedController humerusMotor = new Jaguar(RobotMap.humerusMotor);
    Encoder humerusEncoder = new Encoder(RoboRIOPort.ONE.getValue(), RoboRIOPort.TWO.getValue(), true, CounterBase.EncodingType.k4X);
    humerus = new Arm("humerus", humerusMotor, humerusEncoder );

    //Construct the Radius part of the arm
    SpeedController radiusMotor = new Jaguar(RobotMap.radiusMotor);
    Encoder radiusEncoder = null;
    radius = new Arm("Radius", radiusMotor, radiusEncoder);
  }

  public OI getOperatorControls()
  {
    return operatorControls;
  }

  public DriveTrain getDriveTrain()
  {
    return driveTrain;
  }

  public Arm getHumerus()
  {
    return humerus;
  }

  public Arm getRadius()
  {
    return radius;
  }

  /**
   *
   */
  public void autonomousInit()
  {
    displayRobotDiagnostics();
  }

  public void autonomousPeriodic()
  {
    Scheduler.getInstance().run();
    displayRobotDiagnostics();
  }

  /**
   *
   */
  public void teleopInit()
  {
    displayRobotDiagnostics();
  }

  public void teleopPeriodic()
  {
    Scheduler.getInstance().run();
    displayRobotDiagnostics();
  }

  private void displayRobotDiagnostics()
  {
    for( RobotPart robotPart : robotParts )
    {
      for( Diagnostic diagnostic : robotPart.getDiagnostics() )
      {
        SmartDashboard.putString( robotPart.getName() + " " + diagnostic.getName(), diagnostic.getValue().toString());
      }
    }
  }

  /**
   *
   */
  public void testPeriodic()
  {
    LiveWindow.run();
  }
}