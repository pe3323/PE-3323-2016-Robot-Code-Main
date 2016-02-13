package org.usfirst.frc.team3323.robot;

public class Diagnostic
{
  private String name;
  private Object value;

  public Diagnostic(String name, Object value)
  {
    this.name = name;
    this.value = value;
  }

  public String getName()
  {
    return name;
  }

  public Object getValue()
  {
    return value;
  }
}
