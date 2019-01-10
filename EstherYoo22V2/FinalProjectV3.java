/*
Name: Esther Yoo
Teacher: Ms Dyke
Due Date: Monday January 18 2016
This program contains the final copy of my ISP, the game 'Hangman'.
*/

import java.awt.*;
import hsa.*;
import java.io.*;
import java.awt.Graphics;

public class FinalProjectV3 extends Thread
{
    Console c;
    String choice;
    String word;
    String hint;
    String name;
    int score;
    static final int TOTALWORDS = 100;
    boolean maxWord;
    boolean[] words = new boolean [TOTALWORDS];
    int[] scores = new int [10];
    String[] names = new String [10];
    String[] instructions = new String [24];
    int rand;
    char[] letters = new char [26];
    char guess;
    boolean firstRun;
    int currentElement;
    public Color white = new Color (255, 255, 255);
    public Color wood = new Color (153, 76, 0);
    public Color black = new Color (0, 0, 0);
    public Color chalkboard = new Color (19, 65, 36);
    public Color chalkBlue = new Color (204, 229, 255);


    private void loadImage (String picName, boolean yesClear)
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
	if (yesClear)
	{
	    c.clear ();
	}
	c.drawImage (picture, 0, 0, null);

	if (tracker.isErrorAny ())
	{
	    c.println ("Couldn't load picture");
	    return;
	}
    }


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


    private void draw (int x)
    {
	c.setColor (white);
	if (x == 1)
	{
	    c.drawOval (117, 180, 80, 80); //head
	}
	else if (x == 2)
	{
	    c.drawLine (157, 260, 157, 360); //body
	}
	else if (x == 3)
	{
	    c.drawLine (157, 360, 127, 430); //left leg
	}
	else if (x == 4)
	{
	    c.drawLine (157, 360, 187, 430); //right leg
	}
	else if (x == 5)
	{
	    c.drawLine (157, 260, 117, 320); //left arm
	}
	else if (x == 6)
	{
	    c.drawLine (157, 260, 197, 320); //right leg
	}
	if ((x == 7) && (yesWin () == false))
	{
	    //game over (x-eyes, tongue hanging)
	    c.setColor (white);
	    c.drawLine (137, 200, 147, 210); //right eye
	    c.drawLine (147, 200, 137, 210);
	    c.drawLine (167, 200, 177, 210); //left eye
	    c.drawLine (177, 200, 167, 210);
	    c.drawLine (142, 235, 172, 235); //mouth
	    c.drawLine (142, 236, 172, 236);
	    c.fillArc (148, 225, 20, 25, 0, -180);
	    delay (1000);
	}
    }


    private void pauseProgram ()
    {
	c.setFont (new Font ("Times New Roman", Font.TRUETYPE_FONT, 20));
	c.drawString ("Press any key to continue...", 250, 480);
	c.getChar ();
    }


    public void splashScreen ()
    {
	loadScores ();
	loadImage ("menusplash2.jpg", true);
	c.setColor (wood);
	for (int x = 0 ; x <= 420 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (23, 0 + x, 100, 15); //bottom
	    c.setColor (chalkboard);
	    c.fillRect (23, -15 + x, 100, 15);
	    delay (2);

	}
	for (int x = 0 ; x <= 420 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (65, -320 + x, 15, 320); //main pole
	    c.setColor (chalkboard);
	    c.fillRect (65, -640 + x, 15, 320);
	    delay (1);
	}
	for (int x = 0 ; x <= 100 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (65, 0 + x, 120, 15); //overhanging pole
	    c.setColor (chalkboard);
	    c.fillRect (65, -15 + x, 120, 15);
	    delay (2);
	}
	for (int x = 0 ; x <= 100 ; x++)
	{
	    c.setColor (wood);
	    c.fillRect (170, 0 + x, 15, 50); //connecting man
	    c.setColor (chalkboard);
	    c.fillRect (170, -50 + x, 15, 50);
	    delay (2);
	}
	//hangman pops up
	c.setColor (white);
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
	delay (400);
	c.drawString ("A", 315, 95);
	c.drawString ("A", 515, 95);
	delay (800);
	c.drawString ("N", 365, 95);
	delay (700);
	c.drawString ("G", 415, 95);
	delay (500);
	c.drawString ("M", 460, 95);
	delay (300);
	c.drawString ("N", 565, 95);
	delay (800);
	//skateboard
	for (int x = 0 ; x <= 720 ; x++)
	{
	    if (x == 177)
	    {
		for (int y = 0 ; y <= 60 ; y++)
		{
		    c.setColor (chalkboard);
		    c.fillRect (137, 150 + y, 81, 250);
		    c.setColor (white);
		    c.drawOval (137, 151 + y, 80, 80); //head
		    c.drawLine (177, 231 + y, 177, 331 + y); //body
		    c.drawLine (177, 331 + y, 147, 401 + y); //left leg
		    c.drawLine (177, 331 + y, 207, 401 + y); //right leg
		    c.drawLine (177, 231 + y, 137, 291 + y); //left arm
		    c.drawLine (177, 231 + y, 217, 291 + y); //right leg
		    delay (1);
		}
	    }
	    c.setColor (chalkboard); //erase
	    c.fillRect (-85 + x, 460, 150, 40);
	    c.setColor (chalkBlue); //draw wheels
	    c.fillOval (-60 + x, 470, 20, 20);
	    c.fillOval (30 + x, 470, 20, 20);
	    c.setColor (white); //draw board
	    c.fillOval (-80 + x, 460, 150, 15);
	    if (x >= 178)
	    {
		c.setColor (chalkboard);
		c.fillRect (-41 + x, 210, 85, 250);
		c.setColor (white);
		c.drawOval (-40 + x, 211, 80, 80); //head
		c.drawLine (0 + x, 291, 0 + x, 391); //body
		c.drawLine (0 + x, 391, -30 + x, 461); //left leg
		c.drawLine (0 + x, 391, 30 + x, 461); //right leg
		c.drawLine (0 + x, 291, -40 + x, 351); //left arm
		c.drawLine (0 + x, 291, 40 + x, 351); //right leg
	    }
	    delay (10);
	}
	firstRun = true;
    }


    private int randNum ()
    {
	int counter = 0;
	while (true)
	{
	    counter = 0;
	    rand = (int) (Math.random () * 100) + 1;
	    if (!words [rand - 1])
	    {
		words [rand - 1] = true;
		return rand;
	    }
	    for (int x = 0 ; x <= 3 ; x++)
	    {
		if (words [x])
		    counter++;
		if (counter == 100)
		    return 1000;
	    }
	}
    }


    public void mainMenu (boolean firstRun)
    {
	if (firstRun)
	    loadImage ("menu.png", false);
	else
	    loadImage ("menu2.jpg", true);
	while (true)
	{
	    c.setCursor (23, 0);
	    c.println ();
	    c.setCursor (23, 40);
	    choice = c.readLine ();
	    if (choice.equals ("1") || choice.equals ("2") || choice.equals ("3") || choice.equals ("4"))
		break;
	    new Message ("Please input either 1, 2, 3, or 4!");
	}
    }


    public void chooseLevel ()
    {
	loadImage ("chooselevel.jpg", true);
	while (true)
	{
	    c.setCursor (23, 0);
	    c.println ();
	    c.setCursor (23, 40);
	    choice = c.readLine ();
	    if (choice.equals ("1") || choice.equals ("2"))
		break;
	    new Message ("Please input either 1 or 2!");
	}
	//generate (or call a method that generates) a random num, check its range to determine background (for lvl 1)

	if (choice.equals ("1"))
	{
	    introScreen ();
	}
	else
	{
	    loadImage ("INTRO MYSTERY.jpg", true);
	}
	delay (2000);
    }


    public void enterName ()
    {
	int counter = 0;
	loadImage ("menusplash2.jpg", true);
	c.setFont (new Font ("Lucida Handwriting", Font.TRUETYPE_FONT, 25));
	c.setColor (white);
	c.drawString ("Your score is " + score, 200, 250);
	c.drawString ("Please enter your username: ", 140, 350);
	while (true)
	{
	    c.setCursor (20, 0);
	    c.println ();
	    c.setCursor (20, 40);
	    name = c.readLine ();
	    if ((name.length () <= 15) && (name.indexOf ("\"") == -1) && (name.indexOf ("*") == -1) && (name.indexOf ("/") == -1) && (name.indexOf ("\\") == -1) && (name.indexOf ("[") == -1) && (name.indexOf ("]") == -1) && (name.indexOf (":") == -1) && (name.indexOf (";") == -1) && (name.indexOf ("|") == -1) && (name.indexOf ("=") == -1) && (name.indexOf ("<") == -1) && (name.indexOf (">") == -1) && (name.indexOf ("?") == -1) && (name.indexOf (",") == -1) && (name.indexOf ("+") == -1))
		break;
	    new Message ("Your username cannot be longer than 15 characters, and may not contain the following characters: [spaces] / \\ [ ] : ; | = , + * ? < > ", "INVALID USERNAME!");

	}
    }


    private String chooseWord ()
    {
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("wordsFINAL.txt"));
	    for (int x = 1 ; x < rand ; x++)
	    {
		input.readLine ();
	    }
	    word = input.readLine ();
	}
	catch (IOException e)
	{
	}
	return word;
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


    private void introScreen ()
    {
	if ((rand >= 1) && (rand <= 10))
	{
	    loadImage ("INTRO BIO.jpg", true);
	}
	else if ((rand >= 11) && (rand <= 20))
	{
	    loadImage ("INTRO CHEM.jpg", true);
	}
	else if ((rand >= 21) && (rand <= 30))
	{
	    loadImage ("INTRO PHYSICS.jpg", true);
	}
	else if ((rand >= 31) && (rand <= 40))
	{
	    loadImage ("INTRO COMP SCI.jpg", true);
	}
	else if ((rand >= 41) && (rand <= 50))
	{
	    loadImage ("INTRO MATH.jpg", true);
	}
	else if ((rand >= 51) && (rand <= 60))
	{
	    loadImage ("INTRO ENGLISH.jpg", true);
	}
	else if ((rand >= 61) && (rand <= 70))
	{
	    loadImage ("INTRO MUSIC.jpg", true);
	}
	else if ((rand >= 71) && (rand <= 80))
	{
	    loadImage ("INTRO ART.jpg", true);
	}
	else if ((rand >= 81) && (rand <= 90))
	{
	    loadImage ("INTRO HISTORY.jpg", true);
	}
	else if ((rand >= 91) && (rand <= 100))
	{
	    loadImage ("INTRO GEO.jpg", true);
	}
    }


    private void setUp ()
    {
	word = chooseWord ();
	loadImage ("menusplash2.jpg", true);
	loadImage ("usedLetters.jpg", false);
	if (choice.equals ("1"))
	{
	    BufferedReader input;
	    try
	    {
		input = new BufferedReader (new FileReader ("hintsFinal.txt"));
		for (int x = 1 ; x < rand ; x++)
		{
		    input.readLine ();
		}
		hint = input.readLine ();
	    }
	    catch (IOException e)
	    {
	    }
	}
	c.setColor (wood);
	c.fillRect (13, 450, 90, 15); //bottom
	c.fillRect (50, 130, 15, 320); //main pole
	c.fillRect (50, 130, 110, 15); //overhanging pole
	c.fillRect (150, 130, 15, 50); //connecting man
    }


    public void display ()
    {
	int x = 0;
	int y = 0;
	int numOfGuesses = 0;
	int usedLetterScore = 0;
	int counter = 0;
	int index = 0;
	int guessInt = 0;
	setUp ();
	c.setColor (white);
	for (int b = 0 ; b <= (word.length () - 1) * 30 ; b = b + 30)
	{
	    c.drawLine (185 + b, 160, 205 + b, 160);
	    c.drawLine (185 + b, 161, 205 + b, 161);
	}
	c.setColor (white);
	c.setFont (new Font ("Times New Roman", Font.TRUETYPE_FONT, 25));
	c.drawString ("Please enter a letter: ", 250, 276);
	while (true)
	{
	    guess = c.getChar ();
	    if ((guess >= 65) && (guess <= 90))
	    {
		guessInt = (int) guess + 32;
		guess = (char) guessInt;
	    }
	    if ((guess == '?') && (choice.equals ("1")))
	    {
		new Message (hint, "HINT");
	    }
	    if ((guess == '!') && (choice.equals ("2")))
	    {
		new Message (word, "ANSWER");
	    }
	    else if (guess <= 64 || (guess >= 91 && guess <= 96) || guess >= 123)
	    {
		new Message ("Please enter only letters!", "INVALID CHARACTER");
	    }
	    else
	    {
		c.setColor (chalkboard);
		c.fillRect (452, 253, 30, 30);
		c.setColor (white);
		c.drawString ("" + guess, 455, 276);
		if (usedLetter () == true)
		{
		    usedLetterScore++;
		    new Message ("You already used that letter!", "UH OH!");
		    c.setColor (chalkboard);
		    c.fillRect (452, 253, 30, 30);
		}
		else
		{
		    counter = 0;
		    if ((guess >= 97) && (guess <= 109)) //if guess (char) is between (and including) a and m
		    {
			x = guess - 97;
			y = 0;
		    }
		    else
		    {
			x = guess - 110;
			y = 1;
		    }
		    c.setColor (white);
		    c.fillOval (5 + (x * 49), 5 + (y * 51), 40, 40);
		    //seeing if guess is in word or not
		    for (int z = 0 ; z <= word.length () - 1 ; z++)
		    {
			if (guess != word.charAt (z))
			    counter++;
			else
			{
			    c.setFont (new Font ("Times New Roman", Font.TRUETYPE_FONT, 25));
			    index = 0;
			    for (int b = 0 ; b <= word.length () - 1 ; b++)
			    {
				if (b == 0)
				{
				    index = 0;
				}
				c.drawString ("" + guess, 188 + ((word.indexOf (guess, index)) * 30), 158);
				index = word.indexOf (guess, index + 1);
			    }
			    break;
			}
			if (counter == word.length ())
			{
			    numOfGuesses++;
			    break;
			}
		    }
		    draw (numOfGuesses);
		    if (yesWin () == true)
		    {
			delay (500);
			resultScreens (true);
			break;
		    }
		    else
		    {
			if (numOfGuesses == 7)
			{
			    resultScreens (false);
			    break;
			}
		    }
		}
	    }
	}
	score = 2000 - ((numOfGuesses * 100) + (usedLetterScore * 50));
	if (choice.equals ("2") && yesWin () == true)
	    enterName ();
	else
	    score = -1;
	if (score > scores [9])
	{
	    calcHighScores ();
	}
    }


    private void resultScreens (boolean yesWin)
    {
	String name = "";
	if (yesWin == true)
	{
	    loadImage ("winScreen.jpg", true);
	}


	else
	{
	    loadImage ("loseScreen.jpg", true);
	    c.setFont (new Font ("Times New Roman", Font.TRUETYPE_FONT, 25));
	    c.setColor (white);
	    c.drawString ("The word was: '" + word + "'.", 50, 450);
	}
	pauseProgram ();
    }


    private void whichPic (int instructionNum)
    {
	String filename = "Instructions" + instructionNum + ".jpg";
	loadImage (filename,true);
	if (instructionNum != 1 && instructionNum != 3 && instructionNum != 9 && instructionNum != 14 && instructionNum != 19 && instructionNum != 21)
	{
	    c.setCursor (1, 1);
	    c.println (instructions [instructionNum]);
	}
    }


    public void instructions ()
    {
	char movement = ' ';
	loadImage ("Instructions.jpg", true);
	new Message ("Navigate through the instructions using 'd' (move forward) and 'a' (move backward). Press backspace to go back to main menu.", "INSTRUCTIONS");
	int y = 0;
	BufferedReader input;
	try
	{
	    input = new BufferedReader (new FileReader ("Instructions.txt"));
	    input.readLine ();
	    for (int x = 0 ; x <= 23 ; x++)
	    {
		instructions [x] = input.readLine ();
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
	}
    }


    public void loadScores ()
    {
	BufferedReader input;
	PrintWriter output;
	String temp;
	while (true)
	{
	    try
	    {

		input = new BufferedReader (new FileReader ("HighscoresFINAL.txt"));
		for (int x = 0 ; x <= 9 ; x++)
		{
		    name = input.readLine ();
		    temp = input.readLine ();
		    if (name == null || temp == null || temp.equals ("----"))
		    {
			names [x] = "---------------";
			scores [x] = 0;
		    }
		    else
		    {
			names [x] = name;
			scores [x] = Integer.parseInt (temp);
		    }
		}
		break;
	    }
	    catch (IOException e)
	    {
		try
		{
		    output = new PrintWriter (new FileWriter ("HighscoresFINAL.txt"));
		    output.println ();
		    output.close ();
		}
		catch (IOException f)
		{
		}
	    }
	}
    }


    private void calcHighScores ()  //only call if (score > scores [9])
    {
	int tempScore = 0;
	String tempName = "";
	if (score > scores [9])
	{
	    scores [9] = score;
	    names [9] = name;
	}
	for (int u = 0 ; u <= 9 ; u++)
	{
	    try
	    {
		for (int r = 1 ; r <= 9 ; r++)
		{
		    if (scores [r - 1] <= scores [r])
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
	    catch (Exception e)
	    {
	    }
	}
    }


    public void highScores ()
    {
	loadImage ("highscores background.jpg", true);
	c.setFont (new Font ("Times New Roman", Font.TRUETYPE_FONT, 20));
	c.setColor (black);
	for (int x = 0 ; x <= 9 ; x++)
	{
	    c.drawString (names [x], 213, 115 + (x * 30));
	    c.drawString (Integer.toString (scores [x]), 427, 115 + (x * 30));
	}
	pauseProgram ();
    }


    public void goodBye (boolean maxword)
    {
	if (!maxword)
	{
	    loadImage ("goodbye.jpg", true);
	    c.setColor (white);
	    pauseProgram ();
	}
	else
	{
	    loadImage ("WordLimit.jpg", true);
	    delay (5000);
	}
	c.close ();
    }


    public FinalProjectV3 ()
    {
	c = new Console ("Hangman");
    }


    public static void main (String[] args)
    {
	FinalProjectV3 a = new FinalProjectV3 ();
	a.splashScreen ();
	while (true)
	{
	    //reset everything
	    a.letters = new char [26];
	    a.currentElement = 0;
	    a.score = 0;
	    a.name = "";
	    a.mainMenu (a.firstRun);
	    if (a.choice.equals ("1"))
	    {
		a.rand = a.randNum ();
		if (a.rand == 1000)
		{
		    a.maxWord = true;
		    break;
		}
		a.chooseLevel ();
		a.display ();
	    }
	    else if (a.choice.equals ("2"))
	    {
		a.instructions ();
	    }
	    else if (a.choice.equals ("3"))
	    {
		a.highScores ();
	    }
	    else
		break;
	    a.firstRun = false;
	}
	a.goodBye (a.maxWord);
	PrintWriter output;
	try
	{
	    output = new PrintWriter (new FileWriter ("HighscoresFINAL.txt"));
	    for (int x = 0 ; x <= 9 ; x++)
	    {
		output.println (a.names [x]);
		if (a.scores [x] == 0)
		    output.println ("----");
		else
		    output.println (a.scores [x]);
	    }
	    output.close ();
	}
	catch (IOException e)
	{
	}
    }
}


