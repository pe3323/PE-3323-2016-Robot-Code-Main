package org.usfirst.frc.team3323.robot.subsystems;

import org.usfirst.frc.team3323.robot.Robot;
import org.usfirst.frc.team3323.robot.RobotMap;
import org.usfirst.frc.team3323.robot.commands.ArmOff;
import org.usfirst.frc.team3323.robot.interfaces.ArmInterface;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem implements ArmInterface {
    
    private Jaguar jagArm;
	private Robot robot;
	
	public Arm( Robot robot ){
    	this.robot = robot;
        jagArm = new Jaguar(RobotMap.armMotor);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArmOff(robot.getArm()));
    }

	public void ArmUp() {
		jagArm.set(-0.5);
	}

	public void ArmDown() {
		jagArm.set(0.5);
		
	}

	@Override
	public void off() {
		// TODO Auto-generated method stub
		jagArm.set(0.0);
	}
}

