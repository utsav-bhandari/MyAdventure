/**
 * The Monster class represents a monster in the game.
 * It contains information about the monster's name, attack, armor, agility, max armor, and description.
 */
public class Monster {
    private String name; // The name of the monster
    private double Atk; // The attack damage of the monster
    private double armor; // The armor value of the monster
    private double Agt; // The agility of the monster
    private String description; // A description of the monster
    private double maxArmor; // The maximum armor value of the monster

    /**
     * Constructs a new Monster object with the specified attributes.
     *
     * @param name The name of the monster.
     * @param attack The attack damage of the monster.
     * @param armor The armor value of the monster.
     * @param maxArmor The maximum armor value of the monster.
     * @param agility The agility of the monster.
     * @param description A brief description of the monster.
     */
    public Monster(String name, double attack, double armor, double maxArmor, double agility, String description) {
        this.name = name;
        this.Atk = attack;
        this.armor = armor;
        this.maxArmor = maxArmor;
        this.Agt = agility;
        this.description = description;
    }

    /**
     * Retrieves the name of the monster.
     *
     * @return The name of the monster.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the armor value of the monster.
     *
     * @return The armor value of the monster.
     */
    public double getArmor() {
        return armor;
    }

    /**
     * Retrieves the agility of the monster.
     *
     * @return The agility of the monster.
     */
    public double getAgility() {
        return Agt;
    }

    /**
     * Retrieves the maximum armor value of the monster.
     *
     * @return The maximum armor value of the monster.
     */
    public double getMaxArmor() {
        return maxArmor;
    }

    /**
     * Sets the armor value of the monster.
     *
     * @param armor The new armor value to set.
     */
    public void setArmor(double armor) {
        this.armor = armor;
    }

    /**
     * Retrieves the description of the monster.
     *
     * @return A brief description of the monster.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Inflicts damage on the monster, reducing its armor.
     *
     * @param damage The amount of damage to inflict.
     */
    public void takesDamage(double damage) {
        this.armor -= damage;
    }

    /**
     * Retrieves the attack damage of the monster.
     *
     * @return The attack damage of the monster.
     */
    public double getDamage() {
        return this.Atk;
    }

    /**
     * Checks if the monster is dead (armor depleted).
     *
     * @return true if the monster is dead, false otherwise.
     */
    public boolean isDead() {
        return Math.ceil(this.armor) <= 0;
    }
}
