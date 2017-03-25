// DiffVoltageSensor.java

import ch.aplu.nxt.*;

public class DiffVoltageSensor extends GenericSensor
{
  private final int zeroPoint = 522;
  private final double scaleFactor = -0.0127;
  
  public DiffVoltageSensor(SensorPort port)
  {
    super(port);
  }
  
  public double getVoltage()
  {
    int value = getValue();
    return scaleFactor * (value - zeroPoint);
  }
}
