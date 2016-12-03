package SEProject;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;


public class CharacterInfoPane extends JPanel{
	
	mainFrame mFrame;
	private final int BUTTON_PANEL_HEIGHT=50;
	Image gokuImg; //this was used to hold a picture for testing, but name can be changed. We will need 4 images (one for each class/character)
	Image samImg;
	Image keanuImg;
	Image randyImg;
	//parameterized contructor
	public CharacterInfoPane(mainFrame maFrame)
	{
		
		setLayout(null); //this sets the layoutmanager to null, so we can absolutely postition things with coordinates. generally bad practice to do this but since the drawing 
						 //of game items is definitely going to require coordinate i feel like it is oko to mirror this throughout the system
		setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, (int)(2.75 * mainFrame.FRAME_HEIGHT)));
		setBackground(Color.ORANGE);
		this.mFrame = maFrame;
		
		addButton();
		
		loadImages();
	}
	//adds buttons to button panel and then adds the button panel to the main panel
	private void addButton()
	{
		JPanel buttonPanel = new JPanel();
		
	//	buttonPanel.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, 200));
		
		JButton BackButton = new JButton("Back to Main Menu");
		BackButton.setSize(100, 40);
		BackButton.addActionListener(new BackListener());
		buttonPanel.add(BackButton);
		
		buttonPanel.setBackground(new Color(213, 45, 216));//sets the color of the panel behind the button, should be less obnoxious than current color
		
		buttonPanel.setBounds(0, 0, mainFrame.FRAME_WIDTH, BUTTON_PANEL_HEIGHT);//location and size of button, use some named variables instead of magic numbers
		
		
		add(buttonPanel);
	
	}
	//loads all images
	public void loadImages()
	{
		URL url = CharacterInfoPane.class.getResource("/characterInfoImages/goku1.png");
		ImageIcon ii = new ImageIcon(url);
		System.out.println("with goku url");
		gokuImg = ii.getImage(); 
		url = CharacterInfoPane.class.getResource("/characterInfoImages/sam1.png");
		ii = new ImageIcon(url);
		System.out.println("with sam url");
		samImg = ii.getImage();
		url = CharacterInfoPane.class.getResource("/characterInfoImages/keanu1.png");
		ii = new ImageIcon(url);
		System.out.println("with keanu url");
		keanuImg = ii.getImage();
		url = CharacterInfoPane.class.getResource("/characterInfoImages/randy1.png");
		ii = new ImageIcon(url);
		System.out.println("with randy url");
		randyImg = ii.getImage();
	}
	//draws all of the images representing the cahracters
	public void paintImages(Graphics g)
	{
		int yBase = 100;
		int yInc= 550;
		g.drawImage(gokuImg, 50, yBase,  this); //this drew the picture, which needs to be updated
		g.drawImage(samImg, 50 , yBase +yInc, this);
		g.drawImage(keanuImg, 50 , yBase +2*yInc, this);
		g.drawImage(randyImg, 50 , yBase +3*yInc, this);
		
		g.drawLine(0, yBase, mainFrame.FRAME_WIDTH, yBase);
		g.drawLine(0, yBase +yInc, mainFrame.FRAME_WIDTH, yBase +yInc);
		g.drawLine(0, yBase +2*yInc, mainFrame.FRAME_WIDTH, yBase +2*yInc);
		g.drawLine(0, yBase +3*yInc, mainFrame.FRAME_WIDTH, yBase +3*yInc);
		g.drawLine(0, yBase +4*yInc, mainFrame.FRAME_WIDTH, yBase +4*yInc);
	}

	//draws Goku Description
	public void drawGokuDescription(Graphics g)
	   {           
	     int maxHealth= 400;
		 int rateOfSuccess = 60;
		 int attackPower = 90;
	     g.drawString("Goku is one of the last remaining Saiyans, an alien race of warriors.", 550, 245);
	     g.drawString("Sent to earth as a child, Goku was tasked with eliminating life on the", 550, 270);
	     g.drawString("planet. Luckily, he forgot his mission and became the planet's savior.", 550, 295);
	     g.drawString("Stats: ", 550, 345);
	     g.drawString("Attack Power: " + attackPower, 550, 370);
	     g.drawString("Rate Of Success: " + rateOfSuccess, 550, 395);
	     g.drawString("Maximum Health: " + maxHealth, 550, 420);
	   }
	//draws Sam Description
	public void drawSamDescription(Graphics g)
	{
	     int yOffset = 550;           
	     int maxHealth= 450;
		 int rateOfSuccess = 75;
		 int attackPower = 70;
	     g.drawString("Samuel Jackson is famous for playing foul mouthed, intimidating roles", 550, yOffset + 245);
	     g.drawString("in many Hollywood movies. Taking on characters ranging from hitman in", 550, yOffset + 270);
	     g.drawString("Pulp Fiction to coordinator for the Avengers in the Marvel film franchise", 550, yOffset +295);
	     g.drawString("Sam is always sure to be the center of attention.", 550, yOffset + 320);
	     g.drawString("Stats: ", 550, 345);
	     g.drawString("Attack Power: " + attackPower, 550, yOffset +370);
	     g.drawString("Rate Of Success: " + rateOfSuccess, 550, yOffset +395);
	     g.drawString("Maximum Health: " + maxHealth, 550, yOffset +420);
	}
	//draws Keanu Description
	public void drawKeanuDescription(Graphics g)
	{
	     int yOffset = 1100;           
	     int maxHealth= 485;
		 int rateOfSuccess = 70;
		 int attackPower = 70;
	     g.drawString("Keanu Reeves is known for a plethora of action films wherein he plays", 550, yOffset + 245);
	     g.drawString("powerful and dangerous characters. Most notable for The Matrix trilogy,", 550, yOffset + 270);
	     g.drawString("Keanu has also taken on roles as a samurai and as a retired hitman", 550, yOffset +295);
	     g.drawString("Stats: ", 550, 345);
	     g.drawString("Attack Power: " + attackPower, 550, yOffset +370);
	     g.drawString("Rate Of Success: " + rateOfSuccess, 550, yOffset +395);
	     g.drawString("Maximum Health: " + maxHealth, 550, yOffset +420);
	}
	//draws Randy Description
	public void drawRandyDescription(Graphics g)
	{
	     int yOffset = 1650;           
	     int maxHealth= 505;
		 int rateOfSuccess = 90;
		 int attackPower = 60;
	     g.drawString("Macho Man Randy Savage is regarded as one of the best professional", 550, yOffset + 245);
	     g.drawString("wrestelers in history. Taking part in both the WWF and the WCW, Randy", 550, yOffset + 270);
	     g.drawString("Won 29 wrestling titles suring his illustrious 32 year career", 550, yOffset +295);
	     g.drawString("Stats: ", 550, 345);
	     g.drawString("Attack Power: " + attackPower, 550, yOffset +370);
	     g.drawString("Rate Of Success: " + rateOfSuccess, 550, yOffset +395);
	     g.drawString("Maximum Health: " + maxHealth, 550, yOffset +420);
	}
	//overridden version paintComponent that draws the images of the classes and the descriptions
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintImages(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		drawGokuDescription(g);
		drawSamDescription(g);
		drawKeanuDescription(g);
		drawRandyDescription(g);
	}
	//listener for the back button, sets active panel in main frame to a new main menu
	private class BackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mFrame.setMainMenu();
			System.out.println("GO BACK TO MAIN MENU");
			
		}
	}
}
