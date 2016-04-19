//to be deleted when sorting algorithms verified to work
public class TestSort{
  public static void main(String[] args){
    //make a test array and fill it
    int[] arr = new int[7];
    //test the three sorting algorithms
    arr[0] = 4; arr[1] = 2; arr[2] = 5; arr[3] = 1; arr[4] = 1; arr[5] = 3; arr[6] = 0;
    System.out.println("Running time: " + Sort.heapSort(arr) + " nanoseconds");
    arr[0] = 4; arr[1] = 2; arr[2] = 5; arr[3] = 1; arr[4] = 1; arr[5] = 3; arr[6] = 0;
    System.out.println("Running time: " + Sort.quickSort(arr) + " nanoseconds");
    arr[0] = 4; arr[1] = 2; arr[2] = 5; arr[3] = 1; arr[4] = 1; arr[5] = 3; arr[6] = 0;
    System.out.println("Running time: " + Sort.mergeSort(arr) + " nanoseconds");
  }
}
