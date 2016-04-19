public class Sort{
  //used in heapsort for organizing the heap
  static int[] items; //heap array
  static int numItems; //heap size

  //run the heap sort sorting algorithm on a given array
  public static long heapSort(int[] arr){
    //record the time to keep track of algorithm running time
    long startTime = System.nanoTime();
    //turn the array into a heap
    items = arr;
    numItems = arr.length;
    buildHeap();
    //while the heap size is greater than 1, remove the max and put it at the
    //end of the array, which is now outside the bounds of the heap, to sort it
    while(numItems > 1){
      items[numItems-1] = removeMax();
    }
    //and return the time it took to sort
    return System.nanoTime()-startTime;
  }

  //run the quick sort sorting algorithm on a given array
  public static long quickSort(int[] arr){
    //record the time to keep track of algorithm running time
    long startTime = System.nanoTime();
    //run the quick sort algorithm recursively on itself
    myQuickSort(arr, 0, arr.length-1);
    //and return the time it took to sort
    return System.nanoTime()-startTime;
  }

  //run the merge sort sorting algorithm on a given array
  public static long mergeSort(int[] arr){
    //record the time to keep track of algorithm running time
    long startTime = System.nanoTime();
    //create the temporary array
    int[] arr2 = new int[arr.length];
    //sort the array with myMergeSort()
    arr = myMergeSort(arr, arr2, 1);
    //and return the time it took to sort
    return System.nanoTime()-startTime;
  }

  //mergesort recursively calls itself in the return statement, but switches
  //the temporary and original arrays each time in order to save from copying
  private static int[] myMergeSort(int[] arr, int[] arr2, int width){
      //for each pair of subarrays of width width
      for(int leftbound=0; leftbound<arr.length; leftbound+=2*width){
        /*leftbound is the beginning of the left subarray
        **middlebound is the beginning of the right subarray
        **rightbound is the last position of the right subarray +1
        **i is the index for the left array
        **j is the index for the right array
        **k is the index for the temporary array*/
        int i = leftbound;
        int middlebound = Math.min(leftbound+width, arr.length);
        int j = middlebound;
        int rightbound = Math.min(i+2*width, arr.length);
        //for each and every element in both subarrays
        subarraysort: for(int k=leftbound; k<rightbound; k++){
          //if one of the arrays is exhausted, no more comparisons are needed,
          //just copy the remaining elements of the other one to the temp array
          if(i==middlebound){
            while(j<rightbound){
              arr2[k] = arr[j];
              //maintain indices for the original and temp array
              k++;
              j++;
            }
            break subarraysort; //break out of the loop, done evaluating this
                                //set of subarrays
          }
          if(j==rightbound){
            while(i<middlebound){
              arr2[k] = arr[i];
              //maintain indices for the original and temp array
              k++;
              i++;
            }
            break subarraysort; //break out of the loop, done evaluating this
                                //set of subarrays
          }
          //otherwise, copy the lesser of the two elements into the temp array
          if(arr[i] < arr[j]){
            arr2[k] = arr[i];
            i++;
          }
          else{
            arr2[k] = arr[j];
            j++;
          }
        }
      }
      //if width*2 is >= to the array length, ie, if the next width is going to
      //be as large as or larger than the array length, it's sorted, return the
      //now sorted temp array
      if(width*2 >= arr2.length)
        return arr2;
      //otherwise, run the algorithm again on subarrays twice as large,
      //reversing the roles of the temp and original array
      return myMergeSort(arr2, arr, width*2);
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
    int pivot = arr[(first+last)/2];
    int i = first-1; //left index
    int j = last+1; //right index
    int temp; //for swapping out of order values
    //increment the left index until it finds a value greater than the pivot
    //then decrement the right index until it finds a value less than the pivot
    //swap these values if found, and repeat until there are no more values to
    //swap, ie, the partition is sorted
    while(true){
      //System.out.println("pivot: " + pivot);
      do{
        i++;
        //System.out.println("i: " + i);
      }while(arr[i] < pivot);
      do{
        j--;
        //System.out.println("j: " + j);
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

  //used to get and remove the max value from the heap in heap sort
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
