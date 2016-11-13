package SEProject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends JFrame {

	public static final int FRAME_WIDTH = 640;
	public static final int FRAME_HEIGHT = 480;
	
	public mainFrame()/////ADDD A CONTROLLER INSTEAD OF MAKING THIS DO ALL THE PROCESSING, HAVE THIS CLASS SIMPLY BE THE FRAME?
	{
		add(new MainMenu(this));
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

	//sets active panel to a new Pane1
	public void set1()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new Pane1(this));
		getContentPane().revalidate();
		
	}
	
	//sets active panel to a new Pane2
	public void set2()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new Pane2(this));
		getContentPane().revalidate();
		
	}
	
	//sets active panel to new MainMenu
	public void setMainMenu()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new MainMenu(this));
		getContentPane().revalidate();
	}
	
	
	//sets active panel to a new characterinfopane. Note that this actually sets the active panel to a JScrollPane, which has the character info pane added to it
	public void setCharacterInfoPane()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		

		CharacterInfoPane infoPane = new CharacterInfoPane(this);
		infoPane.setPreferredSize(new Dimension (640, 2000));
		
		JScrollPane scroller = new JScrollPane(infoPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.getVerticalScrollBar().setUnitIncrement(16); //this makes the scroll faster than default
		
		getContentPane().add(scroller);
		getContentPane().revalidate();
		
		
	}
	
	
	//sets the panel to a battle pane
	public void setBattlePane()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new BattlePane(this));
		getContentPane().revalidate();
		
	}
	
	//main method, creates a mainframe
	public static void main(String[] args)
	{
		mainFrame a = new mainFrame();
	}
	
}
