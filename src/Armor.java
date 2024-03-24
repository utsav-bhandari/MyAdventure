/**
 * The Armor class represents an armor item in the game.
 * It contains information about the armor's name, description, and defense value.
 */
public class Armor {
    private String name; // The name of the armor
    private String description; // A description of the armor
    private double defValue; // The defense value of the armor

    /**
     * Constructs a new Armor object with the specified name, description, and defense value.
     *
     * @param name The name of the armor.
     * @param description A brief description of the armor.
     * @param defenseValue The defense value provided by the armor.
     */
    public Armor(String name, String description, double defenseValue) {
        this.name = name;
        this.description = description;
        this.defValue = defenseValue;
    }

    /**
     * Retrieves the name of the armor.
     *
     * @return The name of the armor.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the armor.
     *
     * @return A brief description of the armor.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Retrieves the defense value of the armor.
     *
     * @return The defense value provided by the armor.
     */
    public double getDefValue() {
        return this.defValue;
    }
}
