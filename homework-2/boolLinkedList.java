public class boolLinkedList implements boolList{

  int listsize;
  listNode head;
  listNode tail;

  //nested class for the nodes of the LL
  private class listNode{
    public listNode prev;
    public listNode next;
    public boolean value;

    //initializes the node with its value and references
    public listNode(listNode p, listNode n, boolean val){
      prev = p;
      next = n;
      value = val;
    }
  }
  //initializes the list LL
  public boolLinkedList(){
    head = null;
    tail = null;
    listsize = 0;
  }
  //return the size of the list
  //running time: O(1)
  public int size(){
    return listsize;
  }
  //insert an element before the ith element or at the end if DNE
  //running time: O(n)
  public void insert(int i, boolean value){
    listNode temp = head;
    //check for empty list
    if(listsize == 0){
      head = new listNode(null,tail,value);
      tail = head;
      listsize++;
      return;
    }
    //traverse the LL
    for(int j=0; j<i; j++){
      if(temp.next == null)
        break;
      temp = temp.next;
    }
    listNode temp2 = new listNode(temp.prev, temp, value);
    temp.next = temp2;
    temp.prev = temp2;
    listsize++;
  }
  //remove element i, or do nothing if DNE
  //running time: O(n)
  public void remove(int i){
    listNode temp = head;
    //traverse the LL
    for(int j=0; j<i; j++){
      if(temp.next == null)
        return;
      temp = temp.next;
    }
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
  }
  //return the ith element or raise exception if DNE
  //running time: O(n)
  public boolean lookup(int i){
    if(i<listsize){
      listNode temp = head;
      //traverse the LL
      for(int j=0; j<i; j++){
        temp = temp.next;
      }
      return temp.value;
    }
    else{
      throw new IndexOutOfBoundsException();
    }
  }
  //flip all elements to their opposite, raise exception if empty list
  //running time: O(n)
  public boolean negateAll(){
    if(listsize == 0){
      throw new IllegalArgumentException();
    }
    listNode temp = head;
    //traverse the LL, negating as we go along
    while(temp.next != null){
      temp = temp.next;
      temp.value = !temp.value;
    }
    return true;
  }
}
