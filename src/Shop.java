import java.util.ArrayList;

/**
 * The Shop class represents a room in the game that functions as a shop.
 * Players can interact with the shop to buy weapons and items.
 * It extends the Room class.
 */
public class Shop extends Room {
    private ArrayList<Treasure> shopItems; // List of items available in the shop
    private ArrayList<Integer> itemPrices; // Prices corresponding to the shop items
    private ArrayList<Weapon> shopWeapons; // List of weapons available in the shop
    private ArrayList<Integer> weaponPrices; // Prices corresponding to the shop weapons

    /**
     * Constructs a Shop object with a name and description.
     *
     * @param name        The name of the shop.
     * @param description The description of the shop.
     */
    public Shop(String name, String description) {
        super(name, description);
        this.shopItems = new ArrayList<>();
        this.itemPrices = new ArrayList<>();
        this.shopWeapons = new ArrayList<>();
        this.weaponPrices = new ArrayList<>();
    }

    /**
     * Retrieves the prices of the items available in the shop.
     *
     * @return An ArrayList containing the prices of the shop items.
     */
    public ArrayList<Integer> getItemPrices() {
        return this.itemPrices;
    }

    /**
     * Retrieves the prices of the weapons available in the shop.
     *
     * @return An ArrayList containing the prices of the shop weapons.
     */
    public ArrayList<Integer> getWeaponPrices() {
        return weaponPrices;
    }

    /**
     * Adds an item to the shop inventory with its corresponding price.
     *
     * @param item  The item to add to the shop inventory.
     * @param price The price of the item.
     */
    public void addShopItems(Treasure item, int price) {
        this.shopItems.add(item);
        this.itemPrices.add(price);
    }

    /**
     * Adds a weapon to the shop inventory with its corresponding price.
     *
     * @param weapon The weapon to add to the shop inventory.
     * @param price  The price of the weapon.
     */
    public void addShopItems(Weapon weapon, int price) {
        this.shopWeapons.add(weapon);
        this.weaponPrices.add(price);
    }

    /**
     * Retrieves the list of items available in the shop.
     *
     * @return An ArrayList containing the items available in the shop.
     */
    public ArrayList<Treasure> getShopItems() {
        return shopItems;
    }

    /**
     * Retrieves the list of weapons available in the shop.
     *
     * @return An ArrayList containing the weapons available in the shop.
     */
    public ArrayList<Weapon> getShopWeapons() {
        return shopWeapons;
    }

    /**
     * Displays the inventory of the shop, including weapons and items with their prices and descriptions.
     */
    public void displayShopInventory() {
        Utils.myPrintln("\n                                         $$$$$$\\   $$\\  $$\\ $$$$$$\\    $$$$$$\\   ");
        Utils.myPrintln("                                         $$  __$$\\ $$ |  $$ |$$  __$$\\ $$  __$$\\ ");
        Utils.myPrintln("                                         $$ /  \\__|$$ |  $$ |$$ /  $$ | $$ |  $$ |");
        Utils.myPrintln("                                         \\$$$$$$\\ $$$$$$$$ |$$ |   $$ | $$$$$$$  |");
        Utils.myPrintln("                                         \\____$$\\ $$  __ $ |$$ |   $$ | $$  ____/ ");
        Utils.myPrintln("                                         $$\\   $$ |$$ |  $$ |$$ |  $$ | $$ |      ");
        Utils.myPrintln("                                         \\$$$$$$  |$$ |  $$ | $$$$$$  | $$ |      ");
        Utils.myPrintln("                                         \\______/ \\__|  \\__| \\___/ \\__ |  ");
        Utils.myPrintln("                                                                                 ");

        Utils.myPrintln("Your Gold: " + MyAdventure.player.getGold() + "\uD83E\uDE99 \n-----------");
        Utils.myPrintln("Weapons⚔️:\n----------");
        for (int i = 0; i < shopWeapons.size(); i++) {
            Weapon weapon = shopWeapons.get(i);
            int price = weaponPrices.get(i);
            String critChance = String.format("%.0f%%", weapon.getCritChance() * 100);
            if (weapon.getID() == 999) {
                // Print the best weapon separately
                Utils.myPrintln("\u001B[1m" + "********ELITE WEAPON*********" + "\u001B[0m");
                Utils.myPrintln("Name\uD83C\uDFF7️: \u001B[1m" + weapon.getName() + "\u001B[0m");
                Utils.myPrintln("Damage\uD83D\uDCA5: " + (int) weapon.getDamage() + "\uD83D\uDCA2");
                Utils.myPrintln("CritChance\uD83C\uDFAF: " + critChance);
                Utils.myPrintln("Price\uD83D\uDCB0: " + price + "\uD83E\uDE99");
                Utils.myPrintln("Description\uD83D\uDCDD: " + weapon.getDescription());
                Utils.myPrintln("You might need to spin that wheel to get this one...");
            }
        }
        Utils.myPrintln("Name\uD83C\uDFF7️                        Damage\uD83D\uDCA5                      CritChance\uD83C\uDFAF                 Price\uD83D\uDCB0                       Description\uD83D\uDCDD\n");
        for (int i = 0; i < shopWeapons.size(); i++) {
            Weapon weapon = shopWeapons.get(i);
            int price = weaponPrices.get(i);
            String critChance = String.format("%.0f%%", weapon.getCritChance() * 100);
            if (weapon.getID() == 999) {
                continue;
            }
            Utils.myPrintln(((((weapon.getName() + " ".repeat(30)).substring(0, 30)
                    + (int) weapon.getDamage() + "\uD83D\uDCA2" + " ".repeat(30)).substring(0, 60)
                    + critChance + " ".repeat(30)).substring(0, 90)
                    + price + "\uD83E\uDE99" + " ".repeat(30)).substring(0, 120)
                    + weapon.getDescription());
        }

        Utils.myPrintln("\nItems\uD83D\uDCE6:\n--------");
        Utils.myPrintln("Name\uD83C\uDFF7️                                  Price\uD83D\uDCB0                          Description\uD83D\uDCDD\n");
        for (int i = 0; i < shopItems.size(); i++) {
            Treasure item = shopItems.get(i);
            int price = itemPrices.get(i);
            Utils.myPrintln(((
                    item.getNameWithEmoji() + " ".repeat(40)).substring(0, 40)
                    + price + "\uD83E\uDE99" + " ".repeat(30)).substring(0, 70)
                    + item.getDescription());
        }
    }
}


