package abstractMethod;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame {
	
	public WindowTest() {
		
		
		
		
		setTitle("이미지");
		setBounds(900,100,500,500);
		setVisible(true);//(paint메소드를 실행하게 해주는 이벤트)
	}
	
	public void paint(Graphics g) { //현재 메소드를 아무곳에서도 호출하지 않음. callback 메소드
		//Toolkit t = new Toolkit();//Toolkit은 추상클래스라 생성이 불가
		//Toolkit t = Toolkit.getDefaultToolkit(); // 해당 메소드가 생성자대체
		//Image img = t.getImage("java.jpg");//1. 이미지 불러오기 // 이미지경로는 같은 프로젝트 내에 있어야함.
		//g.drawImage(img, 30, 100, this);//2. 이미지 그리기 // 현재 메모리에 생성해 놓은 주소값을 new WindowTest() 가 가지고 있으므로 이럴 때 new WindowTest() 를 가르키는 것을 this 라 한다. 
		
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage("java.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage("java.jpg"); //위의 두개를 합친것
		//               Toolkit클래스생성                   .     이미지를 얻어와라
		
		//이미지 작게
		g.drawImage(img,
				100,80,400,450,
				0,0,500,754,
				this);
		// 이미지 저장 객체
		// ? ? ? ?   화면크기
		// ? ? ? ?   이미지 크기
		// observer  그림이 그려질 대상 (WindowTest() 객체가 그림이 그려질 대상이 됨. 그래서 This)
		
		//거꾸로
		g.drawImage(img,
				100,80,400,450,
				500,754,0,0,
				this);
	}

	public static void main(String[] args) {
		new WindowTest(); //WindowTest() 라는 객체이름이 없는 객체를 생성하게됨
		
	}
 
}
