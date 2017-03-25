// LeftArc.java
// rightArc, forward and backward

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class LeftArc
{
  public LeftArc()
  {
    LegoRobot robot = new LegoRobot("NXT");
    Gear gear = new Gear();
    robot.addPart(gear);
    gear.setSpeed(60);
    gear.rightArc(0.5, 5000);
    Tools.delay(2000);
    gear.rightArc(-0.2, 5000);
    robot.exit();
  }

  public static void main(String[] args)
  {
    new LeftArc();
  }
}
