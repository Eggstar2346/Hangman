import java.awt.*;
import hsa.Console;
import java.io.*;

public class Highscores
{
    Console c;
    String word;
    int[] score = new int [10];
    String[] name = new String [10];

    public void readSort ()
    {
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("highscores1.txt"));
	    for (int x = 0 ; x <= 9 ; x++)
	    {
		while (word != null)
		{
		    for (int y = 0 ; y <= score.length ; y++)
		    {
			word = input.readLine ();
			score [y] = Integer.parseInt (word);
			c.println(score[y]);
		    }
		}
		for (int i = 0 ; i < score.length ; i++)
		{
		    for (int j = 0 ; j < score.length - 1 ; j++)
		    {
			int temp; //temporary
			if (score [j] >= score [j + 1])
			{
			    temp = score [j];
			    score [j] = score [j + 1];
			    score [j + 1] = temp;
			}
		    }
		}
	    }


	}
	catch (IOException e)
	{
	}
	int x = 0;
	while (score[x] != 0)
	{
	    c.println (score [x]);
	    x++;
	}
    }


    public void readScores ()
    {
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("highscores1.txt"));
	    word = input.readLine ();
	    for (int x = 0 ; x <= 9 ; x++)
	    {
		while (word != null)
		{
		    name [x] = word;
		    score [x] = Integer.parseInt (input.readLine ());
		    c.println (name [x]);
		    c.println (score [x]);
		    word = input.readLine ();
		}
	    }


	}
	catch (IOException e)
	{
	}
    }


    public void write ()
    {
	PrintWriter output;
	try
	{
	    output = new PrintWriter (new FileWriter ("highscores1.txt"));
	    output.println ("hi");
	    output.close ();
	}
	catch (IOException e)
	{
	}

    }


    public Highscores ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Highscores a = new Highscores ();
	//a.readScores ();
	//a.write();
	a.readSort ();
    }
} // Highscores class
