package SEProject;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Goku extends AbstractCharacter{
	
	public Goku(BattlePane bp, boolean isRight)
	{
		setTargetPanel(bp);
		SetIsRightPlayer(isRight);
		setStats();
		loadImages("Goku");
	}
	public void setStats()
	{
		int health = 500;
		int atk = 80;
		int def = 30;
		int ros = 65;
		setAttack(atk);
		setMaxHealth(health);
		setCurrentHealth(health);
		setDefense(def);
		setRateOfSuccess(ros);
	}	
}
