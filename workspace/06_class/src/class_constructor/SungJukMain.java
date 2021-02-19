package class_constructor;

/*
클래스명 : SungJuk
필드      : name, kor, eng, math, tot, avg, grade
메소드   : 생성자 
        calc() - 총점, 평균, 학점 계산
        getName()
      getKor()
      getEng()
      getMath()
      getTot()
      getAvg()
      getGrade()
      
[실행결과]
----------------------------------------------------
이름	   	   국어   	   영어   	   수학  	   총점     	 평균     	 학점
----------------------------------------------------
홍길동  	 90      95      100
코난     	 100     89      75
또치     	 75      80      48
 */

public class SungJukMain {

	public static void main(String[] args) {

		SungJuk[] sj = new SungJuk[3];
		
		sj[0] = new SungJuk("홍길동",90,95,100);
		sj[1] = new SungJuk("코난",100,89,75);
		sj[2] = new SungJuk("또치",75,80,48);
		
		System.out.println("----------------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		for(int i = 0; i < sj.length; i++) {
			sj[i].calc();
			System.out.println(sj[i].getName() + "\t" + sj[i].getKor() + "\t" + sj[i].getEng() + "\t" + sj[i].getMath() + "\t" + sj[i].getTot() + "\t" + sj[i].getAvg() + "\t" + sj[i].getGrade());
			
		}
		
		
	}

}
