package io;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ScoreDTO implements Serializable {//, Comparable<ScoreDTO> { //����ȭ(Serializable)�� ���� ������ ����Ʈ -> ��ü �� ��ü -> ����Ʈ ��ȯ ��ü�� �Ұ�����
	//���� ArrayList �� implements Serializable �� �ϰ� �ֱ� ������ ��̸���Ʈ Ÿ��(��ü)���� read , write �� �� �� ����.
	
	private static final long serialVersionUID = 1L; // UID �� �������� read�� �����ϴ�. ���� Ű���� �ٸ��ٸ� ���� �����ؼ� ����� ���� ����.
	
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;

	
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0 ;
	}


	public String getHak() {
		return hak;
	}


	public String getName() {
		return name;
	}


	public int getKor() {
		return kor;
	}


	public int getEng() {
		return eng;
	}


	public int getMath() {
		return math;
	}


	public int getTot() {
		return tot;
	}


	public double getAvg() {
		return avg;
	}


	public void setHak(String hak) {
		this.hak = hak;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public void setTot(int tot) {
		this.tot = tot;
	}


	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	//Comparable �� implements�� �� ���
//	public int compareTo(ScoreDTO s) {
//		//return this.tot < s.tot ? -1 : 1; //-> �� ����� ���������� ����
//		return this.tot < s.tot ? 1 : -1; // -> �� ����� ���������� �� �� ����
//	}
	
}
