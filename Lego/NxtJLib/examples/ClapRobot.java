// ClapRobot.java
// Start, stop with sound sensor

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ClapRobot implements SoundListener
{
  private Gear gear;
  private boolean isRunning = false;
    
  public ClapRobot()
  {
    LegoRobot robot = new LegoRobot("NXT");
    gear = new Gear();
    robot.addPart(gear);
    SoundSensor ss = new SoundSensor(SensorPort.S1);
    ss.addSoundListener(this, 50);
    robot.addPart(ss);
    while (!QuitPane.quit());
    robot.exit();
  }
  
  public void loud(SensorPort port, int level)
  {
    System.out.println("loud");
    if (isRunning)
    {  
      gear.stop();
      isRunning = false;
    }
    else
    {
      gear.leftArc(0.2);
      isRunning = true;
    }
  }

  public void quiet(SensorPort port, int level)
  {}
 
  public static void main(String[] args)
  {
    new ClapRobot();
  }
}
