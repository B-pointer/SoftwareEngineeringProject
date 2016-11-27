package SEProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Character {//extends AbstractCharacter{ ///throughout this need to replace magic numbers with variables for easier changing
	//Instance cariables related to images and drawing
	private final int NUM_IMG = 3;//
	private Image[] ImageList;//
	private Image auraImage;
	private int currentImageIndex;
	private int FrameCount;//
	private final  int TotalFrames = 50;//
	private boolean isRightPlayer;//if this character is on the right side of the screen (controlled by player 2), set to true
	//size of image info, dependent on images and image positions
	private final int width = 500;//
	private final int height = 500;//
	private final int xBaseRight = mainFrame.FRAME_WIDTH-width;
	private final int xBaseLeft = 15;
	//Stats and battle conditions
	private String characterName;
	private int currentHealth;//
	private int maxHealth;//
	private int x;//
	private int y;//
	private int attackPower;
	private int defense;
	private boolean isCharged;//
	private int rateOfSuccess;//
	private int potionCount;//
	private final int POTION_HEAL_AMOUNT =85;//
	
	//BattlePane reference, may not be necessary but I'll leave it in for now
	BattlePane targetPanel;
	
	//parameterized constructor
	public Character(BattlePane bp, boolean isRight, String name)
	{
		characterName = name;
		targetPanel = bp;
		isRightPlayer = isRight;	
		initImageInfo();
		initCharacterStats();
		
		System.out.println("Name: "+characterName + "CHealth: " + currentHealth + "MHealth: " + maxHealth + "ATK: " + attackPower);
	}

	/*
	 * Getter Methods
	 */
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
	//returns number of potions player currently has remaining
	public int getPotionCount()
	{
		return potionCount;
	}
	//returns number of frames completed in current animation
	public int getFramesShown()
	{
		return FrameCount;
	}
	//return total number of frames in the animation
	public int getTotalFrames()
	{
		return TotalFrames;
	}
	//gets x coordinate of the character
	public int getX()//
	{
		return x;
	}

	
	/*
	 * Methods related to setting character stats for each different character
	 */
	//chooses how to initialize character stats based on the cahracter name passed in during construction of the character
	private void initCharacterStats()
	{
		switch(characterName)
		{
			case "goku": initAsGoku(); break;
			case "sam": initAsSam(); break;
			case "keanu": initAsKeanu(); break;
			case "randy": initAsRandy(); break;
		}
	}
	private void initAsGoku()
	{
		maxHealth= 400;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 60;
		attackPower = 90;
		System.out.println("My name is " + characterName + " and my attack power is " + attackPower);
	}
	
	private void initAsSam()
	{
		maxHealth= 450;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 75;
		attackPower = 70;
	}
	
	private void initAsKeanu()//definitely changes these values
	{
		maxHealth= 85;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 70;
		attackPower = 70;
	}
	
	private void initAsRandy()//definitely changes these values
	{
		maxHealth= 100;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 90;
		attackPower = 60;
	}
	/*
	 * Methods related to loading and incrementing the images in the imageList array
	 */	
	//gets the images and stores them in array
	private void loadImages()//
	{
		  ImageList = new Image[NUM_IMG];
		  ImageIcon ii;
	      for(int i=1; i< NUM_IMG+1; i++)
	      {
	    	  //ii = new ImageIcon("characterImages/Man0001.png");
	    	  //ii = new ImageIcon("characterImages/sam"+i + ".png");
	    	  ii = new ImageIcon("images/characterImages/" + characterName + i +  ".png");
	    	  ImageList[i-1] = ii.getImage();
	      }
	      ii = new ImageIcon("images/characterImages/aura.png");
	      auraImage = ii.getImage();
	      //System.out.println("length of array= " +ImageList.length);
	}
	//assigns the currentImageINdex to the next number, effectively stepping through the animation frames
	private void nextImage()//
	{
		if(currentImageIndex > ImageList.length-2)
			currentImageIndex =0;
		else 
			currentImageIndex ++;
	}
	//sets the x and y location and initializes values related to images such as the index and frame count;
	private void initImageInfo()
	{
		loadImages();
		FrameCount = 0;
		currentImageIndex = 0;
		if(isRightPlayer) //sets x based on right or left character
	        x = xBaseRight;
	    else
	        x=xBaseLeft;
		y=height/2;//sets the y coordinate
	}
	/*
	 * Battle Actions(heal, attack, and charge) and incrementing rounds won
	 */
	//randomly decides whether an attack will hit, calcualtes damage, and uses dealDamage to harm the other player
	public void attack(Character a)//
	{
		Random x = new Random();
		int z = x.nextInt(100);
		//System.out.println(z);
		if(z < rateOfSuccess)//determines if an attack hits and deals any damage
		{
			double ratio = (x.nextInt(51) + 50)/100.0;//this code ensures that if an attack hits, it does at least half of the maximum attack damage
			//System.out.println(ratio);
			int dmg = (int)(ratio*attackPower);
			System.out.println("dmg = " + dmg);
			a.dealDamage(dmg);
		}
		
		//a.dealDamage(50);
	}
	//increases rate of success of character, making attacks mroe accurate
	public void charge()//
	{
		isCharged = true;
		rateOfSuccess += 10;
		//code goes here for increasing the rate of success
	}
	//increases health and decreases number of potions
	public void heal()//
	{
		currentHealth += POTION_HEAL_AMOUNT;
		if(currentHealth > maxHealth)
			currentHealth = maxHealth;
		potionCount --;
	}
	/*
	 * Helper Methods for battle actions and code related to attack animation
	 */
	//deals damage, called by other player class in the battle
	public void dealDamage(int damage)//
	{
		currentHealth -= damage;
		if(currentHealth < 0)
			currentHealth = 0;
	}
	//changes value of x and will change the current picture index
	public void attackUpdate()
	{
		  
		//  System.out.println(FrameCount);
		 // if(FrameCount % 10 == 0 && FrameCount/10 < NUM_IMG)//magic number here
		  if(FrameCount == 3 || FrameCount == 20 || FrameCount == 20|| FrameCount == 40 )  
				nextImage();
		  if(isRightPlayer)
	      {
	         if(FrameCount < 30)
	          x -= 20; //looks good at 25 with id condition at 10
	         else 
	          x+= 20; 
	      }
	      else
	      {
	         if(FrameCount < 30)
	          x += 20; //looks good at 25 with id condition at 10
	          else 
	             x -= 20; 
	      } 
		 
		  FrameCount ++; //might need to change where this is in the method
	}
	//resets the current image index and the character's x coordinate
	public void reset()//
	{
		if(isRightPlayer)
	         x= mainFrame.FRAME_WIDTH-width;
	      else
	         x =15;
	      currentImageIndex = 0;
	      FrameCount = 0;
	}
	//draws the player
	public void drawMe(Graphics g)//, boolean isLeft)//////
	{
	
		if(isRightPlayer)
	      {
	         if(isCharged)
	         {
	        	 g.drawImage(auraImage, x+width, y,-width, height,null );
	        	 //g.setColor(new Color(255, 255, 0, 31));
	        	 //g.fillRect(x, y, width, height);
	        }
	         g.drawImage(ImageList[currentImageIndex], x+width, y,-width, height,null );//targetPanel);
	      }
	      else
	      {
	    	  
	    	  if(isCharged)
		         {
		        	// g.setColor(new Color(255, 255, 0, 31));
		        	// g.fillRect(x, y, width, height);
	    		    g.drawImage(auraImage, x, y,null);
		        }
	    	  g.drawImage(ImageList[currentImageIndex], x, y,null);// targetPanel);
	    	  
	      }
	}	
}
