// The "Drawman" class.
import java.awt.*;
import hsa.*;
import java.io.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.*; 

public class Drawman
{
    Console c;           // The output console

    //colours declaration
    public Color white = new Color (255, 255, 255);
    public Color black = new Color (0, 0, 0);
    public Color red = new Color (255, 0, 0);
    public Color blue = new Color (153, 255, 255);
    public Color man = new Color (255, 255, 204);
    public Color wood = new Color (153, 76, 0);
    public Color shirt = new Color (102, 178, 255);

    public void draw ()
    {
	//draw white oval around entire thing
	// c.setColor(blue);
	// c.fillOval(-60,60,340,500);
	//drawing poles
	c.setColor(wood);
	c.fillRect(13,450,90,15); //bottom
	c.fillRect(50,130,15,320); //main pole
	c.fillRect(50,130,110,15); //overhanging pole
	c.fillRect(150,130,15,50); //connecting man
	//drawing man
	//step 1: torso
	c.setColor(shirt);
	c.fillOval(125,240,70,120);
	c.setColor(black);
	c.fillArc(126,290,68,70,0,-180);
	//step 3: right leg
	c.fillRect(140,340,13,90);
	//step 4: left leg
	c.fillRect(167,340,13,90);
	//step 5: right arm
	c.setColor(shirt);
	int rarmx [] = {80,80,145,145};
	int rarmy [] = {312,295,240,258};
	c.fillPolygon(rarmx, rarmy,4);
	//hand
	c.setColor(man);
	int rhandx [] = {80,80,90,90};
	int rhandy [] = {312,295,286,304};
	c.fillPolygon(rhandx, rhandy,4);
	//step 6: left arm
	c.setColor(shirt);
	int larmx [] = {170,170,235,235};
	int larmy [] = {240,258,312,295};
	c.fillPolygon(larmx, larmy,4);
	//hand
	c.setColor(man);
	int lhandx [] = {225,225,235,235};
	int lhandy [] = {286,304,312,295};
	c.fillPolygon(lhandx, lhandy,4);
	//game over (x-eyes, tongue hanging)
	c.setColor(black);
	c.drawLine(140,195,150,205); //right eye
	c.drawLine(150,195,140,205);
	c.drawLine(170,195,180,205); //left eye
	c.drawLine(180,195,170,205);
	c.drawLine(145,225,175,225); //mouth
	c.drawLine(145,226,175,226);
	c.setColor(red);
	c.fillArc(150,215,20,25,0,-180);
	//step 2: head
	c.setColor(man);
	c.fillOval (120,170,80,80);
	//you win (open eyes, smiling mouth)
	// c.setColor(white);
	// c.fillOval(135,190,20,20); //right eye whites
	// c.fillOval(165,190,20,20); //left eye whites
	// c.setColor(black);
	// c.fillOval(145,195,11,11); //right eye pupil
	// c.fillOval(165,195,11,11); //left eye pupil
	// c.drawArc(145,215,30,20,0,-180); //mouth
	// c.drawArc(145,214,30,20,0,-180);
	BufferedImage img = null;
	try
	{
	    img = ImageIO.read (new File ("usedLetters.jpg"));
	}
	catch (IOException e)
	{
	}
	c.drawImage (img, 0, 0, null);
    }
    
    public void deleteFile()
    {
	// String file = "test delete.txt";
	// try
	// {
	// file.delete();
	// }
	// catch(IOException e)
	// {
	// }
    }
    
    
    private void draw (int x)
    {
	if (x == 1)
	{
	    //drawing man
	    // head
	    c.setColor (man);
	    c.fillOval (120, 170, 80, 80);
	}
	else if (x == 2)
	{
	    //torso
	    c.setColor (shirt);
	    c.fillOval (125, 240, 70, 120);
	    // head
	    c.setColor (man);
	    c.fillOval (120, 170, 80, 80);
	}
	else if (x == 3)
	{
	    c.setColor (gray);
	    c.fillArc (126, 290, 68, 70, 0, -180);
	    //right leg
	    c.fillRect (140, 340, 13, 90);
	}
	else if (x == 4)
	{
	    //left leg
	    c.setColor (gray);
	    c.fillRect (167, 340, 13, 90);
	}
	else if (x == 5)
	{
	    //right arm
	    c.setColor (shirt);
	    int rarmx[] = {80, 80, 145, 145};
	    int rarmy[] = {312, 295, 240, 258};
	    c.fillPolygon (rarmx, rarmy, 4);
	    //right hand
	    c.setColor (man);
	    int rhandx[] = {80, 80, 90, 90};
	    int rhandy[] = {312, 295, 286, 304};
	    c.fillPolygon (rhandx, rhandy, 4);
	    // head
	    c.setColor (man);
	    c.fillOval (120, 170, 80, 80);
	}
	else if (x == 6)
	{
	    //left arm
	    c.setColor (shirt);
	    int larmx[] = {170, 170, 235, 235};
	    int larmy[] = {240, 258, 312, 295};
	    c.fillPolygon (larmx, larmy, 4);
	    //left hand
	    c.setColor (man);
	    int lhandx[] = {225, 225, 235, 235};
	    int lhandy[] = {286, 304, 312, 295};
	    c.fillPolygon (lhandx, lhandy, 4);
	    // head
	    c.setColor (man);
	    c.fillOval (120, 170, 80, 80);
	}
	if ((x == 7) && (yesWin () == false))
	{
	    //game over (x-eyes, tongue hanging)
	    c.setColor (black);
	    c.drawLine (140, 195, 150, 205); //right eye
	    c.drawLine (150, 195, 140, 205);
	    c.drawLine (170, 195, 180, 205); //left eye
	    c.drawLine (180, 195, 170, 205);
	    c.drawLine (145, 225, 175, 225); //mouth
	    c.drawLine (145, 226, 175, 226);
	    c.setColor (red);
	    c.fillArc (150, 215, 20, 25, 0, -180);
	    delay (1000);
	}
    }


    public Drawman ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	Drawman a = new Drawman ();
	a.draw ();
	a.deleteFile();
    } // main method
} // Drawman class
