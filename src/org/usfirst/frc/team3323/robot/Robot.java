package org.usfirst.frc.team3323.robot;

import org.usfirst.frc.team3323.robot.subsystems.Arm;
import org.usfirst.frc.team3323.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	private DriveTrain driveMarkus;
	private OI OmarkusI;
    private Arm arm;
    private Command autoMarkus;

   public void robotInit() {
	   driveMarkus = new DriveTrain( this );
	   arm = new Arm( this );
	   OmarkusI = new OI( this );	   	 
	   
//       autoMarkus = new AutonomousMode( this )        
   }

   public void autonomousInit() {
       autoMarkus.start();
   }

   public void autonomousPeriodic() {
       Scheduler.getInstance().run();
   }

   public void teleopInit() {
         if(autoMarkus != null) {
           autoMarkus.cancel();
//           autonomousCommand = null;
       }
   }
   
   public void teleopPeriodic() {
       Scheduler.getInstance().run();
   }
    
   public void testPeriodic() {
       LiveWindow.run();
   }
   
public DriveTrain getDrive() {
	return driveMarkus;
}

public Arm getArm() {
	return arm;
}

public OI getOperatorControls() {
	return OmarkusI;
}
   
   
}