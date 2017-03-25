// LightBarrier.java

import ch.aplu.nxt.*;

public class LightBarrier extends LegoRobot
  implements LightListener
{
  private LightSensor ls;
  private int dimouts = 0;

  public LightBarrier()
  {
    ls = new LightSensor(SensorPort.S1);
    addPart(ls);
    ls.addLightListener(this, 400);
    ls.activate(false);
  }

  public void bright(SensorPort port, int level)
  {
    ls.activate(true);
  }

  public void dark(SensorPort port, int level)
  {
    ls.activate(false);
    dimouts++;
    System.out.println("nb of dimouts: " + dimouts);
    Tools.delay(2000);  // Inhibit for a while
  }

  public int getDimouts()
  {
    return dimouts;
  }
}
