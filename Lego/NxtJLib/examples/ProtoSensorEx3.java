// ProtoSensorEx3.java
// Events

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ProtoSensorEx3 implements ExitListener, PrototypeListener
{
  private Console c = new Console();

  public ProtoSensorEx3()
  {
    c.addExitListener(this);
    LegoRobot robot = new LegoRobot("APLU1");
    PrototypeSensor ps = new PrototypeSensor(SensorPort.S1);
    robot.addPart(ps);
    ps.addPrototypeListener(this);
    Monitor.putSleep();
    robot.exit();
  }

  public void ainChanged(SensorPort port, int[] ain)
  {
    for (int i = 0; i < 5; i++)
    {
      if (ain[i] != -1)
        c.println("a[" + i + "]:" + ain[i]);
    }
  }

  public void dinChanged(SensorPort port, int[] din)
  {
    for (int i = 0; i < 6; i++)
    {
      if (din[i] != -1)
        c.println("d[" + i + "]:" + din[i]);
    }
  }

  public void notifyExit()
  {
    Monitor.wakeUp();
  }

  public static void main(String[] args)
  {
    new ProtoSensorEx3();
  }
}
