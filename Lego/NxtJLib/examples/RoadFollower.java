// RoadFollower.java
// One light sensor, one touchsensor
// Follow black road with blue left and yellow right border line

import ch.aplu.nxt.*;

public class RoadFollower
{
  public RoadFollower()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    LightSensor ls = new LightSensor(SensorPort.S3);
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    robot.addPart(gear);
    robot.addPart(ls);
    robot.addPart(ts);
    gear.setSpeed(30);
    ls.activate(true);

    while (true)
    {
      int v = ls.getValue();
      if (v < 440)  // black
        gear.forward();
      if (v > 450 && v < 480)  // blue
        gear.rightArc(0.1);
      if (v > 530)  // red
        gear.leftArc(0.1);
      if (ts.isPressed())
        break;
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new RoadFollower();
  }
}
