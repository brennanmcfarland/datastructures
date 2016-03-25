
public class HashTable{
  Item<String>[] table;
  int size();

  //
  public HashTable(){
    table = new Item<String>[64]; //64 is the default capacity
    size = 0;
  }

  //return the size of the hash table
  public int size(){
    return size;
  }

  //gets the string at an array index of the hash table and returns it, for printing
  public String getAtIndex(int i){

  }

  //
  public void insert(String key){

  }

  //search for the key and delete if found
  public void remove(String key){

  }

  //finds and returns the position of the key
  private int findKey(String key){

  }

  //search for the entry with the key and return the associated data, null if not found
  private Item<String> search(String key){
    return findKey(key);
  }

  //double the capacity of the hash table when it is full
  private void growTable(){
    table = System.arraycopy(table,0,new Item<String>[table.length*2],0,table.length);
  }
}
