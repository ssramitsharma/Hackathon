// GenericSensor.java

import ch.aplu.nxt.*;

public class GenericSensor extends Sensor
{
  public GenericSensor(SensorPort port)
  {
    super(port);
  }
  
  protected void init()
  {
    setTypeAndMode(0, RAWMODE);
  }
  
  protected void cleanup()
  {}
    
  public int getValue()
  {
    int value = readRawValue();
    return value;
  }
}
