// BorderFollower.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class BorderFollower implements LightListener
{
  private final int triggerLevel = 500;
  private Gear gear;
 
  public BorderFollower()
  {
    LegoRobot robot = new LegoRobot();

    LightSensor ls = new LightSensor(SensorPort.S1);
    robot.addPart(ls);
    ls.addLightListener(this, triggerLevel);

    gear = new Gear();
    gear.setSpeed(20);
    robot.addPart(gear);
    gear.forward();
  
    while (!QuitPane.quit());
    robot.exit();
  }
   
  public void bright(SensorPort port, int level)
  {
    gear.leftArc(0.2);
  }  
  
  public void dark(SensorPort port, int level)
  { 
    gear.rightArc(0.2);
  } 
    
  public static void main(String[] args)
  {
    new BorderFollower();
  }
}
