package dictionary;

import static dictionary.ReadWords.*;
import java.util.*;

/**
 * Main class of program.
 * @author JavaProgSecure
 */
public class Main {
     /**
     * It's menu with standard dictionary operating options.
     */
    public static void Menu() {
        List<ReadWords> translate = FileReader("angielski.txt","polski.txt");
        long start, stop;
        boolean control = true;
        while (control) {
            //Menu options
            System.out.println();
            System.out.println("Menu");
            System.out.println("1. ENG -> POL");
            System.out.println("2. POL -> ENG");
            System.out.println("3. Find word");
            System.out.println("4. Add new word");
            System.out.println("5. Delete word");
            System.out.println("6. Exit");

            //Get user choice
            Scanner input = new Scanner(System.in);
            System.out.println("Choose option");
            int choice = input.nextInt();

            //Correctly menu
            switch (choice) {
                case 1:
                    System.out.println("Which word you want to translate: ");
                    String wantToPol = input.next();
                    start = System.nanoTime();
                    System.out.println("Translation: " + translatePOL(wantToPol, translate));
                    stop = System.nanoTime();
                    System.out.println("Time of execute: " + ((stop - start)/1000) + " us");
                    break;

                case 2:
                    System.out.println("Which word you want to translate: ");
                    String wantToEng = input.next();
                    start = System.nanoTime();
                    System.out.println("Translation: " + translateENG(wantToEng, translate));
                    stop = System.nanoTime();
                    System.out.println("Time of execute: " + ((stop - start)/1000) + " us");
                    break;

                case 3:
                    System.out.println("Write word that u seek: ");
                    String wordDesire = input.next();
                    start = System.nanoTime();
                    System.out.println(wordFinder(wordDesire, translate));
                    stop = System.nanoTime();
                    System.out.println("Time of execute: " + ((stop - start)/1000) + " us");
                    break;

                case 4:
                    System.out.println("Add new word with a translation: ");
                    System.out.print("English meaning: ");
                    String saveEng = input.next();
                    System.out.print("Polish meaning: ");
                    String savePol = input.next();
                    start = System.nanoTime();
                    wordAdder(saveEng, savePol);
                    stop = System.nanoTime();
                    System.out.println("Time of execute: " + ((stop - start)/1000) + " us");
                    break;
                
                case 5:
                    System.out.println("Type word that you want to delete:");
                    String remove = input.next();
                    removeWord(remove, translate);
                    break;
                    
                case 6:
                    control = false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}
