public class Sort{
  //used in heapsort for organizing the heap
  static int[] items; //heap array
  static int numItems; //heap size

  //run the heap sort sorting algorithm on a given array
  public static long heapSort(int[] arr){
    //turn the array into a heap
    items = arr;
    numItems = arr.length;
    buildHeap();
    //while the heap size is greater than 1, remove the max and put it at the
    //end of the array, which is now outside the bounds of the heap, to sort it
    while(numItems > 1){
      items[numItems-1] = removeMax();
    }
    return 1;
  }

  //run the quick sort sorting algorithm on a given array
  public static long quickSort(int[] arr){
    myQuickSort(arr, 0, arr.length-1);
    for(int i=0; i<arr.length; i++){
      System.out.println(arr[i]);
    }
    return 1;
  }

  //run the merge sort sorting algorithm on a given array
  public static long mergeSort(int[] arr){
    //copy back and forth between other array when merging
    int[] arr2 = new int[arr.length];
    myMergeSort(arr, arr2);
    return 1;
  }

  //
  static void myMergeSort(int[] arr){
    if(arr.length == 1) //do nothing if at base case
      return;

  }

  //run quicksort recursively on itself until the array is sorted
  static void myQuickSort(int[] arr, int first, int last){
    //if the first and last elements meet or overlap, the array is sorted
    if(first >= last)
      return;
    //partition the array and run recursively on both halves
    int partition = partition(arr, first, last);
    myQuickSort(arr, first, partition);
    myQuickSort(arr, partition+1, last);
  }

  //partition the array in quick sort
  static int partition(int[] arr, int first, int last){
    //set the pivot and the indices
    int pivot = (first+last)/2;
    int i = first-1; //left index
    int j = last+1; //right index
    int temp; //for swapping out of order values
    //increment the left index until it finds a value greater than the pivot
    //then decrement the right index until it finds a value less than the pivot
    //swap these values if found, and repeat until there are no more values to
    //swap, ie, the partition is sorted
    while(true){
      do{
        i++;
      }while(arr[i] < pivot);
      do{
        j--;
      }while(arr[j] > pivot);
      if(i < j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
      else{
        return j;
      }
    }
  }

  //used to build the heap in heap sort
  static void buildHeap(){
    for(int i=(numItems-2)/2; i>=0; i--)
      siftDown(i);
  }

  //used to remove the max value from the heap in heap sort
  static int removeMax(){
    int toRemove = items[0];
    items[0] = items[numItems-1];
    numItems--;
    siftDown(0);
    return toRemove;
  }

  //used to sift down a value in heap sort
  static void siftDown(int i){
    int toSift = items[i];
    int parent = i;
    int child = 2*parent+1;
    //while it's not completely sifted down to the bottom
    while(child < numItems){
      //choose the larger child
      if(child+1 < numItems && items[child] < items[child+1])
        child = child+1;
      //if it's in correct order, we're done
      if(toSift > items[child])
        break;
      //if it's not in correct order, swap and continue to sift
      items[parent] = items[child];
      items[child] = toSift;
      parent = child;
      child = 2*parent+1;
    }
    items[parent] = toSift;
  }
}
