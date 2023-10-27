import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Dictionary;
import java.util.Scanner; // Import the Scanner class to read text files

/**************************
 * This program prints all words of the trie at a user-specified depth
 *
 ***************************************/
public class ProblemB {
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

        System.out.println("Enter a prefix to search for all words in the dictionary with that prefix");

        Scanner kb = new Scanner(System.in);

        while(kb.hasNext()){


            String input =  kb.next();

            if(input.equals("quit")){
                break;
            }

            dictionary.depthFirstPrefixPrint(input);

        }


    }
}