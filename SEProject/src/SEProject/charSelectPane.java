package SEProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class charSelectPane extends JPanel {
	
	mainFrame mFrame;
	ArrayList<ImageIcon> imageList;
	private final int NUMBER_BUTTONS =4;
	private int selectionCount;
	public charSelectPane(mainFrame frame)
	{
		mFrame = frame;
		setBackground(Color.MAGENTA);
		
		
		selectionCount = 0;
		getImages();
		addButtons();
		
		setVisible(true);
		
	}
	
	private void getImages()
	{
		imageList = new ArrayList<ImageIcon>();
		for(int i=0; i < NUMBER_BUTTONS; i++)
		{
			ImageIcon ii = new ImageIcon("charSelectImages/Example.png");
			imageList.add(ii);
		}
	}
	
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
			add(aButton);
		}
	}
	//private void assignNextChar(int charID)
	//{
		
		
	//}
	
	public void checkIfComplete() 
	{
		if(selectionCount > 1)
		{
			mFrame.setBattlePane();	//maybe make this sleep here or add a button or something prompting the player
		}
	}
	
	private class SelectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			selectionCount ++;
			String source = e.getActionCommand();
			JButton sourceButton = (JButton)e.getSource();
			sourceButton.setVisible(false);
			//assignNextCharacter(source.parseInt)//this will be used to set the character the player chooses 
			checkIfComplete();
		}
	}
}
