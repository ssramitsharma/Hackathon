// CompassPoll.java

import ch.aplu.util.*;
import ch.aplu.nxt.*;

public class CompassPoll implements ExitListener
{
  private volatile boolean isRunning = false;
  
  public CompassPoll()
  {
    Console c = new Console();
    c.addExitListener(this);
    LegoRobot robot = new LegoRobot();
    CompassSensor cs = new CompassSensor();
    robot.addPart(cs);
    Gear gear = new Gear();
    robot.addPart(gear);
    gear.setSpeed(3);
    gear.left();
    System.out.println("Calibrating now...");
    System.out.println("Click Close to stop calibration (>2 revolutions)");
    cs.startCalibration();
    Monitor.putSleep();  // Execution halted
    cs.stopCalibration();
    robot.playTone(1000, 100);

    System.out.println("Measuring now...");
    System.out.println("Click Close to stop");
    isRunning = true;
    while (isRunning)
      System.out.println("v: " + cs.getDegrees());
    robot.exit();
  }

  public void notifyExit()
  {
    if (isRunning)
      isRunning = false;  // Stop measuring
    else
      Monitor.wakeUp();   // Execution resumed
  }
  
  public static void main(String[] args)
  {
    new CompassPoll();
  }
}