import edu.odu.cs.cs251.linkedlist.SinglyLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		
		list.add("Hello");
		System.out.println(list.get(0));
		list.add("Hi");
		System.out.println(list.size());
		list.insert("testing", 1);
		System.out.println(list.get(1));
		System.out.println(list.remove(0));
		list.set("Reset", 1);
	}

}
