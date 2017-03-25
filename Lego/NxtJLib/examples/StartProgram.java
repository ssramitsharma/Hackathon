// StartProgram.java
// Run a program previously copied to the brick's file system

import ch.aplu.nxt.*;

public class StartProgram 
{
  private final String progName = "TurtleStep.nxj";
  public StartProgram()
  {
    LegoRobot robot = new LegoRobot("NXT");
    if (!robot.startProgram(progName))
      System.out.println("Running of program " + progName + " failed");
    robot.exit();
  }
  public static void main(String[] args)
  {
    new StartProgram();
  }
}
