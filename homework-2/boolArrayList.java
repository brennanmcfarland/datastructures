//TODO: need to check for edge cases, ie array OOB exception
//TODO: exception handling? am i doing it right?  should it also return?  what?
public class boolArrayList implements boolList{
  boolean[] list;
  int listsize;

  //initializes the list array and specifies its max size
  public boolArrayList(int maxsize){
    list = new boolean[maxsize];
    listsize = 0;
  }
  //return the size of the list
  //running time:
  public int size(){
    return listsize;
  }
  //insert an element before the ith element or at the end if DNE
  //running time:
  public void insert(int i, boolean value){
    if(listsize < i+1)
      list[listsize] = value;
    else{
      //shift everything after the insertion point one space to the right
      for(int j=listsize-1;j>i;j--)
        list[j] = list[j-1];
      list[i] = value;
    }
    listsize++;
  }
  //remove element i, or do nothing if DNE
  //running time:
  public void remove(int i){
    if(listsize >= i+1){
      //shift everything after i one space to the left
      for(int j=i;j<listsize-1;j++)
        list[j] = list[j+1];
      listsize--;
    }
  }
  //return the ith element or raise exception if DNE
  //running time:
  public boolean lookup(int i){
    if(i<listsize)
      return list[i];
    else
      throw new InvalidListElementException();
  }
  //flip all elements to their opposite, raise exception if empty list
  //running time:
  public boolean negateAll(){
    if(listsize == 0){
      throw new EmptyListException();
      return false;
    }
    for(int i=0;i<listsize;i++)
      list[i] = !list[i];
    return true;
  }
}
