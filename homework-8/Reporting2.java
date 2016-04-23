import java.io.*;

public class Reporting2{

  static int[] inputarray; //the array holding input to be sorted

  //reads the contents of the input file into an array
  private static void readInput(String inputfile){
    inputarray = new int[getInputLength(inputfile)]; //initialize inputarray size
    //set up the input array and file reader
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputfile));
      String line; //used to hold a line of the file being read
      //feed the file input into the array
      int index = 0;
      for(int i=0; i<inputarray.length; i++){
        inputarray[i] = Integer.parseInt(reader.readLine());
      }
      reader.close();
    }catch(IOException exception){
      System.out.println("Error reading from file.");
      System.exit(1);
    }
  }

  //reads through the file to find the needed size of the input array
  private static int getInputLength(String inputfile){
    int numlines = 0;
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputfile));
      while(reader.readLine() != null){
        numlines++;
      }
      reader.close();
    }catch(IOException exception){
      System.out.println("Error reading from file. ");
      System.exit(1);
    }
    return numlines;
  }

  public static void main(String[] args){

    //HEAPSORT
    long[] trials = new long[3]; //holds each of the 3 trials of each run
    try{
      //output will be written to a text file
      BufferedWriter writer = new BufferedWriter(new FileWriter("bfm21HS.txt"));
      readInput(args[0]); //load the array from the input file
      //write the first run to the output file
      trials[0] = Sort.heapSort(inputarray);
      for(int i=0; i<inputarray.length; i++){
        writer.write(inputarray[i] + "\n");
      }
      writer.close();
    }catch(IOException exception){
      System.out.println("Error reading from file. ");
      return;
    }
    //and run two more times to get a median running time
    for(int i=1; i<trials.length; i++)
    {
      readInput(args[0]); //reload the unsorted array
      trials[i] = Sort.heapSort(inputarray);
    }
    System.out.print("HS bfm21 = "+ ((trials[0]+trials[1]+trials[2])/3)+"ns; ");

    //QUICKSORT
    try{
      //output will be written to a text file
      BufferedWriter writer = new BufferedWriter(new FileWriter("bfm21QS.txt"));
      readInput(args[0]); //reload the unsorted array
      //write the first run to the output file
      trials[0] = Sort.quickSort(inputarray);
      for(int i=0; i<inputarray.length; i++){
        writer.write(inputarray[i] + "\n");
      }
      writer.close();
    }catch(IOException exception){
      System.out.println("Error reading from file. ");
      return;
    }
    //and run two more times to get a median running time
    for(int i=1; i<trials.length; i++)
    {
      readInput(args[0]); //reload the unsorted array
      trials[i] = Sort.quickSort(inputarray);
    }
    System.out.print("QS bfm21 = "+ ((trials[0]+trials[1]+trials[2])/3)+"ns; ");

    //MERGESORT
    try{
      //output will be written to a text file
      BufferedWriter writer = new BufferedWriter(new FileWriter("bfm21MS.txt"));
      readInput(args[0]); //reload the unsorted array
      //write the first run to the output file
      trials[0] = Sort.mergeSort(inputarray);
      for(int i=0; i<inputarray.length; i++){
        writer.write(inputarray[i] + "\n");
      }
      writer.close();
    }catch(IOException exception){
      System.out.println("Error reading from file. ");
      return;
    }
    //and run two more times to get a median running time
    for(int i=1; i<trials.length; i++)
    {
      readInput(args[0]); //reload the unsorted array
      trials[i] = Sort.mergeSort(inputarray);
    }
    System.out.println("MS bfm21 = "+ ((trials[0]+trials[1]+trials[2])/3)+"ns;");

  }
}
