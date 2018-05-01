package java_basic;

class Queue2{
	class Node{
		int val;
		Node next;
		Node(int val){
			this.val=val;
			next=null;
		}
	}
	Node front, rear;
	void enqueue(int item) {
		Node temp = new Node(item);
		if(rear==null) {
			front=rear=temp;
		}else {
			rear.next=temp;
			rear = temp;
		}
		System.out.println(item+" enqueued");
	}
	int dequeue() {
		if(front==null)
			throw new IndexOutOfBoundsException("Queue is empty");
		Node temp = front;
		front=temp.next;
		if(front==null)
			rear=null;
		return temp.val;
	}
}
public class test_queue2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue2 queue = new Queue2();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		System.out.println(queue.dequeue()+" dequeued");
		System.out.println(queue.dequeue()+" dequeued");
		System.out.println(queue.dequeue()+" dequeued");
		
	}

}
