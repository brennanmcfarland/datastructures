import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Integer;

public class HuffmanCompressor{
  static ArrayList<EncodingNode> encoding;

  //all main does is call the huffmanCoder method with the program inputs
  public static void main(String []args){
    System.out.println(huffmanCoder(args[0],args[1]));
  }

  //a method that tests the organization of the tree, prints the level, char and frequency
  private static void testtree(HuffmanNode root, int level){
    System.out.println("level " + level + " freq " + root.getFrequency() + " char " + root.getChar());
    if(root.left != null)
      testtree(root.left, level+1);
    if(root.right != null)
      testtree(root.right, level+1);
  }

  //main encoding method, calls helper methods one by one to compress inputFile
  //to outputFile via Huffman encoding, returns error or completion message
  public static String huffmanCoder(String inputFileName, String outputFileName){
    encoding = new ArrayList<EncodingNode>();
    ArrayList<HuffmanNode> nodelist = generateNodes(inputFileName);
    if(nodelist == null)
      return "Error generating nodes.  Check the input file.";
    HuffmanNode tree = buildTree(nodelist);
    traverse(tree,"");
    if(huffmanEncode(inputFileName,outputFileName) == false)
      return "Error encoding the file.";
    return "The file has been encoded.";
  }

  //scans the input text file to generate the initial ordered list of nodes
  private static ArrayList<HuffmanNode> generateNodes(String inputFileName){
    //i chose to use an array list because it allows for quicker random access,
    //which is useful when manipulating the nodes for actual encoding
    ArrayList<HuffmanNode> nodes = new ArrayList<HuffmanNode>();
    try{
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        int characterintrepresentation;
        char character;
        //creates the list of nodes by scanning through the input file
        while((characterintrepresentation = reader.read()) != -1){
          character = (char)characterintrepresentation;
          boolean found = false; //keeps track of if the character node found
          //for every element in the ArrayList, if the node exists, increment frequency
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
        //will return an error message in the calling method if something goes wrong
        //with reading the file
        catch(IOException exception){
          return null;
        }
    //sort the list
    Collections.sort(nodes);
    return nodes;
  }

  //given a list of nodes, builds it into a tree, returning the root
  private static HuffmanNode buildTree(ArrayList nodes){
    //while not all the nodes are added to the tree
    while(nodes.size() > 1){
      //make a new node that is the parent of the first two nodes in the list
      HuffmanNode temp = new HuffmanNode(null);
      temp.left = (HuffmanNode)nodes.remove(0);
      temp.right = (HuffmanNode)nodes.remove(0);
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

  //traverse the Huffman tree to output the character encoding, path starts a blank string
  //returns a list of nodes with characters and their respective encodings
  private static ArrayList traverse(HuffmanNode root, String path){
    //recursively get to the leaf nodes, appending 1s and 0s to the path for going
    //right + left
    if(root.left != null){
      traverse(root.left, path+"0");
    }
    if(root.right != null){
      traverse(root.right, path+"1");
    //if it's a leaf node, add a node with the character and encoding to the
    //encoding list for encoding, then output it
    }else if (root.left == null) {
      encoding.add(new EncodingNode(root.getChar(),path));
      System.out.println(encoding.get(encoding.size()-1).inChar + ": " + root.getFrequency()
      + ": " + encoding.get(encoding.size()-1).encoding);
    }
    return encoding;
  }

  //given the previously determined encoding, takes an input file and transforms
  //it to an encoded file, returning true if it works
  private static boolean huffmanEncode(String inputFileName, String outputFileName){
    int inputsize = 0; //the number of bits in the input file
    int outputsize = 0; //the number of bits in the output file
    try{
      BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
      int characterintrepresentation;
      char character;
      //encode character by character, incrementing the input and output sizes accordingly
      while((characterintrepresentation = reader.read()) != -1){
        character = (char)characterintrepresentation;
        for(int i=0; i<encoding.size(); i++){
          if(character == encoding.get(i).inChar){
            writer.write(encoding.get(i).encoding);
            inputsize = inputsize+8;
            outputsize = outputsize+encoding.get(i).encoding.length();
            break;
          }
        }
      }
      reader.close();
      writer.close();
    }
    //will trigger an error message in the calling method
    catch(IOException exception){
      return false;
    }
    //print compression in bytes and return that it worked
    System.out.println("Compression: " + (inputsize-outputsize) +
    " bytes of space saved");
    return true;
  }
}
