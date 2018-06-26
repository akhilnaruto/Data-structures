package BinaryTrees;

public class Tree {
  private  Node root;
  
  private  LogHelper logHelper;
  
  public Tree(LogHelper logHelper){
	  this.logHelper = logHelper;
  }
  
  public Node findNode(int key){
	  Node current = root;
	  while(current.iData != key){
		  if(key > current.iData){
			  current = current.rightNode;
		  }else{
			  current = current.leftNode;
		  }
		  
		  if(current == null){
			  return null;
		  }
	  }	
	  return current;
  }
  
  public void insertNode(int key, double data){
	  Node newNode = new Node(key, data);
	  
	  Node current = root;
	  Node lastSeenNotNullNode = null;  
	  if(current == null){
		  root = newNode;
		  return;
	  }
	  while(true){
		  lastSeenNotNullNode = current;
		  logHelper.logNode(lastSeenNotNullNode);
		  if(key >= current.iData){ // go to right
			  current = current.rightNode;
			  if(current == null){
				  lastSeenNotNullNode.rightNode = newNode;
				  logHelper.logForRightNode(newNode, lastSeenNotNullNode);
				  return;
			  }		  
		  }else{ // go to left
			  current = current.leftNode;
			  if(current == null){
				  lastSeenNotNullNode.leftNode = newNode;
				  logHelper.logForLeftNode(newNode, lastSeenNotNullNode);	     
				  return;
			  }
		  }	  
		  
	  }
  }
  
  public void deleteNode(int key){
	  
  }
  
  public void emptyTree(){
	  root = null;
  }
  
  public void setLogHelper(LogHelper logHelper){
	  this.logHelper = logHelper;
  }
    
}
