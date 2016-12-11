
public class Link {
	private int data;
	public Link next;
	public Link previous;
	
	public Link(Link previous, int data, Link next) {
		this.previous = previous;
		this.data = data;
		this.next = next;
	}
	
	public int getData(){
		return data;
	}
}
