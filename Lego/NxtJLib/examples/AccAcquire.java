// AccAcquire.java
// Get accelerometer data from remote NXT in autonomous mode
// For a demo, run AccSensorEx3.java from the NxtJLibA distribution

import java.io.*;
import ch.aplu.bluetooth.*;
import javax.swing.JOptionPane;
import ch.aplu.util.*;
import java.awt.*;

public class AccAcquire implements ExitListener
{
  private final int channel = 1;
  private BluetoothClient bc;
  private DataInputStream dis;
  private DataOutputStream dos;
  private GPanel g = new GPanel(0, 10000, -300, 300);

  public AccAcquire()
  {
    g.bgColor(Color.black);
    g.addExitListener(this);
    g.title("NXT Acceleration Acquiring. [red, green, blue] : [ax, ay, az]");
    g.addStatusBar(30);
    drawGrid();
    String prompt = "Enter NXT Bluetooth Name";
    String init = "NXT";
    String serverName;
    do
    {
      serverName = JOptionPane.showInputDialog(null, prompt, init);
      if (serverName == null)
        System.exit(0);
    }
    while (serverName.trim().length() == 0);

    bc = new BluetoothClient(serverName, channel);
    g.setStatusText("Trying to connect to " + serverName + "...");
    if (!bc.connect())
    {
      g.setStatusText("Connection to " + serverName + " failed");
      return;
    }

    g.setStatusText("Connection to " + serverName + " established");
    BaseTimer.delay(2000);
    dis = new DataInputStream(bc.getInputStream());
    dos = new DataOutputStream(bc.getOutputStream());

    int t = 0;  // in ms
    HiResAlarmTimer timer = new HiResAlarmTimer(100);
    int axOld = 0;
    int ayOld = 0;
    int azOld = 0;
    int tOld = 0;
    try
    {
      while (true)
      {
        while (timer.isRunning())
        {
        }  // Wait until period is over
        timer.start();
        dos.writeInt(0);  // Request data

        dos.flush();

        int ax = dis.readInt();
        int ay = dis.readInt();
        int az = dis.readInt();
        String s =
          String.format("At t =%6d ms: ax = %6d, ay = %6d, ay = %6d",
          t, ax, ay, az);
        g.setStatusText(s, new Font("Monospaced", Font.BOLD, 12), Color.black);

        if (t == 0)
        {
          drawGrid();
          axOld = ax;
          ayOld = ay;
          azOld = az;
          tOld = t;
        }
        else
        {
          g.color(Color.red);
          g.line(tOld, axOld, t, ax);
          g.color(Color.green);
          g.line(tOld, ayOld, t, ay);
          g.color(Color.blue);
          g.line(tOld, azOld, t, az);
          axOld = ax;
          ayOld = ay;
          azOld = az;
          tOld = t;
        }

        t += 100;  // Time step

        if (t == 10000)
          t = 0;
      }
    }
    catch (Exception ex)
    {
    }
    g.setStatusText("Disconnected. Click [x] to quit");
    bc.disconnect();
  }

  public void notifyExit()
  {
    if (bc.isConnected())
      bc.disconnect();
    else
      System.exit(0);
  }

  private void drawGrid()
  {
    g.clear();
    g.color(Color.white);
    for (int x = 0; x <= 10000; x += 1000)
      g.line(x, -300, x, 300);
    for (int y = -300; y <= 300; y += 100)
    {
      g.line(0, y, 10000, y);
      g.text(100, y + 2, "" + y);
    }
  }

  public static void main(String[] args)
  {
    new AccAcquire();
  }
}
