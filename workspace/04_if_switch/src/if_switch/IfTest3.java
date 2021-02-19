package if_switch;
/*
 3개의 숫자(a,b,c)를 입력받아서 작은 순서대로 출력하시오

[실행결과]
a : 68
b : 50
c : 45
45, 50, 68

a : 30
b : 50
c : 45
30, 45, 50
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest3 {

	public static void main(String[] args) throws IOException{
		
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int a ;
		System.out.print(" a: ");
		a = Integer.parseInt(br.readLine());
		
		int b ;
		System.out.print(" b: ");
		b = Integer.parseInt(br.readLine());
		
		int c ;
		System.out.print(" c: ");
		c = Integer.parseInt(br.readLine());
		
		if(a < b && a < c) 
		{//a가 가장 작다면
			if(b < c){
				System.out.println(a + "," + b+ "," + c);
			}else {
				System.out.println(a + "," + c+ "," + b);
			}
		
			
		}else if(b < c) 
		{//b가 가장 작다면
			if(a < c) {
				System.out.println(b + "," + a+ "," + c);
			}else {
				System.out.println(c + "," + a+ "," + b);
			}
		
			
		}else 
		{//c가 가장 작다면
			if(a < b) {
				System.out.println(c + "," + a+ "," + b);
			}else {
				System.out.println(c + "," + b+ "," + a);
			}
		
		}
	
	
	}
}
