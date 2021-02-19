package io;


import java.awt.Event;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;


public class MenuPane extends JMenuBar {
	private JMenu fileM, editM, ciewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	
	public MenuPane() {
		fileM = new JMenu("파일");
		editM = new JMenu("편집");
		ciewM = new JMenu("보기");
		
		
		newM = new JMenuItem("새로만들기");
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료");
		
		
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
		
		//fileM에 들어있는 아이템
		fileM.add(newM);
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		//editM에 들어있는 아이템
		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);
		
		
		add(fileM);
		add(editM);
		add(ciewM);
		
		//단축키 만들기. Ctrl 은 윈도우에서 사용하는 단축키 이므로 자바에서는 사용하면 안됨. 자바에서는 Alt를 제공함
		cutM.setAccelerator(KeyStroke.getKeyStroke('X', Event.ALT_MASK)); // Alt + X
		copyM.setAccelerator(KeyStroke.getKeyStroke('C', Event.ALT_MASK));
		pasteM.setAccelerator(KeyStroke.getKeyStroke('V', Event.ALT_MASK));
		
		
	}//MenuPane()

	
	
	public JMenu getFileM() {
		return fileM;
	}

	public JMenu getEditM() {
		return editM;
	}

	public JMenu getCiewM() {
		return ciewM;
	}

	public JMenuItem getNewM() {
		return newM;
	}

	public JMenuItem getOpenM() {
		return openM;
	}

	public JMenuItem getSaveM() {
		return saveM;
	}

	public JMenuItem getExitM() {
		return exitM;
	}

	public JMenuItem getCutM() {
		return cutM;
	}

	public JMenuItem getCopyM() {
		return copyM;
	}

	public JMenuItem getPasteM() {
		return pasteM;
	}

}
