package org.usfirst.frc.team3323.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3323.robot.Diagnostic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class RobotPart extends Subsystem
{
  private static AtomicInteger idCreator = new AtomicInteger();

  protected RobotPart(String name)
  {
    super(idCreator.incrementAndGet() + ":" + name);
  }

  public List<Diagnostic> getDiagnostics()
  {
    List<Diagnostic> diagnostics = new ArrayList<Diagnostic>();
    diagnostics.add( new Diagnostic( "Diagnostics", "No diagnostics implemented" ) );
    return diagnostics;
  }
}
