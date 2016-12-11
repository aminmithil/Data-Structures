
public class BinarySearchTree {
	
	public static Node root;
	
	public void addNode(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
		} else {
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
				} else {
					focusNode = focusNode.rightNode;
					
					if(focusNode == null){
						parent.rightNode = newNode;
						return;
					}
				}
			}
		}
	}
	
	public void inOrderTraverse(Node focusNode){
		if(focusNode != null){
			inOrderTraverse(focusNode.leftNode);
			System.out.println(focusNode.getData());
			inOrderTraverse(focusNode.rightNode);
		}
	}
	
	public void preOrferTravere(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode.getData());
			
			preOrferTravere(focusNode.leftNode);
			preOrferTravere(focusNode.rightNode);
		}
	}
	
	public void postOrderTraverse(Node focusNode){
		if(focusNode != null){
			postOrderTraverse(focusNode.leftNode);
			postOrderTraverse(focusNode.rightNode);
			
			System.out.println(focusNode.getData());
		}
	}
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.addNode(10);
		tree.addNode(15);
		tree.addNode(8);
		tree.addNode(5);
		tree.addNode(9);
		tree.addNode(11);
		tree.addNode(16);
		tree.preOrferTravere(root);
	}

}