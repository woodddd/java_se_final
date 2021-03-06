 package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowTest extends Frame implements ActionListener,MouseListener,MouseMotionListener{
	//자바 클래스는 단일 상속만 된다.
	//다른 클래스로부터 뭔가 받고싶으면 interface 를 사용해야한다.
	
	private Button exitBtn;
	
	public void init() {
		
		exitBtn = new Button("종료"); //버튼 생성
		this.add("North", exitBtn); //배치 (위치, ..) 위치에 들어가는 값에 따라 버튼위 위치가 달라짐 
		//동쪽 - East , 서쪽 - West , 남쪽 - South , North - 북쪽
		
		setBounds(900,100,300,400);
		setVisible(true);//창을 띄워주세요.
		
		//이벤트
		//이벤트 발생 -> 아래의 문장으로 어디서 어떤 메소드가 발생하여 메소드가 어느 위치에 있는지 찾고
		//그 후  메소드를 실행하게 됨.
		this.addMouseListener(this); // CallBack 메소드를 자바 가상머신(JVM)에게 던져줌. 이벤트 주체가 나에게 있기 때문에 this.addMouseListener(this);(괄호 안에는 해당 메소드가 있는 위치를 자바가상머신에게 알려줘야함)
		this.addMouseMotionListener(this);//(this) 의 의미.  MouseMotionListener 에 해당하는 추상클래스의 구현부를 내(main메소드에서 new 생성한 현재객체)가 가지고 있다.
		//누가(어디서) 이벤트 발생 위치. 어떤 클래스의 메소드에서 발생하게할 것인지 추가. (EvendHandler의 위치) 어디서 발생할 것이냐.(add메소드 실행 위치)
		//          this        .       add....                  . (위치) 
		this.addWindowListener(new WindowExit()); // WindowListener 를 가지고 있는 건 WindowExit 클래스의 객체 이므로 WindowListener의 오버라이딩한 메소드가 존재하는 위치를 말해준 것임.
		exitBtn.addActionListener(this); // 종료버튼에서 이벤트가 발생하면. actionPerformed 가 실행되고. 메소드의 저장 위치는 현재 객체 내에 있다.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//윈도우창의 종료 버튼이 click될 시 실행됨
		System.exit(0); //프로그램 종료. console에 빨간색 네모 박스를 생각하면됨.(프로세스종료)
		
	}
	
	//Interface 인 MouseListener 의 추상메소드를 모두 오버리이딩.
	//오버라이딩 된 메소드를 내가 정의해서 사용해야함.
	// interface 의 추상 메소드 이기 때문에 interface는 틀만 제공을 하기 때문.
	
	// 여기에서 사용된 추상메소드 들은 전부 Call Back 메소드임. 호출을 하지 않고 어떠한 이벤트가 발생할 메소드를 자동 실행하게됨.
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {//들어가다(윈도우창 안으로)
		System.out.println("마우스 IN");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {//나가다(윈도우창 밖으로)
		System.out.println("마우스 OUT");
		
	}

	//Interface 인 MouseMotionListener 의 추상메소드를 모두 오버리이딩.
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("마우스 드래그");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {

		new WindowTest().init();//일회용 객체 생성.메소드 사용
		
	}



}
