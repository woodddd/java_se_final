package io;


import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener,WindowListener {
	private JTextArea output;
	private MenuPane menu;
	private File file;
	private File inputfile;
	
	
	public TryNotepad() {
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//수직방향의 스크롤바를 항상 띄워준다.
		
		menu = new MenuPane();
		this.setJMenuBar(menu); // MenuBar를 생성하고 menu 객체를 참조하게 한다.
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		
		setBounds(700,200,500,300);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// x버튼을 눌렀을 떄, 프레임을 종료하지 않고 ActionPerform가 실행됨
		
		setTitle("간단메모장");
		
		
		//이벤트
		addWindowListener(this);
		
		
		
		
	}//new TryNotepad()
	
	public void event() {
		//이벤트
		
		//fileM 에 대한 이벤트
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		
		//edit에 대한 이벤트
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menu.getNewM()) {
			output.setText("");
		}else if(e.getSource() == menu.getOpenM()) {
			openDialog();
			//fileRead();
		}else if(e.getSource() == menu.getSaveM()) {
			saveDialog();
			fileWriter();
		}else if(e.getSource() == menu.getExitM()) {
			int result = JOptionPane.showConfirmDialog(this, "저장히시겠습니까?","종료",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION) {
				saveDialog();
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
		}else if(e.getSource() == menu.getCutM()) {
			output.cut();
		}else if(e.getSource() == menu.getCopyM()) {
			output.copy();
		}else if(e.getSource() == menu.getPasteM()) {
			output.paste();
		}
		
	}

	

	public void fileRead() {
		output.setText(""); //파일을 읽어올 때, 기존 파일에 있었던 내용을 초기화 하고 내용을 읽어와야함.
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));//문자 기반 스트림
			String line;
			
			while((line = br.readLine()) != null) {//한줄씩 데이터를 읽어오는데 만약 읽을 데이터가 없다면 null이 나옴.
				//readLine은 엔터를 읽지 않고 엔터 바로 앞까지 읽어옴!!!
				//output.setText(line); // - 덮어쓰기 output에 값을 받고 또 output 에 값을 받고, 또받고 덮어쓰기형식으로 값을 받는다.
				output.append(line + "\n");//append를 하게되면 엔터치기 전까지의 데이터를 읽어와서 한줄에 쭉 입력하기 때문에 중간에 엔터친 부분이 있다면 \n을 통해서 줄바꿈을 해 준것임
			}//while
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//						BufferedReader						FileReader
	//TryNotepad.java <------------------------- buffer <------------------------- 선택한 파일
	
	public void openDialog() {
		//File file = null; //파일 초기화, 지역변수는 초기화를 하지 않으면 쓰레기값이 들어가있음
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);//showOpenDialog(null)로 지정을 해주면 창이 따로 뜨게 된다.
		if(result == JFileChooser.APPROVE_OPTION) { //확인버튼을 눌러주면 선택한 파일을 file 에 저장하겠다.
			file = chooser.getSelectedFile();// 사용자가 선택한 파일 이름, 파일 경로명, 디렉토리명 등 정보가 남아있으며, 다이얼로그가 사라져도 이 정보를 file 객체에 저장했으므로 이용 가능하다.
			fileRead();//파일 내용을 읽어오기.
		}
		JOptionPane.showMessageDialog(this, file); //file의 위치가 현재 Frame에 나오게된다.
	}
	
	//==========================================================================
	
	public void fileWriter() {
		if(file == null) return; //만약 file이 null이라면 메소드를 실행하지 않고 종료 
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); //file 에는 파일 경로와 파일명이 저장되어 있으므로 해당 파일로 텍스트필드에 입력한 내용을 전송해주는 것임.
			String data = output.getText();
			bw.write(data); //스트링 타입의 객체를 file 갹체에 담고 있는 경로로 전송한다.
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);//현재 다이어로그가 나올 위치를 () 안에 넣어주는데
		//this - 현재 프레임 위에 다이어로그 새엇ㅇ
		//null - 현재 프레임에 관계없이 아무 위치에 생성
		//result 는 showSaveDialog 에서 저장 또는 취소를 누른 것을 int 형으로 저장한다.
		//그래서 그 결과값을 result 에 담고 있는 것이다.
		
		if(result == JFileChooser.APPROVE_OPTION) { //사용자가 확인을 눌렀다면 int 형의 어떠한 값을 가지고 있을 것이다. JFilechooser에서는 이것을 상수로 지정하여 APPROVE_OPTION 이라는 값과 int 값으로 동일하게 이용한다.
			file = chooser.getSelectedFile();//저장버튼을 눌러주면 선택한 파일을 file 에 저장하겠다.
			// 확인을 누르면 파일이 저장이 되는데 확인을 누르지 않으면 file에 아무런 값이 저장되지 않은 null상태가됨.
		}
		
		JOptionPane.showMessageDialog(this, file);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "변경된 내용을 저장하시겠습니까?","종료",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
		if(result == JOptionPane.YES_OPTION) {
			saveDialog();
			System.exit(0);
		}else if(result == JOptionPane.NO_OPTION) {
			System.exit(0);
		}else if(result == JOptionPane.CANCEL_OPTION) {
			return;
		}
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new TryNotepad().event();
	}

}
