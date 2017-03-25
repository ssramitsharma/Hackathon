// Button1.java

import ch.aplu.nxt.*;

public class Button1
{
  public Button1()
  {
    LegoRobot robot = new LegoRobot();
    boolean isRunning = true;
    while (isRunning)
    {
      if (robot.isButtonHit())
      {
        switch (robot.getHitButtonID())
        {
          case BrickButton.ID_DOWN:
            System.out.println("down");
            break;
          case BrickButton.ID_UP:
            System.out.println("up");
            break;
          case BrickButton.ID_LEFT:
            System.out.println("left");
            break;
          case BrickButton.ID_RIGHT:
            System.out.println("right");
            break;
          case BrickButton.ID_ENTER:
            System.out.println("enter");
            break;
          case BrickButton.ID_ESCAPE:
            System.out.println("escape");
            isRunning = false;
            break;
        }
      }
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new Button1();
  }
}
