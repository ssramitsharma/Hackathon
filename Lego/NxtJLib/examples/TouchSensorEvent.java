// TouchSensorPoll.java

import ch.aplu.nxt.*;

public class TouchSensorEvent implements TouchListener
{
  
  public TouchSensorEvent()
  {
    LegoRobot robot = new LegoRobot(0x16531B3EB1L);
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    ts.addTouchListener(this);
    robot.addPart(ts);
  }
  
  public void pressed(SensorPort port)
  {
    System.out.println("pressed");
  }

  public void released(SensorPort port)
  {
    System.out.println("released");
    
  }
   
  public static void main(String[] args)
  {
    new TouchSensorEvent();
  }
}