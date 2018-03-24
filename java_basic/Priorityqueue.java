package java_basic;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Priorityqueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		p_queue();
	}
	static class comparator implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg1.compareTo(arg0);
		}
		
	}
	public static void p_queue() {
		PriorityQueue<String> pQueue=new PriorityQueue<>(new comparator());
		pQueue.add("AA");
		pQueue.add("ZZ");
		pQueue.add("YY");
		pQueue.add("CC");
		pQueue.add("BB");
		
		
		for(String s:pQueue)
			System.out.println(s);
		
		Iterator itr = pQueue.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
