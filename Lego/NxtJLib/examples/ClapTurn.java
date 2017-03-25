// ClapTurn.java
// Turn when clapped

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ClapTurn implements SoundListener
{
  private final int triggerLevel = 30;
  private Gear gear;
  
  public ClapTurn()
  {
    LegoRobot robot = new LegoRobot();
    SoundSensor ls = new SoundSensor(SensorPort.S1);
    robot.addPart(ls);
    ls.addSoundListener(this, triggerLevel);

    gear = new Gear();
    gear.setSpeed(30);
    robot.addPart(gear);
    gear.forward();

    while (!QuitPane.quit());
    robot.exit();
  }
  
  public void loud(SensorPort port, int level)
  {
    gear.left(500);
    gear.forward();
  }  
  
  public void quiet(SensorPort port, int level)
  { 
  } 
    
  public static void main(String[] args)
  {
    new ClapTurn();
  }
}
