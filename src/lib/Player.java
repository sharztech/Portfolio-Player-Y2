package lib;

/**
 * A Player Class is created consisting of: a name, a gamer tag, and pair of
 * die. This example shows how a Player is a Composition of Name, Gamer Tag and
 * Pair of dice objects.
 * 
 * @author P2765365
 */
public class Player implements Comparable<Player> {

	// Fields

	private Name name;
	private String gamerTag;
	private Rollable pairOfDice;

	// Constructors
	/**
	 * Creates a new instance of Player. Default values for the pair of dice and,
	 * empty strings for the name and gamer tag are initialised .
	 */

	public Player() {
		this.name = new Name("", "");
		this.pairOfDice = new PairOfDice();
		this.gamerTag = "";
	}

	/**
	 * Creates a new instance of Player, that allows you to set the player name and
	 * gamer tag.
	 * 
	 * @param n  the player's name (a Name object).
	 * @param gt The player's gamer tag.
	 */

	public Player(Name n, String gt) {

		this.name = n;
		this.pairOfDice = new PairOfDice();
		this.gamerTag = gt;
	}

	/**
	 * Creates a new instance of Player, with the given values.
	 * 
	 * @param n  the player's name (a Name object).
	 * @param r  The player's pair of dice (a Rollable object).
	 * @param gt The player's gamer tag.
	 */
	public Player(Name n, String gt, Rollable r) {

		this.name = n;
		this.pairOfDice = r;
		this.gamerTag = gt;
	}

	// Methods

	/**
	 * Returns the actual name of the player.
	 * 
	 * @return The player's name.
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Returns the pair of dice associated with the player.
	 * 
	 * @return The players pair of dice.
	 */

	public Rollable getRollable() {
		return pairOfDice;
	}

	/**
	 * Returns the gamer tag of the player.
	 * 
	 * @return The players gamer tag.
	 */

	public String getGamerTag() {
		return gamerTag;
	}

	/**
	 * Sets the player's name.
	 * 
	 * @param name The player's name.
	 */

	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Sets the player's gamer tag.
	 * 
	 * @param gamerTag The player's gamer tag.
	 */

	public void setGamerTag(String gamerTag) { //
		this.gamerTag = gamerTag;
	}

	/** Rolls the dice for the player by delegating it to the PairOfDice class. */
	public void rollDice() {
		pairOfDice.roll();
	}

	/**
	 * Gets the score of the dice that has been rolled.
	 * 
	 * @return The dice score.
	 */
	public int getDiceScore() {
		return pairOfDice.getScore();
	}

	/**
	 * Sets the player's full name with the first letter of the first name and the family name capitalised.
	 * Only sets the full name if the information provided is equal to or greater than two split strings,
	 * otherwise an exception is thrown.
	 * 
	 * @param fullName The full name of the player.
	 */
	public void setFullPlayerName(String fullName) {

		String[] names = fullName.split(" ");

		if (names.length >= 2) { 

			String firstName = names[0].substring(0, 1).toUpperCase() + names[0].substring(1).toLowerCase();
			String familyName = names[1].substring(0, 1).toUpperCase() + names[1].substring(1).toLowerCase();

			name = new Name();
			name.setFirstName(firstName);
			name.setFamilyName(familyName);

		} else {
			throw new IllegalArgumentException("The name format is not correct!");
		}

	}

	/**
	 * Generates a gamer tag for the player based on the number provided.
	 * 
	 * @param num The number that's to be included in the gamer tag.
	 */

	public void generateGamerTag(int num) {

		if (num >= 1 && num <= 100) {

			String fullName = name.getFirstName().toLowerCase() + name.getFamilyName().toLowerCase();
			fullName = fullName.replaceAll("\\s", "");

			String reversedName = new StringBuilder(fullName).reverse().toString();

			gamerTag = reversedName + num;

		}

	}

	/**
	 * Creates a string representation of the Player in the standard format.
	 * 
	 * @return A string representation of the player
	 */

	@Override
	public String toString() {
		return "Player:[" + "name=" + name + ", gamerTag=" + gamerTag + ", Rollable =" + pairOfDice + "]";
	}

	/**
	 * Compares a player to another player to sort them.
	 * 
	 * @param otherPlayer The other player for the initial player to be compared
	 *                     to.
	 * @return A negative integer, zero, or a positive integer to determine whether,
	 *         the player is less than, equal to or greater than the other player.
	 */

	public int compareTo(Player otherPlayer) {

		int players = this.name.compareTo(otherPlayer.name);

		if (players == 0) {
			return this.gamerTag.compareTo(otherPlayer.gamerTag);
		} else {
			return players;
		}

	}
}
