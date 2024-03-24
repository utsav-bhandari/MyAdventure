/**
 * The Fountain class represents a magical fountain in the game.
 * Players can interact with the fountain to restore their health and gain additional benefits.
 */
public class Fountain {
    private String description;

    /**
     * Constructs a Fountain object with a default description.
     * The default description provides information about the fountain's magical properties.
     */
    public Fountain() {
        this.description = "A magical fountain ⛲: Restore yourself to full health and more with a single rejuvenating sip.";
    }

    /**
     * Retrieves the description of the fountain.
     *
     * @return A string representing the description of the fountain.
     */
    public String getDescription() {
        return this.description;
    }
}
