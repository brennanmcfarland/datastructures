import java.util.ArrayList;

public class MajorityElement{
    public static void main(String[] args){
	int[] array = {3,1,3,4,3}; //the test array
        ArrayList<Integer> candidates = new ArrayList<Integer>();
	//list of candidates

	for(int i=0; i<array.length; i++){
	    if(findOccurences(array, array[i]) > array.length/2){
	        System.out.println("The majority element is " + array[i]);
		return;
	    }
	}
	System.out.println("There is no majority element!");
    }
    private static int findOccurences(int[] array, int element){
	int num = 0;
	for(int i=0; i<array.length; i++){
	    if(array[i] == element)
		num++;
	}
	return num;
    }
}
