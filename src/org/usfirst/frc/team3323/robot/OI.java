package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3323.robot.commands.ArmDown;
import org.usfirst.frc.team3323.robot.commands.ArmUp;
import org.usfirst.frc.team3323.robot.commands.SlowForwardLeft;
import org.usfirst.frc.team3323.robot.commands.SlowForwardRight;

public class OI
{

  private final static int LEFT_JOYSTICK_PORT_NUM = 0;
  private final static int RIGHT_JOYSTICK_PORT_NUM = 1;

  private final static int KILL_BUTTON_NUM = 11;

  private final static int SLOW_FORWARD_LEFT_BUTTON_NUM = 1;
  private final static int SLOW_FORWARD_RIGHT_BUTTON_NUM = 1;
  private final static int ARM_DOWN_BUTTON_NUM = 2;
  private final static int ARM_UP_BUTTON_NUM = 3;

  private Button kill = null;
  private Joystick LS = null;
  private Joystick RS = null;

  private Button slowFWDLeft = null;
  private Button slowFWDRight = null;
  private Button armUp = null;
  private Button armDown = null;

  public OI(Robot robot)
  {
    LS = new Joystick(LEFT_JOYSTICK_PORT_NUM);
    RS = new Joystick(RIGHT_JOYSTICK_PORT_NUM);

    slowFWDLeft = new JoystickButton(LS, SLOW_FORWARD_LEFT_BUTTON_NUM);
    slowFWDRight = new JoystickButton(RS, SLOW_FORWARD_RIGHT_BUTTON_NUM);
    armUp = new JoystickButton(RS, ARM_UP_BUTTON_NUM);
    armDown = new JoystickButton(RS, ARM_DOWN_BUTTON_NUM);

    kill = new JoystickButton(RS, KILL_BUTTON_NUM);

//        Kill.toggleWhenPressed(new Kill( robot.getDrive()));

    slowFWDLeft.whileHeld(new SlowForwardLeft(robot.getDriveTrain()));
    slowFWDRight.whileHeld(new SlowForwardRight(robot.getDriveTrain()));
    armUp.whileHeld(new ArmUp(robot.getHumerus()));
    armDown.whileHeld(new ArmDown(robot.getHumerus()));

  }

  public Joystick getLS()
  {
    return LS;
  }

  public Joystick getRS()
  {
    return RS;
  }
}