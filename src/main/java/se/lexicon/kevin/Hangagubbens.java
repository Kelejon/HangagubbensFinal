package se.lexicon.kevin;


import java.util.Scanner;
import java.util.Random;

public class Hangagubbens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] ord = {"korv", "pizza", "pasta", "macka", "potatis", "kaviar", "sill", "smör", "tacos"};

        boolean spela = true;
        while (spela) {
            System.out.println("Välkommen till spelet hänga gubbe!");
            char[] randomOrd = ord[random.nextInt(ord.length)].toCharArray();
            int gissningar = 8;
            char[] spelarensGissningar = new char[gissningar];

            for (int i = 0; i < spelarensGissningar.length; i++) {
                spelarensGissningar[i] = '_';
            }

            boolean gissatOrdet = false;
            int försök = 0;

            while (!gissatOrdet && försök != gissningar) {
                System.out.println("Dina gissningar: ");
                printArray(spelarensGissningar);
                System.out.printf("Du har %d tries left.\n", gissningar - försök);
                System.out.println("Gissa en bokstav");
                char input = scanner.nextLine().charAt(0);
                försök++;

                if (input == '-') {
                    spela = false;
                    gissatOrdet = true;
                } else {
                    for (int i = 0; i < randomOrd.length; i++) {
                        if (randomOrd[i] == input) {
                            spelarensGissningar[i] = input;
                        }
                    }

                    if (omGissatOrdet(spelarensGissningar)) {
                        gissatOrdet = true;
                        System.out.println("Grattis du vann!");
                    }

                }

            }
            if (!gissatOrdet) System.out.println("Du har förbrukat dina gissnings försök");
            System.out.println("Vill du spela igen? (j/n)");
            String spelaigen = scanner.nextLine();
            if (spelaigen.equals("n")) spela = false;
        }
        System.out.println("Spelet är slut");
    }

    public static void printArray(char[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

    }

    public static boolean omGissatOrdet(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '_') return false;
        }
        return true;

    }

}