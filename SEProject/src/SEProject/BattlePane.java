package SEProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BattlePane extends JPanel{
	
	private final int BUTTON_PANEL_HEIGHT= 100;// height of button panel added to the bottom of the panel
	private final int BUTTON_WIDTH;
	//instance fields 
	private JPanel buttonPanel;  
	private boolean isPlayer1Turn;
	private JButton attackButton;
	private JButton chargeButton;
	private JButton healButton;
	mainFrame mFrame;
	Character a;
	//private final Character Player1;
	//private final Character Player2;
	
	//private Character currentCharacter;
	//private Character otherCharacter;
	
	//parameterized constructor takes mainFrame as argument
	public BattlePane(mainFrame maFrame)//add player class
	{
		BUTTON_WIDTH = (mainFrame.FRAME_WIDTH/3)-20;
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
		//buttonPanel.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, BUTTON_PANEL_HEIGHT ));
		
		attackButton = new JButton("Attack");
		attackButton.setBackground(new Color(123, 123, 231));
		attackButton.setPreferredSize(new Dimension(BUTTON_WIDTH, (int)(BUTTON_PANEL_HEIGHT/2)));
		attackButton.setFont(new Font("Arial", Font.PLAIN, 40));
		attackButton.addActionListener(new AttackListener());
		
		healButton = new JButton("Heal(3)");
		healButton.setBackground(new Color(123, 123, 231));
		healButton.setFont(new Font("Arial", Font.PLAIN, 40));
		healButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_PANEL_HEIGHT/2));
		
		healButton.addActionListener(new HealListener());
		
		chargeButton = new JButton("Charge");
		chargeButton.setBackground(new Color(123, 123, 231));
		chargeButton.setFont(new Font("Arial", Font.PLAIN, 40));
		chargeButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_PANEL_HEIGHT/2));
		chargeButton.addActionListener(new ChargeListener());
		
		buttonPanel.setBackground(new Color(213, 45, 216));
		buttonPanel.setBounds(0, mainFrame.FRAME_HEIGHT - BUTTON_PANEL_HEIGHT-29, mainFrame.FRAME_WIDTH, BUTTON_PANEL_HEIGHT);
		
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
	//updates the buttons (and likely will update the status message should we add one)
	public void updateGUI()//needs to be called by another method instead of the heal listener class, but first need to implement turns
	{
		healButton.setText("Heal(" + a.getPotionCount() + ")");
		if(a.getPotionCount() < 1)
			healButton.setEnabled(false);
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
			a.heal();
			updateGUI();
			repaint();
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
	/*
	//listener for animation timer 
	private class animationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(currentCharacter.getFrameCount() > currentCharacter.getNumberTotalFrames())
				((Timer)e.getSource()).stop();
		}
	}
	*/
}
