package io;

import java.io.Serializable;
import java.text.DecimalFormat;

public class ScoreDTO implements Serializable {//, Comparable<ScoreDTO> { //직렬화(Serializable)를 하지 않으면 바이트 -> 객체 와 객체 -> 바이트 변환 자체가 불가능함
	//또한 ArrayList 는 implements Serializable 을 하고 있기 때문에 어레이리스트 타입(객체)으로 read , write 를 할 수 있음.
	
	private static final long serialVersionUID = 1L; // UID 가 맞춰져야 read가 가능하다. 만약 키값이 다르다면 서로 공유해서 사용할 수가 없다.
	
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
	
	//Comparable 을 implements할 때 사용
//	public int compareTo(ScoreDTO s) {
//		//return this.tot < s.tot ? -1 : 1; //-> 이 결과는 오름차순이 나옴
//		return this.tot < s.tot ? 1 : -1; // -> 이 결과는 내림차순을 볼 수 있음
//	}
	
}
