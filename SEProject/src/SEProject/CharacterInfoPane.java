package SEProject;
import java.awt.*;
import java.awt.event.*;

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
		setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, (int)(3.5 * mainFrame.FRAME_HEIGHT)));
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
		ImageIcon ii = new ImageIcon("characterInfoImages/goku1.png");
		gokuImg = ii.getImage(); 
		ii = new ImageIcon("characterInfoImages/sam1.png");
		samImg = ii.getImage();
		ii = new ImageIcon("characterInfoImages/keanu1.png");
		keanuImg = ii.getImage();
		ii = new ImageIcon("characterInfoImages/randy1.png");
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
	//draws all the test descriptions, using drawString method of Graphics class because using text areas sets the default location of the scroll bar to a weird position
	public void drawDescriptions(Graphics g)
	{
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("Description Goes Here", 600, 350); 
	}
	//overridden version paintComponent that draws the images of the classes and the descriptions
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintImages(g);
		drawDescriptions(g);
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
