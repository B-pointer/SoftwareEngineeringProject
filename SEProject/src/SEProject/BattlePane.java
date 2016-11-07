package SEProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class BattlePane extends JPanel{
	
	private JPanel buttonPanel;
	private boolean isPlayer1Turn;
	private JButton attackButton;
	private JButton chargeButton;
	private JButton healButton;
	mainFrame mFrame;
	
	Character a;
	
	
	public BattlePane(mainFrame maFrame)//add player class
	{
		mFrame = maFrame;
		
		setLayout(null);
		
		addButtons();
		
		mFrame.add(this);
	}
	
	private void addButtons()
	{
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(640, 100));
		attackButton = new JButton("Attack");
		attackButton.addActionListener(new AttackListener());
		
		buttonPanel.setBackground(new Color(213, 45, 216));
		buttonPanel.setBounds(0, 402, 640, 50);
		
		buttonPanel.add(attackButton);
		add(buttonPanel);
		
		a =  new Character(this);
		
	}
	
	public void drawHealthBars(Graphics g)
	{
		double aRatio = ((double)a.getCurrentHealth())/a.getMaxHealth();
		int fillAmount = ((int)(200*aRatio));
		g.fillRect(40, 40, fillAmount, 30);
		g.setColor(Color.BLACK);
		g.drawRect(40, 40, 200, 30);
	}

	
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		a.drawStatic(g, true);
		drawHealthBars(g);
		
	}
	
	
	private class AttackListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("Attack");
			a.dealDamage(30);
			repaint();
		
		}	
	}

}
