package day0915;

public class Student {
	//�л��� �ʵ带 ������
	//�ʵ�� ����ó��
	//�츮�� ������Ÿ�� �ʵ��̸� �� �������ָ� �ȴ�.
	
	//�л��� �̸�
	private String name;
	//�л��� ��������
	private int korean;
	//�л��� ��������
	private int english;
	//�л��� ��������
	private int math;
	//�л��� ������ȣ
	private int id;
	
	//name�� ���� ����
	public void setName(String name) { 
		this.name = name; // this.name ��ü �ڱ� �ڽ��� name �� ���Ѵ�.
	}
	
	//name�� ���� ����
	public String getName() { // ����� ���� get�ʵ��() �� �Է��� ������ ����. get(�޴�)
		return name; // get�ʵ���� �Է��� ���� �ʵ��� ���� �������ش�.
	}
	
	//korean�� ���� ����
	public void setKorean(int korean) {
		this.korean = korean;
	}
	
	//korean�� ���� ����
	public int getKorean() {
		return korean;
	}
	
	//english�� ���� ����
	public void setEnglish(int english) {
		this.english = english;
	}
	
	//english�� ���� ����
	public int getEnglish() {
		return english;
	}
	
	//math�� ���� ����
	public void setMath(int math) {
		this.math = math;
	}
	
	//math�� ���� ����
	public int getMath() {
		return math;
	}
	
	//id�� ���� ����
	public void setId(int id) {
		this.id = id;
	}
	
	//id�� ���� ����
	public int getId() {
		return id;
	}
	
	//�޼ҵ带 ������
	//1. ������ ���ϴ� �޼ҵ�
	public int calculateSum() { 
		return korean + english + math;
	}
	
	//2. ����� ���ϴ� �޼ҵ�
	public double calculateAverage() { 
		return calculateSum() / 3.0;
	}
	
	//�Ķ���Ͱ� �ִ� ������
	public Student(String name,int id, int korean, int english, int math) {
		//���� �̸��� ���� ��
		//�Ķ���ʹ� �ʵ庸�� ȣ�� �켱������ ����.
		//ex)name = "abc";
		//���� ���� �̸����� ������ �� �ʵ带 ȣ���� ������
		//��Ȯ�ϰ� "�ش� ��ü�� �ʵ�" ��� �������־�� �Ѵ�.
		//�̷� ������ this.�ʵ� �� ������ �� �ִ�.
		//�� this�� �� �޼ҵ带 �����ϴ� Ŭ���� ��ü �ڽ��� ����Ű�� �ȴ�.
		this.name = name; //Student �޼ҵ��� �Ķ���� ��name�� �ʵ� name �� �ִ´�.
		this.id = id;
		this.korean = korean;
		this.english = english;
		this.math = math;
		
	}
	
	public Student() {
		name = new String();
		//System.out.println(calculateSum());
	}
	
	// static keyword�� �ش� �ʵ� Ȥ�� �޼ҵ带
	// ��ü�������� ���� ȣ���� �� �ְ� ������ش�.
	// �ٸ� �� ����ƽ�̶� Ű����� �ش� �޼ҵ��� �ڵ带
	// ���α׷� ���࿵���� ������ ���Խ�Ű�� ���̱� ������
	// ���� �ش� �޼ҵ尡 ���ο��� �ٸ� �޼ҵ峪 �ʵ带 ����ϰ� �ȴٸ�
	// �� �ٸ� �޼ҵ峪 �ǵ嵵 ���������� ����ƽ�� �ٿ���
	// ���࿵���� ���Խ����־�� �Ѵ�.
	// ��ǥ���� �� : Integer.parseInt(br.readLine());
	
	//equals() �޼ҵ� ����
	public boolean equals(Object obj) {
		if(obj instanceof Student) {//obj�� StudentŬ������ ��ü���� Ȯ��.
			Student s = (Student)obj;
			if(id == s.id && name.equals(s.name)) {
				return true;
			}
		}
		
		return false;
	}
	
	//toString() �޼ҵ� ����
	public String toString() {
		return "�й� : " + id + 
				", �̸� : " + name + 
				", �������� : " + korean + "��"
				+ ", �������� : " + english + "��"
				+ ", �������� : " + math + "��";
	}
}
