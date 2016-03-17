import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;

public class HuffmanCompressor{
  public static void main(String []args){
    String test = huffmanCoder(args[0],args[1]);

    System.out.println("CREATING NODES:");
    LinkedList<HuffmanNode> testlist = generateNodes(args[0]);
    for(int i=0; i<testlist.size(); i++){
      System.out.println("Char " + testlist.get(i).getChar() + " Freq " + testlist.get(i).getFrequency());
    }
    System.out.println("BUILDING TREE:");
    HuffmanNode tree = buildTree(testlist);
    testtree(tree,0);
    System.out.println("TRAVERSING TREE:");
    traverse(tree,"", new LinkedList<HuffmanNode>());
  }

  private static void testtree(HuffmanNode root, int level){
    System.out.println("level " + level + " freq " + root.getFrequency() + " char " + root.getChar());
    if(root.left != null)
      testtree(root.left, level+1);
    if(root.right != null)
      testtree(root.right, level+1);
  }

  //
  public static String huffmanCoder(String inputFileName, String outputFileName){
    return "test";
  }

  //scans the input text file to generate the initial ordered list of nodes
  private static LinkedList<HuffmanNode> generateNodes(String inputFileName){
    LinkedList<HuffmanNode> nodes = new LinkedList<HuffmanNode>();

    try{
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int characterintrepresentation;
        char character;
        while((characterintrepresentation = reader.read()) != -1){
          character = (char)characterintrepresentation;
          boolean found = false; //keeps track of if the character node found
          //for every element in the LinkedList, if the node exists, increment frequency
          for(int i=0;i<nodes.size(); i++){
            if(nodes.get(i).getChar() == character){
              found = true;
              nodes.get(i).incrementFrequency();
              break;
            }
          }
          //if the node does not exist, create it
          if(found == false)
            nodes.add(new HuffmanNode(character));
          }
          reader.close();
        }
        catch(IOException exception){
          System.out.println("Error reading from file.");
        }
    //sort the list
    Collections.sort(nodes);
    return nodes;
  }

  //
  private static HuffmanNode buildTree(LinkedList nodes){

    //while not all the nodes are added
    while(nodes.size() > 1){
      //make a new node that is the parent of the first two nodes in the list
      HuffmanNode temp = new HuffmanNode(null);
      temp.left = (HuffmanNode)nodes.removeFirst();
      temp.right = (HuffmanNode)nodes.removeFirst();
      temp.setFrequency(temp.left.getFrequency()+temp.right.getFrequency());
      //and add it to the list in the appropriate position, preserving sort
      int index = 0;
      while(index < nodes.size() &&
      ((HuffmanNode)(nodes.get(index))).getFrequency() < temp.getFrequency())
        index++;
      nodes.add(index, temp);
    }
    //return the root node of the fully built tree
    return (HuffmanNode)nodes.get(0);
  }

  //traverse the Huffman tree to output the character encoding, path starts ""
  private static void traverse(HuffmanNode root, String path, LinkedList<HuffmanNode> encoding){
    if(root.left != null){
      traverse(root.left, path+"0", encoding);
    }
    if(root.right != null){
      traverse(root.right, path+"1", encoding);
    //if it's a leaf node, output the character
    }else if (root.left == null) {
      //need to make it a table, another class?
      System.out.println(path+root.getChar());
    }
  }

  //
  private static void huffmanEncode(){

  }
}
