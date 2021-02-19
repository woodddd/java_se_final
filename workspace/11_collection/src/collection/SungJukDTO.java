package collection;

import java.text.DecimalFormat;

public class SungJukDTO {
		private int number, kor, eng, math, tot;
		private String name;
		private String avg;
		
		public SungJukDTO() {
			
		}
		
		public void calc() {
			
			DecimalFormat df = new DecimalFormat("#.###");
			
			tot = kor + eng + math;
			avg = df.format((double)tot / 3); // tot / 3. 으로 해도 동일한 결과가 나옴
		}
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getKor() {
			return kor;
		}

		public void setKor(int kor) {
			this.kor = kor;
		}

		public int getEng() {
			return eng;
		}

		public void setEng(int eng) {
			this.eng = eng;
		}

		public int getMath() {
			return math;
		}

		public void setMath(int math) {
			this.math = math;
		}

		public int getTot() {
			return tot;
		}

		public void setTot(int tot) {
			this.tot = tot;
		}

		public String getAvg() {
			return avg;
		}

		public void setAvg(String avg) {
			this.avg = avg;
		}

		@Override
		public String toString() {
			return number + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg;
		}
		
	}
