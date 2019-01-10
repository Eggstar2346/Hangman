// The "Animation" class.
import java.awt.*;
import hsa.*;

public class Animation extends Thread
{
    Console c;           // The output console
    public Color white = new Color (255, 255, 255);
    public Color blue = new Color (153, 255, 255);
    public Color man = new Color (255, 255, 204);
    public Color wood = new Color (153, 76, 0);
    public Color black = new Color (0, 0, 0);
    public Color red = new Color (255, 0, 0);
    public Color shirt = new Color (102, 178, 255);
    public Color background = new Color (10, 8, 21);
    public Color gray = new Color (160, 160, 160);

    private void delay (int time)
    {
	try
	{
	    Thread.sleep (time);
	}
	catch (Exception e)
	{
	}
    }


    public void animation ()
    {
	c.setColor (wood);
	for (int x = 0 ; x <= 420 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (23, 0 + x, 100, 15); //bottom
	    c.setColor (white);
	    c.fillRect (23, -15 + x, 100, 15);
	    delay (2);

	}
	for (int x = 0 ; x <= 420 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (65, -320 + x, 15, 320); //main pole
	    c.setColor (white);
	    c.fillRect (65, -640 + x, 15, 320);
	    delay (1);
	}
	for (int x = 0 ; x <= 100 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (65, 0 + x, 120, 15); //overhanging pole
	    c.setColor (white);
	    c.fillRect (65, -15 + x, 120, 15);
	    delay (2);
	}
	for (int x = 0 ; x <= 100 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (170, 0 + x, 15, 50); //connecting man
	    c.setColor (white);
	    c.fillRect (170, -50 + x, 15, 50);
	    delay (2);
	}
	//hangman pops up
	c.setColor (black);
	c.drawOval (137, 150, 80, 80); //head
	c.drawLine (177, 230, 177, 330); //body
	c.drawLine (177, 330, 147, 400); //left leg
	c.drawLine (177, 330, 207, 400); //right leg
	c.drawLine (177, 230, 137, 290); //left arm
	c.drawLine (177, 230, 217, 290); //right leg
	//HANGMAN lettering
	for (int x = 0 ; x <= 320 ; x = x + 50)
	{
	    c.drawLine (265 + x, 100, 295 + x, 100);
	    c.drawLine (265 + x, 101, 295 + x, 101);
	}
	c.setFont (new Font ("Lucida Handwriting", Font.TRUETYPE_FONT, 40));
	c.drawString ("H", 260, 95);
	delay(400);
	c.drawString ("A", 315, 95);
	c.drawString ("A", 515, 95);
	delay(800);
	c.drawString ("N", 365, 95);
	delay(700);
	c.drawString ("G", 415, 95);
	delay(500);
	c.drawString ("M", 460, 95);
	delay(300);
	c.drawString ("N", 565, 95);
	delay(800);
	//skateboard
	for (int x = 0 ; x <= 720 ; x++)
	{
	    if (x == 177)
	    {
		for (int y = 0 ; y <= 60 ; y++)
		{
		    c.setColor (white);
		    c.fillRect (137, 150 + y, 81, 250);
		    c.setColor (black);
		    c.drawOval (137, 151 + y, 80, 80); //head
		    c.drawLine (177, 231 + y, 177, 331 + y); //body
		    c.drawLine (177, 331 + y, 147, 401 + y); //left leg
		    c.drawLine (177, 331 + y, 207, 401 + y); //right leg
		    c.drawLine (177, 231 + y, 137, 291 + y); //left arm
		    c.drawLine (177, 231 + y, 217, 291 + y); //right leg
		    delay (1);
		}
	    }
	    c.setColor (white); //erase
	    c.fillRect (-85 + x, 460, 150, 40);
	    c.setColor (gray); //draw wheels
	    c.fillOval (-60 + x, 470, 20, 20);
	    c.fillOval (30 + x, 470, 20, 20);
	    c.setColor (black); //draw board
	    c.fillOval (-80 + x, 460, 150, 15);
	    if (x >= 178)
	    {
		c.setColor (white);
		c.fillRect (-41+x, 210, 85, 250);
		c.setColor (black);
		c.drawOval (-40+x, 211, 80, 80); //head
		c.drawLine (0+x, 291, 0+x, 391); //body
		c.drawLine (0+x, 391, -30+x, 461); //left leg
		c.drawLine (0+x, 391, 30+x, 461); //right leg
		c.drawLine (0+x, 291, -40+x, 351); //left arm
		c.drawLine (0+x, 291, 40+x, 351); //right leg
	    }
	    delay (10);
	}
    }


    public Animation ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Animation a = new Animation ();
	a.animation ();
    } // main method
} // Animation class
