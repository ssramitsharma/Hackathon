// ProtoSensorEx1.java
// Test analog and digital inputs

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ProtoSensorEx1 implements ExitListener
{
  private LegoRobot robot;
  private boolean isRunning = true;
  private Console c = new Console();

  public ProtoSensorEx1()
  {
    c.addExitListener(this);
    robot = new LegoRobot("APLU1");
    PrototypeSensor ps = new PrototypeSensor(SensorPort.S1);
    robot.addPart(ps);
    c.println("Version: " + ps.getVersion());
    c.println("Product ID: " + ps.getProductID());
    c.println("Sensor Type: " + ps.getSensorType());
    int[] ain = new int[5];
    int[] din = new int[6];
    int k = 0;
    while (isRunning)
    {
      ps.read(ain, din);
      for (int i = 0; i < 5; i++)
        c.println("ain[" + i + "]: " + ain[i]);
      for (int i = 0; i < 6; i++)
        c.println("din[" + i + "]: " + din[i]);
      c.println();
      Console.delay(2000);
    }
  }
 
  public void notifyExit()
  {
    if (!isRunning)
      robot.exit();
    else
    {  
      c.println("Press close again to terminate");
      isRunning = false;
    }
  }

  public static void main(String[] args)
  {
    new ProtoSensorEx1();
  }
}
