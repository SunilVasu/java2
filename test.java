import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		test t1 = new test();
		t1.testAdd();
	}
	@Test
	public void testAdd() {
		String s = "Hello";
		assertEquals("Hello", s);
		assertEquals("hello", s);
	}

}
