// LightSensorEx1.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class LightSensorEx1 implements LightListener
{
  private final int triggerLevel = 525;
  private Gear gear;
  
  public LightSensorEx1()
  {
    LegoRobot robot = new LegoRobot();
   
    LightSensor ls = new LightSensor(SensorPort.S1);
    robot.addPart(ls);
    ls.addLightListener(this, triggerLevel);

    gear = new Gear();
    gear.setSpeed(30);
    robot.addPart(gear);
    gear.forward();
  
    while (!QuitPane.quit())
    {}
    robot.exit();
  }
   
  public void bright(SensorPort port, int level)
  {
    gear.backward(500);
    gear.left(500);
    gear.forward();
  }  
  
  public void dark(SensorPort port, int level)
  { 
  } 
    
  public static void main(String[] args)
  {
    new LightSensorEx1();
  }
}