package SEProject;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import java.util.ArrayList;
public class charSelectPane extends JPanel {
	
	mainFrame mFrame;
	ArrayList<ImageIcon> imageList;
	ArrayList<JButton> buttonList;
	private final int NUMBER_BUTTONS =4;
	private int selectionCount;
	private int firstCharacterID;
	private int secondCharacterID;
	private String firstCharacterName;
	private String secondCharacterName;
	//constructor
	public charSelectPane(mainFrame frame)
	{
		mFrame = frame;
		setBackground(Color.MAGENTA);
		firstCharacterID=-1;
		secondCharacterID=-1;
		buttonList = new ArrayList<JButton>();
		selectionCount = 0;
		getImages();
		addButtons();
		setVisible(true);
		
	}
	//loads images for the buttons for cahracter seelction
	private void getImages()
	{
		imageList = new ArrayList<ImageIcon>();
		for(int i=0; i < NUMBER_BUTTONS; i++)
		{
			URL url = CharacterInfoPane.class.getResource("/charSelectImages/charSel" + (i+1) + ".png");
			ImageIcon ii = new ImageIcon(url);
			imageList.add(ii);
		}
	}
	//adds the buttons and pictures
	private void addButtons()
	{
		for(int i=0; i < NUMBER_BUTTONS; i++)
		{
			JButton aButton = new JButton();
			aButton.addActionListener(new SelectListener());
			aButton.setActionCommand(String.valueOf(i));//this sets action command to string value of i, needed for assigngin values of the characters to be created in battlepane
			//aButton.setText("Button " + i);
			aButton.setIcon(imageList.get(i));
			aButton.setBorder(BorderFactory.createEmptyBorder());
			aButton.setContentAreaFilled(false);
			aButton.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH/4-20, mainFrame.FRAME_HEIGHT));
			aButton.setFocusable(false);
			buttonList.add(aButton);
			add(aButton);
		}
	}
	//assigns next available character to the selection made with the buttons. Assigns integer to characterID and string to characterName
	private void assignNextCharacter(int charID)
	{
		if(firstCharacterID < 0)
		{
			firstCharacterID = charID;
			firstCharacterName = getStringNameExample(firstCharacterID);
		}
		else
		{
			secondCharacterID = charID;
			secondCharacterName = getStringNameExample(secondCharacterID);
		}
	}
	//gets string name based off int argument
	private String getStringNameExample(int x)
	{
		switch(x){
			case 0: return "goku";
			case 1: return "keanu";
			case 2: return "randy";
			case 3: return "sam";
			default: return "error";
		}
		
	}
	//checks if both characters have been assigned values
	private void checkIfComplete() 
	{
		if(selectionCount > 1)
		{
			addVersusScreen();
		}
	}
	//adds the versus screen, indicating that both characters have been selected and prompts the user to start the battle
	private void addVersusScreen()
	{
		for(JButton a: buttonList)
		{
			a.setVisible(false);
		}
		
		setBackground(Color.gray);
		JButton left  = new JButton();
		left.setBorder(BorderFactory.createEmptyBorder());
		left.setIcon(imageList.get(firstCharacterID));/////bleh
		left.setContentAreaFilled(false);
		left.setFocusable(false);
		JButton right =  new JButton(imageList.get(secondCharacterID));
		right.setBorder(BorderFactory.createEmptyBorder());
		right.setContentAreaFilled(false);
		right.setFocusable(false);
		JLabel vs = new JLabel("        "+ firstCharacterName.toUpperCase() + "   VS   "+ secondCharacterName.toUpperCase());
		vs.setFont(new Font("Arial", Font.PLAIN, 50));
		
		setLayout(new BorderLayout());
		add(left, BorderLayout.WEST);
		add(vs, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		
		JButton start = new JButton("Start");
		start.addActionListener(new StartListener());
		start.setBackground(Color.darkGray);
		start.setForeground(Color.LIGHT_GRAY);
		start.setFont(new Font("Arial", Font.PLAIN, 45));
		start.setBorder(BorderFactory.createRaisedBevelBorder());
		start.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH, 70));
		add(start, BorderLayout.SOUTH);
		//repaint();

	}
	//listener for character selection buttons
	private class SelectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectionCount ++;
			String source = e.getActionCommand();
			JButton sourceButton = (JButton)e.getSource();
			sourceButton.setVisible(false);
			assignNextCharacter(Integer.parseInt(source));//this will be used to set the character the player chooses 
			checkIfComplete();
		}
	}
	//listener for the Start Battle Button
	private class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			mFrame.setBattlePane(firstCharacterName, secondCharacterName);
		}
	}
}
