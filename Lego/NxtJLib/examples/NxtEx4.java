// NxtEx4.java

import ch.aplu.nxt.*;

public class NxtEx4
{
  Gear gear;

  public NxtEx4()
  {
    LegoRobot robot = new LegoRobot(0x16531B3EB1L);

    Motor motA = new Motor(MotorPort.A);
    robot.addPart(motA);
    motA.forward();
    Tools.delay(500);
    robot.exit();
  }

  public static void main(String[] args)
  {
    new NxtEx4();
  }
}
