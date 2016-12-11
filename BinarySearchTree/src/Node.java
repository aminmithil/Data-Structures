
public class Node {
	private int data;
	public Node leftNode;
	public Node rightNode;
	
	public Node(int data){
		this.data = data;
		leftNode = null;
		rightNode = null;
	}
	
	public int getData(){
		return data;
	}
}
