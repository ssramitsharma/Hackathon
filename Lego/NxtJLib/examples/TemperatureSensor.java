// TemperatureSensor.java

import ch.aplu.nxt.*;

public class TemperatureSensor extends Sensor
{
  private final int zeroPoint = 613;
  private final double scaleFactor = -0.25;
  
  public TemperatureSensor(SensorPort port)
  {
    super(port);
  }
  
  protected void init()
  {
    setTypeAndMode(TEMPERATURE, RAWMODE);
  }
  
  protected void cleanup()
  {}
    
  public double getDegrees()
  {
    int value = readRawValue();
    return scaleFactor * (value - zeroPoint);
  }
}
