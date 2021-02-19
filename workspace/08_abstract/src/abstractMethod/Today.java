package abstractMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {

	public static void main(String[] args) throws InterruptedException, ParseException {
		Date date = new Date();
		System.out.println("오늘날짜 : " + date );
	
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 hh:mm:ss");
		System.out.println("오늘날짜 : " + sdf.format(date));
		System.out.println();
		
		//입력 - 내생일 yyyyMMddHHmmss
		//예)       19910713161505
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910713161505"); //String -> Date 형으로 변환

		System.out.println("내생일 = " + birth);
		System.out.println("내생일 = " + sdf.format(birth));
		System.out.println();
		
		//Calendar 클래스의 메소드들을 가져오는 방법. 자식클래스를 new 하여 부모클래스 생성자 이용!(Calendar의 자식클래스는 GregorianClaendar
		//Calendar 를 생성하면 시스템의 현재 시간만 얻어온다.
		//Calendar cal = new Calendar(); //- Calendar 는 추상클래스이기 떄문에 new 로 생성할 수 없음.
		//Calendar cal = new GregorianCalendar(); //Sub Class를 이용하여 생성
		//Calendar를 생성하면 현재 시간만 얻어온다
		
		Calendar cal = Calendar.getInstance(); //메소드 이용하여 생성
		//getInstance 메소드는 자체적으로 new Calendar 를 제공하기 때문에 직접 생성자를 이용할 필요가 없음
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;// 1월 -> 0, 2월 -> 1
 		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일요일 -> 1, 월요일 ->2
		
		String dayOfWeek = null;
		switch(week) {
		case 1 : dayOfWeek = "일요일";
		break;
		case 2 : dayOfWeek = "월요일";
		break;
		case 3 : dayOfWeek = "화요일";
		break;
		case 4:  dayOfWeek = "수요일";
		break;
		case 5 : dayOfWeek = "목요일";
		break;
		case 6 : dayOfWeek = "금요일";
		break;
		case 7 : dayOfWeek = "토요일";
		break;
		}
		
		System.out.println("오늘날짜 : " + year + "년" + month + "월" + day + "일" + dayOfWeek);
	}
}
