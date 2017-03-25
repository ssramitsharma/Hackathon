// BtUpload.java
// Upload a program and start it

import ch.aplu.nxt.*;
import ch.aplu.nxt.platform.*;
import java.io.*;

public class BtUpload
{
  private final String VERSION = "BtUpload V1.0";
  
  public BtUpload(String btName, String fileName)
  {
    System.out.println(VERSION);
    if (btName ==  null || btName.equals(""))
    {
      System.out.println("Illegal Bluetooth name");
      return;
    }
    if (fileName ==  null || fileName.equals(""))
    {
      System.out.println("Illegal filename (empty or null)");
      return;
    }
    
    String programName;
    int i = fileName.lastIndexOf('/');
    if (i == -1)
      i = fileName.lastIndexOf('\\');
    if (i != -1)
    {
      if (i == fileName.length()-1)  // Separator at end
      {
        System.out.println("Illegal filename: " + fileName);
        return;
      }
      programName = fileName.substring(i+1);
    }
    else
      programName = fileName;
    
    System.out.println("Trying to connect to " + btName + "...");
    LegoRobot robot = new LegoRobot(btName, false);
    boolean rc = robot.connect(false, false);
    if (!rc)
    {
      System.out.println("Connnection to " + btName + " failed");
      return;
    }
    System.out.println("Connection established\nTrying to upload " + fileName + "...");

    boolean success =  PlatformTools.sendFile(robot, new File(fileName));
    if (success)
    {
      Tools.delay(2000);
      System.out.println("Upload successful\nTrying to start " + programName + "...");
      success = robot.startProgram(programName);
      if (!success)
        System.out.println("Failed to start program");
    }
    else
      System.out.println("Upload failed");
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    if (args.length != 2)
      System.out.println("Usage: java -jar BtUpload.jar btName fileName");
    else
      new BtUpload(args[0], args[1]);
  }
}
