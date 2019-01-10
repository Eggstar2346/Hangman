// The "Highscores2" class.
import java.awt.*;
import hsa.Console;
import java.io.*;

public class Highscores2
{
    Console c;           // The output console
    int[] score = new int [10];
    int num;
    String word;

    public void read ()
    {
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("highscores1.txt"));
	    for (int q = 0 ; q <= 9 ; q++)
	    {
		word = input.readLine ();
		if (word == null)
		    break;
		score [q] = Integer.parseInt (word);
	    }
	    // for (int i = 0 ; i <= 9 ; i++)
	    // {
	    // for (int j = 0 ; j <= 8 ; j++)
	    // {
	    //     int temp; //temporary
	    //     if (score [j] >= score [j + 1])
	    //     {
	    //         temp = score [j];
	    //         score [j] = score [j + 1];
	    //         score [j + 1] = temp;
	    //     }
	    // }
	    // }
	    // int temp;
	    // for (int u = 0 ; u <= 9 ; u++)
	    // {
	    //     try
	    //     {
	    //         for (int r = 1 ; r <= 9 ; r++)
	    //         {
	    //             if (score [r] == 0)
	    //                 break;
	    //             if (score [r - 1] >= score [r])
	    //             {
	    //                 temp = score [r - 1];
	    //                 score [r - 1] = score [r];
	    //                 score [r] = temp;
	    //             }
	    //         }
	    //     }
	    //     catch (Exception p)
	    //     {
	    //     }
	    // }
	    int tempScore = 0;
	    String tempName = "";
	    if (score > scores [0])
	    {
		scores [0] = score;
		names [0] = name;
		for (int u = 0 ; u <= 9 ; u++)
		{
		    try
		    {
			for (int r = 1 ; r <= 9 ; r++)
			{
			    if (scores [r] == 0)
				break;
			    if (scores [r - 1] > scores [r])
			    {
				tempScore = scores [r - 1];
				tempName = names [r - 1];
				scores [r - 1] = scores [r];
				names [r - 1] = names [r];
				scores [r] = tempScore;
				names [r] = tempName;
			    }
			}
		    }
		    catch (Exception p)
		    {
		    }
		}
	    }
	    for (int x = 0 ; x <= 9 ; x++)
	    {
		if (score [x] == 0)
		    break;
		c.println (score [x]);
	    }
	}


	catch (IOException e)
	{
	}
    }


    public Highscores2 ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Highscores2 a = new Highscores2 ();
	a.read ();
    } // main method
} // Highscores2 class
