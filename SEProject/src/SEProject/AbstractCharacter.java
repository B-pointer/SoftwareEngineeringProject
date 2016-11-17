package SEProject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public abstract class AbstractCharacter {
	
	//static ints for constants
	final static int POTION_HEAL_AMOUNT = 85;
	
	// instance var's
	BattlePane targetPanel;
	
	private int currentHealth;
	private int maxHealth;
	private int attack;
	private int defense;
	private int potionCount;
	private double rateOfSuccess;
	private boolean isRightPlayer;
	private boolean isCharged;

	
	//instace variables pertaining to images
	private int imageWidth;
	private int imageHeight;
	private Image[] imageList;
	private int currentImageIndex;
	private int FramesShown;
	private int totalFrames;
	private int numberImages;
	//instance variables pertaining to positioning
	private int x;
	private int xBase;
	private int y;
	
	// constructor
	public AbstractCharacter() {
		// to be filled...
		
	}
	
	// setters
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setRateOfSuccess(double rateOfSuccess) {
		this.rateOfSuccess = rateOfSuccess;
	}
	public void setCurrentIndex(int index)
	{
		this.currentImageIndex = index;
	}
	public void setImageWidth(int imageWidth)
	{
		this.imageWidth = imageWidth;
	}
	public void setImageHeight(int imaheHeight)
	{
		this.imageHeight = imageHeight;
	}
	public void setFramesShown(int FramesShown)
	{
		this.FramesShown = FramesShown;
	}
	public void setTotalFrames(int totalFrames)
	{
		this.totalFrames = totalFrames;
	}
	public void setNumberImages(int numberImages)
	{
		this.numberImages = numberImages;
	}
	public void SetIsRightPlayer(boolean isRightPlayer)
	{
		this.isRightPlayer = isRightPlayer;
	}
	public void setIsCharged(boolean isCharged)
	{
		this.isCharged = isCharged;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public void setBase(int x)
	{
		this.x = x;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public void setPotionCount(int potionCount)
	{
		this.potionCount = potionCount;
	}
	public void setTargetPanel(BattlePane targetPanel)
	{
		this.targetPanel = targetPanel;
	}
	// getters
	public int getCurrentHealth() {
		return currentHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public double getRateOfSuccess() {
		return rateOfSuccess;
	}
	public int getImageWidth()
	{
		return imageWidth;
	}
	public int getImageHeight()
	{
		return imageHeight;
	}
	public int getFramesShown()
	{
		return FramesShown;
	}
	public int getTotalFrames()
	{
		return totalFrames;
	}
	public int getNumberImages()
	{
		return numberImages;
	}
	public boolean GetIsRightPlayer()
	{
		return isRightPlayer;
	}
	public boolean getIsCharged()
	{
		return isCharged;
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getPotionCount()
	{
		return potionCount;
	}
	public BattlePane getTargetPanel()
	{
		return targetPanel;
	}
	//loading methods
	public void loadImages(String name)
	{
		  imageList = new Image[numberImages];
		  ImageIcon ii;
	      for(int i=1; i< 5; i++)
	      {
	    	  //ii = new ImageIcon("characterImages/Man0001.png");
	    	  ii = new ImageIcon("characterImages/" + name +i + ".png");
	         imageList[i-1] = ii.getImage();
	      }
	}
	private void nextImage()
	{
		if(currentImageIndex > imageList.length-2)
			currentImageIndex =0;
		else 
			currentImageIndex ++;
	}
	
	//battle Actions and drawing method
	public void updateX(int dx)
	{
		x += dx;
	}
	public void heal()
	{
		currentHealth += POTION_HEAL_AMOUNT;
		potionCount -=1;
	}
	public void attack(AbstractCharacter a)
	{
		Random x = new Random();
		int z = x.nextInt(100);
		System.out.println(z);
		if(z < rateOfSuccess)
		{
			double ratio = (x.nextInt(50) + 50)/100.0;
			System.out.println(ratio);
			int dmg = (int)(ratio*attack);
			System.out.println("dmg = " + dmg);
			a.dealDamage(dmg);
		}
	}
	public void dealDamage(int damageTaken)
	{
		currentHealth -= damageTaken;
	}
	public void charge()//this should be overridden
	{
		isCharged = true;
		//
	}	
	public void reset()
	{
		currentImageIndex =0;
		x = xBase;
	}
	public void drawMe(Graphics g)
	{
		if(isRightPlayer)
	      {
	         if(isCharged)
	         {
	        	 g.setColor(new Color(255, 255, 0, 31));
	        	 g.fillRect(x, y, imageWidth, imageHeight);
	        }
	         g.drawImage(imageList[currentImageIndex], x+imageWidth, y,-imageWidth, imageHeight,null );//targetPanel);
	      }
	      else
	      {
	    	  if(isCharged)
		         {
		        	 g.setColor(new Color(255, 255, 0, 31));
		        	 g.fillRect(x, y, imageWidth, imageHeight);
		        }
	    	  ImageIcon ii = new ImageIcon("characterImages/Man0001.png");
	    	  g.drawImage(imageList[currentImageIndex], x, y,null);// targetPanel);
	      }
	}

}
