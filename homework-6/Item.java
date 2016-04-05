//holds data pertaining to an item in the hash table, the key is immutable
public class Item{
  String key;
  int occurences;

  //create a new item
  public Item(String key){
    this.key = key;
    occurences = 1;
  }

  //increment the occurences of the item
  public void addOccurence(){
    occurences++;
  }

  //returns just the key, for rehashing
  public String getKey(){
    return key;
  }

  //returns a string representing the item and it's occurences
  public String toString(){
    return ("("+key+" "+occurences+") ");
  }
}
