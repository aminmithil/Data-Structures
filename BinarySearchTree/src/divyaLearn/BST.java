package divyaLearn;

public class BST {

	public Node root;
	
	BST(){
		root = null;
	}
	
	public void addData(int data){
		Node newNode = new Node(data);
		
		if(root == null)
			root = newNode;
		else{
			Node focusNode = root;
			
			Node parent;
			while(true){
				parent = focusNode;
				if(data < focusNode.getData()){
					focusNode = focusNode.leftNode;
					
					if(focusNode == null){
						parent.leftNode = newNode;
						return;
					}
				} else if(data > focusNode.getData()){
					focusNode = focusNode.rightNode;
					
					if(focusNode == null){
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST tree = new BST();
		
		tree.addData(20);
	}

}
