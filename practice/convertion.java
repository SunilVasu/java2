package practice;

public class convertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hex2decimal();
		decimal2hex();
		dec2binary();
		binary2dec();
	}
	public static void hex2decimal() {
		String hex = "3e8";
		String digits = "0123456789ABCDEF";
		hex = hex.toUpperCase();
		int val=0;
		for(int i=0;i<hex.length();i++) {
			char c = hex.charAt(i);
			int num = digits.indexOf(c);
			val=val*16+num;
		}
		System.out.println("hex2decimal:"+val);
	}
	public static void decimal2hex() {
		int d = 1000;
		String digits = "0123456789ABCDEF";
		String hex="";
		while(d>0) {
			int num=d%16;
			hex=digits.charAt(num)+hex;
			d=d/16;
		}
		System.out.println("decimal2hex:"+hex);
	}
	public static void dec2binary() {
		int d=20;
		String binary = new String();
		while(d>0) {
			binary = d%2+binary;
			d=d/2;
		}
		System.out.println("dec2binary:"+binary);
	}
	public static void binary2dec() {
		int bin = 101;
		int val=0, p=0;
		while(bin>0) {
			val= (int) (val + (bin%10)*Math.pow(2, p));
			p++;
			bin=bin/10;
		}
		System.out.println("binary2dec:"+val);
	}
}
