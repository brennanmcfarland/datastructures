//holds data pertaining to an item in the hash table, the key is immutable
public class Item<T>{
  T key;
  int occurences;

  //create a new item
  public Item(T key){
    this.key = key;
    occurences = 1;
  }

  //increment the occurences of the item
  public void addOccurence(){
    occurences++;
  }

  //returns a string representing the item and it's occurences
  public String toString(){
    return ("("+(String)key+" "+occurences+") ");
  }
}
