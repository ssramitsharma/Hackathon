// RobotNoExit1.java

import ch.aplu.nxt.*;

public class RobotNoExit1 implements TouchListener
{
  private Gear gear;
  public RobotNoExit1()
  {
    LegoRobot robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    TouchSensor ts = new TouchSensor();
    robot.addPart(ts);
    ts.addTouchListener(this);
    gear.forward();
  }

  public void pressed(SensorPort port)
  {
    gear.backward(2000);
    gear.forward();
  }

  public void released(SensorPort port)
  {
  }
  
  public static void main(String[] args)
  {
    new RobotNoExit1();
  }
}
