// NxtEx3.java

import ch.aplu.nxt.*;
import ch.aplu.util.QuitPane;

public class NxtEx3
{
  public NxtEx3()
  {
    LegoRobot robot = new LegoRobot(0x16531B3EB1L);

    Motor motA = new Motor(MotorPort.A);
    robot.addPart(motA);
    while (!QuitPane.quit(false))
    {
      motA.forward();
      Tools.delay(500);
      motA.stop();
      Tools.delay(500);
    }
    robot.exit();
  }

  public static void main(String[] args)
  {
    new NxtEx3();
  }
}
