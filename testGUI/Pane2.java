package testGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Pane2 extends JPanel{
	
	mainFrame mFrame;
	
	public Pane2(mainFrame maFrame)
	{
		
		this.mFrame = maFrame;
		
		JButton aButton = new JButton("set Panel 2");	
		aButton.addActionListener(new aListener());
		add(aButton);
		setBackground(Color.GREEN);
		
		mFrame.add(this);
	}
	
	
	
	private class aListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mFrame.set1();
			System.out.println("clik");
			repaint();
		}
		
	}
	
}