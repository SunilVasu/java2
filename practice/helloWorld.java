package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class helloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	public static void test() {
		String str = "Hello World! Hello!";
		List<String> list = Arrays.asList(str.split(" "));
		System.out.println(list.size());
		for(String n:list)
			System.out.println(n);
		
	}

}
