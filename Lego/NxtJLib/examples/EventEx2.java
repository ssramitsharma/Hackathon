// EventEx2.java

import ch.aplu.nxt.*;
import ch.aplu.util.*;
import java.awt.event.*;
import javax.swing.*;

class EventEx2
{
  LegoRobot robot;
  Gear gear;

  EventEx2()
  {
    GPanel p = new GPanel(false);
    JButton startButton = new JButton("Start");
    JButton stopButton = new JButton("Stop");
    JButton quitButton = new JButton("Quit");
  
    startButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        go();
      }
    });

    stopButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        stop();
      }
    });

    quitButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent evt)
      {
        quit();
      }
    });
    
    p.add(startButton);
    p.add(stopButton);
    p.add(quitButton);
    p.windowSize(400, 70);
    p.visible(true);
    
    robot = new LegoRobot();
    gear = new Gear();
    robot.addPart(gear);
    gear.setSpeed(30);
  }

  void go()
  {
    gear.forward();
  }

  void stop()
  {
    gear.stop();
  }

  void quit()
  {
    stop();
    robot.exit();
  }

  public static void main(String[] args)
  {
    new EventEx2();
  }
}