package SEProject;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

//this is the panel for the main menu. has buttons for going to the character information screen and starting a battle
public class MainMenu extends JPanel{
	
	mainFrame mFrame; //mainframe, should be set to the frame that the main menu is added to. this allows for method calls to update the panels
	JButton StartButton; //buttons for navigation
	JButton CharInfoButton;
	JButton ExitButton;
	private final int buttonLength = 100;
	private final int buttonHeight = 40;
	private Image background;
	
	public MainMenu(mainFrame maFrame)
	{
		setLayout(null);
		this.mFrame = maFrame;
		addButtons();
		setBackground(Color.GREEN);
		ImageIcon ii = new ImageIcon("backgroundImages/mainMenuBackground.png");
		background = ii.getImage();
		mFrame.add(this);
	}	
	public void addButtons()
	{
		
		StartButton = new JButton();//"Start Battle");
		StartButton.setIcon(new ImageIcon("backgroundImages/StartBattleButton.png"));
		StartButton.setContentAreaFilled(false);
		StartButton.setBorder(BorderFactory.createEmptyBorder());
		StartButton.setBounds(420, 300, 360, 120);
		StartButton.addActionListener(new StartListener());
		add(StartButton);
		
		CharInfoButton = new JButton();//"Character Info");
		CharInfoButton.setIcon(new ImageIcon("backgroundImages/CharacterInfoButton.png"));
		CharInfoButton.setContentAreaFilled(false);
		CharInfoButton.setBorder(BorderFactory.createEmptyBorder());
		CharInfoButton.addActionListener(new CharInfoListener());
		CharInfoButton.setBounds(420, 450, 360, 120);
		add(CharInfoButton);
		
		
		ExitButton = new JButton();//"Exit Game");
		ExitButton.setIcon(new ImageIcon("backgroundImages/ExitButton.png"));
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorder(BorderFactory.createEmptyBorder());
		ExitButton.addActionListener(new ExitListener());
		ExitButton.setBounds(420, 600, 360, 120);
		add(ExitButton);
		
		//add(buttonPanel, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, this);
	}
	
	
	//Listener class for the start button, sets the active panel in the main frame to battle pane, needs to be updated so that it instead navigates to the character select screen
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Start Battle");
			//mFrame.setBattlePane();
			mFrame.setCharSelectPane();
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
	//listener class for Exit button, closes program
	private class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
}