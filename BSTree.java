import java.io.*;
import java.util.*;
class treeLinkedList{
    private Node count;
    private int tlCount;
    
    public treeLinkedList(){
    	//This empties the list and the reference to the count node and sets the new node with node data
    	count = new Node(null);
        tlCount = 0;
    }
    //This method adds the element at the end of the list
    public void toAdd(Object data){
        Node Data = new Node(data);
        Node listCount = count;

        while (listCount.getNext() != null){
        	listCount = listCount.getNext();
        }
        listCount.setNext(Data);
        tlCount++;
    }

    //This method returns the element at a designated position from the list
     public Object get(int nodeindex){
        if (nodeindex <= 0)
            return null;
        Node listCount = count.getNext();
        for (int i = 1; i < nodeindex; i++){
            if (listCount.getNext() == null)
                return null;
            listCount = listCount.getNext();
        }
        return listCount.getData();
    }

     private class Node{
        Node nextData;
        Object data;
       public Node(Object storeValue){
    	   nextData = null;
            data = storeValue;
        }
     //This constructor specifies the node to point
        public Node(Object storeValue, Node nextValue){
        	nextData = nextValue;
            data = storeValue;
        }

     //This method returns the data
        public Object getData(){
            return data;
        }
     //This method stores the value
        public void setData(Object storeValue){
        	data = storeValue;
        }
     //This method gets the next value
        public Node getNext(){
            return nextData;
        }
     //This method sets the next value
        public void setNext(Node nextValue){
        	nextData = nextValue;
        }
    }
}
public class BSTree{
     private Node rt;
       	private static class Node{
              Node pt;
              Node lt;
              Node rt;
              int data;

              Node(int data){
                   this.data = data;
              }
              @Override
              //This method returns the data
              public String toString( ){
                   return "" + data;
              }
          }
          //This method inserts the data into a tree
          public void insertData(int data){
              rt = insertData(rt, data);
          }

          public Node insertData(Node node, int data) {
              if(node == null){
                   node = new Node(data);
              } 
              else if(data < node.data){
                   node.lt = insertData(node.lt, data);
                   node.lt.pt = node;
              } 
              else{
                   node.rt = insertData(node.rt, data);
                   node.rt.pt = node;
              }
              return node;
          }
          //This method does the in-order traversal of the tree data
          public void infixRecursive( ){
        	  infixRecursive(rt);
          }

          private void infixRecursive(Node node){
              if( node != null ){
            	  infixRecursive(node.lt);
                   System.out.print(node.data + " ");
                   infixRecursive(node.rt);
              }
          }
          //Main method
          public static void main(String[ ] args){
        	  treeLinkedList lList = new treeLinkedList();
              BSTree bst = new BSTree( );
              Random ranGen = new Random();
              int val;
             
              //This adds elements into the BS Tree LinkedList
              for(int i = 1; i <= 50; i++){
                   lList.toAdd(1 + ranGen.nextInt(99 - 1));
              }
              //This prints out the random BS Tree elements
              System.out.println("Binary Search Tree LinkedList Elements: ");
              for( int i = 1; i <=50; i++){
                   val=(int)lList.get(i);
                   if(i<50)
                        System.out.print(val+",");
                   else
                             System.out.println(val);
                   bst.insertData(val);
              }        
             System.out.println(" ");
              //This prints out the sorted BS Tree elements
              System.out.println("Binary Search Tree Sorted Elements: ");
              bst.infixRecursive( );                     
          }
}