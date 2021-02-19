package collection;

public class PersonDTO implements Comparable<PersonDTO> {//Comparable 기본 정렬기준을 구현하는데 사용함.
	private String name;
	private int age;

	public PersonDTO(String name, int age) {
		this.name = name;
		this.age = age;
	} 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	//Comparable 메소드 오버라이딩
	@Override
	public int compareTo(PersonDTO p) {//자기자신 과 매개변수의 객체를 비교함
		
		//해당 메소드는 sort가 알아서 호출하는 메소드이다. 그러므로 우리가 어떠한 동작을 하는지 정확히 알 수 없음
		//그래서 어떤 값을 기준으로 비교할 것인지 기준값만 우리가 잡아줄 수 있음.
		
		
		//오름차순
//		if(this.age < p.age) return -1;
//		else if(this.age > p.age) return 1;
//		else return 0;
		
		//내림차순
		if(this.age < p.age) return 1;
		else if(this.age > p.age)return -1;
		else return 0;
	}
	
	public String toString() {
		return "이름 = " + name + "\t 나이 = " + age ;
	}

}
