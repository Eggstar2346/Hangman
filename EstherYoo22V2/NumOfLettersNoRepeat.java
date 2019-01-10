import java.awt.*;
import hsa.*;
import java.io.*;

public class NumOfLettersNoRepeat
{
    Console c;           // The output console
    String word;
    int counter;
    boolean[] array = new boolean [123];

    public void result ()
    {
	BufferedReader input;
	PrintWriter output;
	int a = 0;
	int letters = 0;
	try
	{
	    input = new BufferedReader (new FileReader ("wordsFINAL.txt"));
	    output = new PrintWriter (new FileWriter ("result2.txt"));
	    for (int x = 0 ; x <= 99 ; x++)
	    {
		word = input.readLine ();
		for (int y = 0 ; y <= word.length () - 1 ; y++)
		{
		    array [word.charAt (y)] = true;

		}
		for (int y = 0 ; y < 123 ; y++)
		{
		    if (array [y])
		    {
			letters++;
			c.print ("HOLA");
		    }
		}
		c.print ("END");
		output.println (x + 1 + ". " + letters);
		letters = 0;
		array = new boolean [123];

	    }
	    output.close ();
	}
	catch (IOException e)
	{
	}
    }


    public NumOfLettersNoRepeat ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	NumOfLettersNoRepeat a = new NumOfLettersNoRepeat ();
	a.result ();
    } // main method
} // NumOfLetters class
