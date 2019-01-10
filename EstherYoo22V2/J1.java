// The "J1" class.
import java.awt.*;
import hsa.Console;
import java.io.*;

public class J1
{
    Console c;           // The output console
    String[] word = new String [100];
    String[] definitions = new String [100];

    public void wordlist ()
    {
	BufferedReader input;
	PrintWriter output;
	try
	{
	    input = new BufferedReader (new FileReader ("wordsFINAL.txt"));
	    output = new PrintWriter (new FileWriter ("J1 test.txt"));
	    for (int x = 0 ; x < 100 ; x++)
	    {
		word [x] = input.readLine ();
		definitions [x] = input.readLine ();
	    }
	    for (int x = 0 ; x < 100 ; x++)
	    {
		output.println (word [x]);
	    }
	    output.close ();
	}
	catch (IOException e)
	{
	}

    }


    private void draw ()
    {
	c.setColor (Color.BLACK);
	c.drawOval (117, 180, 80, 80); //head
	c.drawLine (157, 260, 157, 360); //body
	c.drawLine (157, 360, 127, 430); //left leg
	c.drawLine (157, 360, 187, 430); //right leg
	c.drawLine (157, 260, 117, 320); //left arm
	c.drawLine (157, 260, 197, 320); //right leg
	//game over (x-eyes, tongue hanging)
	c.setColor (Color.BLACK);
	c.drawLine (137, 200, 147, 210); //right eye
	c.drawLine (147, 200, 137, 210);
	c.drawLine (167, 200, 177, 210); //left eye
	c.drawLine (177, 200, 167, 210);
	c.drawLine (142, 235, 172, 235); //mouth
	c.drawLine (142, 236, 172, 236);
	c.setColor (Color.BLACK);
	c.fillArc (148, 225, 20, 25, 0, -180);
    }


    public J1 ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	J1 a = new J1 ();
	a.wordlist ();
	a.draw ();
    } // main method
} // J1 class
