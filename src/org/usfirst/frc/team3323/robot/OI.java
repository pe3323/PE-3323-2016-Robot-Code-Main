package org.usfirst.frc.team3323.robot;

import org.usfirst.frc.team3323.robot.commands.SlowForwardLeft;
import org.usfirst.frc.team3323.robot.commands.SlowForwardRight;
import org.usfirst.frc.team3323.robot.commands.ArmDown;
import org.usfirst.frc.team3323.robot.commands.ArmUp;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {

    private final static int LEFT_JOYSTICK_PORT_NUM = 0;
    private final static int RIGHT_JOYSTICK_PORT_NUM = 1;
    
    private final static int KILL_BUTTON_NUM = 11;
    
    private final static int SLOW_FORWARD_LEFT_BUTTON_NUM = 1;
    private final static int SLOW_FORWARD_RIGHT_BUTTON_NUM = 1;
    private final static int ARM_DOWN_BUTTON_NUM = 2;
    private final static int ARM_UP_BUTTON_NUM = 3;
    
    private Joystick LS = null;
    
    private Joystick RS = null;    
    
    private Button Kill = null;
    
    private Button slowFWDLeft = null;
    private Button slowFWDRight = null;
    private Button ArmUp = null;
    private Button ArmDown = null;
    
    public OI( Robot robot ){
    	LS = new Joystick(LEFT_JOYSTICK_PORT_NUM);
    	RS = new Joystick(RIGHT_JOYSTICK_PORT_NUM);
    	
    	slowFWDLeft = new JoystickButton(LS, SLOW_FORWARD_LEFT_BUTTON_NUM);
    	slowFWDRight = new JoystickButton(RS, SLOW_FORWARD_RIGHT_BUTTON_NUM);
    	ArmUp = new JoystickButton(RS, ARM_UP_BUTTON_NUM);
    	ArmDown = new JoystickButton(RS, ARM_DOWN_BUTTON_NUM);
        
        Kill = new JoystickButton(RS, KILL_BUTTON_NUM);
    	
//        Kill.toggleWhenPressed(new Kill( robot.getDrive()));

        slowFWDLeft.whileHeld(new SlowForwardLeft(robot.getDrive()));
        slowFWDRight.whileHeld(new SlowForwardRight(robot.getDrive()));
        ArmUp.whileHeld(new ArmUp(robot.getArm()));
        ArmDown.whileHeld(new ArmDown(robot.getArm()));
        
    }
    
    public Joystick getLS(){
        return LS;
    }
    
    public Joystick getRS(){
        return RS;
    }
}