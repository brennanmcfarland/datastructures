public class HuffmanNode implements Comparable<HuffmanNode>{

  public HuffmanNode left;
  public HuffmanNode right;
  Character inChar; //the character if a leaf node, otherwise null
  int frequency; //number of occurrences of all characters in subtree

  //initializes the node given a character, setting frequency to 1
  public HuffmanNode(Character ic){
    inChar = ic;
    frequency = 1;
    left = null;
    right = null;
  }
  public char hello(){
    return 'a';
  }
  //returns the character represented
  public Character getChar(){
    return inChar;
  }

  //returns the frequency
  public int getFrequency(){
    return frequency;
  }

  //sets the frequency
  public void setFrequency(int f){
    frequency = f;
  }

  //increments the frequency
  public void incrementFrequency(){
    frequency++;
  }

  //compares to another node's frequency
  public int compareTo(HuffmanNode o){
    return frequency-o.getFrequency();
  }
}
