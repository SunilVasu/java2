package practice;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}
public class list {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		linkedList();
		removeSmallestNode();
		
		sum();
	}
	public static void linkedList() {
		Node temp=new Node(20);
		temp.next=new Node(15);
		temp.next.next=new Node(25);
		temp.next.next.next=new Node(20);
		Node root=temp;
		
		display(temp);
		root=removeNode3(root,15);
		System.out.println("After Update");
		display(root);
	}
	public static void display(Node n) {
		while(n!=null) {
			System.out.println(n.data);
			n=n.next;
		}
	}
	//remove nodes greater than x
	//cloudera submitted code
	public static Node removeNode(Node start, int x) {
		if(start==null) return start;
		if(start.data>x && start.next==null) return null;
		
		Node curr = start;
		Node prev = null;
		
		while(curr!=null && curr.data>x) {
			prev=curr;
			curr=curr.next;
		}
		if(prev!=null) prev.next=null;
		Node newHead = curr;
		while(curr.next!=null) {
			if(curr.next.data>x)
				curr.next=curr.next.next;
			else
				curr=curr.next;
		}
		return newHead;
	}
	//optimized
	public static Node removeNode3(Node start, int x) {
		Node dummy = new Node(0);
		dummy.next = start;
		Node curr = dummy;
		while(curr.next!=null) {
			if(curr.next.data>x)
				curr.next = curr.next.next;
			else
				curr=curr.next;
		}
		return dummy.next;
	}
	//remove duplicate elem from sorted list
	public static Node removeNode2(Node start, int x) {
		Node curr=start;
		while(curr!=null && curr.next!=null) {
			if(curr.data==curr.next.data)
				curr.next=curr.next.next;
			else
				curr=curr.next;
		}
		return start;
	}
	//cloudera
	public static void removeSmallestNode() {
		Node head = new Node(10);
		head.next = new Node(5);
		head.next.next = new Node(15);
		
		Node temp=head;
		Node smallest=head;
		Node prev=null;
		
		while(temp!=null) {
			if(temp.next!=null && temp.next.data<smallest.data) {
				smallest = temp.next;
				prev=temp;
			}
			temp=temp.next;
		}
		if(smallest==head)
			head = head.next;
		else
			prev.next=smallest.next;
		
		while(head!=null) {
			System.out.print("-"+head.data);
			head=head.next;
		}
	}
	public static void sum() {
		int[] arr = new int[] {5,10,15};
		System.out.println("\nSum:"+helper(arr,0));
	}
	public static int helper(int[] arr, int n) {
		if(n==arr.length)
			return 0;
		return arr[n]+helper(arr, n+1);
	}

}
