
public class DoubleLinedList {
	public Link head;
	
	public DoubleLinedList() {
		head = null;
	}
	public void addData(int data){
		if(head == null) {
			head = new Link(null, data, null);
		} else{
			Link newLink = new Link(null, data, head);
			head.previous = newLink;
			head = newLink;
		}
	}
	public void printReverseList(){
		Link current = head;
		while(current.next != null){
			//System.out.println(current.getData());
			current = current.next;
		}
		while(current != null){
			System.out.println(current.getData());
			current = current.previous;
		}
	}
	public void printList(){
		Link current = head;
		while(current != null){
			System.out.println(current.getData());
			current = current.next;
		}
	}
	public static void main(String[] args) {
		DoubleLinedList dll = new DoubleLinedList();
		dll.addData(1);
		dll.addData(2);
		dll.addData(3);
		dll.addData(4);
		dll.printReverseList();
	}

}
