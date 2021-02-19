package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class JListEx extends JFrame{
	
	public JListEx() {
		super("JList Test");
		setLayout(new FlowLayout());//FlowLayout - 가운데를 중심으로 옆으로 나란히 나열됨.
		
		String[] listData = {"HONG","GIL","Dong","JAVA","JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);//초점(포지션)을 첫번째 인덱스에 있는 값으로 바꿔라.
		
		DefaultListModel<String> model = new DefaultListModel<String>();// 데이터를 담아준다.
		JList<String> list2 = new JList<String>(model);// JList는 보여주는 역할만 함.
		model.addElement("사과");
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		list2.setSelectedIndex(1);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("육상");
		vListData.add("태권도");
		vListData.add("유도");
		
		class Student{
			String id;
			String name;
			String department;
			public Student(String id, String name, String department) {
				this.id = id;
				this.name = name;
				this.department = department;
			}
			
			@Override
			public String toString() {//new Student("100","홍길동","전산과") 과 같이 객체생성을 하면 객체 주소값이 요소로 저장되므로 toString을 통해 name을 추출해 준 것.
				return name;
			}
		}
		
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
	//	list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("100","홍길동","전산과"));
		model2.addElement(new Student("200","손오공","건축과"));
		model2.addElement(new Student("300","사오정","토목과"));
		model2.addElement(new Student("400","저팔계","경영과"));
		list4.setSelectedIndex(1);
		
		
		
		
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		
		setBounds(300,200,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//JFrame 창의 기본 x버튼을 누르면 창을 숨기고 프로세스는 살아있지만 
		//EXIT_ON_CLOSE 를 하게되면 프로세스가 종료된다.
		//setDefaultCloseOperation은 JFrame의 x 버튼을 눌렀을 때 제어하기 위하여 사용한다.
	}
	

	public static void main(String[] args) {
		new JListEx();
		
		
	}

}
