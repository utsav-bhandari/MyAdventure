/**
 * The Pot class represents a pot that can contain gold and/or health potions.
 * Players can break the pot to obtain its contents.
 */
public class Pot {
    private int gold = 0; // Amount of gold inside the pot
    private Treasure healthPotion; // Health potion inside the pot

    /**
     * Constructs a Pot object with a chance to contain gold and/or a health potion.
     * The probability of containing gold is 70%, and the probability of containing a health potion is 15%.
     */
    public Pot() {
        // Determine if the pot contains gold
        if (StdRandom.uniformDouble() < 0.8) {
            // Generate a random amount of gold between 3 and 13 (inclusive)
            this.gold = StdRandom.uniformInt(StdRandom.uniformInt(3), StdRandom.uniformInt(9, 14));
        }
        // Determine if the pot contains a health potion
        if (StdRandom.uniformDouble() < 0.20) {
            // Create a health potion
            this.healthPotion = new Treasure("Health Potion", "\uD83E\uDDEA", "use to heal yourself. **gulp**", 1);
        }
    }

    /**
     * Retrieves the amount of gold inside the pot.
     *
     * @return An integer representing the amount of gold inside the pot.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Retrieves the health potion inside the pot.
     *
     * @return A Treasure object representing the health potion inside the pot, or null if no health potion is present.
     */
    public Treasure getHealthPotion() {
        return healthPotion;
    }

    /**
     * Breaks the pot and provides its contents to the player.
     * If the pot contains nothing, a message is displayed indicating that.
     */
    public void breakPot() {
        if (this.healthPotion == null && this.gold == 0) {
            Util.myPrintln("Nothing inside.");
            return;
        }
        // Provide the health potion to the player if present
        if (this.healthPotion != null) {
            Util.myPrintln("You found a health potion\uD83E\uDDEA!");
            MyAdventure.player.addItem(this.healthPotion);
        }
        // Provide the gold to the player if present
        if (this.gold != 0) {
            Util.myPrintln("You found " + this.gold + "\uD83E\uDE99 inside!");
            MyAdventure.player.addGold(this.gold);
        }
    }
}
