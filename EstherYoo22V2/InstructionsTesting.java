// The "InstructionsTesting" class.
import java.awt.*;
import hsa.*;
import java.io.*;

public class InstructionsTesting
{
    Console c;           // The output console
    String[] array = new String [24];
    char movement;

    private void loadImage (String picName)
    {
	Image picture;
	picture = Toolkit.getDefaultToolkit ().getImage (picName);
	MediaTracker tracker = new MediaTracker (new Frame ());

	tracker.addImage (picture, 0);
	try
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e)
	{
	}

	c.drawImage (picture, 0, 0, null);

	if (tracker.isErrorAny ())      // If there were any errors then abort the program
	{
	    c.println ("Couldn't load picture");
	    return;
	}
    } // init method


    private void whichPic (int instructionNum)
    {
	String filename = "Instructions" + instructionNum + ".jpg";
	loadImage (filename);
	if (instructionNum != 1 && instructionNum != 3 && instructionNum != 9 && instructionNum != 14 && instructionNum != 19 && instructionNum != 21)
	{
	    c.setCursor (1, 1);
	    c.println (array [instructionNum]);
	}

	// if (instructionNum == 2)
	//     loadImage("Instructions0.jpg");
	// else if (instructionNum == 4)
	//     loadImage("Instructions1.jpg");
	// else if (instructionNum == 5)
	//     loadImage("Instructions2.jpg");
	// else if (instructionNum == 6)
	//     loadImage("Instructions3.jpg");
	// else if (instructionNum == 7)
	//     loadImage("Instructions4.jpg");
	// else if (instructionNum == 8)
	//     loadImage("Instructions5.jpg");
	// else if (instructionNum == 10)
	//     loadImage("Instructions6.jpg");
	// else if (instructionNum == 11)
	//     loadImage("Instructions7.jpg");
	// else if (instructionNum == 12)
	//     loadImage("Instructions8.jpg");
	// else if (instructionNum == 13)
	//     loadImage("Instructions9.jpg");
	// else if (instructionNum == 15)
	//     loadImage("Instructions10.jpg");
	// else if (instructionNum == 16)
	//     loadImage("Instructions11.jpg");
	// else if (instructionNum == 17)
	//     loadImage("Instructions11.jpg");
	// else if (instructionNum == 18)
	//     loadImage("Instructions13.jpg");
	// else if (instructionNum == 20)
	//     loadImage("Instructions14.jpg");
	// else if (instructionNum == 22)
	//     loadImage("Instructions15.jpg");
	// else if (instructionNum == 23)
	//     loadImage("Instructions16.jpg");
    }


    public void showInstructions ()
    {
	loadImage ("Instructions.jpg");
	new Message ("Navigate through the instructions using 'd' (move forward) and 'a' (move backward). Press backspace to quit.","INSTRUCTIONS");
	int y = 0;
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("Instructions.txt"));
	    input.readLine ();
	    for (int x = 0 ; x <= 23 ; x++)
	    {
		array [x] = input.readLine ();
	    }
	}
	catch (IOException e)
	{
	}
	while (true)
	{
	    movement = c.getChar ();
	    if (movement == 68 || movement == 100 || movement == 65 || movement == 97)
	    {
		if (movement == 68 || movement == 100)
		    y++;
		else
		    y--;
		if (y > 23)
		    y = 23;
		else if (y < 1)
		    y = 1;
		whichPic (y);
	    }
	    else if (movement == 8)
		break;
	    else
		new Message ("Please enter only 'a', 'd', or space!", "INVALID INPUT");

	    // if (y == 1)
	    //     loadImage("InstructionsIntro2.jpg");
	    // else if (y == 3)
	    //     loadImage("InstructionsIntro3.jpg");
	    // else if (y == 9)
	    //     loadImage("InstructionsIntro4.jpg");
	    // else if (y == 14)
	    //     loadImage("InstructionsIntro5.jpg");
	    // else if (y == 19)
	    //     loadImage("InstructionsIntro6.jpg");
	    // else if (y == 21)
	    //     loadImage("InstructionsIntro7.jpg");
	    // else
	    // {

	    // c.setCursor(1,1);
	    // c.println(array[y]);
	}
    }


    public InstructionsTesting ()
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	InstructionsTesting a = new InstructionsTesting ();
	a.showInstructions ();
    } // main method
} // InstructionsTesting class
