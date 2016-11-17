package SEProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Character extends AbstractCharacter{ ///throughout this need to replace magic numbers with variables for easier changing
	//image array for animation frames
	private final int NUM_IMG = 4;//
	private Image[] ImageList;//
	private Image currentImage;//may not be used in favor of current image index found immediately below
	private int currentImageIndex;
	private int FrameCount;//
	private int TotalFrames;//
	//size of image info, dependent on images
	private int width = 219;//
	private int height = 353;//
	
	//more stats and things go here
	private int currentHealth;//
	private int maxHealth;//
	private int x;//
	private int y;//
	//private int attackPower;
	private int defense;
	private boolean isCharged;//
	
	//private int rateOfSuccess;//
	
	private boolean isRightPlayer;//if this character is on the right side of the screen (controlled by player 2), set to true
	private final int POTION_HEAL_AMOUNT =85;//
	private int potionCount;//
	
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
		FrameCount = 0;
		TotalFrames = 50;
		currentImageIndex = 0;
		isCharged = false;
		//rateOfSuccess = 70;
		setRateOfSuccess(70);
		setAttack(75);
		//attackPower = 75;
	}
	//gets the images and stores them in array
	private void loadImages()//
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
	
	private void nextImage()//
	{
		if(currentImageIndex > ImageList.length-2)
			currentImageIndex =0;
		else 
			currentImageIndex ++;
	}
	//returns max health
	public int getMaxHealth()//
	{
		return maxHealth;
	}

	//return currentHealth
	public int getCurrentHealth()//
	{
		return currentHealth;
		
	}
	/*
	public void attack(Character a)//
	{
		Random x = new Random();
		int z = x.nextInt(100);
		System.out.println(z);
		if(z < rateOfSuccess)
		{
			double ratio = (x.nextInt(50) + 50)/100.0;
			System.out.println(ratio);
			int dmg = (int)(ratio*attackPower);
			System.out.println("dmg = " + dmg);
			a.dealDamage(dmg);
		}
		
		//a.dealDamage(50);
	}
*/
	public int getPotionCount()//
	{
		return potionCount;
	}

	public void charge()//
	{
		isCharged = true;
		//code goes here for increasing the rate of success
	}

	//deals damage, called by other player class in the battle
	public void dealDamage(int damage)//
	{
		currentHealth -= damage;	
	}

	//changes value of x and will change the current picture index
	public void attackUpdate()
	{
		  
		//  System.out.println(FrameCount);
		 // if(FrameCount % 10 == 0 && FrameCount/10 < NUM_IMG)//magic number here
		  if(FrameCount == 11 || FrameCount == 27 || FrameCount == 33 || FrameCount == 42 )  
				nextImage();
		  if(isRightPlayer)
	      {
	         if(FrameCount < 30)
	          x -= 30; //looks good at 25 with id condition at 10
	         else 
	          x+= 30; 
	      }
	      else
	      {
	         if(FrameCount < 30)
	          x += 30; //looks good at 25 with id condition at 10
	          else 
	             x -= 30; 
	      } 
		 
		  FrameCount ++; //might need to change where this is in the method
	}

	//returns number of frames completed in current animation
	public int getFramesShown()//
	{
		return FrameCount;
	}

	//return total number of frames in the animation
	public int getTotalFrames()//
	{
		return TotalFrames;
	}

	public void reset()//
	{
		if(isRightPlayer)
	         x= mainFrame.FRAME_WIDTH-250;
	      else
	         x =15;
	      currentImageIndex = 0;
	      FrameCount = 0;
	}

	//increases health and decreases number of potions
	public void heal()//
	{
		currentHealth += POTION_HEAL_AMOUNT;
		potionCount --;
		
	}
	//gets x coordinate of the character
	public int getX()//
	{
		return x;
	}
	
	//draws the player
	public void drawMe(Graphics g)//, boolean isLeft)//////
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
	         if(isCharged)
	         {
	        	 g.setColor(new Color(255, 255, 0, 31));
	        	 g.fillRect(x, y, width, height);
	        }
	         g.drawImage(ImageList[currentImageIndex], x+width, y,-width, height,null );//targetPanel);
	      }
	      else
	      {
	    	  if(isCharged)
		         {
		        	 g.setColor(new Color(255, 255, 0, 31));
		        	 g.fillRect(x, y, width, height);
		        }
	    	  ImageIcon ii = new ImageIcon("characterImages/Man0001.png");
	    	  g.drawImage(ImageList[currentImageIndex], x, y,null);// targetPanel);
	      }
	}	
}
