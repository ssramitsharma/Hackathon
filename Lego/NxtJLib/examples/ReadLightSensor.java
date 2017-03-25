// ReadLightSensor.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ReadLightSensor
{
  private final int period = 1000;  // ms

  public ReadLightSensor()
  {
    LegoRobot robot = new LegoRobot();
    LightSensor ls = new LightSensor(SensorPort.S1);
    robot.addPart(ls);
    Console.init();
    System.out.println("LightSensor getValue() returns:");

    int time = 0;
    while (!QuitPane.quit())
    {
      System.out.println("At " + time/1000 + " s: " + ls.getValue());
      Tools.delay(period);
      time += period;
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new ReadLightSensor();
  }
}
