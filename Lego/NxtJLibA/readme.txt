NxtJLibA Java Library for Lego NXT (autonomous mode) - Readme
Version 1.21, August 10, 2012
==================================================================

This version runs only with NXT firmware version 0.91beta-3! For installing the
firmware, download the leJOS NXJ distribution 0.91beta-3 and follow the 
instructions given there. 

We give a simple recipe here (under Windows):
1. Download the Lego NXT USB driver from the Lego Website and install it.
2. Connect the NXT to the USB port. The Lego Device should be recognized.
3. Execute the leJOS installation program.
4. Put the NXT in the  firmware download mode by resetting it (pressing the
   small almost hidden button in the stick hole under the USB port).
5. Go to the bin subdirectory of the leJOS home directory and run nxjflash.bat.

See the websites www.aplu.ch/nxt for most recent information.
Only Lego bricks running the leJOS firmware are supported.


History:
-------
  V1.00 - Aug 2008:
    - First official release
  V1.01 - Aug 2008:
    - Added flag inCallback for all sensors to inhibit more than
      one callback at the same time
  V1.02 - Aug 2008:
    - Added sendFile(), startProgram(), findFirst(), findNext()
  V1.03 - Aug 2008:
    - Added parameter SensorPort in all sensor callback methods
  V1.04 - Oct 2009:
    - Source code included
    - JavaDoc revisted
    - Modified: Motor.continueTo() turns now to absolute position
    - Added: Motor.continueRelativeTo()
    - Modified: LightSensor init turns LED off
  V1.05 - Nov 2008:
    - Added CompassSensor, CompassAdapter, CompassListener
    - Bug fixed in ch.aplu.util.AlarmTimer callback notification
  V1.06 - Jan 2009:
    - Added PrototypeSensor, PrototypeAdapter, PrototypeListener
    - All SensorAdapters now implement their listener          
  V1.07 - Feb 2009:
    - Compile Java SE V5 for backward compatibilty
  V1.08 - Apr 2009:
    - btc.setIOMode(NXTConnection.RAW) instead of btc.setIOMode(0)
      in BluetoothServer.java (compatible for leJOS 0.7)
  V1.09 - Apr 2009:
    - Same for BluetootClient.java
  V1.10 - Jan 2010:
    - Release for leJOS 0.85
  V1.11 - Feb 2010
    - RFID sensor added
    - TurtleCrawler added
  V1.12 - Apr 2010
    - Modified to public: SensorPort.getId(), SensorPort.getLabel()
    - Modified to public: MotorPort.getId(), MotorPort.getLabel()
    - Added: addXXXListener with default trigger level, setTriggerLevel()
    - Added ColorLightSensor
    - Fixed wrong error messages
    - Added check for port conflicts
    - Firmware previous to 0.85 no longer supported

  V1.13 - May 2010
    - Added SensorPort.equals() to compare port labels
    - Added Transceiver.releaseConnection(), Transceiver.isConnected()
    - Added TransceiverListener.isListening() to notify when server starts

 V1.14 - Sep 2010
    - Subsequent calls of motor and gear movement methods return immediately
      if motor or gear are already in the requested movement
    - Added dummy classes NxtContext, Obstacle with empty methods
      for source compatibility with NxtSim libary

 V1.15 - Apr 2011
    - Added classes to support HiTechnics sensors: accelerometer sensor,
      color sensor, gyro sensor

 V1.16 - Jul 2011
    - Gear timed movement methods simplified using Thread.sleep() due to
      crash if many subsequent calls follow in a tight loop

 V1.17 - Sep 2011
    - Ported to leJOS version 0.90 (modifications in classes ColorSensor, ColorSensorHT
      and Motor)

 V1.18 - March 2011
    - Ported to leJOS version 0.91
    - Added: class SuperProSensor to support HiTechnic NXT SuperPro Prototype Board

 V1.19 - March 2011
    - Ported to leJOS version 0.91beta-2
    - Motor.stop() now returns immediately, unlike lejos.nxt.Motor.stop(),
      but like lejos.nxt.Motor.stop(true)
 V1.20 - March 2011
    - Ported to leJOS version 0.91beta-3
 V1.21 - March 2011
    - classes.jar now contains patched original leJOS version (Added some
      lines in Motor.java, LCD.java, added Car.java, Tools.java)


Installation:
------------
   1. Unpack the NxtJLibA.zip in any folder

   2. We packed the NxtJLibA library in the NXJ library (version 0.91) 
      classes.jar found in the subfolder 'lib' of the NXJ environment. 
      Backup the orginal version and replace it with our classes.jar.
      This results that you can import all original leJOS packages plus
      the new APLU packages in the same project.

   3. Compile/run some of the examples in the subfolder 'examples'.
      Try to understand the code.



Bluetooth connection:
--------------------

For programs using Bluetooth to communicate between two NXTs or a NXT and
a PC, the two devices must be "paired" e.g. a security code must be accepted
by the partner device. On NXT use Bluetooth | Search and Pair.


For any help or suggestions send an e-mail to support@aplu.ch or post an
article in the forum at www.aplu.ch/forum
