public class boolLinkedList{

  int listsize;
  listNode head;
  listNode tail;

  //nested class for the nodes of the LL, is protection level correct?
  private class listNode{
    public listNode prev;
    public listNode next;
    public boolean value;

    //initializes the node with its value and references
    public listNode(listNode p, listNode n, boolean val){
      prev = p;
      next = n;
      val = v;
    }
  }
  //initializes the list LL
  public boolLinkedList(){
    head = null;
    tail = null;
  }
  //return the size of the list
  public int size(){
    return listsize;
  }
  //insert an element before the ith element or at the end if DNE
  public void insert(int i, boolean value){
    listNode temp = head;
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
}
