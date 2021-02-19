package abstractMethod;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {

	
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat(); // 추상클래스는 본인의 클래스로 new를 할 수 없어서 자식클래스를 이용!!
		//3자리마다, 찍어주고 소수이하 3째자리 까지 추출해줌.
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##원");
		//# - 소수점 이하의 숫자가 유효숫자가 아닌것은 표현하지 않는다.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		//0 - 강제로 표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); // NumberFormat nf = new DecimalFormat(); 서브클래스를 이용한 것과 동일한 결과가 나옴
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//￦로 표시(현재 설정된 운영체제에서의 나라 의 통화)
		nf4.setMaximumFractionDigits(2);//소수 이하 2째 자리까지 처리  // NumberFormat nf2 = new DecimalFormat("#,###.##원"); 랑 같은 결과 추출
		//.## 과 같은결과
		nf4.setMinimumFractionDigits(2);//소수 이하 2째 자리까지 강제로 0이 표시
		//.00 과 같은결과
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);//＄로 표시 (US통화)
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.JAPAN);//￥표시
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
	}
}
