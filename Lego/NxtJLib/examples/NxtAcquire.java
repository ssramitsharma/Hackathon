// NxtAcquire.java
// Get data from remote NXT in autonomous mode
// For a demo, run BtAcquire.java from the NxtJLibA distribution

import java.io.*;
import ch.aplu.bluetooth.*;
import javax.swing.JOptionPane;
import ch.aplu.util.*;

public class NxtAcquire implements ExitListener
{
  private final int channel = 1;
  private BluetoothClient bc;
  private DataInputStream dis;
  private DataOutputStream dos;
  private GPanel g = new GPanel(0, 10000, 0, 1000);

  public NxtAcquire()
  {
    g.addExitListener(this);
    g.title("NXT Remote Data Acquiring");
    drawGrid();
    String prompt = "Enter NXT Bluetooth Name";
    String init = "APLU1";
    String serverName;
    do
    {
      serverName = JOptionPane.showInputDialog(null, prompt, init);
      if (serverName == null)
        System.exit(0);
    }
    while (serverName.trim().length() == 0);

    bc = new BluetoothClient(serverName, channel);
    g.title("Trying to connect to " + serverName + "...");
    if (!bc.connect())
    {
      g.title("Connection to " + serverName + " failed");
      return;
    }

    g.title("Connection to " + serverName + " established");
    BaseTimer.delay(2000);
    dis = new DataInputStream(bc.getInputStream());
    dos = new DataOutputStream(bc.getOutputStream());

    int t = 0;  // in ms
    HiResAlarmTimer timer = new HiResAlarmTimer(100);
    try
    {
      while (true)
      {
        while (timer.isRunning()) {}  // Wait until period is over
        timer.start();
        dos.writeInt(0);  // Request data

        dos.flush();

        int value = dis.readInt();
        g.title("Time: " + t + " ms  Value: " + value);
        if (t == 0)
        {
          drawGrid();
          g.move(t, value);
        }
        else
          g.draw(t, value);

        t += 100;  // Time step

        if (t == 10000)
          t = 0;
      }
    }
    catch (Exception ex)
    {}
    g.title("Disconnected. Click [x] to quit");
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
    for (int x = 0; x <= 10000; x += 1000)
      g.line(x, 0, x, 1000);
    for (int y = 0; y <= 1000; y += 100)
      g.line(0, y, 10000, y);
  }

  public static void main(String[] args)
  {
    new NxtAcquire();
  }
}
