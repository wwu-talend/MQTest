package testTree;

public class Test {
	public static void main(String[] args) {

		TreeTest biTree=new TreeTest(); 

		       int[] data={ 3, 20, 9, 13, 15,8}; 

		       biTree.buildTree(data); 

		       biTree.printTree();
		       
		       biTree.getDeep();


	}

}
