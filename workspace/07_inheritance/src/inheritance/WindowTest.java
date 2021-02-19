package inheritance;

import java.awt.Color;
import java.awt.Frame; //Frame 클래스 import
import java.awt.Graphics;
//java.lang 은 JVM 이 알아서 찾아가지만 그 이외는 꼭! import를 해 주어야 한다.
public class WindowTest extends Frame {
	
	public WindowTest() {//구현
		//new Frame("제목 입력했습니다!").setVisible(true);
		//main 메소드의new WindowTest() 를통해 부모와 자식 생성자를 실행하게 되는데,
		// 위의 문장을 실행하게 되면 부모클래스의 생성자를 한번 더 실행하게됨
		//그렇게 되면 결과적으로 main 메소드 를 통해 부모클래스 1 번 자식클래스 1번 생성자 실행.
		// 그 후 WindowTest()생성자의  new Frame("제목 입력했습니다!")을 통해 부모 클래스의 생성자를 1번 실행
		//결과적 부모클래스2번실행 자식클래스 1번이 실행되게 되어 Frame 클래스의 생성자가 2번실행되었으므로
		//창이 두개가 생성되는 것임.
		
		// *super는 무조건 첫번째 줄에 사용해야함!!
		super("내가 만든 윈도우");//super를 사용하게 되면 부모생성자를 실행하게 될 때, super()로 인한 파라미터에 입력값이 들어가게됨.
		//궁금한것.
		//부모클래스의 생성자를 먼저 실행한 후 super 를 통해 자식클래스의 생성자를 실행할 때 super를 통해 파라미터 값을 넣어주게 되면 이미 부모생성자가 실행되고 난 후 여서 적용이 안되어야 하는 것 아닌가요? 그게 아니라면 super를 통해 부모생성자를 한번 더 실행해 주는건가요?
		//해결 : 우선 main 메소드에서 WindowTest() 를 실행 했으므로 자식 메소드인 WindowTest로들어온 후
		//부모 생성자를 실행하게 되는데 super를 만난 후 파라미터가 있는 생성자로 갈지, 없는 생성자로 들어갈 지 결정하게 됨,
		// 그래서 WindowTest() -> super -> Frame 생성자 실행 -> WindowTest 생성자 실행
		//단! super가 생성 된 경우 부모 생성자의 생성자를 이용하라는 말 이므로 바로 부모 생성자를 실행하면 된다.
		//만약 super 명령이 없더라도 super() 명령이 안쓰여진 것 뿐이므로 부모 생성자 -> 자식생성자 순으로 실행한다.
		
		System.out.println("도형");// System.in -> 키보드로 입력을 받음 System.out -> console 로 출력
		//그래서 위의 명령으로 윈도우 창에 도형 이란 글자를 내보낼 수 없는 것임.
		
		//Color c = new Color(126,222,86); // 이건 객체에 주소값을 저장하므로 메모리에 값이 잡히지만
		this.setBackground(new Color(126,222,86));//바탕색// 아래와 같이 사용하면 값을 저장하지않고 일회용으로 사용하게 되는것.
		
		setForeground(Color.yellow);
		
		//setSize(300,400);(int weight, int height)
		//setBounds(x의 위치, y의 위치 , 너비, 높이)
		this.setBounds(650,150,300,400);
		this.setVisible(true); //Visible 보이는, 가시성 (윈도우화면을 보이게 해라)
	}
	
	public void paint(Graphics g) {//구현
		//윈도우창 안에 무언가를 그리는 메소드
		g.drawString("도형", 100, 80); // (추출할 것 , x좌표, y좌표)
		
		//g.drawLine(x1, y1, x2, y2);
		g.drawLine(70, 120, 200, 300); 
		g.drawLine(200, 120, 70, 300);
		//g.drawRect(x, y, width, height);
		g.drawRect(220, 310, 70, 70);
		//g.drawOval(x, y, width, height);
		g.drawOval(220, 310, 70, 70);
		
	} //patint 메소드는 호출부가 없다. 
	// 이러한 것처럼
	// 일정한 시점이 되면 JVM에 의해서 호출되는 메소드 - Call Back 메소드
	// 우리가 알고 있는 메소드 중 main 메소드 또한 Call Back 메소드이다.
	// 실행시점(Ctrl + f11)이 되면 main 메소드를 실행한다.
	// paint 메소드는 setVisible(true) 라는 메소드가 실행될 때,
	// 그 시점에서 JVM 에 의해 자동 호출되어 실행이됨.
	
	public static void main(String[] args) {
		//WindowTest aa = new WindowTest(); 객체 aa 에 저장된 값의 주소를 저장
		new WindowTest(); // 값을 저장하지 않고 일회용사용
	}

}
