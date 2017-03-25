// NxtEx1.java

import ch.aplu.nxt.*;

public class NxtEx1
{
  public NxtEx1()
  {
    // Create robot and connect
    LegoRobot robot = new LegoRobot();
    // Speeds up the connection if you know the Bluetooth address
    // long address = Long.parseLong("16530847B5", 16);
    // or long address = 0x16530847B5L
    // LegoRobot robot = new LegoRobot(address);


    // Create two motors
    Motor motA = new Motor(MotorPort.A);
    Motor motB = new Motor(MotorPort.B);

    // Assemble motors into robot
    robot.addPart(motA);
    robot.addPart(motB);

    // Use motors
    motA.forward();
    motB.forward();
  }

  public static void main(String[] args)
  {
    new NxtEx1();
  }
}
