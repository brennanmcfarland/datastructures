public class boolListDemo{
  public static void main(String[] args){
    //initialize the boolArrayList, add a bunch of values and print the integer
    boolList arraylist = new boolArrayList(10);
    arraylist.insert(11,true); //1
    arraylist.insert(11,false);
    arraylist.insert(11,true); //4
    arraylist.insert(11,false);
    arraylist.insert(11,true); //16
    arraylist.insert(11,true); //32
    arraylist.insert(11,true); //two's complement
    System.out.println("The array integer representation is " + boolToSigned(arraylist));

    //do the same thing for boolLinkedList
    boolList linkedlist = new boolLinkedList();
    linkedlist.insert(11,false);
    linkedlist.insert(11,false);
    linkedlist.insert(11,true); //4
    linkedlist.insert(11,false);
    linkedlist.insert(11,true); //two's complement
    System.out.println("The linked list integer representation is " + boolToSigned(linkedlist));
  }
  //return the signed integer value represented by the boolean list
  //running time: O(n^2)
  private static int boolToSigned(boolList lst){
    //determine the unsigned integer value
    int unsigned = 0;
    for(int i=0;i<lst.size()-1;i++){
      if(lst.lookup(i) == true)
        unsigned += Math.pow(2,i);
    }
    //and convert to signed integer value using two's complement
    if(lst.lookup(lst.size()-1) == true)
      return unsigned-(int)Math.pow(2,lst.size());
    else
      return unsigned;
  }
}
