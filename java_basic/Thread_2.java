package java_basic;

public class Thread_2 implements Runnable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//If not extending the Thread class,the class object would not be treated as a thread object.
		//So need to explicitely create Thread class object. We pass the object of the class that implements Runnable 
		//so that the class run() method may execute.
		Thread_2 o1 = new Thread_2();
		Thread t1 = new Thread(new Thread_2());
		Thread t2 = new Thread(new Thread_2());
		t1.start();
		t2.start();
		//t1.stopRunning();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread running");
		for(int i=0;i<=5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
