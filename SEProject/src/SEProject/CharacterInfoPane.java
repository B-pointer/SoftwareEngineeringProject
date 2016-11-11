package SEProject;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CharacterInfoPane extends JPanel{
	
	mainFrame mFrame;
	//JScrollPane scrollPanel;
	
	Image terryImg; //this was used to hold a picture for testing, but name can be changed. We will need 4 images (one for each class/character)
	
	public CharacterInfoPane(mainFrame maFrame)
	{
		
		setLayout(null); //this sets the layoutmanager to null, so we can absolutely postition things with coordinates. generally bad practice to do this but since the drawing 
						 //of game items is definitely going to require coordinate i feel like it is oko to mirror this throughout the system
		
		ImageIcon ii = new ImageIcon("terryCrews.jpg");
	    terryImg = ii.getImage();
	    
		setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, 4 * mainFrame.FRAME_HEIGHT));
		
		this.mFrame = maFrame;
		
		addButtonPanel();
		
		setBackground(Color.ORANGE);

	}
	
	
	private void addButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		
		buttonPanel.setPreferredSize(new Dimension(100, 300));
		
		JButton BackButton = new JButton("Back to Main Menu");
		BackButton.setSize(100, 40);
		BackButton.addActionListener(new BackListener());
		buttonPanel.add(BackButton);
		
		buttonPanel.setBackground(new Color(213, 45, 216));//sets the color of the panel behind the button, should be less obnoxious than current color
		
		buttonPanel.setBounds(170, 10, 300, 37);//location and size of button, use some named variables instead of magic numbers
		
		
		add(buttonPanel);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//g.drawRect(50, 100, 400, 400);
		g.drawImage(terryImg, 50, 50, this); //this drew the picture, which needs to be updated
		g.drawString("Sample Text and stuff", 50, 500); //using drawString since adding a JTextArea or something similar sets the defualt position of the scrollbar to weird places
		
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
