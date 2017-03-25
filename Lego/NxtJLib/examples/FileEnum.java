// FileEnum.java
// Enumerate the files in the brick's file system.

import ch.aplu.nxt.*;

public class FileEnum 
{
  public FileEnum()
  {
    LegoRobot robot = new LegoRobot(0x001963E1DD1CL);
    int nb = 0;
    int totalSize = 0;
    FileInfo fi = robot.findFirst();
    System.out.println("\nEnumerating files...");
    if (fi == null)
      System.out.println("no files found");
    else
    {
      System.out.println(fi.fileName);
      nb++;
      totalSize += fi.fileSize;
      while ((fi = robot.findNext(fi.fileHandle)) != null)
      {
        System.out.println(fi.fileName);
        nb++;
        totalSize += fi.fileSize;
      }
      System.out.println("\nNumber of files: " + nb);
      System.out.println("Total space used: " + totalSize);
    }
    robot.exit();
  }
  public static void main(String[] args)
  {
    new FileEnum();
  }
}
