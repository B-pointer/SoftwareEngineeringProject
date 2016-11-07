package testGUI;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class CharacterInfoPane extends JPanel{
	
	mainFrame mFrame;
	JScrollPane scrollPanel;
	
	Image terryImg;
	
	/*public CharacterInfoPane()
	{
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
	      
	    terryImg = toolkit.getImage("terryCrews.jpg");

		//terryImg = ii.getImage();
		
		setPreferredSize(new Dimension(500, 1000));
		
		
		JPanel buttonPanel = new JPanel();
		
		JButton BackButton = new JButton("Back to Main Menu");
		BackButton.setSize(100, 40);
		BackButton.addActionListener(new BackListener());
		buttonPanel.add(BackButton);
		add(buttonPanel, BorderLayout.NORTH);
		

		setBackground(Color.ORANGE);
		
	}
	*/
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
		


		
		
		
		//scrollPanel = new JScrollPane(this);//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		setBackground(Color.ORANGE);
		
		//mFrame.add(this);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//g.drawRect(50, 100, 400, 400);
		g.drawImage(terryImg, 50, 50, this);
		
		
	}
	
	private class BackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mFrame.setMainMenu();
			System.out.println("GO BACK TO MAIN MENU");
			
		}
	}
}
