
import java.util.ArrayList;
/**
 * This class represents an English to Portuguese dictionary
 * It uses a 26 node tree
 * @author RM
 */
public class Dictionary {
    private TrieNode root;
    private int depth;


    /** Constructor Sets the root of the trie to an empty string.
     */
    public Dictionary(){
        root = new TrieNode();
        root.definitionOfWord = "";
        root.isWord = false;
        depth = 0;
    }

    /** Method to add a word to the existing tree along with its translation
     * @para word w to be added to the tree with its definiton or translation. In this case it will be a transaltion
     */
    public void addWord(String w,String definition){

        TrieNode temp = root;

        for(int letter = 0; letter < w.length(); letter++) {
            int nodeIndex = letterToNum(w.charAt(letter));
            //if letter node dne, make new node as a child of temp
            if (temp.alphabet[nodeIndex] == null) {

                TrieNode newNode = new TrieNode();
                newNode.letter = w.charAt(letter);


                temp.alphabet[nodeIndex] = newNode;


                //if node is the end of word, make node a word and give definition
                if (letter == w.length() - 1) {
                    newNode.isWord = true;
                    temp.word = w;
                    newNode.definitionOfWord = definition;
                    return;
                }
                temp = temp.alphabet[nodeIndex];

            } else {
                //move to child node
                temp = temp.alphabet[nodeIndex];

                //if node is the end of word, make node a word and give definition
                if (letter == w.length() - 1) {
                    temp.isWord = true;
                    temp.word = w;
                    temp.definitionOfWord = definition;
                }
            }
        }

    }

    public int letterToNum(char x){
        return (int)x - 97;
    }

    /** Method to return the definition of the word if the word is found, otherwise returns null
     * @para word s is the word we are searching for
     * @return string s which is the word to be searched, null otherwise
     */
    public String wordSearch(String s) {
// WRITE YOUR CODE HERE
        TrieNode temp = root;

        String word = "";

        for(int letter = 0; letter < s.length(); letter++){

            int nodeIndex = letterToNum(s.charAt(letter));
            if(temp.alphabet[nodeIndex] == null){
                return null;
            }else{

                temp = temp.alphabet[nodeIndex];

                word = word + temp.letter;

                //if the current node is a word and the word matches the desired word, return its definition
                if(temp.isWord && word.equals(s)){
                    return temp.definitionOfWord;
                }
            }
        }
        return null;
    }

    /** Method to print all the words with a given prefix and their definitions.
     * @para word s is the prefix we are searching for
     */

    public void depthFirstPrefixPrint(String s){
        //TODO will be used for finding all words of a given prefix
// WRITE YOUR CODE HERE
        TrieNode temp = root;

        for(int i = 0; i < s.length(); i++){
            temp = temp.alphabet[letterToNum(s.charAt(i))];
        }

        traverseTree(temp);

    }

// WRITE YOUR CODE HERE
    public void traverseTree(TrieNode node){

        if(node.isWord){
            System.out.println(node.definitionOfWord);
        }

        for(int i = 0; i < 26; i ++) {

            if(node.alphabet[i] != null){
                traverseTree(node.alphabet[i]);
            }

        }

    }



    /** Class to represent a node with 26 potential children
     *   Uses an array to store the references to children
     *   @author RM
     */

    public class TrieNode {

        //used to store translations or definitions
        private String definitionOfWord=null;
        //stores the word
        private String word = null;
        //26 potential children of this node
        private TrieNode[] alphabet;
        //flag for if this node is the end node of a word
        private boolean isWord;

        // [a-z] what letter is this node
        private char letter;

        public TrieNode(){
            alphabet = new TrieNode[26]; //26 references for 26 letters [a-z]
        }
    }
}