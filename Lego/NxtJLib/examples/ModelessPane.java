// ModelessPane.java
// Touch sensor, display count in modeless pane

import ch.aplu.nxt.*;
import ch.aplu.util.*;

public class ModelessPane implements TouchListener, Cleanable
{
  private LegoRobot robot;
  private int pressedNb = 0;
  private int releasedNb = 0;
  private ModelessOptionPane mop;
  
  public ModelessPane()
  {
    robot = new LegoRobot("NXT");
    mop = new ModelessOptionPane("Please actuate touch sensor");
    mop.showTitle("Touch Sensor"); 
    mop.addCleanable(this);
    
    TouchSensor ts = new TouchSensor(SensorPort.S1);
    // The following two lines may be interchanged
    robot.addPart(ts);
    ts.addTouchListener(this);
  }
  
  public void clean()
  {
    robot.exit();
  }
  
  public void pressed(SensorPort port)
  {  
     pressedNb++;
     showNbEvents();
  }  
  
  public void released(SensorPort port)
  { 
     releasedNb++;
     showNbEvents();
  } 

  private void showNbEvents()
  {  
    mop.setText("pressed #: " + pressedNb + 
                "\nreleased #: " + releasedNb);
  }
    
  public static void main(String[] args)
  {
    new ModelessPane();
  }
}
