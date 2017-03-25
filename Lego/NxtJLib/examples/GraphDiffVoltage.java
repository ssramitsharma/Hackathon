// GraphDiffVoltage.java
// Use Differential Voltage Sensor from Vernier
// Show periodical readings in a simple graph

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class GraphDiffVoltage implements ExitListener
{
  private double period = 0.1; //  s
  private double maxTime = 20; // s
  private boolean isRunning = true;

  public GraphDiffVoltage()
  {
    GPanel p = new GPanel(-1, maxTime + 1, -5, 5);
    p.addExitListener(this);
    LegoRobot robot = new LegoRobot();
    DiffVoltageSensor dvs = new DiffVoltageSensor(SensorPort.S1);
    robot.addPart(dvs);
    double t = 0;
    double y;
    HiResAlarmTimer timer = new HiResAlarmTimer((long)(1E6 * period));
    while (isRunning)
    {
      timer.start();
      if (t == 0)
        clearGraphics(p);
      y = dvs.getVoltage();
      if (t == 0)
        p.move(t, y);
      else
        p.draw(t, y);
      t += period;
      if (t >= maxTime)
        t = 0;
      while (timer.isRunning())
      {
      }
    }
    robot.exit();
    System.exit(0);
  }

  private void clearGraphics(GPanel p)
  {
    p.clear();
    p.line(0, 0, maxTime, 0);
    p.line(maxTime, 0, maxTime, -0.1);
    p.text(maxTime-0.5 , -0.3, maxTime + "s");
    p.line(0, -5, 0, 5);
  }

  public void notifyExit()
  {
    isRunning = false;
  }

  public static void main(String[] args)
  {
    new GraphDiffVoltage();
  }
}
