package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//계산기 프로그램
//사용자가 첫번재 정수를 입력하고
//+ - * / % 를 선택하고
//두번째 정수를 입력하면
//해당 기능에 맞춘 메소드가 실행되서 
//결과값을 화면에
//출력하게 만들어보세요

//예시
//첫번째 값을 입력해주세요: (1입력)
//연산자를 선택해주세요: +
//두번째 값을 입력해주세요: (100입력)
//결과값: 101

public class Ex04Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	public int sub(int a , int b) {
		return a - b;
	}
	public int mul(int a, int b) {
		return a * b;
	}
	public double avg(int a, int b) {
		return (double)a / b;
	}
	public int remainder(int a, int b) {
		return a % b;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Ex04Calculator mt = new Ex04Calculator();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("첫 번쨰 값을 입력해주세요 : ");
		int first = Integer.parseInt(br.readLine());
		
		System.out.println("연산자를 선택해주세요 : ");
		String op = br.readLine();
		
		System.out.println("두 번쨰 값을 입력해주세요 : ");
		int second = Integer.parseInt(br.readLine());
		
		while(true) {
			if(op.equals("+")) {
				System.out.print("결과 값 :");
				System.out.println(mt.add(first,second));
				break;
			}else if(op.equals("-")) {
				System.out.print("결과 값 :");
				System.out.println(mt.sub(first, second));
				break;
			}else if(op.equals("*")) {
				System.out.print("결과 값 :");
				System.out.println(mt.mul(first, second));
				break;
			}else if(op.equals("/")) {
				System.out.print("결과 값 :");
				System.out.println(String.format("%.2f", mt.avg(first, second)));
				break;
			}else if(op.equals("%")) {
				System.out.print("결과 값 :");
				System.out.println(mt.remainder(first, second));
				break;
			}else {
				System.out.println("잘못된 연산자 입니다. 다시 입력해주세요.");
				op = br.readLine();
				
			}
		
		}

		
		
	}

}
