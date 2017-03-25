// ProtoSensorEx4.java
// Switches at pin B0, B1 control motors

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ProtoSensorEx4 implements PrototypeListener
{
  private PrototypeSensor ps = new PrototypeSensor();
  private Motor motA = new Motor(MotorPort.A);
  private Motor motB = new Motor(MotorPort.B);

  public ProtoSensorEx4()
  {
    LegoRobot robot = new LegoRobot();
    robot.addPart(motA);
    robot.addPart(motB);
    robot.addPart(ps);
    ps.addPrototypeListener(this);
    int[] ain = new int[5];
    int[] din = new int[6];
    ps.read(ain, din);
    setSpeed(ain[0]);
    if (din[0] == 1)
      motA.forward();
    if (din[1] == 1)
      motB.forward();
    while (!QuitPane.quit())
    {
    }
    robot.exit();
  }

  private void setSpeed(int s)
  {
    motA.setSpeed(s * 100 / 1023);
    if (motA.isMoving())
      motA.forward();
    motB.setSpeed(s * 100 / 1023);
    if (motB.isMoving())
      motB.forward();
  }

  public void ainChanged(SensorPort port, int[] ain)
  {
    if (ain[0] != -1)
      setSpeed(ain[0]);
  }

  public void dinChanged(SensorPort port, int[] din)
  {
    if (din[0] == 0)
      motA.stop();
    if (din[0] == 1)
      motA.forward();
    if (din[1] == 0)
      motB.stop();
    if (din[1] == 1)
      motB.forward();
  }

  public static void main(String[] args)
  {
    new ProtoSensorEx4();
  }
}
