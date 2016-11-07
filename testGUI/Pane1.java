package testGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class Pane1 extends JPanel{
	
	mainFrame mFrame;
	
	public Pane1(mainFrame maFrame)
	{
		mFrame = maFrame;
		JButton aButton = new JButton("set Panel 2");	
		aButton.addActionListener(new aListener());
		add(aButton);
		setBackground(Color.RED);
		
		mFrame.add(this);
	}
	
	
	
	private class aListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			mFrame.set2();
			//System.out.println("clik");
			//repaint();
		/*	mFrame.getContentPane().removeAll();
			mFrame.getContentPane().invalidate();
			
			mFrame.getContentPane().add(new Pane2(mFrame));
			mFrame.getContentPane().revalidate();
		*/
		}
		
	}
	
}
