public class Util {
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

    /**
     * Prints a win message.
     */
    public static void printWinMessage() {
        Util.myPrintln("\n             ██╗   ██╗ ██████╗ ██╗   ██╗██╗   ██╗███████╗                                                   ");
        Util.myPrintln("               ╚██╗ ██╔╝██╔═══██╗██║   ██║██║   ██║██╔════╝                                                   ");
        Util.myPrintln("                ╚████╔╝ ██║   ██║██║   ██║██║   ██║█████╗                                                     ");
        Util.myPrintln("                 ╚██╔╝  ██║   ██║██║   ██║╚██╗ ██╔╝██╔══╝                                                     ");
        Util.myPrintln("                  ██║   ╚██████╔╝╚██████╔╝ ╚████╔╝ ███████╗                                                   ");
        Util.myPrintln("                  ╚═╝    ╚═════╝  ╚═════╝   ╚═══╝  ╚══════╝                                                   ");
        Util.myPrintln("          ███████╗██╗   ██╗██████╗ ██╗   ██╗██╗██╗   ██╗███████╗██████╗                                  ");
        Util.myPrintln("          ██╔════╝██║   ██║██╔══██╗██║   ██║██║██║   ██║██╔════╝██╔══██╗                                 ");
        Util.myPrintln("          ███████╗██║   ██║██████╔╝██║   ██║██║██║   ██║█████╗  ██║  ██║                                 ");
        Util.myPrintln("          ╚════██║██║   ██║██╔══██╗╚██╗ ██╔╝██║╚██╗ ██╔╝██╔══╝  ██║  ██║                                 ");
        Util.myPrintln("          ███████║╚██████╔╝██║  ██║ ╚████╔╝ ██║ ╚████╔╝ ███████╗██████╔╝                                 ");
        Util.myPrintln("          ╚══════╝ ╚═════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═══╝  ╚══════╝╚═════╝                                  ");
        Util.myPrintln("                         ████████╗██╗  ██╗███████╗                                                                     ");
        Util.myPrintln("                         ╚══██╔══╝██║  ██║██╔════╝                                                                     ");
        Util.myPrintln("                            ██║   ███████║█████╗                                                                       ");
        Util.myPrintln("                            ██║   ██╔══██║██╔══╝                                                                       ");
        Util.myPrintln("                            ██║   ██║  ██║███████╗                                                                     ");
        Util.myPrintln("                            ╚═╝   ╚═╝  ╚═╝╚══════╝                                                                     ");
        Util.myPrintln("          ██████╗ ██╗   ██╗███╗   ██╗ ██████╗ ███████╗██╗ ██████╗ ███╗   ██╗                            ");
        Util.myPrintln("          ██╔══██╗██║   ██║████╗  ██║██╔════╝ ██╔════╝██║██╔═══██╗████╗  ██║                            ");
        Util.myPrintln("          ██║  ██║██║   ██║██╔██╗ ██║██║  ███╗█████╗  ██║██║   ██║██╔██╗ ██║                            ");
        Util.myPrintln("          ██║  ██║██║   ██║██║╚██╗██║██║   ██║██╔══╝  ██║██║   ██║██║╚██╗██║                            ");
        Util.myPrintln("          ██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝███████╗██║╚██████╔╝██║ ╚████║██╗                         ");
        Util.myPrintln("          ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝ ╚══════╝╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝                         ");
    }
}

