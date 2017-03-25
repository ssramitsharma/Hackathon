// ProtoSensorEx2.java
// Test digital outputs, does not work with current leJOS firmware

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ProtoSensorEx2 implements ExitListener
{
  private final int in = 0;
  private final int out = 1;
  private LegoRobot robot;
  private boolean isRunning = true;
  private Console c = new Console();

  public ProtoSensorEx2()
  {
    c.addExitListener(this);
    robot = new LegoRobot("APLU1");
    PrototypeSensor ps = new PrototypeSensor(SensorPort.S1);
    robot.addPart(ps);
    int[] ioControl = {out, out, in, in, in, out};
    ps.setDIO(ioControl);
    int[] dout = new int[6];
    int k = 0;
    while (isRunning)
    {
      if (k++ % 2 == 0)
      {
        dout[0] = 1;
        dout[1] = 1;
        dout[5] = 1;
      }
      else
      {
        dout[0] = 0;
        dout[1] = 0;
        dout[5] = 0;
      }
      ps.write(dout);

      int[] din = new int[6];
      ps.readDigital(din);
      c.println("DigitalIn:");
      for (int i = 0; i < 6; i++)
        c.println("din[" + i + "]: " + din[i]);
      Tools.delay(50);
    }  
  }

  public void notifyExit()
  {
    if (!isRunning)
      robot.exit();
    else
      c.println("Press close again to terminate");
    isRunning = false;
  }

  public static void main(String[] args)
  {
    new ProtoSensorEx2();
  }
}
