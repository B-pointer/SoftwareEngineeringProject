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
		
		setLayout(null);
		ImageIcon ii = new ImageIcon("terryCrews.jpg");
	    terryImg = ii.getImage();
	    
		setPreferredSize(new Dimension(500, 1000));
		
		this.mFrame = maFrame;
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(100, 300));
		
		JButton BackButton = new JButton("Back to Main Menu");
		BackButton.setSize(100, 40);
		BackButton.addActionListener(new BackListener());
		buttonPanel.add(BackButton);
		buttonPanel.setBackground(new Color(213, 45, 216));
		buttonPanel.setBounds(170, 10, 300, 37);
		
		add(buttonPanel);
		
		
		setBackground(Color.ORANGE);

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//g.drawRect(50, 100, 400, 400);
		g.drawImage(terryImg, 50, 50, this); //this drew the picture, which needs to be updated
		
		
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
