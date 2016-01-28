package org.usfirst.frc.team3323.robot.commands;
 
import edu.wpi.first.wpilibj.command.Command;

//import robot.subsystems.ImageProcessing; 

public abstract class CommandBase extends Command {
     
    
    
    //public static OnBoardCompressor compressor = new OnBoardCompressor(0); 
    //public static ImageProcessing imageProcessing = new ImageProcessing();
   
 
    public CommandBase(String name) {
        super(name);
    }
 
    public CommandBase() {
        super();
    }
     
}