// LightRegulator.java
// pos = 0..300

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class LightRegulator
{
  private final int sollWert = 900;
  
  public LightRegulator()
  {
    LegoRobot robot = new LegoRobot();
    Motor mot = new Motor(MotorPort.A);
    robot.addPart(mot);
    
    LightSensor ls = new LightSensor();
    robot.addPart(ls);
    
    System.out.println("Set regulator in maximal position\nand press Quit");
    while (!QuitPane.quit()) {}
    QuitPane.init();
    System.out.println("Initializing now...");
    init(mot);
    int pos = 0;
    int istWert;
    while (!QuitPane.quit())
    {
      istWert = ls.getValue();
      System.out.println("pos: " + pos + " istWert: " + istWert);
      if (istWert > sollWert)
      {
        pos = pos - 5;
        if (pos < 0)
          pos = 0;
      }  
      else
      {
        pos = pos + 5;
        if (pos > 300)
          pos = 300;
      }
      mot.continueTo(pos);
    }  
    mot.continueTo(300);
    robot.exit();
  }

  private void init(Motor mot)
  {
    mot.setSpeed(5);
    mot.rotateTo(-300);
    mot.resetMotorCount();
  }
  
  public static void main(String[] args)
  {
    new LightRegulator();
  }
}