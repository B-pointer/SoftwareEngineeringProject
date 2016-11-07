package SEProject;

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


public class Character { ///throughout this need to replace magic numbers with variables for easier changing
	
	private Image characterImage;
	//more stats and things go here
	
	private int currentHealth;
	private int maxHealth;
	private int x;
	
	
	private int attackPower;
	private int defense;
	
	
	BattlePane targetPanel;//may not be necessary, probably will be though for drawing images from files
	
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
	

	
	public void update()//trying to make the box move by calling this from BattlePane, couldnt get it to work
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
