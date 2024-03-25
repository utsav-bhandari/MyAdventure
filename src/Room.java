import java.util.ArrayList;

/**
 * The Room class represents a room in a game environment.
 * It contains information about the room's name, description, neighbors, and items.
 */
public class Room {
    private String name; // The name of the room
    private String description; // A description of the room
    private ArrayList<String> exits = new ArrayList<>(); // List of exit directions
    private ArrayList<Room> neighbors = new ArrayList<>(); // List of neighboring rooms
    private Treasure treasure; // Treasure item in the room
    private Weapon weapon; // Weapon item in the room
    private Monster monster; // Monster in the room
    private ArrayList<Pot> pots = new ArrayList<>(); // Pots in the room
    private Chest chest; // Chest in the room
    private Armor armorPiece; // Armor in the room
    private Fountain fountain; // Fountain in the room
    private SlotMachine slotMachine; // SlotMachine in the room

    /**
     * Constructs a new Room object with the specified name and description.
     *
     * @param name        The name of the room.
     * @param description A brief description of the room.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        if (StdRandom.uniformDouble() < 0.5) {
            for (int i = 0; i < StdRandom.uniformInt(1, 4); i++) {
                this.pots.add(new Pot());
            }
        }
    }

    /**
     * Sets the monster present in the room.
     *
     * @param monster The monster to be set in the room.
     */
    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    /**
     * Sets the treasure item present in the room.
     *
     * @param treasure The treasure item to be set in the room.
     */
    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    /**
     * Sets the weapon item present in the room.
     *
     * @param weapon The weapon item to be set in the room.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Sets the chest present in the room.
     *
     * @param chest The chest to be set in the room.
     */
    public void setChest(Chest chest) {
        this.chest = chest;
    }

    /**
     * Sets the armor piece present in the room.
     *
     * @param armorPiece The armor piece to be set in the room.
     */
    public void setArmor(Armor armorPiece) {
        this.armorPiece = armorPiece;
    }

    /**
     * Sets the fountain present in the room.
     *
     * @param fountain The fountain to be set in the room.
     */
    public void setFountain(Fountain fountain) {
        this.fountain = fountain;
    }

    /**
     * Sets the slot machine present in the room.
     *
     * @param slotMachine The slot machine to be set in the room.
     */
    public void setSlotMachine(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
    }

    /**
     * Adds a neighboring room in the specified direction.
     *
     * @param direction The direction of the neighboring room.
     * @param room      The neighboring room to be added.
     */
    public void addNeighbor(String direction, Room room) {
        exits.add(direction);
        neighbors.add(room);
    }

    /**
     * Retrieves the name of the room.
     *
     * @return The name of the room.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the description of the room.
     *
     * @return A brief description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the neighboring room in the specified direction.
     *
     * @param direction The direction of the neighboring room.
     * @return The neighboring room or null if no such neighbor exists.
     */
    public Room getNeighbor(String direction) {
        int check = exits.indexOf(direction);
        if (check == -1) {
            return null;
        }
        return neighbors.get(check);
    }

    /**
     * Retrieves the monster present in the room.
     *
     * @return The monster present in the room or null if no monster is present.
     */
    public Monster getMonster() {
        return monster;
    }

    /**
     * Retrieves the weapon item present in the room.
     *
     * @return The weapon item present in the room or null if no weapon is present.
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Retrieves the armor piece present in the room.
     *
     * @return The armor piece present in the room or null if no armor piece is present.
     */
    public Armor getArmorPiece() {
        return armorPiece;
    }

    /**
     * Retrieves the treasure item present in the room.
     *
     * @return The treasure item present in the room or null if no treasure is present.
     */
    public Treasure getTreasure() {
        return treasure;
    }


    /**
     * Retrieves the chest present in the room.
     *
     * @return The chest present in the room or null if no chest is present.
     */
    public Chest getChest() {
        return chest;
    }

    /**
     * Retrieves the fountain present in the room.
     *
     * @return The fountain present in the room or null if no fountain is present.
     */
    public Fountain getFountain() {
        return fountain;
    }

    /**
     * Retrieves the number of pots in the room.
     *
     * @return The number of pots in the room.
     */
    public int getPotSize() {
        return this.pots.size();
    }

    /**
     * Retrieves the list of pots present in the room.
     *
     * @return The list of pots present in the room.
     */
    public ArrayList<Pot> getPots() {
        return pots;
    }

    /**
     * Retrieves the slot machine present in the room.
     *
     * @return The slot machine present in the room or null if no slot machine is present.
     */
    public SlotMachine getSlotMachine() {
        return this.slotMachine;
    }

    /**
     * Simulates the action of a player opening a chest in the room.
     * The player receives gold and any treasure items found in the chest.
     */
    public void playerOpensChest() {
        int goldInChest = StdRandom.uniformInt(50, 101);
        Utils.myPrintln("You found " + goldInChest + "\uD83E\uDE99 in the chest!");
        MyAdventure.player.addGold(goldInChest);
        for (Treasure item : this.getChest().getLoot()) {
            Utils.myPrintln("You also found a " + item.getNameWithEmoji() + ".");
            MyAdventure.player.addItem(item);
        }
        Utils.myPrintln("\n***The chest disappears as you finish looting it...***");
    }

    /**
     * Removes the neighboring room in the specified direction.
     *
     * @param direction The direction of the neighboring room to be removed.
     */
    public void removeNeighbor(String direction) {
        int index = exits.indexOf(direction);
        if (index != -1) {
            neighbors.remove(index);
            exits.remove(index);
        }
    }

    /**
     * Lists the exit directions of the room.
     *
     * @return A string representation of the exit directions.
     */
    public String listExits() {
        return this.exits.toString();
    }
}
