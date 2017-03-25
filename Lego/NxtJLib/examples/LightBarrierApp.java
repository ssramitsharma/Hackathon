// LightBarrierApp.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class LightBarrierApp
{
  public LightBarrierApp()
  {
    LightBarrier lb = new LightBarrier();

    LegoRobot robot = new LegoRobot();
    Gear gear = new Gear();
    robot.addPart(gear);
    gear.leftArc(0.3);

    boolean isRunning = true;
    while (!QuitPane.quit())
    {
      if (lb.getDimouts() == 3 && isRunning)
      {  
        gear.stop();
        isRunning = false;
      }
    }  
    lb.disconnect();
    robot.exit();
  }

  public static void main(String[] args)
  {
    new LightBarrierApp();
  }
}
