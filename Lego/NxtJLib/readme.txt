NxtJLib Java Library for Lego NXT - Readme
Version 1.27, Aug 5, 2014
==================================================================

See the websites www.aplu.ch/nxt for most recent information.
Only Lego bricks running the leJOS firmware are supported.

History:
-------
V1.00 - Aug 2008: - First public beta release, source code not included
V1.01 - Aug 2008: - Added flag inCallback to all sensors to inhibit more
                    than one callback at the same time
V1.02 - Aug 2008: - Added sendFile(), startProgram(), findFirst(), findNext()
V1.03 - Aug 2008: - Added parameter SensorPort in all sensor callbacks
V1.04 - Oct 2008: - Source code included
V1.05 - Nov 2008: - Added CompassSensor, CompassAdapter, CompassListener
                  - Fixed bug in ch.aplu.util.AlarmTimer callback notification
V1.06 - Jan 2009: - Added PrototypeSensor, PrototypeAdapter, PrototypeListener
                  - All SensorAdapters now implement their listener
V1.07 - Feb 2009: - Changed GUI classes in ch.aplu.util to run all Swing
                    methods in EDT
V1.08 - Mar 2009: - Improved some classes in ch.aplu.util
V1.09 - Feb 2010: - Added Gear.isMoving(), added class TurtleCrawler
V1.10 - Apr 2010: - All listener interfaces extends java.util.EventListener
                    in order to be used as bean event properties (for Jython)
                  -  Modified to public: SensorPort.getId(), SensorPort.getLabel()
                  - Added: addXXXListener with default trigger level, setTriggerLevel()
V1.11 - Sep 2010: - Subsequent calls of motor and gear movement methods 
                    return immediately if motor or gear are already in 
                    the requested movement
                  - Added dummy classes NxtContext, Obstacle with empty methods
                    for source compatibility with NxtSim libary
V1.12 - Oct 2010: - Connection pane will stay displayed until program terminates
V1.13 - Oct 2010: - All polling methods call Thread.sleep(10) for better thread 
                    response in narrow loops
V1.14 - Dec 2010: - Update of package ch.aplu.util
V1.15 - Jul 2011: - Gear timed movement methods simplified using Thread.sleep() due to
                    crash if many subsequent calls follow in a tight loop
V1.16 - Oct 2011: - Fixed null pointer exception when connection without showing the connect panel
                  - NxtRobot.disconnect() now waits for cleanup and returns success flag
V1.17 - Aug 2012: - On error Sensor.LSRead() returns null now
                  - Removed some public methods in class UltrasonicSensor              
V1.18 - Aug 2012: - NxtRobot, TurtleRobot, TurtleCrawler ctors overloaded to take
                    the Bluetooth address for fast connection      
V1.19 - Mar 2013: - Key ClosingMode in nxtjlib.properties, throws RuntimeException when
                    using value ReleaseOnClose
V1.20 - Apr 2013: - Removed automatic connection when part methods are called
                  - Connect panel cannot be closed while connecting
V1.21 - Apr 2013: - Hack to install special bluetooth driver for Mac 
                    OSX 10.8, 10.9, 11.0
V1.22 - May 2013: - Some minor adaptions to be used with Jython
V1.25 - Jul 2014: - Fixed: GearState.STOPPED in Gear for all stopping methods
                  - Added: class PackageInfo
V1.26 - Aug 2014: - Added: LCD methods in class LegoRobot for compatibility with EV3JLib
V1.27 - Aug 2014  - Added: in class LegoRobot key events to simulate brick buttons
 

Installation:
------------
   1. Unpack the NxtJLib.zip in any folder

   2. Copy the library jar NxtJLib.jar in subfolder 'lib' into your 
      favorite folder for jar files, e.g. c:\jars

   2a. (For Mac OS X Version 10.8 up): Copy folder/subfolders 'legoNXT' from
      folder 'lib' into the userhome folder. The structure 
      <userhome>/legoNXT/lejosNXJ/lib/bluetooth must contain file IOBluetooth,
      the old OS X Bluetooth driver used by Bluecove.
  
   3. Download the Bluecove library bluecove-xxx.jar from 
      http://code.google.com/p/bluecove (xxx is the current release number).
      Copy it into your favorite folder for jar files, e.g. c:\jars

   4. Create a project with your favorite IDE and add NxtJLib.jar and
      bluecove-xxx.jar to the project library jars

   5. Compile/run some of the examples in the subfolder 'examples',
      e.g. NxtDemo.java. Try to understand the code


For any help or suggestions send an e-mail to support@aplu.ch or post an article
to the forum at www.aplu.ch/forum.
