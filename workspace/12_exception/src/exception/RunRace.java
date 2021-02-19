package exception;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Runas - Run Configurations - arguments 
//arguments
// 말 마릿수  + " " + 말이름1 + 말이름2 + 말이름3 .....

//Frame - BorderLayout(동서남북)
public class RunRace extends Frame implements ActionListener{
	private Button btn;
	private int count;
	private Racer[] r;
	
	public RunRace(String[] args) {
		
		btn = new Button("출발");
		count = Integer.parseInt(args[0]);		
		r = new Racer[count];
		
		for(int i = 0; i < count ; i++) {
			r[i] = new Racer(args[i+1]);//Run as 의 args[0]에 말의 수를 입력하고 1번인덱스부터 이름을 입력함.
		}
		
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));// FlowLayout스타일로 작성을 할 것이다.순차적 레이아웃. RIGHT - 우측정렬로 할 것이다
		p.add(btn); //패널에 버튼을 올리고
		add("South", p); // 프레임 위에 패널을 올른 후 남쪽으로 패널을 몰을 것이다. Frame 의 기본값인 Border Layout 동/서/남/북 스타일로 현재 남쪽에 패널을 삽입 후 패널은 우측 정렬을 기준으로 작성하였다.
 
		Panel p2 = new Panel(new GridLayout(count,1));//말 마릿수만큼 패널을 나눔
		for(int i = 0; i < count; i ++) {
			p2.add(r[i]);//패널에 Racer객체를 말 마릿수만큼 올림.
			//결국 Frame 위에 말 마릿수만큼의 Canvas가 올라간 것임.
		}
		add("Center",p2);//GridLayout 을 이용하여 count 칸 1열의 형식으로 Frame의 Center영역을 나눠줌

		setResizable(false);
		setBounds(700,200,600,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//버튼의 이벤트
		btn.addActionListener(this);//버튼에 대한 이벤트가 들어오면 actionPerFormed 메소드를 실행하여 버튼을 비활성화 시킴
		
	}//RunRace

	
	//ActionListener 추상메소드 오버라이딩
	@Override
	public void actionPerformed(ActionEvent e) {
		//출발 버튼이 눌리면 출발 버튼을 비활성화
		btn.setEnabled(false);//버튼을 비활성화 하겠다.
		Thread[] t = new Thread[count];
		for(int i = 0 ; i < count ; i++) {
			t[i] = new Thread(r[i]);// 스레드 생성 ( ) 안에는  Thread대상이 들어감
			t[i].setPriority((int)(Math.random() * 10 + 1));// 우선순위를 1~10 사이로 무작위로 넣어줌
			//만약 run() 의 for 문에서 i가 일정하게 증가한다면 우선순위가 높은 스레드가 확률적으로 먼저 실행이 되어 값이 더 커지는 것을 보려고 한 것임.
			//스레드는 병행 처리를 하기 때문에 다중 스레드가 실행되면 우선순위가 높은 스레드를 확률적으로 더 먼저 실행하게 되어있음. 하지만 우선순위가 높다고 무조건 먼저 실행되는 것은 아님.
			t[i].start();//스레드 시작 - 스레드 실행(운영체제가 run() 을 찾아감)
		}//for
	}//actionPerformed

	public static void main(String[] args) {
		if(args.length < 2 ) {
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}
		if(Integer.parseInt(args[0]) != args.length -1) {
			System.out.println("말 마리수와 이름의 개수가 맞지 않습니다.");
			System.exit(0);
		}
		new RunRace(args);
	}


	
}
