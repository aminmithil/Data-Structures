
public class SingleLinkedList {
	private Link head;
	
	public SingleLinkedList() {
		head = null;
	}
	public void addData(int data){
		Link link = new Link(data);
		if(head == null)
			head = link;
		else{
			link.next = head;
			head = link;
		}
	}
	public void removeData(){
		head = head.next;
	}
	public void printList(){
		Link tempList = head;
		while(tempList != null){
			System.out.println(tempList.getData());
			tempList = tempList.next;
		}
	}
	public static void main(String args[]){
		SingleLinkedList list = new SingleLinkedList();
		list.addData(1);
		list.addData(2);
		list.addData(3);
		list.addData(4);
		list.addData(5);
		list.addData(6);
		list.removeData();
		list.printList();
	}
}
