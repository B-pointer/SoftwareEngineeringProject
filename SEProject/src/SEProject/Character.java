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
	//image array for animation frames
	private final int NUM_IMG = 4;
	private Image[] ImageList;
	private Image currentImage;//may not be used in favor of current image index found immediately below
	private int currentImageIndex;
	
	//size of image info, dependant on images
	private int width = 219;
	private int height = 353;
	
	//more stats and things go here
	private int currentHealth;
	private int maxHealth;
	private int x;
	private int y;
	private int attackPower;
	private int defense;
	
	private boolean isRightPlayer;//if this character is on the right side of the screen (controlled by player 2), set to true
	

	private final int POTION_HEAL_AMOUNT =85;
	private int potionCount;
	
	BattlePane targetPanel;//may not be necessary, probably will be though for drawing images from files
	
	//parameterized constructor
	public Character(BattlePane bp, boolean isRight)
	{
		isRightPlayer = isRight;
		
		 if(isRightPlayer)//move to method?
	         x = mainFrame.FRAME_WIDTH-250;
	      else
	         x=15;
	      y=250;

		targetPanel = bp;
		maxHealth= 400;
		currentHealth= maxHealth;
		potionCount = 3;
		loadImages();
		
		currentImageIndex = 0;
		
	}
	//gets the images and stores them in array
	private void loadImages()
	{
		  ImageList = new Image[NUM_IMG];
		  ImageIcon ii;
	      for(int i=1; i< 5; i++)
	      {
	    	  //ii = new ImageIcon("characterImages/Man0001.png");
	    	  ii = new ImageIcon("characterImages/Man000"+i + ".png");
	         ImageList[i-1] = ii.getImage();
	      }
	}
	
	private void nextImage()
	{
		if(currentImageIndex > ImageList.length-2)
			currentImageIndex =0;
		else 
			currentImageIndex ++;
	}
	//returns max health
	public int getMaxHealth()
	{
		return maxHealth;
	}
	
	//return currentHealth
	public int getCurrentHealth()
	{
		return currentHealth;
		
	}
	
	
	public int getPotionCount()
	{
		return potionCount;
	}
	
	//deals damage, called by other palyer class in the battle
	public void dealDamage(int damage)
	{
		currentHealth -= damage;
		
	}
	
	
	public void heal()
	{
		currentHealth += POTION_HEAL_AMOUNT;
		potionCount --;
		
	}
	//gets x coordinate of the character
	public int getX()
	{
		return x;
	}
	
	//draws the player
	public void drawMe(Graphics g)//, boolean isLeft)
	{
		/*
		int y = 100;
		if(isLeft)
			x=40;
		else
			x=500;
		g.setColor(Color.RED);
		g.fillRect(x, y, 100, 100);
		*/
		if(isRightPlayer)
	      {
	         g.setColor(Color.red);
	         g.fillRect(x, y+150, 100, 100);
	         g.drawImage(ImageList[currentImageIndex], x+width, y,-width, height, targetPanel);
	      }
	      else
	      {
	    	  ImageIcon ii = new ImageIcon("characterImages/Man0001.png");
	    	  g.drawImage(ImageList[currentImageIndex], x, y, targetPanel);
	      }
	}
	

	//changes the value of x
	public void update()//trying to make the box move by calling this from BattlePane, couldnt get it to work
	{
		x +=5;
		
	}	
}
