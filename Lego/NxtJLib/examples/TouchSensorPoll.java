// TouchSensorPoll.java

import ch.aplu.nxt.*;

public class TouchSensorPoll 
{
  
  public TouchSensorPoll()
  {
    LegoRobot robot = new LegoRobot(0x16531B3EB1L);
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    robot.addPart(ts);
    while (true)
    {
      boolean isButtonPressed = ts.isPressed();
      System.out.println("State " + isButtonPressed);
      Tools.delay(500);
     
    }
  }
   
  public static void main(String[] args)
  {
    new TouchSensorPoll();
  }
}