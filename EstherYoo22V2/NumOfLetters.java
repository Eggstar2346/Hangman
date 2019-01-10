// The "NumOfLetters" class.
import java.awt.*;
import hsa.*;
import java.io.*;

public class NumOfLetters
{
    Console c;           // The output console
    String word;
    
    public void result ()
    {
	BufferedReader input;
	PrintWriter output;
	int y = 0;
	try
	{
	    input = new BufferedReader (new FileReader ("wordsFINAL.txt"));
	    output = new PrintWriter (new FileWriter ("result.txt"));
	    for (int x = 0 ; x <= 99 ; x++)
	    {
		word = input.readLine();
		y = x + 1;
		output.println(y + ". " + word.length());
	    }
	    output.close();
	}
	catch (IOException e)
	{
	}
    }
    
    public NumOfLetters ()
    {
	c = new Console ();
    }
    
    public static void main (String[] args)
    {
	NumOfLetters a = new NumOfLetters ();
	a.result();
    } // main method
} // NumOfLetters class
