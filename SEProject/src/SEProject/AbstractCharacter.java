package SEProject;

public abstract class AbstractCharacter {
	
	// instance var's
	private int currentHealth;
	private int maxHealth;
	private int attack;
	private int defense;
	private double rateOfSuccess;
	
	// constructer
	public Character() {
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
	
}
