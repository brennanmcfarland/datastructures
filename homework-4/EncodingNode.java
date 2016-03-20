/*this class just holds the input character and output encoding for a character,
similar to the huffmannode but more stripped down to streamline the actual
compression*/
public class EncodingNode{
  public Character inChar;
  public String encoding;

  public EncodingNode(Character ic, String e){
    inChar = ic;
    encoding = e;
  }
}
