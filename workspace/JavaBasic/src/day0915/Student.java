package day0915;

public class Student {
	//학생의 필드를 만들어보자
	//필드는 변수처럼
	//우리가 데이터타입 필드이름 을 선언해주면 된다.
	
	//학생의 이름
	private String name;
	//학생의 국어점수
	private int korean;
	//학생의 영어점수
	private int english;
	//학생의 수학점수
	private int math;
	//학생의 관리번호
	private int id;
	
	//name에 대한 셋터
	public void setName(String name) { 
		this.name = name; // this.name 객체 자기 자신의 name 을 말한다.
	}
	
	//name에 대한 겟터
	public String getName() { // 저장된 값을 get필드명() 을 입력한 곳으로 받음. get(받다)
		return name; // get필드명을 입력한 곳에 필드의 값을 리턴해준다.
	}
	
	//korean에 대한 셋터
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	//korean에 대한 겟터
	public int getKorean() {
		return korean;
	}
	
	//english에 대한 셋터
	public void setEnglish(int english) {
		this.english = english;
	}
	
	//english에 대한 겟터
	public int getEnglish() {
		return english;
	}
	
	//math에 대한 셋터
	public void setMath(int math) {
		this.math = math;
	}
	
	//math에 대한 겟터
	public int getMath() {
		return math;
	}
	
	//id에 대한 셋터
	public void setId(int id) {
		this.id = id;
	}
	
	//id에 대한 겟터
	public int getId() {
		return id;
	}
	
	//메소드를 만들어보자
	//1. 총점을 구하는 메소드
	public int calculateSum() { 
		return korean + english + math;
	}
	
	//2. 평균을 구하는 메소드
	public double calculateAverage() { 
		return calculateSum() / 3.0;
	}
	
	//파라미터가 있는 생성자
	public Student(String name,int id, int korean, int english, int math) {
		//같은 이름이 있을 때
		//파라미터는 필드보다 호출 우선수위가 높다.
		//ex)name = "abc";
		//따라서 같은 이름으로 존재할 때 필드를 호출할 때에는
		//명확하게 "해당 객체의 필드" 라고 지정해주어야 한다.
		//이럴 떄에는 this.필드 로 지정할 수 있다.
		//즉 this란 이 메소드를 실행하는 클래스 객체 자신을 가리키게 된다.
		this.name = name; //Student 메소드의 파라미터 값name을 필드 name 에 넣는다.
		this.id = id;
		this.korean = korean;
		this.english = english;
		this.math = math;
		
	}
	
	public Student() {
		name = new String();
		//System.out.println(calculateSum());
	}
	
	// static keyword는 해당 필드 혹은 메소드를
	// 객체생성없이 곧장 호출할 수 있게 만들어준다.
	// 다만 이 스태틱이란 키워드는 해당 메소드의 코드를
	// 프로그램 실행영역에 강제로 포함시키는 것이기 때문에
	// 만약 해당 메소드가 내부에서 다른 메소드나 필드를 사용하게 된다면
	// 그 다른 메소드나 피드도 마찬가지로 스태틱을 붙여서
	// 실행영역에 포함시켜주어야 한다.
	// 대표적인 예 : Integer.parseInt(br.readLine());
	
	//equals() 메소드 구현
	public boolean equals(Object obj) {
		if(obj instanceof Student) {//obj가 Student클래스의 객체인지 확인.
			Student s = (Student)obj;
			if(id == s.id && name.equals(s.name)) {
				return true;
			}
		}
		
		return false;
	}
	
	//toString() 메소드 구현
	public String toString() {
		return "학번 : " + id + 
				", 이름 : " + name + 
				", 국어점수 : " + korean + "점"
				+ ", 영어점수 : " + english + "점"
				+ ", 수학점수 : " + math + "점";
	}
}
