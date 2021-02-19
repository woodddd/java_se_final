package method;

public class Operator {

	public static void main(String[] args) {

		int a = 0;
		a += 5; // a = a + 5
		a *= 2;
		a -= 3;
		System.out.println("a = " + a); // a = 7
		
		a++;
		System.out.println("a = " + a); // a = 8
		
		int b = a++; 
		// int b = a;
		// a++;
		//¶û °°Àº Çü½ÄÀÌ µÇ°Ô µÊ.
		System.out.println("a = " + a + "\tb = " + b); // a = 9  b = 8
		
		int c = ++a;
		//++a ; 
		//int c = a;
		System.out.println("a = " + a + "\tc = " + c); // a = 10 c = 10
		
		int d = ++a - b--;
//		++a;
//		int d = a - b;
//		b--;
		System.out.println("a = " + a + "\tb = " + b + "\td = " + d);// a = 11 b = 7 d = 3
		
		System.out.println("a++ = " + a++); // a = 11
		System.out.println("a = " + a); // a = 12
		
		System.out.println("a = " + a);// a= 12
		
		System.out.println("++a = " + ++a);// a = 13 
		
	}

}
