package org.usfirst.frc.team3323.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc.team3323.robot.Diagnostic;
import org.usfirst.frc.team3323.robot.commands.ArmOff;

import java.util.ArrayList;
import java.util.List;

public class Arm extends RobotPart
{
  private final SpeedController motor;
  private final Encoder encoder;

  public Arm(String name, SpeedController motor, Encoder encoder)
  {
    super(name);
    this.motor = motor;
    this.encoder = encoder;
  }

  public void initDefaultCommand()
  {
    setDefaultCommand(new ArmOff(this));
  }

  public void up()
  {
    motor.set(-0.5);
  }

  public void down()
  {
    motor.set(0.5);
  }

  public void stop()
  {
    motor.set(0.0);
  }

  public List<Diagnostic> getDiagnostics()
  {
    List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
    diagnostics.add( new Diagnostic( "Motor", motor.get() ) );
    diagnostics.add( new Diagnostic( "Inverted", motor.getInverted() ) );
    diagnostics.add( new Diagnostic( "Direction", encoder.getDirection() ) );
    diagnostics.add( new Diagnostic( "Distance", encoder.getDistance() ) );
    diagnostics.add( new Diagnostic( "EncodingScale", encoder.getEncodingScale() ) );
    diagnostics.add( new Diagnostic( "FPGAIndex", encoder.getFPGAIndex() ) );
    diagnostics.add( new Diagnostic( "PIDSourceType", encoder.getPIDSourceType() ) );
    diagnostics.add( new Diagnostic( "Rate", encoder.getRate() ) );
    diagnostics.add( new Diagnostic( "SamplesToAverage", encoder.getSamplesToAverage() ) );
    diagnostics.add( new Diagnostic( "Stopped", encoder.getStopped() ) );
    diagnostics.add( new Diagnostic( "Raw", encoder.getRaw() ) );
    return diagnostics;
  }
}
