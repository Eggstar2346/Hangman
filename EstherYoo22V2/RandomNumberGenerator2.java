// The "RandomNumberGenerator2" class.
import java.awt.*;
import hsa.*;

public class RandomNumberGenerator2
{
    Console c;           // The output console
    int num;
    boolean[] array = new boolean [4];

    private int rand ()
    {
    int counter = 0;
	while (true)
	{
	    counter = 0;
	    num = (int) (Math.random () * 4) + 1;
	    System.out.println(num);
	    if (!array [num - 1])
	    {
		array [num - 1] = true;
		return num;
	    }
	    for (int x = 0; x <= 3; x++)
	    {
		if (array[x])
		    counter++;
		if (counter == 4)
		    return 1000;
	    }
	}
    }
    
    public void work ()
    {
    while (true)
    {
       c.println(rand());
       c.getChar();
       }
    }


    public RandomNumberGenerator2 ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	RandomNumberGenerator2 a = new RandomNumberGenerator2 ();
	a.work ();
    } // main method
} // RandomNumberGenerator2 class
