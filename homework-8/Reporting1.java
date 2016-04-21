import java.io.*;
import java.util.Random;
/* BIG IDEA:
  for each sorting method, there's three runs (one for each case)
  for each case, run on different size arrays
  for each different size array, run 3 times as specified
*/
public class Reporting1{
  //holds and generates data for each of the different array sizes
  private static class Arrays{
    int[] XS;
    int[] S;
    int[] L;
    int[] XL;

    //initialize the arrays
    private Arrays(){
      XS = new int[1000];
      S = new int[10000];
      L = new int[100000];
      XL = new int[1000000];
    }

    //fill the arrays with data in sorted order
    private void fillSorted(){
      for(int i=0; i<XS.length; i++)
        XS[i] = i;
      for(int i=0; i<S.length; i++)
        S[i] = i;
      for(int i=0; i<L.length; i++)
        L[i] = i;
      for(int i=0; i<XL.length; i++)
        XL[i] = i;
    }

    //fill the arrays with data in reverse sorted order
    private void fillReverse(){
      for(int i=0; i<XS.length; i++)
        XS[i] = XS.length-i-1;
      for(int i=0; i<S.length; i++)
        S[i] = S.length-i-1;
      for(int i=0; i<L.length; i++)
        L[i] = L.length-i-1;
      for(int i=0; i<XL.length; i++)
        XL[i] = XL.length-i-1;
    }

    //fill the arrays with random, unsorted data
    private void fillRandom(){
      Random rand = new Random(System.nanoTime());
      for(int i=0; i<XS.length; i++)
        XS[i] = rand.nextInt();
      for(int i=0; i<S.length; i++)
        S[i] = rand.nextInt();
      for(int i=0; i<L.length; i++)
        L[i] = rand.nextInt();
      for(int i=0; i<XL.length; i++)
        XL[i] = rand.nextInt();
    }
  }



  public static void main(String[] args){
    System.out.println("Please wait while the data is being processed...");

    try{
      //output will be formatted and written to a text file
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
      //initialize the data class
      Arrays data = new Arrays();
      long[] trials = new long[3]; //holds each of the 3 trials of each run

      writer.write("All units in nanoseconds (ns):\n");
      //HEAPSORT: run trials on heapsort
      writer.write("HEAPSORT"); writer.newLine();
      writer.write("  array size:     1000      10000      100000      1000000\n");

      //for sorted input,
      writer.write("      sorted:     ");
      data.fillSorted();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for reverse sorted input
      writer.write("     reverse:     ");
      data.fillReverse();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for random input
      writer.write("      random:     ");
      data.fillRandom();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.heapSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //QUICKSORT: run trials on quicksort
      writer.write("QUICKSORT"); writer.newLine();
      writer.write("  array size:     1000      10000      100000      1000000\n");

      //for sorted input,
      writer.write("      sorted:     ");
      data.fillSorted();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for reverse sorted input
      writer.write("     reverse:     ");
      data.fillReverse();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for random input
      writer.write("      random:     ");
      data.fillRandom();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.quickSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //MERGESORT: run trials on mergesort
      writer.write("MERGESORT"); writer.newLine();
      writer.write("  array size:     1000      10000      100000      1000000");
      writer.newLine();

      //for sorted input,
      writer.write("      sorted:     ");
      data.fillSorted();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for reverse sorted input
      writer.write("     reverse:     ");
      data.fillReverse();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      //for random input
      writer.write("      random:     ");
      data.fillRandom();
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.S);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.L);
      writer.write(Sort.median(trials)+"     ");
      for(int i=0; i<trials.length; i++)
        trials[i] = Sort.mergeSort(data.XS);
      writer.write(Sort.median(trials)+"     \n");

      writer.close();
    } //gives an error message if file output went wrong
    catch(IOException exception){
      System.out.println("Error writing to the file.  Results not recorded.");
    }

    System.out.println("Success!  The data has been recorded in the output file.");
  }
}
