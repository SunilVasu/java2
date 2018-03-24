
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		Set<Integer> set = new HashSet<>();
		set.add(1);
		
		System.out.println(set.add(1));
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek());
		//fibin
		int n=5;
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibin(i));
		}
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibinIter(i));
		}
	}
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	//Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
	public static int fibin(int n) {
		if(n==0||n==1) return n;
		return fibin(n-1)+fibin(n-2);
	}
	public static int fibinIter(int n) {
		if(n==0||n==1) return n;
		int a=0, b=1, z=0;
		for(int i=2;i<=n;i++) {
			z=a+b;
			a=b;
			b=z;
		}
		return z;
	}

}
