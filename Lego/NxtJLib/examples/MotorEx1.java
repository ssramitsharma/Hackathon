// MotorEx1.java

import ch.aplu.nxt.*;

public class MotorEx1
{
  public MotorEx1()
  {
    long address = 0x16531B3EB1L;
    LegoRobot robot = new LegoRobot(address);
    Motor mot = new Motor(MotorPort.A);
 
    robot.addPart(mot);
 
    System.out.println("isMoving0 = " + mot.isMoving());
    mot.forward();
    System.out.println("isMoving1 = " + mot.isMoving());
    Tools.delay(2000);
    mot.stop();
    System.out.println("isMoving2 = " + mot.isMoving());
    Tools.delay(2000);
    System.out.println("isMoving3 = " + mot.isMoving());
  }
  

  public static void main(String[] args)
  {
    new MotorEx1();
  }
}
