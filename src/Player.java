import java.util.ArrayList;

/**
 * The Player class represents the player character in the game.
 * It contains information about the player's attributes, inventory, and actions.
 */
public class Player {
    private double maxHP; // The maximum health points of the player
    private double currentHP; // The current health points of the player
    private double Atk; // The attack power of the player
    private double Def; // The defense value of the player
    private double Lck; // The luck attribute of the player
    private double Agt; // The agility attribute of the player
    private int gold; // The amount of gold possessed by the player
    private Weapon currentWeapon; // The currently equipped weapon of the player
    private ArrayList<Weapon> weapons = new ArrayList<>(); // The collection of weapons in the player's inventory
    private ArrayList<Treasure> items = new ArrayList<>(); // The collection of treasures in the player's inventory
    private ArrayList<Armor> armorPieces = new ArrayList<>(); // The collection of armor pieces in the player's inventory

    /**
     * Constructs a new Player object with the specified attributes.
     *
     * @param maxHealthPoints The maximum health points of the player.
     * @param healthPoints The current health points of the player.
     * @param attack The attack power of the player.
     * @param defense The defense value of the player.
     * @param agility The agility attribute of the player.
     */
    public Player(double maxHealthPoints, double healthPoints, double attack, double defense, double agility) {
        this.maxHP = maxHealthPoints;
        this.currentHP = healthPoints;
        this.Atk = attack;
        this.Def = defense;
        this.Lck = StdRandom.uniformInt(5, 15);
        this.Agt = agility;
        this.weapons.add(new Weapon("Your fists", 0.5, 0, "Your unimpressive fists.", 100));
    }

    /**
     * Retrieves the agility attribute of the player.
     *
     * @return The agility attribute of the player.
     */
    public double getAgility() {
        return Agt;
    }

    /**
     * Retrieves the number of items in the player's inventory.
     *
     * @return The number of items in the player's inventory.
     */
    public int getItemCount() {
        return this.items.size();
    }

    /**
     * Retrieves the collection of treasures in the player's inventory.
     *
     * @return The collection of treasures in the player's inventory.
     */
    public ArrayList<Treasure> getItems() {
        return this.items;
    }

    /**
     * Retrieves the collection of weapons in the player's inventory.
     *
     * @return The collection of weapons in the player's inventory.
     */
    public ArrayList<Weapon> getArsenal() {
        return this.weapons;
    }

    /**
     * Retrieves the dodge chance of the player.
     *
     * @return The dodge chance of the player.
     */
    public double getDodgechance() {
        // Calculate dodge chance based on luck and agility
        double baseDodgeChance = 0.05; // Base dodge chance
        double luckFactor = Lck / 82; // double of max possible luck
        double agilityFactor = Agt / 75; // triple of max agility

        // Calculate total dodge chance
        double totalDodgeChance = baseDodgeChance + luckFactor * 0.2 + agilityFactor * 0.1;

        // Ensure dodge chance is within valid range (0 to 1)
        totalDodgeChance = Math.max(0, Math.min(1, totalDodgeChance));

        return totalDodgeChance;
    }

    /**
     * Retrieves the amount of gold possessed by the player.
     *
     * @return The amount of gold possessed by the player.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Retrieves the current health points of the player.
     *
     * @return The current health points of the player.
     */
    public double getCurrentHP() {
        return currentHP;
    }

    /**
     * Retrieves the maximum health points of the player.
     *
     * @return The maximum health points of the player.
     */
    public double getMaxHP() {
        return this.maxHP;
    }

    /**
     * Sets the current weapon of the player.
     *
     * @param weapon The new current weapon of the player.
     */
    public void setCurrentWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
        this.Atk = weapon.getDamage();
    }

    /**
     * Retrieves the defense value of the player.
     *
     * @return The defense value of the player.
     */
    public double getDef() {
        return Def;
    }

    /**
     * Retrieves the currently equipped weapon of the player.
     *
     * @return The currently equipped weapon of the player.
     */
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    /**
     * Increases the player's agility attribute by the specified amount.
     *
     * @param agt The amount by which to increase the player's agility.
     */
    public void addAgt(double agt) {
        this.Agt += agt;
    }

    /**
     * Adds a treasure item to the player's inventory.
     *
     * @param item The treasure item to add to the player's inventory.
     */
    public void addItem(Treasure item) {
        this.items.add(item);
    }

    /**
     * Adds a weapon to the player's inventory.
     *
     * @param weapon The weapon to add to the player's inventory.
     */
    public void addItem(Weapon weapon) {
        this.weapons.add(weapon);
    }

    /**
     * Adds an armor piece to the player's inventory and increases the player's defense value accordingly.
     *
     * @param armor The armor piece to add to the player's inventory.
     * @param defValue The defense value provided by the armor piece.
     */
    public void addItem(Armor armor, double defValue) {
        this.armorPieces.add(armor);
        this.Def += defValue;
    }

    /**
     * Increases the amount of gold possessed by the player.
     *
     * @param gold The amount of gold to add to the player's possession.
     */
    public void addGold(int gold) {
        this.gold += gold;
        Utils.myPrintln("Gold: " + this.gold + "\uD83E\uDE99");
    }

    /**
     * Increases the player's luck attribute by the specified amount.
     *
     * @param luckValue The amount by which to increase the player's luck.
     */
    public void addLuck(double luckValue) {
        this.Lck += luckValue;
    }

    /**
     * Restores the player's health points by the specified amount.
     *
     * @param healValue The amount by which to restore the player's health points.
     */
    public void heals(double healValue) {
        Utils.myPrintln("A surge of vitality fills you.");
        if (this.currentHP + healValue > maxHP) {
            this.currentHP = maxHP;
        } else {
            this.currentHP += healValue;
        }
    }

    /**
     * Inflicts damage on the player after considering the player's defense.
     *
     * @param damage The amount of damage to be inflicted on the player.
     */
    public void takesDamage(double damage) {
        double actualDamage = Math.ceil(damage - this.Def);
        this.currentHP -= actualDamage;
    }

    /**
     * Checks if the player is dead.
     *
     * @return True if the player's current health points are less than or equal to 0, false otherwise.
     */
    public boolean isDead() {
        return this.currentHP <= 0;
    }

    /**
     * Removes a specific item from the player's inventory.
     *
     * @param ID The ID of the item to be removed from the inventory.
     */
    public void removeItemFromInventory(int ID) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getID() == ID) {
                items.remove(i);
                return;
            }
        }
        Utils.myPrintln("You cannot strip away that which you have no claim to possess.");
    }

    /**
     * Removes a specific weapon from the player's inventory.
     *
     * @param ID The ID of the weapon to be removed from the inventory.
     */
    public void removeWeaponFromInventory(int ID) {
        for (int i = 0; i < this.weapons.size(); i++) {
            if (this.weapons.get(i).getID() == ID) {
                weapons.remove(i);
                return;
            }
        }
        Utils.myPrintln("You cannot strip away that which you have no claim to possess.");
    }

    /**
     * Prompts the player to drink from the fountain of vitality.
     *
     * @return True if the player chooses to drink, false otherwise.
     */
    public boolean useFountainChoice() {
        char borderChar = '*';
        int borderLength = 45;

        // Create the border string
        String border = new String(new char[borderLength]).replace('\0', borderChar);

        Utils.myPrintln(border);
        Utils.myPrintln("* Drink from the well of Vitality? [yes/no] *");
        Utils.myPrintln(border);
        Utils.myPrint("> ");
        String choice = StdIn.readLine();
        if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
            this.useFountain();
            return true;
        } else {
            Utils.myPrintln("\n...");
            return false;
        }
    }

    /**
     * Plays the slot machine game.
     * Rewards the player based on luck with chances to win gold prizes.
     */
    public void playSlotMachine() {
        if (gold < 15) {
            Utils.myPrintln("You don't have enough gold to play the slot machine!");
            return;
        }
        this.addGold(-15);

        // Simulate spinning the reels
        double randomNumber = StdRandom.uniformDouble();
        double luckFactor = this.Lck * 0.001;

        if (randomNumber < 0.025 + luckFactor) { // 2.5% base chance of hitting jackpot
            Utils.myPrintln("\n\033[1;33m-------------------------------------\033[0m");
            Utils.myPrintln("\033[1;33m|    🎉🎉🎉   JACKPOT!   🎉🎉🎉    |\033[0m");
            Utils.myPrintln("\033[1;33m|                                   |\033[0m");
            Utils.myPrintln("\033[1;33m|    💰   Congratulations!   💰     |\033[0m");
            Utils.myPrintln("\033[1;33m|        You've won 999 gold!       |\033[0m");
            Utils.myPrintln("\033[1;33m-------------------------------------\033[0m\n");
            this.addGold(999);
        } else if (randomNumber < 0.095 + luckFactor) { // 7% base chance of winning a sweet prize
            Utils.myPrintln("\033[0;35mYou've won a sweet prize of 50 gold!\033[0m");
            this.addGold(50);
        } else if (randomNumber < 0.245 + luckFactor) { // 12% base chance of winning a small prize
            Utils.myPrintln("\033[0;32mYou've won a small prize of 15 gold!\033[0m");
            this.addGold(15);
        } else {
            Utils.myPrintln("\033[0;31mBetter luck next time! Spin again to try your luck.\033[0m");
        }
    }

    /**
     * Calculates the player's attack buff after rolling a magical dice.
     * Buffs the player's attack based on the dice roll result.
     *
     * @return The calculated attack buff value.
     */
    public double damageAfterMagicalDiceBuff() {
        double playerAttackBuff = 0;
        double currentPlayerAttack = this.getCurrentWeapon().getDamage();

        int magicalDiceRoll = StdRandom.uniformInt(0, 7);
        switch (magicalDiceRoll) {
            case 0:
                Utils.myPrintln("Rolled a 0. No buff!");
                break;
            case 1:
                playerAttackBuff += currentPlayerAttack * 0.05;
                Utils.myPrintln("Rolled a 1. 5% buff!");
                break;
            case 2:
                playerAttackBuff += currentPlayerAttack * 0.1;
                Utils.myPrintln("Rolled a 2. 10% buff!");
                break;
            case 3:
                playerAttackBuff += currentPlayerAttack * 0.15;
                Utils.myPrintln("Rolled a 3. 15% buff!");
                break;
            case 4:
                playerAttackBuff += currentPlayerAttack * 0.2;
                Utils.myPrintln("Rolled a 4. 20% buff!");
                break;
            case 5:
                playerAttackBuff += currentPlayerAttack * 0.25;
                Utils.myPrintln("Rolled a 5. 25% buff!");
                break;
            case 6:
                // 5% chance for 50% damage boost
                if (StdRandom.uniformDouble() < 0.3) {
                    playerAttackBuff += currentPlayerAttack * 0.5;
                    Utils.myPrintln("Rolled a 6. 50% buff!!!!");
                } else {
                    Utils.myPrintln("The dice refused to be rolled. Better luck next time...");
                }
                break;
        }
        return playerAttackBuff;
    }

    /**
     * Calculates the damage after considering the critical strike chance.
     * If the weapon crits, the damage is doubled.
     *
     * @return The calculated damage after considering the critical strike chance.
     */
    public double getDamageAfterCritChance() {
        // If weapon crits, 100% damage increase
        if (StdRandom.bernoulli(this.currentWeapon.getCritChance())) {
            Utils.myPrintln("\u001B[1m" + "********CRITICAL STRIKE*********" + "\u001B[0m");
            return this.currentWeapon.getDamage();
        }
        return 0;
    }

    /**
     * Calculates the damage dealt using the Scroll of Piercing Precision.
     *
     * @return The damage dealt using the Scroll of Piercing Precision.
     */
    public double useScrollOfPiercingPrecision() {
        return this.currentWeapon.getDamage();
    }

    /**
     * Checks if the player has a specific weapon in their inventory.
     *
     * @return True if the player has the specified weapon, false otherwise.
     */
    public boolean hasHilt() {
        for (Weapon weapon : weapons) {
            if (weapon.getID() == 101) {
                return true;
            }
        }
        return false;
    }

    /**
     * Uses the fountain to restore health points to maximum and increase maximum health points by 20.
     */
    public void useFountain() {
        this.MaxHealthIncrease();
        this.heals(this.getMaxHP());
    }

    /**
     * Increases the player's maximum health points by 20.
     */
    public void MaxHealthIncrease() {
        this.maxHP += 20;
    }


    /**
     * Displays the player's statistics including max HP, attack, defense, luck, and agility.
     */
    public void displayStats() {
        Utils.myPrintln("╔═══════════╦═════════╦═════════╦═════════╦═════════╗");
        Utils.myPrint("");
        StdOut.printf("║   Max HP  ║ Attack  ║ Defense ║ Luck    ║ Agility ║%n");
        Utils.myPrintln("╠═══════════╬═════════╬═════════╬═════════╬═════════╣");
        Utils.myPrint("");
        StdOut.printf("║ %9.0f ║ %7.0f ║ %7.0f ║ %7.0f ║ %7.0f ║%n", maxHP, Atk, Def, Lck, Agt);
        Utils.myPrintln("╚═══════════╩═════════╩═════════╩═════════╩═════════╝");
    }

    /**
     * Displays the weapons in the player's arsenal.
     * Each weapon is shown with its name, damage, critical chance, and description.
     */
    public void displayWeapons() {
        // Print header
        Utils.myPrintln("Weapons⚔️:");
        Utils.myPrintln("----------");
        Utils.myPrintln("Name\uD83C\uDFF7️                        Damage\uD83D\uDCA5                      CritChance\uD83C\uDFAF                  Description\uD83D\uDCDD\n");

        // Print weapons
        for (Weapon weapon : weapons) {
            String name;
            if (weapon.getID() == this.currentWeapon.getID()) {
                name = (weapon.getName() + " [equipped]" + " ".repeat(30)).substring(0, 30);
            } else {
                name = (weapon.getName() + " ".repeat(30)).substring(0, 30);
            }
            String formattedOutput = getString(weapon, name);
            Utils.myPrintln(formattedOutput);
        }
    }

    /**
     * Checks if the player dodges an attack.
     *
     * @param dodgeForGrom True if dodging for Grom, false otherwise.
     * @return True if the player dodges the attack, false otherwise.
     */
    public boolean dodges(boolean dodgeForGrom) {
        if (dodgeForGrom) {
            return StdRandom.bernoulli(0.85);
        }
        return StdRandom.bernoulli(this.getDodgechance());
    }

    /**
     * Displays the items in the player's inventory.
     * Each item is shown with its name and description.
     */
    public void displayItems() {
        Utils.myPrintln("\nChoose item to use:\n-------------------");
        // Find maximum lengths of name and description
        int maxNameLength = 0;
        int maxDescriptionLength = 0;
        for (Treasure item : this.items) {
            maxNameLength = Math.max(maxNameLength, item.getName().length());
            maxDescriptionLength = Math.max(maxDescriptionLength, item.getDescription().length());
        }

        // Print items with formatted name and description
        for (Treasure item : this.items) {
            String itemName = item.getNameWithEmoji();
            if (item.getID() == 0) {
                itemName = "[MD]" + item.getNameWithEmoji();
            }
            String itemDescription = item.getDescription();

            // Calculate the dynamic width for each column
            int nameWidth = maxNameLength + 4;
            int descriptionWidth = maxDescriptionLength + 4;

            // Format the output
            String formattedOutput = String.format("%-" + nameWidth + "s %-" + descriptionWidth + "s", itemName, "  " + itemDescription);
            Utils.myPrintln(formattedOutput);
        }
    }


    /**
     * Formats the weapon information into a string for display.
     *
     * @param weapon The weapon to format.
     * @param name   The name of the weapon.
     * @return The formatted string containing weapon information.
     */
    private static String getString(Weapon weapon, String name) {
        String damage = ((int) weapon.getDamage() + "\uD83D\uDCA2" + " ".repeat(30)).substring(0, 30);
        String critChance = String.format("%.0f%%", weapon.getCritChance() * 100);
        critChance = (critChance + " ".repeat(30)).substring(0, 30);

        String description = weapon.getDescription();

        // Combine the formatted strings
        return name + damage + critChance + description;
    }

    public void displayInventory() {
        // Print header
        Utils.myPrintln("Inventory:");
        Utils.myPrintln("-----------------------------------------------------------------------------------------------------");
        Utils.myPrintln("Gold: " + this.getGold() + "\uD83E\uDE99 \n-----------");
        Utils.myPrintln("Weapons⚔️:\n-----------");
        Utils.myPrintln("Name\uD83C\uDFF7️                                 Damage\uD83D\uDCA5                      CritChance\uD83C\uDFAF                  Description\uD83D\uDCDD\n");
        for (Weapon weapon : weapons) {
            String name;
            if (weapon.getID() == this.currentWeapon.getID()) {
                name = (weapon.getName() + " [equipped]");
            }
            else{
                name =  weapon.getName();
            }
            String critChance = String.format("%.0f%%", weapon.getCritChance() * 100);
            Utils.myPrintln((((name + " ".repeat(40)).substring(0, 40)
                    + (int)weapon.getDamage() + "\uD83D\uDCA2" + " ".repeat(30)).substring(0, 70)
                    + critChance + " ".repeat(30)).substring(0, 100)
                    + weapon.getDescription());
        }

        Utils.myPrintln("---------\nItems\uD83D\uDCE6:\n---------");
        Utils.myPrintln("Name\uD83C\uDFF7️                        Description\uD83D\uDCDD\n");
        for (Treasure item : items) {
            Utils.myPrintln((item.getNameWithEmoji() + " ".repeat(30)).substring(0, 30) + item.getDescription());
        }

        Utils.myPrintln("--------------\nArmorpieces\uD83D\uDEE1️:\n--------------");
        Utils.myPrintln("Name\uD83C\uDFF7️                        Defense\uD83D\uDEE1                     Description\uD83D\uDCDD\n");
        for (Armor armor : armorPieces) {
            Utils.myPrintln(((armor.getName() + " ".repeat(30)).substring(0, 30)
                    + (int)armor.getDefValue() + " ".repeat(30)).substring(0, 60)
                    + armor.getDescription());
        }
    }
}
