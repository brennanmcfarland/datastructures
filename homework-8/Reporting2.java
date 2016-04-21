import java.io.*;

public class Reporting2{

  //reads the contents of the input file into an array
  private static int[] readInput(String inputfile){

    //set up the input array and file reader
    int[] inputarray = null;

    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputfile));
      String line; //used to hold a line of the file being read

      //get the number of lines for the input array size
      int index = 0;
      while((line = reader.readLine()) != null){
        reader.readLine();
        index++;
      }
      inputarray = new int[index];

      //reset the reader, and feed the file input into the array
      reader.reset();
      index = 0;
      while((line = reader.readLine()) != null){
        inputarray[index] = Integer.parseInt(line);
        index++;
      }
    }catch(IOException exception){
      System.out.println("Error reading from file.");
      System.exit(1);
    }
    return inputarray;
  }

  public static void main(String[] args){

    //HEAPSORT
    int[] testarray = readInput(args[0]); //read input from given file
    long[] trials = new long[3]; //holds each of the 3 trials of each run
    Sort.heapSort(testarray);
    try{
      //output will be written to a text file
      BufferedWriter writer = new BufferedWriter(new FileWriter("bfm21HS.txt"));
      //print the first run to the program
      trials[0] = Sort.heapSort(testarray);
      for(int i=0; i<testarray.length; i++)
        writer.write(testarray[i] + "\n");
    }catch(IOException exception){
      System.out.println("Error reading from file. ");
      return;
    }
    //and run the other 2 to get a median running time
    for(int i=1; i<trials.length; i++) //note: is it running on sorted version of itself 2nd and 3rd times?  check running time
      trials[i] = Sort.heapSort(testarray);
    System.out.println("HS bfm21 = "+ Sort.median(trials)+"ns");

  }
}
