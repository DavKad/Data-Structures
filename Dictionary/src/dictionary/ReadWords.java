package dictionary;

import java.io.*;
import java.util.*;
/**
 * Object of this class get you ability to dictionary operating. Using LinkedList class.
 * For more info check LinkedList class. 
 * @author JavaProgSecure
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html" target = "_blank">LinkedList</a>
 */
public class ReadWords {

    private final String eng;
    private final String pol;
    private static List<ReadWords> words = new LinkedList();

    public ReadWords(String x, String y) {
        this.eng = x;
        this.pol = y;
    }
    /**
     * Reads file to get words and save it in LinkedList as properties of Word object. 
     * @param nameENG name of file that you want to read english words. 
     * @param namePOL name of file that you want to read polish words.
     * @return LinkedList with a objects contains words. 
     */
    public static List<ReadWords> FileReader(String nameENG, String namePOL) {
        try {
            BufferedReader FileToReadENG = new BufferedReader(new FileReader(nameENG));
            BufferedReader FileToReadPOL = new BufferedReader(new FileReader(namePOL));
            try {
                String lineENG, linePOL;
                while ((lineENG = FileToReadENG.readLine()) != null && (linePOL = FileToReadPOL.readLine()) != null) {
                    String[] splited;
                    splited = new String[2];
                    splited[0] = lineENG;
                    splited[1] = linePOL;
                    words.add(new ReadWords(splited[0], splited[1]));
                }
                FileToReadENG.close();
                FileToReadPOL.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return words;
    }
    /**
     * English word getter
     * @return English word value.
     */
    public String getENG() {
        return this.eng;
    }
    /**
     * Polish word getter
     * @return  Polish word value.
     */
    public String getPOL() {
        return this.pol;
    }
    /**
     * Translate english word to polish word
     * @param word english word that you want to translate
     * @param list List from you want to get a word.
     * @return  Polish word value.
     */
    public static String translatePOL(String word, List<ReadWords> list) {
        for (ReadWords x : list) {
            if (x.getENG().equals(word)) {
                return x.getPOL();
            }
        }
        return "Word missing";
    }
     /**
     * Translate polish word to english word
     * @param word polish word that you want to translate
     * @param list List from you want to get a word.
     * @return  English word value.
     */
    public static String translateENG(String word, List<ReadWords> list) {
        for (ReadWords y : list) {
            if (y.getPOL().equals(word)) {
                return y.getENG();
            }
        }
        return "Word missing";
    }
     /**
     * Find word that you want to find.
     * @param word word that you want to find
     * @param list List from you want to get a word.
     * @return  Sentence when coudnt find a word.
     */
    public static String wordFinder(String word, List<ReadWords> list) {
        for (ReadWords x : list) {
            if (x.getENG().equals(word) || x.getPOL().equals(word)) {
                System.out.println("Word finded");
                if (x.getENG().equals(word)) {
                    return "Translation: " + x.getPOL();
                } else {
                    return "Translation: " + x.getENG();
                }
            }
        }
        return "No such word.";
    }
     /**
     * Add english and polish mining of word that you want to add.
     * @param word english word that you want to add.
     * @param secWord polish word that you want to add..
     */
    public static void wordAdder(String word, String secWord) {
        
            words.add(new ReadWords(word, secWord));
            try {
                BufferedWriter addWordENG = new BufferedWriter(new FileWriter("angielski.txt", true));
                BufferedWriter addWordPOL = new BufferedWriter(new FileWriter("polski.txt", true));
                addWordENG.newLine();
                addWordPOL.newLine();
                addWordENG.write(word);
                addWordPOL.write(secWord);
                addWordENG.close();
                addWordPOL.close();
                System.out.println("Word saved corectly");
            }
         catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
}
     /**
     * Remove word and his meaning in the list.
     * @param word word that you want to remove.
     * @param list List from you want to remove word.
     */
    public static void removeWord(String word, List<ReadWords> list) {
        Scanner input = new Scanner(System.in);
        System.out.print("You are sure you want to delete it (Y/N): ");
        String choice = input.next();
        Iterator<ReadWords> iter = list.iterator();
        if (choice.equals("Y") || choice.equals("y")) {
            while (iter.hasNext()) {
                ReadWords x = iter.next();
                if (x.getENG().equals(word) || x.getPOL().equals(word)) {
                    iter.remove();
                    System.out.println("Word removed.");
                }
            }
        } else {
            System.out.println("Like i thought, you need it!");
        }
    }
     /**
     * Prints what list contains.
     * @param  words list that you want to show.
     */
    public static void printAll(List<ReadWords> words) {
        for (ReadWords z : words) {
            System.out.println(z.getENG() + z.getPOL());
        }
    }
}