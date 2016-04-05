import java.util.ArrayList;

public class HashTable{
  ArrayList<Item>[] table;
  int size; //the # entries in the hash table, not the capacity in slots

  //
  public HashTable(){
    table = (ArrayList<Item>[])new ArrayList[64]; //64 is the default capacity
    for(int i=0; i<table.length; i++)
      table[i] = new ArrayList<Item>();
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
  public String[] toStringArray(){
    //the size is an array, more efficient, size is calculated to fit the hash
    String[] tablestrings = new String[size*(getAvgListSize()+1)];
    //for each hash slot, check if occupied and if so copy the list to string array
    //each list becomes a string in tablestrings[]
    for(int i=0; i<size; i++){
      tablestrings[i] = "";
      for(int j=0;j<table[i].size();j++){
        System.out.println(table[i].get(j).toString());
        tablestrings[i] += table[i].get(j).toString();
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
    System.out.println("Just inserted " + key);
    toStringArray();
  }

  //double the capacity of the hash table when it is full
  private void growTable(){
    ArrayList<Item>[] oldtable = table;
    //table = (ArrayList<Item>[])new ArrayList[64]; //64 is the default capacity
    //table = System.arraycopy(table,0,new ArrayList[table.length*2],0,table.length);
    table = (ArrayList<Item>[])new ArrayList[table.length*2];
    //for(int i=0; i<oldtable.length; i++)
    //  table[i] = oldtable[i];
    //table = System.arraycopy(table,0,((ArrayList<Item>[])new ArrayList<Item>[table.length*2]),0,table.length);
    //need to rehash the table to account for the new hash function/table size
    for(int i=0; i<oldtable.length; i++){
      //for every list in the old hash table, remove and hash all entries
      while(oldtable[i].size() > 0){
        insert(oldtable[i].remove(0).getKey());
      }
    }
  }
}
