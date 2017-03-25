// CrawlerSquare.java
// Turtle-like movement on a square

import ch.aplu.nxt.*;

public class CrawlerSquare
{
  public CrawlerSquare()
  {
    TurtleCrawler t = new TurtleCrawler("NXT");
    for (int i = 0; i < 4; i++)
    {  
      t.forward(100);
      t.left(90);
    }
    t.exit();
  }
  
  public static void main(String[] args)
  {
    new CrawlerSquare();
  }
}
