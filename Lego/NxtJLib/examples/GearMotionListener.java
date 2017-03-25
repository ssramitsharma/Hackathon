// GearMotionListener.java
// Use of non-bocking rotateTo() and MotionListener callback 

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class GearMotionListener 
  implements MotionListener, Cleanable
{
  private ModelessOptionPane mop;
  private LegoRobot robot;
  
  public GearMotionListener()
  {
    robot = new LegoRobot("NXT");
    mop = new ModelessOptionPane("");
    mop.showTitle("Close button to disconnect");
    mop.addCleanable(this);
    Motor mot = new Motor(MotorPort.A);
    mot.addMotionListener(this);
    robot.addPart(mot);
    mot.rotateTo(5000, false);  // non-blocking
    mop.setText("Motion started");
  }

  public void motionStopped()
  {
    mop.setText("Motion stopped");
  }
  
  public void clean()
  {
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new GearMotionListener();
  }
}
