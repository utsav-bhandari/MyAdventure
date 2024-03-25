public class Utils {
    /**
     * Prints the given string with a decorative border.
     *
     * @param lines The string to be printed.
     */
    public static void myPrintln(String lines) {
        for (var line : lines.split("\n", -1)) {
            StringBuilder filler = new StringBuilder();
            while (filler.length() < 50) {
                filler.append(chooseRandomCharacter());
            }
            StdOut.println(filler + "╣ " + line);
        }
    }

    /**
     * Prints an empty line with a decorative border.
     */
    public static void myPrintln() {
        StringBuilder filler = new StringBuilder();
        while (filler.length() < 50) {
            filler.append(chooseRandomCharacter());
        }
        StdOut.println(filler + "╣ ");
    }

    /**
     * Prints the given string without a newline character.
     *
     * @param lines The string to be printed.
     */
    public static void myPrint(String lines) {
        String[] split = lines.split("\n", -1);
        for (int i = 0; i < split.length; i++) {
            var line = split[i];
            StringBuilder filler = new StringBuilder();
            while (filler.length() < 50) {
                filler.append(chooseRandomCharacter());
            }

            if (i < split.length - 1) {
                StdOut.println(filler + "╣ " + line);
            } else {
                StdOut.print(filler + "╣ " + line);
            }
        }
    }

    /**
     * Prints a decorative border to represent the end of the game.
     */
    public static void myPrintlnAtGameOver() {
        StringBuilder filler = new StringBuilder();
        while (filler.length() < 50) {
            filler.append(chooseRandomCharacter());
        }
        for (int i = 0; i < 5; i++) {
            StdOut.println(filler.toString().repeat(10));
        }

    }

    private static String chooseRandomCharacter() {
        String[] chars = {"⋯", "┆", "~", "╌", " ", "-"};
        return chars[StdRandom.uniformInt(chars.length)];
    }

    /**
     * Prints the image of the boss.
     */
    public static void printBossImage() {
        BossImage.print();
    }

    public static void printHelpCommands() {
        Utils.myPrintln("Examples of commands:");
        Utils.myPrintln("  help");
        Utils.myPrintln("  attack/attack Grog");
        Utils.myPrintln("  strike");
        Utils.myPrintln("  go north");
        Utils.myPrintln("  look");
        Utils.myPrintln("  take Scroll of flying");
        Utils.myPrintln("  equip");
        Utils.myPrintln("  break pot(\uD83C\uDFFA)");
        Utils.myPrintln("  show inv/stats/shop");
        Utils.myPrintln("  use");
        Utils.myPrintln("  open chest");
        Utils.myPrintln("  spin");
        Utils.myPrintln("  buy");
    }

    public static void printFountainText() {
        Utils.myPrintln("\nAs you close your eyes, a soothing sensation washes over you, and you drift into a peaceful dream...\n.....");
        Utils.myPrintln("Time seems to slow down, and you find yourself lost in a realm of tranquility.\n....");
        Utils.myPrintln("Moments pass like gentle whispers in the wind...\n...");
        Utils.myPrintln("Eventually, you awaken, finding yourself back in the room you were in before.\n..");
        Utils.myPrintln("Where the entrance to the fountain once stood, there's now only a solid stone wall, leaving you wondering if it was all just a dream.\n.");
        Utils.myPrintln("MaxHp +20!!!!");
    }

    public static void printHealthPotText() {
        Utils.myPrintln("\n\033[0;32m-------------------------------------");
        Utils.myPrintln("|        You drank a Health        |");
        Utils.myPrintln("|            Potion!               |");
        Utils.myPrintln("|                                  |");
        Utils.myPrintln("|             HP +15               |");
        Utils.myPrintln("-------------------------------------\033[0m\n");
    }

    public static void printSoffText() {
        Utils.myPrintln("\033[0;37m");
        Utils.myPrintln("-------------------------------------");
        Utils.myPrintln("|      You used the Scroll of      |");
        Utils.myPrintln("|           Swifter Feet!          |");
        Utils.myPrintln("|                                  |");
        Utils.myPrintln("|           Agility +15            |");
        Utils.myPrintln("-------------------------------------\n");
        Utils.myPrintln("\033[0m");
        Utils.myPrintln("You feel lighter on your feet...");
    }

    public static void printSoppText() {
        Utils.myPrintln("\033[0;31m");
        Utils.myPrintln("-------------------------------------");
        Utils.myPrintln("|   You used the Scroll of Piercing |");
        Utils.myPrintln("|             Precision!            |");
        Utils.myPrintln("|                                   |");
        Utils.myPrintln("|         Next hit is CRITICAL!     |");
        Utils.myPrintln("-------------------------------------\n");
        Utils.myPrintln("\033[0m");
    }

    public static void printGreaterHealthPotText() {
        Utils.myPrintln("\033[0;34m");
        Utils.myPrintln("-------------------------------------");
        Utils.myPrintln("|    You consumed a Greater Health |");
        Utils.myPrintln("|             Potion!              |");
        Utils.myPrintln("|                                  |");
        Utils.myPrintln("|               HP +35             |");
        Utils.myPrintln("-------------------------------------\n");
        Utils.myPrintln("\033[0m");
    }

    public static void printShopEncounterMessage() {
        Utils.myPrintln("╭──────────────────────────────────────────────────────╮");
        Utils.myPrintln("│                                                      │");
        Utils.myPrintln("│          Welcome to the Arcane Bazaar!               │");
        Utils.myPrintln("│                                                      │");
        Utils.myPrintln("│   Step into a realm of enchantment and mystery       │");
        Utils.myPrintln("│   where wonders await your discovery. Enjoy your     │");
        Utils.myPrintln("│   shopping adventure and don't forget to try         │");
        Utils.myPrintln("│   out our brand new ***SLOT MACHINE***               │");
        Utils.myPrintln("│                                                      │");
        Utils.myPrintln("╰──────────────────────────────────────────────────────╯");
    }

    public static void printHiltIntoTTGMessage() {
        Utils.myPrintln("As you face the boss, a sudden realization dawns upon you.");
        Utils.myPrintln("You gaze upon the hilt you once thought to be unassuming,");
        Utils.myPrintln("now pulsating with an otherworldly energy.");
        Utils.myPrintln("The words of legends echo in your mind as you grasp the hilt tightly,");
        Utils.myPrintln("feeling the dormant power awakening within.");
        Utils.myPrintln("");
        Utils.myPrintln("\"The Twilight's Glimmer,\" you whisper in awe,");
        Utils.myPrintln("as the darkness around you seems to part,");
        Utils.myPrintln("revealing the true nature of your once humble weapon.");
        Utils.myPrintln("Its darkened blade, adorned with ancient runes,");
        Utils.myPrintln("now radiates with an ethereal glow,");
        Utils.myPrintln("harnessing the powers of twilight itself.");
        Utils.myPrintln("");
        Utils.myPrintln("With newfound understanding, you wield the sword,");
        Utils.myPrintln("feeling the surge of unmatched precision and grace");
        Utils.myPrintln("bestowed upon you by the legendary weapon.");
        Utils.myPrintln("It is not merely a hilt but a key to unlocking your destiny,");
        Utils.myPrintln("guiding you towards victory in the looming battle against the boss.");
    }

    public static void printDeathMessageAndQuit() {
        Utils.myPrintln("☠".repeat(23));
        Utils.myPrintln("☠" + " " + "YOU HAVE PERISHED! GAME OVER..." + " " + "☠");
        Utils.myPrintln("☠".repeat(23));
        Utils.myPrintlnAtGameOver();
        System.exit(0);
    }

    /**
     * Prints a win message.
     */
    public static void printWinMessage() {
        Utils.myPrintln("\n             ██╗   ██╗ ██████╗ ██╗   ██╗██╗   ██╗███████╗                                                   ");
        Utils.myPrintln("               ╚██╗ ██╔╝██╔═══██╗██║   ██║██║   ██║██╔════╝                                                   ");
        Utils.myPrintln("                ╚████╔╝ ██║   ██║██║   ██║██║   ██║█████╗                                                     ");
        Utils.myPrintln("                 ╚██╔╝  ██║   ██║██║   ██║╚██╗ ██╔╝██╔══╝                                                     ");
        Utils.myPrintln("                  ██║   ╚██████╔╝╚██████╔╝ ╚████╔╝ ███████╗                                                   ");
        Utils.myPrintln("                  ╚═╝    ╚═════╝  ╚═════╝   ╚═══╝  ╚══════╝                                                   ");
        Utils.myPrintln("          ███████╗██╗   ██╗██████╗ ██╗   ██╗██╗██╗   ██╗███████╗██████╗                                  ");
        Utils.myPrintln("          ██╔════╝██║   ██║██╔══██╗██║   ██║██║██║   ██║██╔════╝██╔══██╗                                 ");
        Utils.myPrintln("          ███████╗██║   ██║██████╔╝██║   ██║██║██║   ██║█████╗  ██║  ██║                                 ");
        Utils.myPrintln("          ╚════██║██║   ██║██╔══██╗╚██╗ ██╔╝██║╚██╗ ██╔╝██╔══╝  ██║  ██║                                 ");
        Utils.myPrintln("          ███████║╚██████╔╝██║  ██║ ╚████╔╝ ██║ ╚████╔╝ ███████╗██████╔╝                                 ");
        Utils.myPrintln("          ╚══════╝ ╚═════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═══╝  ╚══════╝╚═════╝                                  ");
        Utils.myPrintln("                         ████████╗██╗  ██╗███████╗                                                                     ");
        Utils.myPrintln("                         ╚══██╔══╝██║  ██║██╔════╝                                                                     ");
        Utils.myPrintln("                            ██║   ███████║█████╗                                                                       ");
        Utils.myPrintln("                            ██║   ██╔══██║██╔══╝                                                                       ");
        Utils.myPrintln("                            ██║   ██║  ██║███████╗                                                                     ");
        Utils.myPrintln("                            ╚═╝   ╚═╝  ╚═╝╚══════╝                                                                     ");
        Utils.myPrintln("          ██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗██╗ ██████╗ ███╗   ██╗                            ");
        Utils.myPrintln("          ██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██║██╔═══██╗████╗  ██║                            ");
        Utils.myPrintln("          ██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║██║   ██║██╔██╗ ██║                            ");
        Utils.myPrintln("          ██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║██║   ██║██║╚██╗██║                            ");
        Utils.myPrintln("          ██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗██║╚██████╔╝██║ ╚████║██╗                         ");
        Utils.myPrintln("          ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝                         ");
    }
}

