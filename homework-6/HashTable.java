import java.util.ArrayList;

public class HashTable{
  ArrayList<Item><String>[] table;
  int size(); //the # entries in the hash table, not the capacity in slots

  //
  public HashTable(){
    table = new ArrayList<Item><String>[64]; //64 is the default capacity
    size = 0;
  }

  //return the size of the hash table in # entries
  public int size(){
    return size;
  }

  //return the capacity of the hash table
  public int capacity(){
    return table.length;
  }

  //formats the entries in the hash table to a string array, each element is a hash element
  public String[] toString(){
    //the size is an array, more efficient, size is calculated to fit the hash
    String[] tablestrings = new String[size*getAvgListSize()];
    //for each hash slot, check if occupied and if so copy the list to string array
    //each list becomes a string in tablestrings[]
    for(int i=0; i<size; i++){
      tablestrings[i] = "";
      if(table[i] != null)
        for(int j=0;j<table[i].size();j++){
          tablestrings[i] += table[i].get(i);
        }
    }
    return tablestrings;
  }

  //returns the average length of the collision lists across all hash slots
  //(including empty ones)
  public int getAvgListSize(){
    return size/table.length;
  }

  //
  public void insert(String key){
    int hashCode = key.hashCode();
    //if it already exists in the list, increment the # occurences, if not, create it
    for(int i=0; i<table[hashCode%table.length].size(); i++){
      if(table[hashCode%table.length].get(i).key == key){
        table[hashCode%table.length].get(i).addOccurence();
        return;
      }
    }
      table[hashCode%table.length].add(new Item(key));
      size++;
  }

  //double the capacity of the hash table when it is full
  private void growTable(){
    ArrayList<Item><String>[] oldtable = table;
    table = System.arraycopy(table,0,new List<Item><String>[table.length*2],0,table.length);
    //need to rehash the table to account for the new hash function/table size
    for(int i=0; i<oldtable.length; i++){
      //for every list in the old hash table, remove and hash all entries
      while(oldtable[i].size() > 0){
        insert(oldtable[i].remove(0));
      }
    }
  }
}
