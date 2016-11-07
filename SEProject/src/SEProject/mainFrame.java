package testGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends JFrame {

	
	public mainFrame()/////ADDD A CONTROLLER INSTEAD OF MAKING THIS DO ALL THE PROCESSING, HAVE THIS CLASS SIMPLY BE THE FRAME
	{
		add(new MainMenu(this));
		setSize(640, 480);
		
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}

		
	public void set1()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new Pane1(this));
		getContentPane().revalidate();
		
	}
	
	
	public void set2()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new Pane2(this));
		getContentPane().revalidate();
		
	}
	
	public void setMainMenu()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new MainMenu(this));
		getContentPane().revalidate();
	}
	
	public void setCharacterInfoPane()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		

		CharacterInfoPane infoPane = new CharacterInfoPane(this);
		infoPane.setPreferredSize(new Dimension (640, 2000));
		
		JScrollPane scroller = new JScrollPane(infoPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		getContentPane().add(scroller);
		getContentPane().revalidate();
		
		
	}
	
	public void setBattlePane()
	{
		getContentPane().removeAll();
		getContentPane().invalidate();
		
		getContentPane().add(new BattlePane(this));
		getContentPane().revalidate();
		
	}
	public static void main(String[] args)
	{
		
		mainFrame a = new mainFrame();
		
		
	}
	
}
