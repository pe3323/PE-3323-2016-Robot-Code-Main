package org.usfirst.frc.team3323.robot.commands;
 
import org.usfirst.frc.team3323.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
 
/**
 *
 * @author Markus
 */
public class SlowForwardRight extends CommandBase {
     
    private boolean isDone = false;
	private DriveTrain drivey;
     
    public SlowForwardRight( DriveTrain drivey ) {
    	this.drivey = drivey;
        requires(drivey);
    }
    
    protected void initialize() {         
    }

    protected void execute() {
        drivey.slowFWDRight();
    }
 
    protected void end() {
    }
 
    protected void interrupted() {
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
}