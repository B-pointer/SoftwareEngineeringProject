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
	private final Character Player1;
	private final Character Player2;
	
	private Character currentCharacter;
	private Character otherCharacter;
	
	
	private final int DELAY = 100;
	//parameterized constructor takes mainFrame as argument
	public BattlePane(mainFrame maFrame)//add player class
	{
		BUTTON_WIDTH = (mainFrame.FRAME_WIDTH/3)-20;
		mFrame = maFrame;
		setLayout(null);
		addButtons();
		mFrame.add(this);
		//a =  new Character(this);
		Player1= new Character(this, false);
		Player2 = new Character(this, true);
		currentCharacter = Player1;
		otherCharacter = Player2;
	}

	//swaps the current player and other player
	public void swapCurrent()
	   {
	      if(Player1.equals(currentCharacter))
	      {
	         currentCharacter = Player2;
	         otherCharacter= Player1;
	      }
	      else
	      {
	         currentCharacter = Player1;
	         otherCharacter = Player2;
	      }
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
	private void drawHealthBars(Graphics g)
	{
		double char1Ratio = ((double)Player1.getCurrentHealth())/Player1.getMaxHealth();
		double char2Ratio = ((double)Player2.getCurrentHealth())/Player1.getMaxHealth();
		int fillAmount = ((int)(200*char1Ratio));
		int fillAmount2 = ((int)(200*char2Ratio));
		g.setColor(Color.RED);
		g.fillRect(40, 40, fillAmount, 30);
		g.fillRect(mainFrame.FRAME_WIDTH-250, 40, fillAmount2, 30);
		g.setColor(Color.BLACK);
		g.drawRect(40, 40, 200, 30);
		g.drawRect(mainFrame.FRAME_WIDTH-250, 40, 200, 30);
	}

	private void performAttack()
	{
		attackButton.setEnabled(false);//need to disable all buttons
		Timer t = new Timer(DELAY, new animationListener());
		t.start();
		
	}
	//override of paintComponent, calls drawMethod for characters
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//a.drawMe(g, true);
		drawHealthBars(g);
		otherCharacter.drawMe(g);
		currentCharacter.drawMe(g);
		
	}
	//updates the buttons (and likely will update the status message should we add one)
	public void updateGUI()//needs to be called by another method instead of the heal listener class, but first need to implement turns
	{
		healButton.setText("Heal(" + currentCharacter.getPotionCount() + ")");//change to currentPLayer
		if(currentCharacter.getPotionCount() < 1)//change to currentPlayer
			healButton.setEnabled(false);
	}
	
	//listener for attack button
	private class AttackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Attack");
			performAttack();
			//Player1.dealDamage(30);//change to current Player
			//repaint();
		}	
	}
	//listener for Heal Button
	private class HealListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Heal");	
			currentCharacter.heal();
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
			currentCharacter.charge();
			repaint();
		}	
	}
	
	//listener for animation timer 
	private class animationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(currentCharacter.getFrameCount() > currentCharacter.getTotalFrames()-1)
			{
				((Timer)e.getSource()).stop();
				System.out.println("reached end condition");
				attackButton.setEnabled(true);//change to all buttons, or make switch turn method
				currentCharacter.reset();
				swapCurrent();//change to switch turn method as mentioned above
				repaint();
				return;
			}
			currentCharacter.attackUpdate();
			repaint();
		}
	}
	
}
