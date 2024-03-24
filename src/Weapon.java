/**
 * The Weapon class represents a weapon in a game.
 * It stores information such as the weapon's name, damage, and description.
 */
public class Weapon {
    private String name; // The name of the weapon
    private double damage;  // The damage value of the weapon
    private double critChance;
    private String description; // A description of the weapon
    private final int ID;
    /**
     * Constructs a new Weapon object with the specified attributes.
     *
     * @param name The name of the weapon.
     * @param damage The damage value of the weapon.
     * @param description A brief description of the weapon.
     */
    public Weapon(String name, double critChance, double damage, String description, int ID){
        this.name = name;
        this.damage = damage;
        this.critChance = critChance;
        this.description = description;
        this.ID = ID;
    }

    /**
     * Retrieves the name of the weapon.
     *
     * @return The name of the weapon.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieves the damage value of the weapon.
     *
     * @return The damage value of the weapon.
     */
    public double getDamage() {
        return this.damage;
    }

    public void addDamage(double damage) {
        this.damage += damage;
    }
    public double getCritChance() {
        return this.critChance;
    }

    /**
     * Retrieves the description of the weapon.
     *
     * @return A brief description of the weapon.
     */
    public String getDescription() {
        return this.description;
    }

    public int getID() {
        return this.ID;
    }
}
