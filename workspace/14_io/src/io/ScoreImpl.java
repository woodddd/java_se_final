package io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ScoreImpl implements Score {
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
	}

	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
		
	}

	@Override
	public void print(DefaultTableModel model) {
		//���̺��� ���� ������ ���̺��� �ʱ�ȭ �����־����.
		model.setRowCount(0); //���̺� �ʱ�ȭ
		//������ ���� �־��ٸ� ���� print �� ������ ���� ����Ǿ� �ִ� ���� �� ���� �߰� �Ǳ� ������
		//���̺��� �ʱ�ȭ ������ �� �ʱ�ȭ�� �ؾ� �ߺ������Ͱ� ����� ���� �ʴ´�.
		
		//���̺��� ��� ����Ʈ�� ����� �� ���� ������ ���� �̿�
		for(ScoreDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor() + ""); //add�� ���ڿ��� �� �� �ֱ� ������
			v.add(dto.getEng() + "");
			v.add(dto.getMath() + "");
			v.add(dto.getTot() + "");
			v.add(dto.getAvg() + "");
			
			model.addRow(v);
		}//for
		
	}
	
	@Override
	public void save() {
		//���� �����ư�� ������ ���� ���̺� ������ ���Ϸ� �����ؾ��Ѵ�.
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);//������ �� �� �ִ� ���̾�α�â�� ����//null�� ������ ���������� ���̾�αװ� ������
		File file = null;//�ʱ�ȭ
		
		if(result == JFileChooser.APPROVE_OPTION) {//���� ��ư�� ����
			file = chooser.getSelectedFile();// ���õ� ����(�����̸�)�� �����´�.
		}
		
		if(file == null) return; //���̺� ���̾�α׿��� ��Ҹ� ���� ���.
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));//�Ʊ� �޾� ���Ҵ� file (���ϸ��� �����ϰ�����) �� �������� ������ ��θ� ������.
			for(ScoreDTO dto : list) {
				oos.writeObject(dto); //���� ��ΰ� �����Ǿ� �ִ� oos �� ���Ͽ� Object Ÿ������ ��ü�� ����� ���� ������.
			}
			oos.close();// OutputStream ��ü�� �� ����Ͽ��ٸ� close�� ���Ͽ� �޸� �Ҵ��� �����Ѵ�.
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void search(DefaultTableModel model) {
//		//showInputDialog�� �̿��ؼ� �й��� �Է¹޴´�.
//		model.setRowCount(0); //���� �Էµ� ���� ������ �ʱ�ȭ ���������
//		
//		String hak = JOptionPane.showInputDialog(null,"���ϴ� �й��� �Է��ϼ���", "�й����� �˻�", JOptionPane.YES_NO_CANCEL_OPTION);
//		
//		
//		//���� ��Ҹ� �����ų� �й��� �Է����� ������ �׳� �޼ҵ带 ������.
//		if(hak == "" || hak == null) {//null �� ��Ҹ� ������ �� �̴�.
//			return; 
//		}else {
//			for(ScoreDTO dto : list) {
//				if(hak.equals(dto.getHak())) {
//					Vector<String> v = new Vector<String>();
//					v.add(dto.getHak());
//					v.add(dto.getName());
//					v.add(dto.getKor() + ""); 
//					v.add(dto.getEng() + "");
//					v.add(dto.getMath() + "");
//					v.add(dto.getTot() + "");
//					v.add(dto.getAvg() + "");
//					
//					model.addRow(v);
//				}//if
//			}//for
//		}//if
		
		//���ϴ� �й��� ������ JTable�� ������ָ� �ȴ�.
		
		//���ϴ� �й��� ������ showMessageDialog�� �̿��ؼ� "ã���� �ϴ� �й��� �����ϴ�." ��� ����Ѵ�.
		
		
		
		//����Բ�
		String hak = JOptionPane.showInputDialog(null, "�й��� �Է��ϼ���");
		if(hak == null || hak.equals("")) return; // ��Ҹ� �����ų� �ƹ��͵� �Է����� �������
		
		int sw = 0;
		//model.setRowCount(0); // ���� �ڵ带 ��ã�Ƶ� �ش� �޼ҵ带 ������ ������
		for(ScoreDTO dto : list) {
			if(hak.equals(dto.getHak())) {
				
				model.setRowCount(0);//�Ź� ������ ���ư��� ������ ���� �й��� �����Ѵٸ� �й��� �Ѱ��� �����Ե�. ������ �й��� ������ �ߺ��� ���� ���� ������ �Ű� ����x
				
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor() + ""); 
				v.add(dto.getEng() + "");
				v.add(dto.getMath() + "");
				v.add(dto.getTot() + "");
				v.add(dto.getAvg() + "");
				
				model.addRow(v);
				
				sw = 1;
			}//if
		}//for
		
		if(sw == 0) {
			JOptionPane.showMessageDialog(null,"ã���� �ϴ� �й��� �����ϴ�.");
		}//if
		
	}//search()


	@Override
	public void tot_desc() {
		
		
		//Comparator ��� �� ��! ��, �긦 ����Ϸ��� �Ű����� DefaultTableModel model �� �޾ƾ���.
		
//		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
//
//			@Override
//			public int compare(ScoreDTO a, ScoreDTO b) {
//				
//				return a.getTot() < b.getTot() ? 1 : -1;//return ���� a < b ���� -1 : 1 -> �������� , 1 : -1 -> ��������
//			}
//			
//		};//�͸�Ŭ����
//			Collections.sort(list, com);
//			
//			model.setRowCount(0);
//			
//			for(ScoreDTO dto : list) {
//				
//				
//				
//			Vector<String> v = new Vector<String>();
//			v.add(dto.getHak());
//			v.add(dto.getName());
//			v.add(dto.getKor() + ""); 
//			v.add(dto.getEng() + "");
//			v.add(dto.getMath() + "");
//			v.add(dto.getTot() + "");
//			v.add(dto.getAvg() + "");
//			
//			model.addRow(v);
//			}
		
		//Comparable ���!!
		//Collections.sort(list); // ScoreDTO ���� implements �� Comparable<ScoreDTO> �� compareTo �޼ҵ带 �������̵� �Ͽ� 
		// Collections.sort�� �̿��� �� �ֵ��� ���� �� ���̴�.
		//sort �ޙ��尡 ����Ǹ� �������̵� �� CompareTo �޼ҵ带 ã�ư�.
			
		//������� Comparator<ScoreDTO>
		
		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {//�������̽��� Comparator �� �߻��� �����̹Ƿ� ���� new �� �� ����.�׷��� �͸� �̳� Ŭ������ �̿�
			public int compare(ScoreDTO s, ScoreDTO s2) {
				return s.getTot() < s2.getTot() ? 1: -1; // ���� ������ ���� ���� ��� -1 Ŭ��� 1 �� ������ �Ѵٸ� ��������
				//�� �ݴ��� ��� �������� ������ �ȴ�.
			}
		};
		Collections.sort(list, com);
		
			
	}//tot_desc

	@Override
	public void load() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);//������ �� �� �ִ� ���̾�α� ����
		File file = null;
		
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile(); // ������ ������ �ִٸ� ���ϸ� �� ��������� ��ü�� ������
		}
		
		if(file == null) return;
		
		list.clear(); // ����Ʈ ��ü�� ���������� ���� �ƴϰ� , list�ȿ� ����ִ� ���� ������. ��� ��
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); 
			while(true) {
				try {
					ScoreDTO dto = (ScoreDTO)ois.readObject(); // �ڽ� = (�ڽ�)�θ�  ---> readObject �� ObjectŸ������ �о����, �װ��� �ڽ�Ŭ������ ���� ����ȯ ������ ����.
					list.add(dto); //list�� �߰��� �� ScoreForm ���� print ����.
				}catch(EOFException e) { // End Of File Exception (������ ���� ������ �Ǹ� ����) ������ ã�°͵��� ���� ���������� �𸣱� ������ ������ �߻��ϰԵ�.
					break;
				}
				
			}//while
			
			//ois.close(); Unreachable --- ������� ������ �� ���� �ڵ��.
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // ClassNotFoundException �� IOException �� ������� �ʴ´�. �׷��� readObject�� ����Ϸ��� ������ �� �ΰ��� catch �� �־�� �Ѵ�.
			e.printStackTrace();
		}//ClassNotFoundException -- Ŭ������ ã�� ������ ���..
		
	}
	
	
	

}
