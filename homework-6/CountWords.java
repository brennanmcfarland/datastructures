import java.io.*;

public class CountWords{
  //
  public static String wordCount(String input_file, String output_file){
    try{
      //set up the readers and hash table
      BufferedReader reader = new BufferedReader(new FileReader(input_file));
      BufferedWriter writer = new BufferedWriter(new FileWriter(output_file));
      HashTable table = new HashTable();
      String line;
      String[] words; //holds the words parsed out from line
      Item<String> temp;  //holds the current word being manipulated if found
      //read line by line
      while((line = reader.readLine()) != -1){
        //parse the line into words
        line = line.replaceAll("[^A-Za-z0-9]", " "); //eliminates punctuation
        line = line.toLowerCase(); //makes the spellcheck case-insensitive
        words = line.split(" "); //split the string into words divided by spaces
        //for each word, increment occurences or create a new hash element if null
        for(int i=0; i<words.length; i++){
          temp = table.search(words[i]);
          if(temp == null)
            table.insert(words[i]);
          else
            temp.addOccurence();
        }
      }
      reader.close();
      //for every index in the hash table that's full, write and print it out
      for(int i=0; i<table.size(); i++){
        if((temp = table.getAtIndex(i)) != null)
          writer.write(temp.toString());
      }
      writer.close();
    }
    //will return an error message in the calling method if something goes wrong
    catch(IOException exception){
      return "Error reading/writing files.";
    }
    return ("OK; Total words: " + x + ", Hash table size: " + y +
      ", Average length of collision lists: " + z);
  }
}
