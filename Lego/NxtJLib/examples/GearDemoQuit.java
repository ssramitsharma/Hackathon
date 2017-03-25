// GearDemoQuit.java
// Same as GearDemo, but use QuitPane to quit any time

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class GearDemoQuit implements Cleanable
{
  private LegoRobot robot = new LegoRobot("NXT");

  public GearDemoQuit()
  {
    QuitPane qp = new QuitPane();
    qp.addQuitNotifier(this);

    Gear gear = new Gear();
    robot.addPart(gear);
    
    for (int i = 0; i < 4; i++)
    {
      gear.forward(1000);
      gear.left(200);
    }
  }

  public void clean()
  {
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new GearDemoQuit();
  }
}
