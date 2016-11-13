package SEProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class BattlePane extends JPanel{
	
	private final int BUTTON_PANEL_HEIGHT= 100;// height of button panel added to the bottom of the panel
	//instance fields 
	private JPanel buttonPanel;  
	private boolean isPlayer1Turn;
	private JButton attackButton;
	private JButton chargeButton;
	private JButton healButton;
	mainFrame mFrame;
	
	Character a;
	
	//parameterized constructor takes mainFrame as argument
	public BattlePane(mainFrame maFrame)//add player class
	{
		mFrame = maFrame;
		setLayout(null);
		addButtons();
		mFrame.add(this);
		a =  new Character(this);
	}
	
	
	//adds buttons to button panel and then adds the button panel to the main panel
	private void addButtons()
	{
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, BUTTON_PANEL_HEIGHT ));
		
		attackButton = new JButton("Attack");
		attackButton.addActionListener(new AttackListener());
		
		healButton = new JButton("Heal");
		healButton.addActionListener(new HealListener());
		
		chargeButton = new JButton("Charge");
		chargeButton.addActionListener(new ChargeListener());
		
		buttonPanel.setBackground(new Color(213, 45, 216));
		buttonPanel.setBounds(0, 402, 640, 50);
		
		buttonPanel.add(attackButton);
		buttonPanel.add(healButton);
		buttonPanel.add(chargeButton);
		add(buttonPanel);

	}
	
	
	//called by paintComponent, draws the health bars of the players based on their current and max health
	public void drawHealthBars(Graphics g)
	{
		double aRatio = ((double)a.getCurrentHealth())/a.getMaxHealth();
		int fillAmount = ((int)(200*aRatio));
		g.fillRect(40, 40, fillAmount, 30);
		g.setColor(Color.BLACK);
		g.drawRect(40, 40, 200, 30);
	}

	
	//override of paintComponent, calls drawMethod for characters
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		a.drawStatic(g, true);
		drawHealthBars(g);
		
	}
	
	//listener for attack button
	private class AttackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Attack");
			a.dealDamage(30);
			repaint();
		}	
	}
	//listener for Heal Button
	private class HealListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Heal");		
		}	
	}
	//listener for charge button
	private class ChargeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Charge");
		}	
	}


}
