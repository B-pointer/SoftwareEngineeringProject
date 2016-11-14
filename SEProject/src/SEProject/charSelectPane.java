package SEProject;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class charSelectPane extends JPanel {
	
	mainFrame mFrame;
	ArrayList<ImageIcon> imageList;
	private final int NUMBER_BUTTONS =4;
	public charSelectPane(mainFrame frame)
	{
		mFrame = frame;
		setBackground(Color.MAGENTA);
		
		
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
			aButton.setActionCommand(String.valueOf(i));
			//aButton.setText("Button " + i);
			aButton.setIcon(imageList.get(i));
			aButton.setBorder(BorderFactory.createEmptyBorder());
			aButton.setContentAreaFilled(false);
			aButton.setPreferredSize(new Dimension(mainFrame.FRAME_WIDTH/4-20, mainFrame.FRAME_HEIGHT));
			add(aButton);
		}
	}
	
	private class SelectListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String source = e.getActionCommand();
			JButton sourceButton = (JButton)e.getSource();
			sourceButton.setVisible(false);
			//setNextCharacter(source.parseInt)//this will be used to set the character the player chooses 
		}
	}
}
