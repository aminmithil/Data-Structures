import java.util.HashSet;
import java.util.Set;

public class BinarySearchTree {
	
	public static Node root;
	private Set<Integer> heightsFound = new HashSet<>();
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
	
	public Node searchNode(int data){
		Node focusNode = root;
		
		while(focusNode.getData() != data){
			if(data < focusNode.getData())
				focusNode = focusNode.leftNode;
			
			else
				focusNode = focusNode.rightNode;
			
			if(focusNode == null)
				return null;
		}
		return focusNode;
	}
	
	public boolean deleteNode(int data){
		Node focusNode = root;
		Node parent = root;
		
		boolean isLeft = true;
		
		while(focusNode.getData() != data){
			parent = focusNode;
			
			if(data < focusNode.getData()){
				isLeft = true;
				focusNode = focusNode.leftNode;
			} else if(data > focusNode.getData()){
				isLeft = false;
				focusNode = focusNode.rightNode;
			}
			
			if(focusNode == null)
				return false;
		}
		
		if(focusNode.leftNode == null && focusNode.rightNode == null){
			if(focusNode == root)
				root = null;
			
			else if(isLeft)
				parent.leftNode = null;
			
			else
				parent.rightNode = null;
		}
		
		else if(focusNode.rightNode == null){
			if(focusNode == root)
				root = focusNode.leftNode;
			
			else if(isLeft)
				parent.leftNode = focusNode.leftNode;
			
			else
				parent.rightNode = focusNode.leftNode;
		}
		
		else if(focusNode.leftNode == null){
			if(focusNode == root)
				root = focusNode.rightNode;
			
			else if(isLeft)
				parent.leftNode = focusNode.rightNode;
			
			else
				parent.rightNode = focusNode.rightNode; 
		}
		
		else {
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root)
				root = replacement;
			
			else if(isLeft)
				parent.leftNode = replacement;
			
			else
				parent.rightNode = replacement;
			
			replacement.leftNode = focusNode.leftNode;
		}
		
		return true;
	}
	
	public Node getReplacementNode(Node replacementNode) {
		Node replacementParent = replacementNode;
		Node replacement = replacementNode;
		
		Node focusNode = replacementNode.rightNode;
		
		while(focusNode != null){
			replacementParent = replacement;
			replacement = focusNode;
			focusNode = focusNode.leftNode;
		}
		
		if(replacement != replacementNode.rightNode){
			replacementParent.leftNode = replacement.rightNode;
			replacement.rightNode = replacementNode.rightNode;
		}
		
		return replacement;
	}
	
	public int maxDepth(Node node){
		if(node == null)
			return 0;
		else {
			int leftDepth = maxDepth(node.leftNode);
			int rightDepth = maxDepth(node.rightNode);
			
			if(leftDepth > rightDepth)
				return leftDepth+1;
			else
				return rightDepth+1;
		}
	}
	public boolean isBalanced(Node node){
		return isBalanced(node, 0);
	}
	
	private boolean isBalanced(Node node, int curLevel) {
        if (node == null) return true;
        if (node.leftNode == null || node.rightNode == null) {
            for (Integer h : heightsFound) {
                if (Math.abs(curLevel - h) >= 1)
                    return false;
            }
            heightsFound.add(curLevel);
        }
        return isBalanced(node.leftNode, curLevel + 1) && isBalanced(node.rightNode, curLevel + 1);
    }
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		
		tree.addNode(8);
		tree.addNode(6);
		tree.addNode(11);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(12);
		tree.addNode(10);

		System.out.println(tree.maxDepth(root));
		
		/*				8
		 * 		6				11	
		 * 5		7		9		12
		 * 						10
		 */
	}
}
