package testTree;

public class TreeTest {

	private Node root;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

	public TreeTest() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		}else{
		  if (data <= node.data) {
			node.left = insert(node.left, data);
		  }else{
			node.right = insert(node.right, data);
          }
		}
		return (node); // in any case, return the new pointer to the caller
	}
	
	public void buildTree( int [] data){
	      for ( int i=0;i<data. length ;i++){ 
	         insert(data[i]);
	      }  
	}
	
	public void printTree() { 
	      printTree( root ); 
	      System. out .println(); 
	} 

	private void printTree(Node node) { 
	      if (node == null ) return ; 
	      // left, node itself, right 
	      
	      printTree(node. left ); 
	      System. out .print(node. data + "  " );
	      printTree(node. right );
	       
	}
	
	public int getDepth(Node node){
	    int lDepth,rDepth;
	    if(node==null){
	    return 0;
	    }
	    lDepth=getDepth(node.left);
	    rDepth=getDepth(node.right);
	    return (lDepth>rDepth?lDepth:rDepth)+1;
	}
	
	public void getDeep() {
		System.out.println("deep: " + getDepth(root));
	}





	

}
