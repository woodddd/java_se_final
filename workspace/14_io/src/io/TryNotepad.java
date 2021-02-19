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
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);//���������� ��ũ�ѹٸ� �׻� ����ش�.
		
		menu = new MenuPane();
		this.setJMenuBar(menu); // MenuBar�� �����ϰ� menu ��ü�� �����ϰ� �Ѵ�.
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		
		setBounds(700,200,500,300);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// x��ư�� ������ ��, �������� �������� �ʰ� ActionPerform�� �����
		
		setTitle("���ܸ޸���");
		
		
		//�̺�Ʈ
		addWindowListener(this);
		
		
		
		
	}//new TryNotepad()
	
	public void event() {
		//�̺�Ʈ
		
		//fileM �� ���� �̺�Ʈ
		menu.getNewM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		
		//edit�� ���� �̺�Ʈ
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
			int result = JOptionPane.showConfirmDialog(this, "�������ðڽ��ϱ�?","����",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
			
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
		output.setText(""); //������ �о�� ��, ���� ���Ͽ� �־��� ������ �ʱ�ȭ �ϰ� ������ �о�;���.
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));//���� ��� ��Ʈ��
			String line;
			
			while((line = br.readLine()) != null) {//���پ� �����͸� �о���µ� ���� ���� �����Ͱ� ���ٸ� null�� ����.
				//readLine�� ���͸� ���� �ʰ� ���� �ٷ� �ձ��� �о��!!!
				//output.setText(line); // - ����� output�� ���� �ް� �� output �� ���� �ް�, �ǹް� ������������� ���� �޴´�.
				output.append(line + "\n");//append�� �ϰԵǸ� ����ġ�� �������� �����͸� �о�ͼ� ���ٿ� �� �Է��ϱ� ������ �߰��� ����ģ �κ��� �ִٸ� \n�� ���ؼ� �ٹٲ��� �� �ذ���
			}//while
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//						BufferedReader						FileReader
	//TryNotepad.java <------------------------- buffer <------------------------- ������ ����
	
	public void openDialog() {
		//File file = null; //���� �ʱ�ȭ, ���������� �ʱ�ȭ�� ���� ������ �����Ⱚ�� ������
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);//showOpenDialog(null)�� ������ ���ָ� â�� ���� �߰� �ȴ�.
		if(result == JFileChooser.APPROVE_OPTION) { //Ȯ�ι�ư�� �����ָ� ������ ������ file �� �����ϰڴ�.
			file = chooser.getSelectedFile();// ����ڰ� ������ ���� �̸�, ���� ��θ�, ���丮�� �� ������ ����������, ���̾�αװ� ������� �� ������ file ��ü�� ���������Ƿ� �̿� �����ϴ�.
			fileRead();//���� ������ �о����.
		}
		JOptionPane.showMessageDialog(this, file); //file�� ��ġ�� ���� Frame�� �����Եȴ�.
	}
	
	//==========================================================================
	
	public void fileWriter() {
		if(file == null) return; //���� file�� null�̶�� �޼ҵ带 �������� �ʰ� ���� 
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file)); //file ���� ���� ��ο� ���ϸ��� ����Ǿ� �����Ƿ� �ش� ���Ϸ� �ؽ�Ʈ�ʵ忡 �Է��� ������ �������ִ� ����.
			String data = output.getText();
			bw.write(data); //��Ʈ�� Ÿ���� ��ü�� file ��ü�� ��� �ִ� ��η� �����Ѵ�.
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);//���� ���̾�αװ� ���� ��ġ�� () �ȿ� �־��ִµ�
		//this - ���� ������ ���� ���̾�α� ������
		//null - ���� �����ӿ� ������� �ƹ� ��ġ�� ����
		//result �� showSaveDialog ���� ���� �Ǵ� ��Ҹ� ���� ���� int ������ �����Ѵ�.
		//�׷��� �� ������� result �� ��� �ִ� ���̴�.
		
		if(result == JFileChooser.APPROVE_OPTION) { //����ڰ� Ȯ���� �����ٸ� int ���� ��� ���� ������ ���� ���̴�. JFilechooser������ �̰��� ����� �����Ͽ� APPROVE_OPTION �̶�� ���� int ������ �����ϰ� �̿��Ѵ�.
			file = chooser.getSelectedFile();//�����ư�� �����ָ� ������ ������ file �� �����ϰڴ�.
			// Ȯ���� ������ ������ ������ �Ǵµ� Ȯ���� ������ ������ file�� �ƹ��� ���� ������� ���� null���°���.
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
		int result = JOptionPane.showConfirmDialog(this, "����� ������ �����Ͻðڽ��ϱ�?","����",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
		
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
