// TwoTurtles.java
// Two turtles

import ch.aplu.nxt.*;

public class TwoTurtles
{
  public TwoTurtles()
  {
    TurtleRobot t1 = new TurtleRobot("NXT"); 
    TurtleRobot t2 = new TurtleRobot("NXT5");
    for (int i = 0; i < 3; i++)
    {  
      step(t1);
      step(t2);
    }
    t1.disconnect();
    t2.exit();
  }
  
  private void step(TurtleRobot t)
  {
    t.forward(100);
    t.left(90);
    t.forward(100);
    t.right(90);
  }
  
  public static void main(String[] args)
  {
    new TwoTurtles();
  }
}
