package abstractMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/*
년도 입력 : 2002
월 입력 : 10   

일	월	화	수	목	금	토
	1   2   3   4   5	6
7   8   9   10  11  12	13
14  15  16  17  18  19	20
21  22  23  24  25  26	27
28  29  30  31

기본생성자 - 년도, 월 입력
calculator() - 매달 1일이 무슨 요일로 시작?, 매달 끝나는 일?
display() - 출력
 */

public class CalendarMain {
	
	private int year;
	private int month;
	private int week;
	private int lastDay;
	public CalendarMain() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력: ");
		year = Integer.parseInt(br.readLine());
		System.out.print("월 입력: ");
		month = Integer.parseInt(br.readLine());
	}
	
	public void calculator() {
		Calendar cal = Calendar.getInstance(); //클래스 생성 calendar 클래스는 추상클래스이므로 직접적으로 new 할 수 없음.
		
		//시간의 기준이 필요.
//		cal.set(Calendar.YEAR,year);
//		cal.set(cal.MONTH, month - 1);
//		cal.set(cal.DAY_OF_MONTH,1); //DAY_OF_MONTH (한달중에 일) 
		//(cal.DAY_OF_MONTH,1) 한달중에 시작일을 1일로 바꾸겠다.
		
		cal.set(year, month -1 , 1);// 1일
		week = cal.get(cal.DAY_OF_WEEK); // 1일이 무슨 요일로 시작 하는지 추출
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // 매달 끝나는 일 .(getActualMaximum - 월중에서 가장 큰값을 호출)
		
		System.out.println("week = " + week);
	}
	
	public void display() {
	System.out.println("일\t월\t화\t수\t목\t금\t토");
	
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		
		for(int i = 1; i <=lastDay; i++) {
			System.out.print(i + "\t");
			
			if(week%7==0) {
				System.out.println();
			}
			week++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		CalendarMain cm = new CalendarMain();
		cm.calculator();
		cm.display();
		
		
		
		
	}

}
