// GearDemo.java
// One robot with a gear, hard-coded NXT Bluetooth name

import ch.aplu.nxt.*;

public class GearDemo 
{
  public GearDemo()
  {
    LegoRobot robot = new LegoRobot("NXT");
    Gear gear = new Gear();
    robot.addPart(gear);
    
    for (int i = 0; i < 4; i++)
    {
      gear.forward(1000);
      gear.left(200);
    }
   
    // Disconnect and terminate
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new GearDemo();
  }
}
