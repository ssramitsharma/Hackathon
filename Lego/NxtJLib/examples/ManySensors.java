// ManySensors.java
// Several sensors, events

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ManySensors 
  implements SoundListener, TouchListener, LightListener, ExitListener
{
  private final int soundTriggerLevel = 30;
  private final int lightTriggerLevel = 400;
  private LegoRobot robot;
  private Gear gear;
  
  public ManySensors()
  {
    robot = new LegoRobot("NXT");

    Console c = new Console();
    c.addExitListener(this);
 
    SoundSensor ss = new SoundSensor(SensorPort.S1);
    robot.addPart(ss);
    ss.addSoundListener(this, soundTriggerLevel);

    TouchSensor ts = new TouchSensor(SensorPort.S2);
    robot.addPart(ts);
    ts.addTouchListener(this);

    LightSensor ls = new LightSensor(SensorPort.S3);
    robot.addPart(ls);
    ls.addLightListener(this, lightTriggerLevel);

    gear = new Gear();
    gear.setSpeed(30);
    robot.addPart(gear);
    gear.forward();
  }
  
  public void loud(SensorPort port, int level)
  {
    System.out.println("Callback: loud(" + level + ")");
  }  
  
  public void quiet(SensorPort port, int level)
  { 
    System.out.println("Callback: quiet(" + level + ")");
  } 

  public void bright(SensorPort port, int level)
  { 
    System.out.println("Callback: bright(" + level + ")");
  } 

  public void dark(SensorPort port, int level)
  { 
    System.out.println("Callback: dark(" + level + ")");
  } 
  
  public void pressed(SensorPort port)
  { 
    System.out.println("Callback: pressed()");
    gear.backward(5000);
    gear.forward();
  } 

  public void released(SensorPort port)
  { 
    System.out.println("Callback: released()");
  } 
   
  public void notifyExit()
  {
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new ManySensors();
  }
}
