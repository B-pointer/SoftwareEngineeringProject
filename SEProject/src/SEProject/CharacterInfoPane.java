package SEProject;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CharacterInfoPane extends JPanel{
	
	mainFrame mFrame;
	private final int BUTTON_PANEL_HEIGHT=50;
	
	Image terryImg; //this was used to hold a picture for testing, but name can be changed. We will need 4 images (one for each class/character)
	
	
	//parameterized contructor
	public CharacterInfoPane(mainFrame maFrame)
	{
		
		setLayout(null); //this sets the layoutmanager to null, so we can absolutely postition things with coordinates. generally bad practice to do this but since the drawing 
						 //of game items is definitely going to require coordinate i feel like it is oko to mirror this throughout the system
   
		setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, 8 * mainFrame.FRAME_HEIGHT));
		setBackground(Color.ORANGE);
		this.mFrame = maFrame;
		
		addButton();
		
		ImageIcon ii = new ImageIcon("characterInfoImages/terryCrews.jpg");
	   // ImageIcon ii = new ImageIcon("characterImages/Man0001.png");
		terryImg = ii.getImage(); 
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
	
	//overridden version paintComponent that draws the images of the classes and the descriptions
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//g.drawRect(50, 100, 400, 400);
		g.drawImage(terryImg, 50, 50, this); //this drew the picture, which needs to be updated
		g.drawString("Sample Text and stuff", 50, 500); //using drawString since adding a JTextArea or something similar sets the defualt position of the scrollbar to weird places
		g.drawImage(terryImg, 1153, 50, -397, 396, this);
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
