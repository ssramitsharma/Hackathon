// TurtleSquare.java
// Turtle-like movement on a square

import ch.aplu.nxt.*;

public class TurtleSquare
{
  public TurtleSquare()
  {
    TurtleRobot t = new TurtleRobot();
    int n = 0;
    for (int i = 0; i < 4; i++)
    {
      t.forward(100);
      t.left(90);
    }
    t.exit();
  }

  public static void main(String[] args)
  {
    new TurtleSquare();
  }

}
