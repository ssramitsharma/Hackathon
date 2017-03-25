// NoConnectPanel.java
// Show not connect panel, NXT Bluetooth name hard-coded
// Request Bluetooth address and battery level

import javax.swing.JOptionPane;
import ch.aplu.nxt.*;

public class NoConnectPanel 
{
  public NoConnectPanel()
  {
    // Create robot
    LegoRobot robot = new LegoRobot("NXT", false);

    // Connect without connection panel
    boolean rc = robot.connect(false);
    if (!rc)
    {
      JOptionPane.showMessageDialog(null, "Can't connect to brick NXT");
      System.exit(1);
    }
   
    String btAddress = robot.getBtAddress();
    JOptionPane.showMessageDialog(null, 
                                  "Bluetooth Address: " + 
                                  btAddress,
                                  "Request Bluetooth Address",
                                  JOptionPane.INFORMATION_MESSAGE);
    
    double batteryLevel = robot.getBatteryLevel();
    JOptionPane.showMessageDialog(null, 
                                  "Battery Level: " + 
                                  batteryLevel + " V",
                                  "Request Battery Level",
                                  JOptionPane.INFORMATION_MESSAGE);
    
   
    // Disconnect and terminate
    robot.exit();
  }
  
  public static void main(String[] args)
  {
    new NoConnectPanel();
  }
}
