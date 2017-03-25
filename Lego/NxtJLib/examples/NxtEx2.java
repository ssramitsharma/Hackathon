// NxtEx2.java

import ch.aplu.nxt.*;

public class NxtEx2
{
  public NxtEx2()
  {
    LegoRobot robot = new LegoRobot(0x16531B3EB1L);

    Motor motA = new Motor(MotorPort.A);
    robot.addPart(motA);
    while (true)
    {
      motA.forward();
      Tools.delay(500);
      motA.stop();
      Tools.delay(500);
    }
  }

  public static void main(String[] args)
  {
    new NxtEx2();
  }
}
