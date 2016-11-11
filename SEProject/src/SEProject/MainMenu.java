package SEProject;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//this is the panel for the main menu. has buttons for going to the character information screen and starting a battle
public class MainMenu extends JPanel{
	
	mainFrame mFrame; //mainframe, should be set to the frame that the main menu is added to. this allows for method calls to update the panels
	
	JButton StartButton; //buttons for navigation
	JButton CharInfoButton;
	
	private final int buttonLength = 100;
	private final int buttonHeight = 40;
	
	public MainMenu(mainFrame maFrame)
	{
		
		this.mFrame = maFrame;
		
		// ImageIcon ii = new ImageIcon("terryCrews.jpg");
	    // terry = ii.getImage();
		
		StartButton = new JButton("Start Battle");
		StartButton.setSize(buttonLength, buttonHeight);
		StartButton.addActionListener(new StartListener());
		add(StartButton);
		
		CharInfoButton = new JButton("Character Info");
		CharInfoButton.setSize(buttonLength, buttonHeight);
		CharInfoButton.addActionListener(new CharInfoListener());
		add(CharInfoButton);
		
		
		
		setBackground(Color.GREEN);
		
		mFrame.add(this);
	}
	
	//Listener class for the start button, sets the active panel in the main frame to battle pane, needs to be updated so that it instead navigates to the character select screen
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Start Battle");
			mFrame.setBattlePane();

		}
	}
	
	//listener class for charInfo button, sets active panel in main frame to the character info pane
	private class CharInfoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Show Character Information");
			mFrame.setCharacterInfoPane();
		}
	}
}