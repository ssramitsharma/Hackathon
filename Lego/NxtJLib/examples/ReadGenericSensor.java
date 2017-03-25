// ReadGenericSensor.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ReadGenericSensor 
{
  public ReadGenericSensor()
  {
    LegoRobot robot = new LegoRobot();
    GenericSensor gs = new GenericSensor(SensorPort.S1);
    robot.addPart(gs);
    while (!QuitPane.quit())
    {
      int value = gs.getValue();
      System.out.println("Current value: " + value);
      Tools.delay(1000);
    }
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new ReadGenericSensor();
  }
}
