import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Dictionary;
import java.util.Scanner; // Import the Scanner class to read text files

/*******************
 *
 * This program reads words from a file and creats a trie dictionary.
 * Then, the suer can enter a word and find the translation
 */
public class ProblemA {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        try {
            File file = new File("src/words.txt");

            Scanner myfile = new Scanner(file);


            while(myfile.hasNext()){

                dictionary.addWord(myfile.nextLine(), myfile.nextLine());

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }



        Scanner kb = new Scanner(System.in);

        while(kb.hasNext()){


            String input =  kb.next();

            if(input.equals("quit")){
                break;
            }

            String translation = dictionary.wordSearch(input);

            if(translation == null){
                System.out.println("Word not found");
            } else{
                System.out.println(translation);
            }

        }


    }
}
