import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Create a dictionary of at least 30 words with Hash Table. Instead of using a linked list to resolve collisions,
as in separate chaining, use a binary search tree. You’ll create a hash table that is an array of trees.
(You can use Binary Heap of course. It’s up to you) (20 pt.)
Note: Your dictionary must have at least four words which starts with same letter.
And Words and meanings should read file from “my_words.txt”
Word: computer / noun
Meaning: an electronic machine that can store and arrange large amounts of information
 */

public class Main {
    public static void main(String[] args) {
        //Create a hashTable
        HashTable hashTable = new HashTable();

        //Read values from file and add them into our created hashTable
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/my_words.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] dic = line.split(":");
                hashTable.put(dic[0],dic[1]);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Now let's look at some word's meanings:
        System.out.println(hashTable.get("campus"));
        System.out.println(hashTable.get("carpenter"));
        System.out.println(hashTable.get("challenge"));

    }
}