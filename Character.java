package testGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Character {
	
	private Image characterImage;
	//more stats and things go here
	
	private int currentHealth;
	private int maxHealth;
	private int x;
	BattlePane targetPanel;
	
	public Character(BattlePane bp)
	{
		targetPanel = bp;
		maxHealth= 400;
		currentHealth= 300;
	}
	
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return currentHealth;
		
	}
	
	
	public void dealDamage(int damage)
	{
		currentHealth -= damage;
		
	}
	
	public int getX()
	{
		return x;
	}
	public void drawStatic(Graphics g, boolean isLeft)
	{
		//int x;
		int y = 100;
		if(isLeft)
			x=40;
		else
			x=500;
		g.setColor(Color.RED);
		
		g.fillRect(x, y, 100, 100);
		
	}
	
	public void animationA()
	{
		//int delay = 20;
		//Timer timer = new Timer(delay, new animationListener());
       // timer.start();
		x+=5;
	}
	
	public void update()
	{
		x +=5;
		
	}
	
	private class animationListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			  //x += 1;
		    //  targetPanel.repaint();	
		}
		
	}
	
}
