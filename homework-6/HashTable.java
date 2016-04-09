import java.util.ArrayList;

public class HashTable{
  ArrayList<Item>[] table;
  int size; //the # entries in the hash table, not the capacity in slots

  //initialize the hash table
  public HashTable(){
    table = (ArrayList<Item>[])new ArrayList[64]; //64 is the default capacity
    //each entry needs an empty list initialized
    for(int i=0; i<table.length; i++)
      table[i] = new ArrayList<Item>();
    size = 0;
  }

  //return the size of the hash table in # entries
  public int size(){
    return size;
  }

  //return the capacity of the hash table in # table slots
  public int capacity(){
    return table.length;
  }

  //formats the entries in the hash table to a string array, each element is a hash element
  public String[] toStringArray(){
    //the size is an array, more efficient, size is calculated to fit or exceed
    //the hash
    String[] tablestrings = new String[size*(getAvgListSize()+1)];
    //for each hash slot, check if occupied and if so copy the list to string array
    //each list becomes a string in tablestrings[]
    int numstrings=0;
    for(int i=0; i<table.length; i++){
      if(table[i].size() > 0){
        tablestrings[numstrings] = "";
        for(int j=0;j<table[i].size();j++){
          tablestrings[numstrings] += table[i].get(j).toString();
        }
      numstrings++;
      }
    }
    //trim the array so there's no null entries that might have been generated
    //when estimating the size
    String[] newtablestrings = new String[numstrings];
    System.arraycopy(tablestrings,0,newtablestrings,0,numstrings);
    return newtablestrings;
  }

  //returns the average length of the collision lists across all hash slots
  //(including empty ones)
  public int getAvgListSize(){
    return size/table.length;
  }

  //inserts an entry into the hash table
  public void insert(String key){
    int hashCode = key.hashCode();
    //if it already exists in the list, increment the # occurences, if not, create it
    for(int i=0; i<table[Math.abs(hashCode)%table.length].size(); i++){
      if(table[Math.abs(hashCode)%table.length].get(i).key.equals(key)){
        table[Math.abs(hashCode)%table.length].get(i).addOccurence();
        return;
      }
    }
    table[Math.abs(hashCode)%table.length].add(new Item(key));
    size++;
    //grow the hash table if needed
    //i decided to grow the hash table when the average list size gets longer
    //than 3 to keep the hashing fast, ie, as close to O(1) as possible, without
    //spending too much time rehashing all the time
    if(getAvgListSize() > 3)
      growTable();
  }

  //double the capacity of the hash table when it is full
  private void growTable(){
    //copy the old table and make a new one to put the rehashed entries in
    ArrayList<Item>[] oldtable = table;
    table = (ArrayList<Item>[])new ArrayList[table.length*2];
    for(int i=0; i<table.length; i++)
      table[i] = new ArrayList<Item>();
    //need to rehash the table to account for the new hash function/table size
    for(int i=0; i<oldtable.length; i++){
      //for every list in the old hash table, remove and hash all entries
      while(oldtable[i].size() > 0){
        String tempkey = oldtable[i].remove(0).getKey();
        insert(tempkey);
      }
    }
  }
}
