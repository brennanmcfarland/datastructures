public class boolListDemo{
  void main(String[] args){
    //initialize the boolArrayList, add a bunch of values and print the integer
    boolList arraylist = new boolArrayList(10);
    arraylist.insert(11,true);
    arraylist.insert(11,false);
    arraylist.insert(11,true);
    arraylist.insert(11,false);
    arraylist.insert(11,true);
    arraylist.insert(11,false);
    arraylist.insert(11,false);
    System.out.println("The integer representation is" + boolToSigned(arraylist));

    //do the same thing for boolLinkedList
    boolList linkedlist = new boolLinkedList();
    linkedlist.insert(11,false);
    linkedlist.insert(11,true);
    linkedlist.insert(11,true);
    linkedlist.insert(11,false);
    linkedlist.insert(11,true);

  }
  //return the signed integer value represented by the boolean list
  //running time:
  private static int boolToSigned(boolList lst){
    //determine the unsigned integer value
    int unsigned = 0;
    for(int i=0;i<lst.size();i++){
      if(lst.lookup(i) == true)
        unsigned += Math.pow(2,i);
    }
    //and convert to signed integer value using two's complement
    return (int)Math.pow(2,lst.size())-unsigned;
  }
}
