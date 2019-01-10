// The "Processing1" class.
import java.awt.*;
import hsa.*;

public class Processing1 extends Thread
{
    Console c;           // The output console
    String word = "hydrocarbons";
    char[] letters = new char [26];
    char guess;
    int currentElement;
    char[] numOfLetters = new char [word.length ()];

    private void title ()
    {
	c.clear ();
	c.print (' ', 37);
	c.println ("Hangman");
	c.println ();
    }


    private void pauseProgram ()
    {
	c.println ();
	c.println ();
	c.print (' ', 25);
	c.print ("Press any key to continue...");
	c.getChar ();
    }


    private void askData ()
    {
	int numOfGuesses = 0;
	int counter = 0;
	while (true)
	{
	    c.println ("Please enter a letter: ");
	    guess = c.getChar ();
	    if (usedLetter () == true)
		c.println ("You already used that letter!");
	    else
	    {
		counter = 0;
		c.println ("You guessed '" + guess + "'.");
		//if guessed letter is not in word, increase numOfGuesses
		for (int x = 0 ; x <= word.length () - 1 ; x++)
		{
		    if (guess != word.charAt (x))
			counter++;
		    else
		    {
			break;
		    }
		    if (counter == word.length ())
		    {
			numOfGuesses++;
			break;
		    }
		}
		c.println (numOfGuesses);
		//cover up letter
		if (yesWin () == true)
		{
		    winScreen ();
		}
		else if ((yesWin () == false) && (numOfGuesses == 7))
		    loseScreen ();
	    }
	}
    }


    private boolean usedLetter ()
    {
	for (int x = 0 ; x <= 25 ; x++)
	{
	    if (guess == letters [x])
	    {
		return true;
	    }
	}
	letters [currentElement] = guess;
	currentElement++;
	return false;
    }


    private void drawMan ()
    {
    }


    //may not need
    private int numOfNonRepeating ()
    {
	int y = 0;
	int counter = 0;
	int currentElement = 0;

	while (true)
	{
	    for (int x = 0 ; x <= word.length () - 1 ; x++)
	    {
		if (word.charAt (y) == numOfLetters [x])
		{
		    break;
		}
		if ((word.charAt (y) != numOfLetters [x]) && (x == currentElement))
		{
		    numOfLetters [currentElement] = word.charAt (y);
		    currentElement++;
		    break;
		}
	    }
	    y++;
	    if (y > word.length () - 1)
	    {
		counter = 0;
		for (int x = 0 ; x <= word.length () - 1 ; x++)
		{
		    if (numOfLetters [x] != '\u0000')
			counter++;
		}
		return counter;
	    }
	}
    }


    private boolean yesWin ()
    {
	int y = word.length () - 1;
	int counter = 0;
	while (true)
	{
	    for (int x = 0 ; x <= letters.length - 1 ; x++)
	    {
		if (word.charAt (y) != letters [x]) //if the letter at y is not equal to letter at x in the array
		{
		    counter++;
		}
		if (counter == letters.length) //if counter is equal to number of elements in array
		{
		    return false;
		}
	    }
	    counter = 0;
	    if (y == 0)
	    {
		return true;
	    }
	    else
		y--;
	}
    }


    public void display ()
    {
	askData ();
    }


    private void winScreen ()
    {
	title ();
	c.println ("You win!");
    }


    private void loseScreen ()
    {
	title ();
	c.println ("You lose!");
    }


    public Processing1 ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Processing1 a = new Processing1 ();
	a.display ();

    } // main method
} // Processing1 class


