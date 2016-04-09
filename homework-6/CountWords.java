import java.io.*;

public class CountWords{

  //all main does is print out the string returned by the method
  public static void main(String[] args){
    System.out.println(wordCount(args[0],args[1]));
  }

  //reads a given input file and prints the frequency of words into the output
  //file and to the terminal
  public static String wordCount(String input_file, String output_file){
    HashTable table;
    try{
      //set up the readers and hash table
      BufferedReader reader = new BufferedReader(new FileReader(input_file));
      BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));
      table = new HashTable();
      String line;
      String[] words; //holds the words parsed out from line
      Item temp;  //holds the current word being manipulated if found
      //read line by line
      while((line = reader.readLine()) != null){
        //parse the line into words
        line = line.replaceAll("[^A-Za-z0-9]", " "); //eliminates punctuation
        line = line.toLowerCase(); //makes the spellcheck case-insensitive
        words = line.split(" "); //split the string into words divided by spaces
        //for each word occurence, insert it into the hash table
        for(int i=0; i<words.length; i++){
            //if this "word" is just whitespace, ignore, otherwise insert
            if(!(words[i].replaceAll("\\s+","").equals(""))){
              table.insert(words[i]);
            }
        }
      }
      reader.close();
      //get the string[] representation of the hash table and write it string by string
      //now we're using words to hold the string[] representation of the hash table
      //to save memory
      //toStringArray also prints to the terminal, more efficient
      words = table.toStringArray();
      for(int i=0; i<words.length; i++){
        writer.write(words[i]);
      }
      writer.close();
    }
    //will return an error message in the calling method if something goes wrong
    catch(IOException exception){
      return "Error reading/writing files.";
    }
    //success return message
    return ("OK; Total words: " + table.size() + ", Hash table size: " + table.capacity()
     + ", Average length of collision lists: " + table.getAvgListSize());
  }
}
