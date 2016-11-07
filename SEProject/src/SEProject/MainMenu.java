package SEProject;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MainMenu extends JPanel{
	
	mainFrame mFrame;
	
	JButton StartButton;
	JButton CharInfoButton;
	
//	Image terry;
	
	
	public MainMenu(mainFrame maFrame)
	{
		
		this.mFrame = maFrame;
		
		// ImageIcon ii = new ImageIcon("terryCrews.jpg");
	    // terry = ii.getImage();
		
		StartButton = new JButton("Start Battle");
		StartButton.setSize(100, 40);
		StartButton.addActionListener(new StartListener());
		add(StartButton);
		
		CharInfoButton = new JButton("Character Info");
		CharInfoButton.setSize(100, 40);
		CharInfoButton.addActionListener(new CharInfoListener());
		add(CharInfoButton);
		
		
		
		setBackground(Color.GREEN);
		
		mFrame.add(this);
	}
	
	/*
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(terry, 100, 100, this);
	}
	
	*/
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Start Battle");
			mFrame.setBattlePane();

		}
	}
	private class CharInfoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Show Character Information");
			mFrame.setCharacterInfoPane();
		}
	}
}