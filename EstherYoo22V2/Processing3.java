// The "Processing3" class.
import java.awt.*;
import hsa.*;
import java.io.*;

public class Processing3
{
    Console c;           // The output console
    String word = "hello";
    public Color black = new Color (0, 0, 0);

    public void drawLine ()
    {
	c.setColor (black);
	for (int x = 0 ; x <= 390 ; x = x + 27)
	{
	    c.drawLine (230+x, 480, 250+x, 480);
	    c.drawLine (230+x, 481, 250+x, 481);
	}
    }


    public Processing3 ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Processing3 a = new Processing3 ();
	a.drawLine ();
    } // main method
} // Processing3 class
