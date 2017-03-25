// Button2.java

import ch.aplu.nxt.*;

public class Button2
{
  public Button2()
  {
    LegoRobot robot = new LegoRobot("NXT");
    while (true)
    {
      if (robot.isDownHit())
        System.out.println("down");
      else if (robot.isUpHit())
        System.out.println("up");
      else if (robot.isLeftHit())
        System.out.println("left");
      else if (robot.isRightHit())
        System.out.println("right");
      else if (robot.isEnterHit())
        System.out.println("enter");
      else if (robot.isEscapeHit())
        System.out.println("escape");
    }
  }

  public static void main(String[] args)
  {
    new Button2();
  }
}
