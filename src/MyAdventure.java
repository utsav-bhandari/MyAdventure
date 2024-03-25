import java.util.ArrayList;
import java.util.Arrays;

public class MyAdventure {
    public static void main(String[] args) {
        new MyAdventure().run();
    }

    /** The room where the player currently is. */
    private Room currentRoom;

    /** The player playing the game. */
    public static Player player;

    /** Combat state */
    private static boolean inCombat = false;

    private final ArrayList<String> commandList  = new ArrayList<>(Arrays.asList("go", "buy", "help", "attack", "strike", "look", "take", "equip", "break", "show", "use", "open", "spin"));

    /** Static room for item drop from Grom */
    private static Room r10;


    public MyAdventure() {
        player = new Player(20, 20, 0,2,10);
        player.addItem(new Treasure("Magical Dice", "🎲", "Use to gain a random damage buff. Don't worry, it's magic. [Reusable]", 0));
        // Create rooms
        Room entrance = new Room("Entrance",
                "You stand at the mouth of a dimly lit cave, its walls adorned with glistening formations.\n" +
                        "The air is cool and musty, hinting at unseen creatures lurking within.");

        Room r1 = new Room("Grog's Lair",
                "You enter a chamber filled with the stench of ale and stale bread.\n" +
                        "Dim torchlight flickers off the damp stone walls, casting eerie shadows around you.");

        Room r2 = new Room("Dagger Den",
                "This room is littered with discarded weapons and torn banners.\n" +
                        "A faint metallic tang hangs in the air, a grim reminder of past skirmishes.");

        Room r3 = new Room("Zephyr's Refuge",
                "As you step into this room, a sudden gust of wind sends chills down your spine.\n" +
                        "The air crackles with electricity, and you sense a presence darting through the shadows.");

        Room r4 = new Room("Scroll Sanctum",
                "A serene aura envelops this room, illuminated by the soft glow of arcane symbols etched into the walls.\n" +
                        "Ancient scrolls line the shelves, their contents obscured by layers of dust.");

        Room r5 = new Room("Chamber of Ka-boom",
                "The air in this room crackles with static electricity, punctuated by the occasional rumble.\n" +
                        "You tread carefully, wary of the explosive danger that lurks within.");

        Room r6 = new Room("Grusk's Domain",
                "You find yourself in a cavernous chamber, its ceiling obscured by darkness.\n" +
                        "The ground trembles beneath your feet as a hulking figure looms in the shadows.");

        Room r7 = new Room("Treasure Trove",
                "Your eyes widen as you enter this room, filled to the brim with glittering treasures.\n" +
                        "A sense of anticipation fills the air, beckoning you to explore its riches.");

        Room r8 = new Room("Gleaming Gallery",
                "You step into a chamber bathed in ethereal light, its walls adorned with shimmering crystals.\n" +
                        "The air feels charged with magic, filling you with a sense of wonder.");

        Room r9 = new Room("Fountain of Renewal",
                "A tranquil fountain occupies the center of this room, its waters shimmering with healing energy.\n" +
                        "You feel a sense of serenity wash over you as you approach its edge.");

        r10 = new Room("Troll's Lair",
                "You enter a cavernous chamber filled with the stench of decay.\n" +
                        "The ground trembles beneath your feet as a towering figure emerges from the shadows.");

        Room r11 = new Room("Spider's Nest",
                "As you step into this room, your skin crawls at the sight of countless webs stretching from wall to wall.\n" +
                        "A sense of unease settles over you as you realize you're not alone.");

        Shop r12 = new Shop("Arcane Bazaar",
                "You find yourself in a bustling marketplace filled with exotic wares and curious artifacts.\n" +
                        "A lone merchant stands behind a grand oak counter, his wares displayed enticingly before him.\n" +
                        "His eyes gleam with a mix of anticipation and shrewd calculation as he awaits your inquiry.");

        Room r13 = new Room("Brog's Chamber",
                "You enter a chamber bathed in dim torchlight, its walls adorned with crude drawings.\n" +
                        "A sense of foreboding hangs in the air as you prepare for what lies ahead.");

        Room r14 = new Room("Golem's Sanctum",
                "This room is dominated by the presence of a towering figure, its stone form etched with ancient runes.\n" +
                        "You feel a sense of trepidation as you realize the magnitude of the challenge before you.");

        Room r15 = new Room("Fountain of Rebirth",
                "The soothing sound of flowing water fills this chamber, accompanied by the soft glow of magical energy.\n" +
                        "You feel rejuvenated as you approach the fountain's edge, ready to face whatever lies ahead.");

        Room r16 = new Room("Chamber of the Duskborne Archlich",
                "You stand at the threshold of darkness, the air heavy with the scent of decay.\n" +
                        "Sinister whispers echo through the chamber, chilling you to the bone as you prepare to confront the ultimate adversary.");


        entrance.addNeighbor("north", r1);
        entrance.setWeapon(new Weapon("hilt", 1, 1
                , "It seems to be a hilt of a fairly large sword.", 101));

        r1.addNeighbor("south", entrance);
        r1.addNeighbor("north", r2);
        r1.setMonster(new Monster("Grog", 10, 30, 30, 11,
                "He's a small, mischievous hobgoblin from folklore, known for playing tricks on humans.\n" +
                        "He seems a little dim-witted."));
        r1.setArmor(
                new Armor("Iron Boots",
                        "It belongs to a small creature.",
                        4));


        r2.addNeighbor("south", r1);
        r2.addNeighbor("east", r3);
        r2.addNeighbor("west", r5);
        r2.setWeapon(new Weapon("Dagger", 0.15,10,
                "It's a sharp dagger with Hobgoblin blood on it.", 102));

        r3.addNeighbor("west", r2);
        r3.addNeighbor("east", r4);
        r3.setMonster(new Monster("Zephyr", 10, 35, 35, 25,
                "A feathered goblin with lightning speed and a weightless presence, " +
                        "darting through the shadows,\nhis feathery form barely disturbing the air as he goes."));
        r3.setTreasure(new Treasure("Health Potion", "\uD83E\uDDEA", "Use to heal yourself. **gulp**", 1));

        r4.addNeighbor("west", r3);
        r4.setTreasure(new Treasure("Scroll of Swifter Feet", "\uD83D\uDCDC",
                "Use to enhance your agility with a single swift stroke.", 2));

        r5.addNeighbor("east", r2);
        r5.addNeighbor("north", r6);
        r5.setMonster(new Monster("Ka-boom", 100, 1, 1, 20,
                "He's a volatile force, ready to explode at a moment's notice."));
        r5.setTreasure(new Treasure("Stone of Serrated Edge", "\uD83E\uDEA8",
                "Use to elevate your weapon's bite with a single stroke.", 3));

        r6.addNeighbor("south", r5);
        r6.addNeighbor("west", r7);
        r6.addNeighbor("north", r8);
        r6.setMonster(new Monster("Grusk", 15, 35, 35, 9,
                "He's an orc and a hulking figure exuding intimidation with every step."));

        r7.addNeighbor("east", r6);
        r7.setChest(new Chest());
        r7.getChest().setChestLoot(new ArrayList<>(Arrays.asList(
                new Treasure("Scroll of Piercing Precision", "\uD83D\uDCDC",
                        "Use to unleash a guaranteed critical strike.", 4),
                new Treasure("Greater Health Potion", "⚗️",
                        "Use to fill the depths of your empty soul **GULP**", 5))));
        r7.setArmor(new Armor(
                "Iron helmet",
                "It has deep gouges on it from what could be tusks.",
                4));

        r8.addNeighbor("south", r6);
        r8.addNeighbor("north", r9);
        r8.addNeighbor("east", r10);
        r8.setTreasure(new Treasure("Gleam", "\uD83D\uDD2E",
                "A fortuitous wisp: bestows upon you heightened fortune with its ethereal glow upon use.", 6));

        r9.addNeighbor("south", r8);
        r9.setFountain(new Fountain());

        r10.addNeighbor("west", r8);
        r10.addNeighbor("east", r11);
        r10.setMonster(new Monster("Grom", 30, 95, 95, 5,
                "The towering troll: A colossal presence, his sheer size striking fear into the hearts of all who dare to cross his path."));

        r11.addNeighbor("west", r10);
        r11.addNeighbor("north", r12);
        r11.addNeighbor("east", r13);
        r11.setMonster(new Monster("Pusblight Crawler", 50, 5, 5,  40,
                "A hyperfast spider shrouded in putrid pus, her body oozing with decay as she nears her demise."));

        r12.addNeighbor("south", r11);
        r12.setSlotMachine(new SlotMachine());
        r12.addShopItems(new Treasure("Health Potion", "\uD83E\uDDEA", "Use to heal yourself. **gulp**", 1), 30);
        r12.addShopItems(new Treasure("Health Potion", "\uD83E\uDDEA", "Use to heal yourself. **gulp**", 1), 30);
        r12.addShopItems(new Treasure("Greater Health Potion", "⚗️", "Use to fill the depths of your empty soul **GULP**", 5), 70);
        r12.addShopItems(new Treasure("Scroll of Piercing Precision", "\uD83D\uDCDC", "Use to unleash a guaranteed critical strike.", 4), 70);
        r12.addShopItems(new Treasure("Scroll of Piercing Precision", "\uD83D\uDCDC", "Use to unleash a guaranteed critical strike.", 4), 70);
        r12.addShopItems(new Weapon("The Ebon Edge", 0.15, 40,
                "A sleek, black blade with a deadly edge, renowned for its swift strikes and unmatched reliability in battle.", 103), 125);

        r13.addNeighbor("west", r11);
        r13.addNeighbor("north", r14);
        r13.setMonster(new Monster("Brog", 40, 100, 100, 20,
                "Sibling to the hapless hobgoblin Grog, this creature bears the burden of loss, its bloodshot eyes reflecting the weight of past sorrows."));

        r14.addNeighbor("south", r13);
        r14.addNeighbor("east", r16);
        r14.addNeighbor("north", r15);
        r14.setMonster(new Monster("Dreadstone Sentinel", 35,300, 300, 3,
                "Forged from ancient obsidian and bound by the dark arts of the Archlich, it stands as a formidable guardian,\n" +
                        "its eyes gleaming with malevolent energy as it obeys its master's bidding."));

        r15.addNeighbor("south", r14);
        r15.setFountain(new Fountain());

        r16.addNeighbor("west", r14);
        r16.setMonster(new Monster("Duskborne Archlich", 40, 270, 270, 22,
                "\nThe Duskborne Archlich, master of shadows and harbinger of twilight,\n" +
                        "stands as the ultimate adversary, his ethereal form wreathed in the fading light of dusk.\n" +
                        "With arcane powers unrivaled and a heart as dark as the night,\n" +
                        "he awaits challengers at the precipice of twilight's embrace.\n"));

        // The player starts in the entrance with their fists
        currentRoom = entrance;
        player.setCurrentWeapon(player.getArsenal().get(0));
        Utils.myPrintln("\nExtend the terminal to cover the entire screen for the best experience!\nGOOD LUCK!\n");
        Utils.myPrintln("\n\nYour starting Stats:");
        player.displayStats();
        Utils.myPrintln("You start with a Magical Dice in your inventory: [> show inv] to see what it does.");
    }

    /** Runs the game. */
    public void run() {
        help();
        Utils.myPrintln();
        while (true) {
            Utils.myPrintln("You are in " + currentRoom.getName() + ".");
            Utils.myPrint("> ");
            handleCommand(StdIn.readLine());
            Utils.myPrintln();
            if (currentRoom.getMonster() == null && currentRoom.getName().equals("Chamber of the Duskborne Archlich")) {
                    Utils.printWinMessage();
                    System.exit(0);
            }
        }
    }

    /** Prints examples of possible commands as a hint to the player. */
    public void help() {
        Utils.printHelpCommands();
    }

    /** Handles a command read from standard input and returns true if it's a combat command. */
    public boolean handleCommand(String line) {
        String[] words = line.split(" ");
        String command = words[0].toLowerCase();
        if (command.isEmpty()) {
            Utils.myPrintln("Enter a command!");
            return false;
        }
        if (!commandList.contains(command)) {
            Utils.myPrintln("Not a valid command!");
            return false;
        }

        // Concatenate multiple words into a single string
        StringBuilder object = new StringBuilder();
        for (int i = 1; i < words.length; i++) {
            object.append(words[i]);
            if (i < words.length - 1) {
                object.append(" ");
            }
        }
        String choice = object.toString();

        if (currentRoom.getMonster() != null &&
                !(command.equalsIgnoreCase("attack")
                        || command.equalsIgnoreCase("look")
                        || command.equalsIgnoreCase("help")
                        || command.equalsIgnoreCase("equip")
                        || command.equalsIgnoreCase("show")
                        || command.equalsIgnoreCase("use")
                        || command.equalsIgnoreCase("strike"))) {
            Utils.myPrintln("You can't do that with " + currentRoom.getMonster().getName() + " here.");
            return false;
        } else if (command.trim().equals("attack")) {
            if (inCombat) {
                Utils.myPrintln("You are already engaged in combat.\n");
                return false;
            }
            attack(choice);
        } else if (command.trim().equals("help")) {
            help();
            return false;
        } else if (command.trim().equals("go")) {
            go(choice);
        } else if (command.trim().equals("look")) {
            look();
            return false;
        } else if (command.trim().equals("equip")) {
            equip();
            return false;
        } else if (command.trim().equals("take")) {
            take(choice);
        } else if (command.trim().equals("open")) {
            open(choice);
        } else if (command.trim().equals("show")) {
            show(choice);
            return false;
        } else if (command.trim().equals("use")) {
            use();
            return false;
        } else if (command.trim().equals("buy")) {
            buy();
        } else if (command.trim().equals("spin")) {
            spin();
        } else if (command.trim().equals("strike")) {
            if (!inCombat) {
                Utils.myPrintln("You can only strike enemies while in combat!");
            }
            else {
                return true;
            }
        } else if (command.trim().equals("break")) {
            breakPots(choice);
        } else {
            Utils.myPrintln("Invalid command entered.");
            return false;
        }
        return true;
    }

    /**
     * Engages the monster and enters combat if name is valid
     */
    public void attack(String name) {
        Monster monster = currentRoom.getMonster();
        if (monster != null && (name.isEmpty() || monster.getName().equalsIgnoreCase(name))) {
            switch (monster.getName()) {
                case "Grog","Zephyr", "Ka-boom", "Grusk", "Grom", "Pusblight Crawler", "Brog", "Dreadstone Sentinel", "Duskborne Archlich" -> combat();
            }
        } else {
            Utils.myPrintln("You cannot attack" + name + " or there is no " + name + " here.");
        }
    }

    /** Moves in the specified direction, if possible. */
    public void go(String direction) {
        Room destination = currentRoom.getNeighbor(direction);
        if (destination == null) {
            Utils.myPrintln("You can't go that way from here.");
        } else {
            currentRoom = destination;
            look();
            if (currentRoom instanceof Shop) {
                shopEncounter();
            }
        }
    }

    /** Prints a description of the current room and its contents. */
    public void look() {
        renderPlayerHP();
        Utils.myPrintln(currentRoom.getDescription()
                + "\n---------------");
        if (currentRoom.getMonster() != null) {
            Utils.myPrintln(currentRoom.getMonster().getName() + " appears!\n"
                    + currentRoom.getMonster().getDescription()
                    + "\n---------------");
            renderMonsterHPAndAttackAndAgility();

        }
        if (currentRoom.getWeapon() != null) {
            Utils.myPrintln("There is a "
                    + currentRoom.getWeapon().getName() + " here. "
                    + currentRoom.getWeapon().getDescription()
                    + "\n---------------");
        }
        if (currentRoom.getChest() != null) {
            Utils.myPrintln("There is a CHEST here!"
                    + "\n---------------");
        }
        if (currentRoom.getArmorPiece() != null) {
            Utils.myPrintln(currentRoom.getArmorPiece().getName() + " here. "
                    + currentRoom.getArmorPiece().getDescription()
                    + "\n---------------");
        }
        if (currentRoom.getTreasure() != null) {
            Utils.myPrintln(currentRoom.getTreasure().getNameWithEmoji() + " here. "
                    + currentRoom.getTreasure().getDescription()
                    + "\n---------------");
        }
        if (currentRoom.getFountain() != null) {
            Utils.myPrintln(currentRoom.getFountain().getDescription()
                    + "\n---------------");
        }
        if (currentRoom.getPotSize() != 0) {
            if (currentRoom.getPotSize() > 1) {
                Utils.myPrintln("There are "
                        + currentRoom.getPotSize() + "\uD83C\uDFFA here."
                        + "\n---------------");
            }
            else {
                Utils.myPrintln("There is a \uD83C\uDFFA here."
                        + "\n---------------");
            }
        }
        if (currentRoom.getSlotMachine() != null) {
            Utils.myPrintln("Look! A \uD83C\uDFB0slot machine\uD83C\uDFB0. Spin the wheel!!!");
        }
        Utils.myPrintln("Exits: " + currentRoom.listExits());
    }

    /** Attempts to open a chest. */
    public void open(String container) {
        Chest chest = currentRoom.getChest();
        if (chest != null && container.equalsIgnoreCase("chest")) {
            currentRoom.playerOpensChest();
            currentRoom.setChest(null);
        }
        else {
            Utils.myPrintln("You cannot open a " + container + " or there is no chest here.");
        }
    }

    /** Attempts to pick up the specified treasure or weapon. */
    public void take(String name) {
        Treasure treasure = currentRoom.getTreasure();
        Weapon weapon = currentRoom.getWeapon();
        Armor armor = currentRoom.getArmorPiece();
        if (treasure != null && treasure.getName().equalsIgnoreCase(name)) {
            Utils.myPrintln("You acquired " + treasure.getNameWithEmoji() + "!");
            player.addItem(treasure);
            currentRoom.setTreasure(null);
            return;
        }
        if (weapon != null && weapon.getName().equalsIgnoreCase(name)) {
            Utils.myPrintln("You acquired " + weapon.getName() + "!");
            if (weapon.getName().equals("hilt")) {
                Utils.myPrintln("I might want to equip that...");
            }
            player.addItem(weapon);
            currentRoom.setWeapon(null);
            return;
        }
        if (armor != null && armor.getName().equalsIgnoreCase(name)) {
            Utils.myPrintln("You acquired " + armor.getName() + "!");
            Utils.myPrintln("Def\uD83D\uDEE1 +" + (int)armor.getDefValue());
            player.addItem(armor, armor.getDefValue());
            currentRoom.setArmor(null);
            return;
        }
        Utils.myPrintln("You cannot take a " + name + " or it does not exist here.");
    }

    /** Equip weapon if player possesses it. */
    public void equip() {
        Utils.myPrintln("\nChoose weapon to equip?");
        player.displayWeapons();
        Utils.myPrint("> ");
        String choice = StdIn.readLine();
        for (int i = 0; i < player.getArsenal().size(); i++) {
            // If weapon is in inv
            if (choice.equalsIgnoreCase(player.getArsenal().get(i).getName())) {
                player.setCurrentWeapon(player.getArsenal().get(i));
                Utils.myPrintln("You equipped " + choice + "!");
                Utils.myPrintln("Atk⚔️ " + (int)player.getCurrentWeapon().getDamage());
                return;
            }
        }
        Utils.myPrintln("You do not possess " + choice + ".");
    }

    /** Show Shop if in one, inventory, or stats of the player */
    public void show(String choice) {
        if (choice.equalsIgnoreCase("Shop")) {
            if (currentRoom instanceof Shop) {
                ((Shop) currentRoom).displayShopInventory();
            }
            else {
                Utils.myPrintln("You need to be in a shop to look at shop items.");
            }
        } else if (choice.equalsIgnoreCase("Inv")) {
            player.displayInventory();
        } else if (choice.equalsIgnoreCase("stats")) {
            player.displayStats();
        } else {
            Utils.myPrintln(choice + " cannot be shown.");
        }
    }

    /** Use items or fountain and return identifying int values */
    public int use() {
        if (currentRoom.getFountain() != null) {
            boolean playerUsedFountain = player.useFountainChoice();
            if (playerUsedFountain) {
                currentRoom.setFountain(null);
                Utils.printFountainText();
                currentRoom = currentRoom.getNeighbor("south");
                currentRoom.removeNeighbor("north");
                return -1;
            }
        }

        if (player.getItemCount() == 0) {
            Utils.myPrintln("You have no usable items.");
            return -1;
        }

        player.displayItems();

        Utils.myPrint("\n> ");
        String itemName = StdIn.readLine();
        for (Treasure item : player.getItems()) {
            // Item exits in inv
            if (item.getName().equalsIgnoreCase(itemName) || itemName.equalsIgnoreCase("md")) {
                // If the items are of type "use <item>"

                if (item.getID() == 0){
                    if (!inCombat) {
                        Utils.myPrintln(item.getNameWithEmoji() + " can only be rolled in combat!");
                        return -1;
                    }
                    else {
                        return item.getID();
                    }
                } else if (item.getID() == 1) {
                    // health potion
                    Utils.printHealthPotText();
                    player.heals(15);
                    renderPlayerHP();
                    player.removeItemFromInventory(1);
                    return item.getID();
                } else if (item.getID() == 2) {
                    // scroll of swifter feet
                    Utils.printSoffText();
                    player.addAgt(15);
                    renderPlayerHPAndAgility();
                    player.removeItemFromInventory(2);
                    return item.getID();
                } else if (item.getID() == 4) {
                    if (inCombat) {
                        // Scroll of piercing precision
                        Utils.printSoppText();
                        player.removeItemFromInventory(4);
                        return item.getID();
                    }
                    else {
                        Utils.myPrintln(item.getNameWithEmoji() + " can only be used in combat!");
                        return -1;
                    }
                } else if (item.getID() == 5) {
                    // Greater health potion
                    Utils.printGreaterHealthPotText();
                    player.heals(35);
                    renderPlayerHP();
                    player.removeItemFromInventory(5);
                    return item.getID();
                } else if (item.getID() == 6) {
                    int luckIncrement = 15 + (StdRandom.uniformDouble() < 0.3 ? StdRandom.uniformInt(11, 26) : StdRandom.uniformInt(5, 11));
                    Utils.myPrintln("\033[0;35m");
                    Utils.myPrintln("-------------------------------------");
                    Utils.myPrintln("|     You receive Gleam's blessing  |");
                    Utils.myPrintln("|                                   |");
                    Utils.myPrintln("|            Lck +" + luckIncrement + "               |");
                    Utils.myPrintln("-------------------------------------\n");
                    Utils.myPrintln("\033[0m");
                    player.addLuck(luckIncrement);
                    player.removeItemFromInventory(6);
                    return item.getID();
                    // If the item is of type "use <item> on <item>"
                } else {
                    if (item.getID() == 3) {
                        Utils.myPrintln("Use the " + item.getNameWithEmoji() + " on which weapon?: ");
                        player.displayWeapons();
                        Utils.myPrint("\n> ");
                        String weaponName = StdIn.readLine();
                        for (int i = 0; i < player.getArsenal().size(); i++) {
                            // Player has the weapon
                            if (weaponName.equalsIgnoreCase(player.getArsenal().get(i).getName())) {
                                Utils.myPrintln("\033[0;33m");
                                Utils.myPrintln("-------------------------------------");
                                Utils.myPrintln("|   You used the Stone of Serrated  |");
                                Utils.myPrintln("|              Edge!                |");
                                Utils.myPrintln("|                                   |");
                                Utils.myPrintln("|          " + weaponName + " damage +15        |");
                                Utils.myPrintln("-------------------------------------\n");
                                Utils.myPrintln("\033[0m");
                                player.getArsenal().get(i).addDamage(15);
                                player.setCurrentWeapon(player.getArsenal().get(i));
                                player.removeItemFromInventory(3);
                                renderPlayerAttack();
                                return item.getID();
                            }
                        }
                        Utils.myPrintln("You do not possess " + weaponName + ".");
                        return -1;
                    }
                }
            }
        }
        Utils.myPrintln("You cannot use a " + itemName + " or you do not possess such an item.");
        return -1;
    }

    /** When players uses break command to break pots */
    public void breakPots(String name) {
        ArrayList<Pot> pots = currentRoom.getPots();
        if (!pots.isEmpty() && (name.equalsIgnoreCase("pot") || name.equalsIgnoreCase("pots"))) {
            pots.get(0).breakPot();
            pots.remove(0);
            if (pots.size() > 1) {
                Utils.myPrintln(pots.size() + " more \uD83C\uDFFA left.");
            }
            else if (pots.size() == 1) {
                Utils.myPrintln("1\uD83C\uDFFA left.");
            }
        }
        else {
            Utils.myPrintln("You cannot break a " + name + " or it does not exist here.");
        }
    }

    /** To buy from the shop */
    public void buy() {
        // Check if the current room is a shop
        if (!(currentRoom instanceof Shop)) {
            Utils.myPrintln("You need to be in a shop to buy items.");
            return;
        }

        if (((Shop) currentRoom).getShopItems().isEmpty() && ((Shop) currentRoom).getShopWeapons().isEmpty()) {
            Utils.myPrintln("Arrr, ye've cleaned me out, matey! Not a single item left in me shop.\n");
            return;
        }
        // Display shop inventory
        ((Shop) currentRoom).displayShopInventory();
        Utils.myPrintln("\nAye, ye wish to buy, eh? Pick one!\n");
        Utils.myPrint("> ");
        String choice = StdIn.readLine();

        // Iterate through the shop items
        for (int i = 0; i < ((Shop) currentRoom).getShopItems().size(); i++) {
            // If the item exists in the shop
            if (((Shop) currentRoom).getShopItems().get(i).getName().equalsIgnoreCase(choice)) {
                // Get the item and its price
                Treasure selectedItem = ((Shop) currentRoom).getShopItems().get(i);
                int itemPrice = ((Shop) currentRoom).getItemPrices().get(i);

                // Check if the player has enough gold to buy the item
                if (player.getGold() >= itemPrice) {
                    // Remove the item from the shop's inventory
                    ((Shop) currentRoom).getShopItems().remove(i);
                    ((Shop) currentRoom).getItemPrices().remove(i);

                    Utils.myPrintln("You bought a " + selectedItem.getNameWithEmoji() + ".");
                    // Subtract the item price from the player's gold
                    player.addGold(-itemPrice);

                    // Add the item to the player's inventory
                    player.addItem(selectedItem);
                    return;
                } else {
                    Utils.myPrintln("Not enough gold to buy " + selectedItem.getName() + ".");
                    return;
                }
            }
        }
        for (int j = 0; j < ((Shop) currentRoom).getShopWeapons().size(); j++) {
            // If the item exists in the shop
            if (((Shop) currentRoom).getShopWeapons().get(j).getName().equalsIgnoreCase(choice)) {
                // Get the item and its price
                Weapon selectedWeapon = ((Shop) currentRoom).getShopWeapons().get(j);
                int weaponPrice = ((Shop) currentRoom).getWeaponPrices().get(j);

                // Check if the player has enough gold to buy the item
                if (player.getGold() >= weaponPrice) {
                    // Remove the item from the shop's inventory
                    ((Shop) currentRoom).getShopWeapons().remove(j);
                    ((Shop) currentRoom).getWeaponPrices().remove(j);

                    Utils.myPrintln("You bought a " + selectedWeapon.getName() + ".");
                    // Subtract the item price from the player's gold
                    player.addGold(-weaponPrice);

                    // Add the item to the player's inventory
                    player.addItem(selectedWeapon);
                    return;
                } else {
                    Utils.myPrintln("Not enough gold to buy " + selectedWeapon.getName() + ".");
                    return;
                }
            }
        }

        // If the item was not found in the shop's inventory
        Utils.myPrintln("Arrr, me apologies, matey, but it seems I don't have " + choice + " in stock at the moment.\n");
    }

    /** To spin a SlotMachine. */
    public void spin() {
        if (currentRoom.getSlotMachine() != null) {
            player.playSlotMachine();
            return;
        }
        Utils.myPrintln("There is no slot machine here to spin the wheel.");
    }

    /** When player enters shop */
    public void shopEncounter() {
        Utils.printShopEncounterMessage();
        if (player.hasHilt()) {
            String dialogue = "Hey there, matey!\n" +
                    "I couldn't help but notice that exquisite hilt you've got there. Looks like it's seen some adventures, eh?\n" +
                    "Say, I'm a bit of a collector of unique artifacts, and that hilt of yours has caught me eye.\n" +
                    "How about we make a deal? I'd be willing to offer you a handsome sum for it.\n" +
                    "Y'can spin that slot machine o'er there a buncha times with this much, don'tcha think?\n" +
                    "What say ye?";
            String[] lines = dialogue.split("\n");
            Utils.myPrintln("Merchant\uD83C\uDFA9: ");
            for (String line : lines) {
                Utils.myPrintln("\t" + line);
            }
            boolean playerDoesNotChooseValidOption = true;
            while (playerDoesNotChooseValidOption) {
                Utils.myPrintln("----------------------------------------------------------");
                Utils.myPrintln("The merchant is offering you 100\uD83E\uDE99 for the hilt!");
                Utils.myPrintln("----------------------------------------------------------\n");
                Utils.myPrintln("Take it?[yes/no]");
                Utils.myPrint("> ");
                String choice = StdIn.readLine();
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("yes")) {
                    if (player.getCurrentWeapon().getID() == 101) {
                        Utils.myPrintln("\nYou need to equip something else to sell the hilt!");
                        return;
                    }
                    Utils.myPrintln("\nYou traded your hilt for 100\uD83E\uDE99!");
                    player.addGold(100);
                    player.removeWeaponFromInventory(101);
                    ((Shop) currentRoom).getShopWeapons().add(new Weapon("The Twilight's Glimmer", 0.8, 50, "a sword shrouded in mystery, its darkened blade adorned with ancient runes.\n" +
                            "Legend whispers of its true nature hidden within an unassuming hilt, waiting for the hands of fate to unlock its potential.\n" +
                            "When wielded, it emits a faint, ethereal glow, rumored to harness the powers of twilight itself, granting its bearer unmatched precision and grace in battle.", 999));
                    ((Shop) currentRoom).getWeaponPrices().add(999);
                    playerDoesNotChooseValidOption = false;
                } else if (choice.equalsIgnoreCase("n") || choice.equalsIgnoreCase("no")) {
                    Utils.myPrintln("Arrr, really? I thought for sure ye'd be interested in me offer. Well,...\n");
                    playerDoesNotChooseValidOption = false;
                } else {
                    Utils.myPrintln("Uhh... what was that?");
                }
            }
        }

        // No hilt interaction start here
        Utils.myPrintln("Why don't ye take a gander around me humble shop?\n"
                + "Ye might find somethin' else that tickles yer fancy.\n");

        Utils.myPrintln("[> show shop] to shop for items");
    }

    /** Player enters turn-based combat */
    public void combat() {
        inCombat = true;
        boolean gromEncounter = false;
        boolean spiderEncounter = false;
        boolean bossEncounter = false;
        int bossTurnCounter = -1;

        // Grom in room
        if (currentRoom.getMonster().getName().equals("Grom")) {
            gromEncounter = true;
            Utils.myPrintln("\nTip: Grom's swings are lethal but he is very slow. You will ~~likely~~ dodge his attacks!");
        }

        // spider in room
        if (currentRoom.getMonster().getName().equals("Pusblight Crawler")) {
            spiderEncounter = true;
        }

        Monster currentRoomMonster = currentRoom.getMonster();
        boolean playerTakesTheLead;

        // boss fight
        if (currentRoomMonster.getName().equals("Duskborne Archlich")) {
            bossEncounter = true;
            Utils.printBossImage();
            Utils.myPrintln("\nYOU HAVE ENGAGED IN COMBAT WITH " + currentRoomMonster.getName().toUpperCase() + ", THERE IS TRULY NO GOING BACK!\n");
            Utils.myPrintln("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-\n");
            if (player.hasHilt()) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                Utils.printHiltIntoTTGMessage();
                player.addItem(new Weapon("The Twilight's Glimmer", 0.6, 50, "a sword shrouded in mystery, its darkened blade adorned with ancient runes.\n" +
                        "Legend whispers of its true nature hidden within an unassuming hilt, waiting for the hands of fate to unlock its potential.\n" +
                        "When wielded, it emits a faint, ethereal glow, rumored to harness the powers of twilight itself, granting its bearer unmatched precision and grace in battle.", 999));
                player.setCurrentWeapon(player.getArsenal().get(player.getArsenal().size() - 1));
                player.removeWeaponFromInventory(101);
                }

        }
        else {
            Utils.myPrintln("\nYou have engaged in combat with " + currentRoomMonster.getName() + ", there's no going back!\n");
        }
        // player has higher agility
        if (player.getAgility() > currentRoom.getMonster().getAgility()) {
            Utils.myPrintln("You are faster, you move first!\n");
            playerTakesTheLead = true;
        }
        // monster has higher agility
        else {
            Utils.myPrintln("\nYou are slower, " + currentRoomMonster.getName() + " moves first!\n");
            playerTakesTheLead = false;
        }

        // turn starts/continues until either the player or the monster dies
        while (true) {
            // boss fight combat
            if (bossEncounter) {
                bossTurnCounter += 1;
                if (player.isDead() || bossTurnCounter == 6) {
                    Utils.myPrintln("\nYOU DIED FROM THE LICH'S CURSE. YOUR SOUL CEASES TO EXIST!");
                    player.takesDamage(player.getDef() + player.getCurrentHP());
                    renderPlayerHP();
                    Utils.myPrintln("☠".repeat(23));
                    Utils.myPrintln("☠" + " " + "YOU HAVE PERISHED! GAME OVER..." + " " + "☠");
                    Utils.myPrintln("☠".repeat(23));
                    Utils.myPrintlnAtGameOver();
                    System.exit(0);
                }
                Utils.myPrintln("\nNOTE: YOU ARE INFLICTED WITH THE ARCHLICH'S CURSE!");
                Utils.myPrintln("CURSE DESCRIPTION: ");
                Utils.myPrintln("YOU ONLY HAVE " + (6 - bossTurnCounter) + " TURNS TO DEFEAT HIM BEFORE YOU PERISH!");
                Utils.myPrintln("YOU SOUL WILL DIMINISH PER TURN! YOU WILL START LOSING HEALTH!");
                if (bossTurnCounter > 0) {
                    player.takesDamage(player.getDef() + 7);
                    renderPlayerHP();
                }
            }

            // proxy player weapon
            double currentPlayerAttack;

            // player is faster scenario
            if (playerTakesTheLead) {
                // check for valid combat command
                while (true) {
                    currentPlayerAttack = player.getCurrentWeapon().getDamage();
                    Utils.myPrintln("What will you do? [> strike] to attack");
                    Utils.myPrint("> ");
                    String choice = StdIn.readLine();
                        // player uses a combat item mid-battle
                    if (choice.trim().equalsIgnoreCase("use")) {
                        int usedItemID = use();
                        if (usedItemID == 0) {
                            // roll magical dice
                            currentPlayerAttack += player.damageAfterMagicalDiceBuff();
                            break;

                        } else if (usedItemID == 4) {
                            // scroll of piercing precision
                            currentPlayerAttack += player.useScrollOfPiercingPrecision();
                            break;
                        } else if (usedItemID == -1) {
                            continue;
                        }
                    }
                    else { // combat unrelated commands
                        if (handleCommand(choice)) {
                            break;
                        }
                    }
                }

                // Apply crit value if player crits
                currentPlayerAttack += player.getDamageAfterCritChance();
                // player attacks
                currentRoomMonster.takesDamage(currentPlayerAttack);
                Utils.myPrintln(currentRoomMonster.getName() + " took " + Math.round(currentPlayerAttack) + " damage!");
                renderMonsterHPAndAttackAndAgility();
                // check monster is dead
                if (currentRoomMonster.isDead()) {
                    Utils.myPrintln(currentRoomMonster.getName() + " has fallen!");
                    // Grom drops a chestplate when he dies
                    if (currentRoomMonster.getName().equals("Grom")) {
                        r10.setArmor(new Armor("Black Iron Chestplate",
                                        "covered in mud, but looks as sturdy as a troll",
                                        20));
                        Utils.myPrintln("The heavy chestplate on Grom's chest shrinks as it falls on the ground.");
                    }

                    currentRoom.setMonster(null);
                    inCombat = false;
                    return;
                }
                // monster survives
                else {
                    // monster attack lands and entering Grom's room gives bonus dodge chance
                    if (!player.dodges(gromEncounter) ) {
                        player.takesDamage(currentRoomMonster.getDamage());
                        Utils.myPrintln(currentRoomMonster.getName() + " attacked! You took " + (int) (currentRoomMonster.getDamage() - player.getDef()) + " damage!");
                        renderPlayerHP();
                    }
                    // player dodges!
                    else {
                        Utils.myPrintln("You dodged that attack. Lucky!");
                        // debuff related death
                        if (bossEncounter && player.isDead()) {
                            Utils.myPrintln("YOU DIED FROM THE LICH'S CURSE. YOUR SOUL CEASES TO EXIST!");
                            Utils.printDeathMessageAndQuit();
                        }

                    }
                    // check player is dead
                    if (player.isDead()) {
                        Utils.printDeathMessageAndQuit();
                    }
                }
            }
            // player is slower scenario
            else {
                // Grog dying is a canon event
                if (currentRoomMonster.getName().equals("Grog")) {
                    grogDies();
                    inCombat = false;
                    return;
                }
                // spider encounter
                if (spiderEncounter) {
                    Utils.myPrintln("\nTHE SPIDER CHARGES AT YOU AT HYPERSPEED. YOU DID NOT REACT IN TIME!");
                    Utils.myPrintln(currentRoomMonster.getName() + " DIED A EXPLODING MESS OF PUS! YOU HAVE BEEN BURNT BY ACID!");
                    player.takesDamage(currentRoomMonster.getDamage());
                    renderPlayerHP();
                    currentRoom.setMonster(null);
                    inCombat = false;
                    return;
                }
                // monster attack lands
                if (!player.dodges(gromEncounter)) {
                    player.takesDamage(currentRoomMonster.getDamage());
                    Utils.myPrintln(currentRoomMonster.getName() + " attacked! You took " + (int) (currentRoomMonster.getDamage() - player.getDef()) + " damage!");
                    renderPlayerHP();
                } else { // player dodges
                    Utils.myPrintln("You dodged that attack. Lucky!");
                    // debuff related death
                    if (bossEncounter && player.isDead()) {
                        Utils.myPrintln("YOU DIED FROM THE LICH'S CURSE. YOUR SOUL CEASES TO EXIST!");
                        Utils.printDeathMessageAndQuit();
                    }
                }
                // check player is dead
                if (player.isDead()) {
                    Utils.printDeathMessageAndQuit();
                } else { // player survives attack
                    while (true) {
                        currentPlayerAttack = player.getCurrentWeapon().getDamage();
                        Utils.myPrintln("What will you do? [> strike] to attack");
                        Utils.myPrint("> ");
                        String choice = StdIn.readLine();
                        // player uses a combat item mid-battle
                        if (choice.trim().equalsIgnoreCase("use")) {
                            int usedItemID = use();
                            if (usedItemID == 0) {
                                // roll magical dice
                                currentPlayerAttack += player.damageAfterMagicalDiceBuff();
                                break;

                            } else if (usedItemID == 4) {
                                // scroll of piercing precision
                                currentPlayerAttack += player.useScrollOfPiercingPrecision();
                                break;
                            } else if (usedItemID == -1) {
                                continue;
                            }
                        }
                        else { // combat unrelated commands
                            if (handleCommand(choice)) {
                                break;
                            }
                        }
                    }
                    // Apply crit value if player crits
                    currentPlayerAttack += player.getDamageAfterCritChance();
                    // player attacks
                    currentRoomMonster.takesDamage(currentPlayerAttack);
                    Utils.myPrintln(currentRoomMonster.getName() + " took " + Math.round(currentPlayerAttack) + " damage!");
                    renderMonsterHPAndAttackAndAgility();
                    // check monster is dead
                    if (currentRoomMonster.isDead()) {
                        Utils.myPrintln(currentRoomMonster.getName() + " has fallen!");
                        currentRoom.setMonster(null);
                        inCombat = false;
                        return;
                    }
                }
            }
        }
    }
    public void renderPlayerHPAndAgility() {
        // Render player HP
        Utils.myPrintln("Player HP: " + Math.round(Math.max(0, player.getCurrentHP())) + " HP [" + "❤".repeat(playerCalculateHeartWidth()) + " ".repeat(10 - playerCalculateHeartWidth()) + "]");

        // Render player agility
        Utils.myPrintln("Agility: " + (int) player.getAgility() + "\uD83E\uDDB6");
    }

    public void renderMonsterHPAndAttackAndAgility() {
        // Check if there is a monster in the current room
        if (currentRoom.getMonster() == null) {
            return;
        }

        // Render monster HP
        Utils.myPrintln(currentRoom.getMonster().getName() + " HP: " + Math.round(Math.max(0, currentRoom.getMonster().getArmor())) + " HP [" + "█".repeat(monsterCalculateHeartWidth()) + " ".repeat(10 - monsterCalculateHeartWidth()) + "]");

        // Render monster attack
        Utils.myPrintln("Attack: " + (int) currentRoom.getMonster().getDamage() + "⚔️️");

        // Render monster agility
        Utils.myPrintln("Agility: " + (int) currentRoom.getMonster().getAgility() + "\uD83E\uDDB6\n");
    }

    public void renderPlayerHP() {
        // Render player HP
        Utils.myPrintln("\n---------------");
        Utils.myPrintln("Player HP: " + Math.round(Math.max(0, player.getCurrentHP())) + " HP [" + "❤".repeat(playerCalculateHeartWidth()) + " ".repeat(10 - playerCalculateHeartWidth()) + "]");
        Utils.myPrintln("---------------\n");
    }

    public void renderPlayerAttack() {
        // Render player attack
        Utils.myPrintln("Attack: " + (int) player.getCurrentWeapon().getDamage() + "⚔️️\n️");
    }

    public int playerCalculateHeartWidth() {
        // Calculate the width of the heart symbols representing player HP
        if (Math.max(0, player.getCurrentHP()) == 0) {
            return 0;
        }
        return ((int) ((10 - 1) * (Math.max(0, player.getCurrentHP()) / player.getMaxHP()))) + 1;
    }

    public int monsterCalculateHeartWidth() {
        // Calculate the width of the heart symbols representing monster HP
        if (Math.max(0, currentRoom.getMonster().getArmor()) == 0) {
            return 0;
        }
        return ((int) ((10 - 1) * (Math.max(0, currentRoom.getMonster().getArmor()) / currentRoom.getMonster().getMaxArmor())) + 1);
    }

    public void grogDies() {
        // Handle the case when Grog dies
        Utils.myPrintln("Grog slips and falls while charging at you. His dagger slices his throat and tumbles into the next room.");
        Utils.myPrintln("Grog dies a pathetic death...");
        currentRoom.getMonster().setArmor(0); // Set Grog's armor to 0
        renderMonsterHPAndAttackAndAgility(); // Render updated monster stats
        currentRoom.setMonster(null); // Remove Grog from the room
    }
}
