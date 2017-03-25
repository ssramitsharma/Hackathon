// RobotNoExit2.java

import ch.aplu.nxt.*;

public class RobotNoExit2
{
  public RobotNoExit2()
  {
    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    while (true)
    {
      gear.forward(2000);
      gear.left(1000);
    }
  }

  public static void main(String[] args)
  {
    new RobotNoExit2();
  }
}
