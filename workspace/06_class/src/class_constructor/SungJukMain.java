package class_constructor;

/*
Ŭ������ : SungJuk
�ʵ�      : name, kor, eng, math, tot, avg, grade
�޼ҵ�   : ������ 
        calc() - ����, ���, ���� ���
        getName()
      getKor()
      getEng()
      getMath()
      getTot()
      getAvg()
      getGrade()
      
[������]
----------------------------------------------------
�̸�	   	   ����   	   ����   	   ����  	   ����     	 ���     	 ����
----------------------------------------------------
ȫ�浿  	 90      95      100
�ڳ�     	 100     89      75
��ġ     	 75      80      48
 */

public class SungJukMain {

	public static void main(String[] args) {

		SungJuk[] sj = new SungJuk[3];
		
		sj[0] = new SungJuk("ȫ�浿",90,95,100);
		sj[1] = new SungJuk("�ڳ�",100,89,75);
		sj[2] = new SungJuk("��ġ",75,80,48);
		
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		for(int i = 0; i < sj.length; i++) {
			sj[i].calc();
			System.out.println(sj[i].getName() + "\t" + sj[i].getKor() + "\t" + sj[i].getEng() + "\t" + sj[i].getMath() + "\t" + sj[i].getTot() + "\t" + sj[i].getAvg() + "\t" + sj[i].getGrade());
			
		}
		
		
	}

}
