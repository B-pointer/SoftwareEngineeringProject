package SEProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BattlePane extends JPanel{
	
	//constants and final ints
	private final int DELAY = 30;//delay for the timer that moves the images
	private final int BUTTON_PANEL_HEIGHT= 100;// height of button panel added to the bottom of the panel
	private final int BUTTON_WIDTH = (mainFrame.FRAME_WIDTH/3)-20;
	
	//instance fields 
	private JPanel buttonPanel;  
	private JButton attackButton;
	private JButton chargeButton;
	private JButton healButton;
	private JButton NextRoundButton;
	
	mainFrame mFrame;
	private Character Player1;
	private Character Player2;
	private Character currentCharacter;
	private Character otherCharacter;
	private int currentRoundCount;
	private int Player1Wins;
	private int Player2Wins;
	
	//parameterized constructor takes mainFrame as argument 
	//this should be sorted into several other methods (i.e. resetPlayers so that matches can be more easily implemented)
	public BattlePane(mainFrame maFrame)//add player class
	{
		currentRoundCount = 0;
		Player1Wins = 0;
		Player2Wins = 0;
		mFrame = maFrame;
		setLayout(null);
		addButtons();
		mFrame.add(this);
		resetBattle();
		
	}
	/*
	 * Methods related to initializing battle, turns, and determing if round/matches are over
	 */
	//resets the battle, creating new instances of the characters and thus restoring them to full health and full potion. called during construction and at beginning of each new round
	public void resetBattle()
	{
		showActionButtons();
		NextRoundButton.setVisible(false);
		
		currentRoundCount += 1;
		Player1= new Character(this, false, "keanu");
		Player2 = new Character(this, true, "randy");
		currentCharacter = Player1;
		otherCharacter = Player2;
	}
	
	//resets buttons for next turn
	public void nextTurn()
	{
		System.out.println("Next Turn");
		if(checkRoundEnd())
		{
			System.out.println("Round Over");
			if(currentCharacter.equals(Player1))
			{
				System.out.println("Player 1 wins");
				Player1Wins ++;
			}
			else
			{
				System.out.println("Player 2 wins");
				Player2Wins ++;
			}
			if(checkBattleEnd())
				showEndOfBattle();
			else
				showEndOfRound();
		}
		swapCurrent();
		updateHealButton();
		enableButtons();
		repaint();
	}
	//switch buttons on and off
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
	
	//returns true if the otherCharacter has fewer than 1 health
	public boolean checkRoundEnd()
	{
		return (otherCharacter.getCurrentHealth() < 1);
	}
	
	public boolean checkBattleEnd()
	{
		return (Player1Wins  >1 || Player2Wins > 1);	
	}
	/*
	 * Methods related to adding and disabling buttons and panels
	 */
	
	//adds buttons to button panel and then adds the button panel to the main panel
	private void addButtons()
	{
		buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(213, 45, 216));
		buttonPanel.setBounds(0, mainFrame.FRAME_HEIGHT - BUTTON_PANEL_HEIGHT-29, mainFrame.FRAME_WIDTH, BUTTON_PANEL_HEIGHT);
		
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
		
		NextRoundButton= new JButton ("Next Round");
		NextRoundButton.setBackground(Color.DARK_GRAY);
		NextRoundButton.setForeground(Color.LIGHT_GRAY);
		NextRoundButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_PANEL_HEIGHT/2));
		NextRoundButton.setFont(new Font("Arial", Font.PLAIN, 40));
		NextRoundButton.addActionListener(new NextListener());
		NextRoundButton.setVisible(false);
		
		buttonPanel.add(attackButton);
		buttonPanel.add(healButton);
		buttonPanel.add(chargeButton);
		buttonPanel.add(NextRoundButton);
		add(buttonPanel);
	}
	
	//updates the buttons (and likely will update the status message should we add one)
	public void updateHealButton()//needs to be called by another method instead of the heal listener class, but first need to implement turns
	{
		healButton.setText("Heal(" + currentCharacter.getPotionCount() + ")");//change to currentPLayer
		if(currentCharacter.getPotionCount() < 1 )//change to currentPlayer
			healButton.setEnabled(false);
	}
	
	//disables the attack, charge, and heal buttons on the GUI
	public void disableButtons()
	{
		attackButton.setEnabled(false);
		healButton.setEnabled(false);
		chargeButton.setEnabled(false);
	}
	
	//enables the attack, heal, and charge buttons on the GUI. Heal is only enabled if the current player has potions remaining
	public void enableButtons()
	{
		attackButton.setEnabled(true);
		
		chargeButton.setEnabled(true);
		if(currentCharacter.getPotionCount() > 0)
			healButton.setEnabled(true);
	}
	
	//shows the end of round button and hides the other buttons
	public void showEndOfRound()
	{
		 hideActionButtons();
		 NextRoundButton.setVisible(true);
	}
	
	//display for end of battle
	public void showEndOfBattle()
	{	
		hideActionButtons();
		NextRoundButton.setVisible(false);
		
		JButton endButton = new JButton("Return to Menu");
		endButton.setBackground(Color.DARK_GRAY);
		endButton.setForeground(Color.LIGHT_GRAY);
		endButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_PANEL_HEIGHT/2));
		endButton.setFont(new Font("Arial", Font.PLAIN, 40));
		endButton.addActionListener(new EndListener());
		buttonPanel.add(endButton);
	}
	
	//hides all action buttons by setting them to be invisible
	public void hideActionButtons()
	{
		attackButton.setVisible(false);
		healButton.setVisible(false);
		chargeButton.setVisible(false);
	}
	
	//sets all action buttons visible so they can be interacted with
	public void showActionButtons()
	{
		attackButton.setVisible(true);
		healButton.setVisible(true);
		chargeButton.setVisible(true);
	}
	
	
	/*
	 * Methods related to drawing
	 */
	//override of paintComponent, calls drawMethod for characters
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//a.drawMe(g, true);
		//g.drawString(StatusLabel, 400, 700);
		drawHealthBars(g);
		otherCharacter.drawMe(g);
		currentCharacter.drawMe(g);
		g.setColor(new Color(0, 255, 0, 80));
		setFont(new Font("Arial", Font.PLAIN, 40));
		g.drawString("Round " + currentRoundCount, 520, 60);
		g.drawString("Wins: " + Player1Wins, 40, 120);
		g.drawString("Wins: " + Player2Wins, 950, 120);
		if(currentCharacter.equals(Player1))
		{
			g.fillRect(0, mainFrame.FRAME_HEIGHT-150, mainFrame.FRAME_WIDTH/2, 15);//mainFrame.FRAME_HEIGHT-150);
		}
		else
		{
			g.fillRect(mainFrame.FRAME_WIDTH/2, mainFrame.FRAME_HEIGHT-150,mainFrame.FRAME_WIDTH , 15);//mainFrame.FRAME_HEIGHT-150);
		}
		
		
	}
	
	//called by paintComponent, draws the health bars of the players based on their current and max health
	private void drawHealthBars(Graphics g)
	{
		double char1Ratio = ((double)Player1.getCurrentHealth())/Player1.getMaxHealth();
		double char2Ratio = ((double)Player2.getCurrentHealth())/Player1.getMaxHealth();
		int fillAmount = ((int)(450*char1Ratio));
		int fillAmount2 = ((int)(450*char2Ratio));
		g.setColor(Color.RED);
		g.fillRect(40, 40, fillAmount, 30);
		g.fillRect(mainFrame.FRAME_WIDTH-(500-(450-fillAmount2)), 40, fillAmount2, 30);
		//g.fillRect(mainFrame.FRAME_WIDTH-500, 40, fillAmount2, 30);
		g.setColor(Color.BLACK);
		g.drawRect(40, 40, 450, 30);
		g.drawRect(mainFrame.FRAME_WIDTH-500, 40, 450, 30);
	}
	
	//Uses a timer to display animation frames. disables buttons during the animation. The buttons are re-enabled at by the nextTurn method
	private void performAttack()
	{
		disableButtons();
		Timer t = new Timer(DELAY, new animationListener());
		t.start();
	}
	
	/*
	 * Listeners for buttons
	 */

	//listener for attack button, callsPerform attack
	private class AttackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Attack");
			performAttack();
		}	
	}
	//listener for Heal Button, calls nextTurn after calling hea button for current player
	private class HealListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Heal");	
			currentCharacter.heal();
			nextTurn();
		}	
	}
	//listener for charge button, calls nextTurn after calling charge method for current player
	private class ChargeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Charge");
			currentCharacter.charge();
			nextTurn();
		}	
	}	
	//Listener for next round button, calls resetBattle
	private class NextListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			resetBattle();
		}	
	}
	//returns to the main menu
	//Listener for next round button, calls resetBattle
	private class EndListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mFrame.setMainMenu();
		}	
	}
	
	//listener for animation timer, calls next turn when attack animation is over. Calls attackUpdate for current player to update position and picture
	private class animationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(currentCharacter.getFramesShown() > currentCharacter.getTotalFrames()-1)
			{
				((Timer)e.getSource()).stop();
				//System.out.println("reached end condition");
				currentCharacter.attack(otherCharacter);//move this elsewhere???
				currentCharacter.reset();
				//System.out.println("Current health  = " + currentCharacter.getCurrentHealth());
				nextTurn();
			}
			else
			{
				currentCharacter.attackUpdate();
				repaint();
			}
		}
	}
	
}
