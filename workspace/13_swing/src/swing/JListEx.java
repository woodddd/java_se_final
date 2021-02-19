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
		setLayout(new FlowLayout());//FlowLayout - ����� �߽����� ������ ������ ������.
		
		String[] listData = {"HONG","GIL","Dong","JAVA","JSP"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(1);//����(������)�� ù��° �ε����� �ִ� ������ �ٲ��.
		
		DefaultListModel<String> model = new DefaultListModel<String>();// �����͸� ����ش�.
		JList<String> list2 = new JList<String>(model);// JList�� �����ִ� ���Ҹ� ��.
		model.addElement("���");
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		list2.setSelectedIndex(1);
		
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸");
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		
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
			public String toString() {//new Student("100","ȫ�浿","�����") �� ���� ��ü������ �ϸ� ��ü �ּҰ��� ��ҷ� ����ǹǷ� toString�� ���� name�� ������ �� ��.
				return name;
			}
		}
		
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
	//	list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("100","ȫ�浿","�����"));
		model2.addElement(new Student("200","�տ���","�����"));
		model2.addElement(new Student("300","�����","����"));
		model2.addElement(new Student("400","���Ȱ�","�濵��"));
		list4.setSelectedIndex(1);
		
		
		
		
		add(list1);
		add(list2);
		add(scroll);
		add(list4);
		
		setBounds(300,200,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//JFrame â�� �⺻ x��ư�� ������ â�� ����� ���μ����� ��������� 
		//EXIT_ON_CLOSE �� �ϰԵǸ� ���μ����� ����ȴ�.
		//setDefaultCloseOperation�� JFrame�� x ��ư�� ������ �� �����ϱ� ���Ͽ� ����Ѵ�.
	}
	

	public static void main(String[] args) {
		new JListEx();
		
		
	}

}
