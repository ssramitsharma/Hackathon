// MoveSquare.java
// Move on square using a gear

import ch.aplu.nxt.*;

public class MoveSquare
{
  public MoveSquare()
  {
    // Create robot and connect it
    LegoRobot robot = new LegoRobot("NXT");
  
    // Create gear and assemble it
    Gear gear = new Gear();
    robot.addPart(gear);
    
    // Reduce speed to get better accuracy
    gear.setSpeed(30);
    
    // Move a square
    for (int i = 0; i < 4; i++)
      gear.forward(2000).left(480);
    
    // Align rear wheel to forward position
    gear.forward(200);  

    // Cleanup
    robot.exit();
  }

  public static void main(String[] args)
  {
    new MoveSquare();
  }
}
