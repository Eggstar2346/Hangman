import java.applet.*;   // allows access to MediaTracker
import java.awt.*;
import hsa.*;

public class DisplayPic
{
    Console c;
    Image picture;                   // image class

    public void loadImage ()          // This sets up the image
    {
	picture = Toolkit.getDefaultToolkit ().getImage ("mypic.gif");      // Load the image.

	// Now, it can actually take some time to load the image, and
	// it could fail (image not found, etc).  The following checks for  all that.
	// The MediaTracker class is a utility class to track the status of a number of media objects. 
	// Media objects could include audio clips as well as images, though currently only images are supported. 
	MediaTracker tracker = new MediaTracker (new Frame ());

	tracker.addImage (picture, 0);  // Add the picture to the list of images to be tracked

	// Wait until all the images are loaded.  This can throw an
	// InterruptedException although it's not likely, so we ignore  it if it occurs.

	try
	{
	    tracker.waitForAll ();
	}
	catch (InterruptedException e)
	{
	}

	if (tracker.isErrorAny ())      // If there were any errors then abort the program
	{
	    c.println ("Couldn't load " + "mypic.gif");
	    return;
	}
    } // init method


    public void displayImage ()
    {
	c.drawImage (picture, 100, 100, null);
	c.println ("picture width = " + picture.getWidth (null));
	c.println ("picture height = " + picture.getHeight (null));

	c.println ("Console window width = " + c.getWidth ());
	c.println ("Console window height = " + c.getHeight ());

    }


    public DisplayPic ()      // Create the console
    {
	c = new Console ();
    }


    public static void main (String[] args)
    {
	DisplayPic n = new DisplayPic ();

	// Load the picture
	n.loadImage ();
	n.displayImage ();
    } // main method
} // BouncePicConsole class







