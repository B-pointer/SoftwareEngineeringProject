   public void drawGokuDescription(Graphics g)
   {
      Sting text = ( "Goku_-_47copy-1.jpg");
        g.drawString(text, 550, 325);
        Height= 63in;
        Weight= 210lbs; 
                
      maxHealth= 400;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 60;
		attackPower = 90;
		System.out.println("My name is " + characterName + " and my attack power is " + attackPower);
            
   }
            
   public void drawSamDescription(Graphics g)
   {
      String text = ("http://www.imfdb.org/images/thumb/1/1b/TheMan_27.jpg/400px-TheMan_27.jpg");
         g.drawString(text, 550, 325);
         Height= 74in;
         Weight= 200lbs;
         
		maxHealth= 450;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 75;
		attackPower = 70;
      System.out.println("My name is " + characterName + " and my attack power is " + attackPower);

   }
	
   public void drawKeanuDescription(Graphics g)
	{
      String text = ("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR1EbmoippCryk_TKK9hvnoNj_6d8kvXynZNezcyJF9Fr-ANke36Q");
         g.drawString(text, 550, 325);
         Height= 71in;
         Weight= 195lbs;
 
		maxHealth= 85;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 70;
		attackPower = 70;
      System.out.println("My name is " + characterName + " and my attack power is " + attackPower);

	}
   
   public void drawRandyDescription(Graphics g) 
   {
      String text = ("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcSbuhnzfafP22sq8UXyOLwjiQgw-KFJLbMu64_o1laWPfV5vTvf");          
		   g.drawString(text, 550, 325);
         Height= 72in;
         Weight= 225lbs;
      
      maxHealth= 100;
		currentHealth= maxHealth;
		potionCount = 3;	
		isCharged = false;
		rateOfSuccess = 90;
		attackPower = 60;
      System.out.println("My name is " + characterName + " and my attack power is " + attackPower);

	}           