
public class NFT {

	private String name;
	private int rarity, level, health;
	private boolean evo, isPoisoned, isStunned;

	public NFT(String name, int rarity, int level, int health, boolean evo, boolean isPoisoned, boolean isStunned) {
		this.name = name;
		this.rarity = rarity;
		this.level = level;
		this.evo = evo;
		this.health = health;
		this.isPoisoned = isPoisoned;
		this.isStunned = isStunned;
	}

}
