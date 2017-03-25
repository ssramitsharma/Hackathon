// ReadDiffVoltageSensor.java
// Use Differential Voltage Sensor from Vernier

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ReadDiffVoltageSensor 
{
  public ReadDiffVoltageSensor()
  {
    LegoRobot robot = new LegoRobot();
    DiffVoltageSensor dvs = new DiffVoltageSensor(SensorPort.S1);
    robot.addPart(dvs);
    while (!QuitPane.quit())
    {
      double value = dvs.getVoltage();
      System.out.println("Current voltage: " + value + " V");
      Tools.delay(1000);
    }
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new ReadDiffVoltageSensor();
  }
}
