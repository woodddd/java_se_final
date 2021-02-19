package day0915;

public class Ex01Class {
   //Java�� 3���� ����̴�.
   //3���� ���� ��ü������ ���α׷���(Object Oriented Programming)�� ��ǥ�� �Ѵ�.
   //�׷��ٸ� ��ü������ ���α׷����̶� �����ΰ�?
   //��ü�� �����ΰ�?
   
   // 2���� ��� ���������� ������
   // ���α׷��� ����� �������� ���� 
   // �� ��ɵ��� ���� �츮�� �ʿ��Ҷ����� �� ��ɵ��� �����ϴ� ���� ��ǥ�� �Ͽ���.
   
   // 3���� ��� ��ü������ ������
   // ���α׷��� ����� ������ �ƴ϶� ���� ���α׷����� �������� ���� �Ǿ���.
   // �� �ϳ��� Ŀ�ٶ� ���α׷���
   // ���� ���α׷��� ������ ���� �� ������ ���������� �߻��ϴ� �޽����� Ȱ���ϰ� 
   // ����� ���� �ٷ� ��ü�������� �ȴ�.
   
   // �ڹٿ����� ���α׷��� Ŭ������ �����Ѵ�.
   // Ŭ������ ������ �츮�� ��ü ��� �θ���.
   
   // �� ���� Ŭ������ ����
   // �ϳ��� Ŀ�ٶ� Ŭ������ �� Ŭ������ ����, �� ��ü�� Ȱ���ϴ°� ��ü������ ���α׷��̶� ���̴�.
   
   // ���� ����
   // �츮�� ���� �޼ҵ尡 �ִ� Ŭ��������
   // ���ڿ��� �ٷ� ������ ��Ʈ�� Ŭ���� ������ ����
   // �ʿ信 ���� �ش� ��Ʈ�� Ŭ������ �޼ҵ带 �����Ѵٵ���
   // �׷������� ���������� �޽����� ���� ���� �޼ҵ尡 �ٷ�� �ȴ�.
   
   // �� ��ü�� Ŭ������ ������ ��ü��� �ϴ°��̴�.
   // ����: String string1 = new String();
   //     ���⼭ string1�� String ��ü�� �ȴ�.
   
   // Ŭ������ �ʵ�� �޼ҵ�� �̷���� �ִ�.
   // A. �ʵ�
   //    �ʵ��, �ش� Ŭ������ ��ü���� ������ ���� ������ ������ �����ϰ� �ȴ�.
   //    ���� ��, �л��̶�� Ŭ������ �̸�, ����, ����, ����, ���� ��������
   //    ������ ���� �� �ֵ��� �츮�� �����ϰ� �ȴ�.
   
   // B. �޼ҵ�
   //    �޼ҵ�� �ش� Ŭ������ ��ü���� ���������� ������ �ִ� ��ɵ��� ���Ѵ�.
   //    ���� ���, �л��� ����� ���ϴ� �޼ҵ���
   //    ��� Ŭ������ �Ȱ��� ���ư�����, �ش� �л� Ŭ������ ��ü�� ������ �ִ�
   //    ������ ������ ���� ����� �޶����� �ȴ�.
   //    ���� �� �л�1�� 80 81 82 ���� ������ �ְ�
   //    �л�2�� 70 71 72 �� ������ �ִٰ� �����ϸ�
   //    �л�1�� �л�2�� ����� ����ϴ� ����� �ٸ���?
   
   // ������
   // �����ڶ� �ش� Ŭ������ ��ü�� �ʱ�ȭ�ɶ�
   // �ʵ��� ���� �����ϰų� �߰����� �۾��� �츮�� ������ �� �ִ�.
   // �������� ��� �޼ҵ�� ���� ����������
   // ����Ÿ�Ե� ���� �޼ҵ��� �̸��� Ŭ������ �̸��� �Ȱ���.
   
   // ���� �츮�� Ŭ������ �����ڸ� ���� ��������� ������
   // �ڹٰ� �⺻������ �������ִ� �����ڸ� ����ϰ� �ȴ�.
   // �ڹٰ� �⺻������ �������ִ� �����ڴ�
   // ��ü�� �ʵ常 �ʱ�ȭ ���ش�.
   // ���� �ʵ尡 �⺻�� ������Ÿ���̸� 0���� �ʱ�ȭ�ϰ�
   // ������ ������Ÿ���̸� null�� �ʱ�ȭ���ش�. (�⺻���� ���� 8������ �ִµ� �⺻���� ������ ������ ������)
   
   // �츮�� �����ڸ� ���� ������ְ� �Ǹ�
   // �ڹٰ� �⺻������ �������ִ� �⺻ �����ڴ� ���̻� ����� �� ����.
   // �׷��� ������ �����е��� �Ѱ��� �����ؾ��� ���� �ִµ�
   // ���� �Ķ���Ͱ� �ִ� �����ڸ� ������شٸ�
   // ���̻� �Ķ���Ͱ� ���� �����ڴ� ȣ���� �� ����.
   
   // �޼ҵ� �����ε�(method overloading)
   // �����ʹ� �ٸ��� �޼ҵ�� �Ȱ��� �̸��� ���� �������� �޼ҵ尡 ������ ���� �ִ�.
   // �� �Ѱ��� ������ �ٴµ�, �Ȱ��� �̸��� ���´ٰ� �ϴ���
   // �Ķ���ʹ� �޶�� �Ѵٴ� ���̴�.
   // �̷��� �Ķ���Ͱ� �ٸ� ���� �̸��� �޼ҵ带 ����� �ִ� ���� �츮��
   // �޼ҵ� �����ε��̶�� �Ѵ�.
   
   // Q1: �����ε� ���ؿ�?
   //     �Ȱ��� ������ ������ �Ķ���Ͱ� �������� ���� ���� ����ؼ�
   //     �̸��� ���Ͻ����־� �ڵ��� �������� �����ֱ� ���� ����̴�.
   
   // Q2: �Ķ���Ͱ� �ٸ��ٴ°� ���� �ǹ��ΰ���?
   //     �Ķ���Ͱ� �ٸ��ٴ°� ()�� ������ �Ķ���͵��� �ڷ����� ������ �ٸ��ٴ� �ǹ��̴�.
   //     ����: printInfo(String name, int age, String phone) �� ���
   //          �ڷ����� ������ String, int, String �̴�.
   //          �̷� ���, �����ε��� �Ҷ� �Ķ������ ������ String, int, String ���� �ƴϾ�߸� �Ѵ�.
   //          printInfo(String name, int age) �� ���� (������ String, int�̱� ����)
   //          printInfo(String phone, int age, String address)�� �Ұ��� (������ String, int, String �̱� ����)
   //             �׷��� printInfo("a", 5, "b")�� ���� �޼ҵ带 ȣ���ؾߵɱ��~
   
   // null �̶� �����ΰ�
   // ������ ������Ÿ���� �ʵ� Ȥ�� ������ 
   // �ּҰ��� �ο��� �Ǿ�����
   // �ش� �ּҿ� ������ �ʱ�ȭ ���� ���� �����̴�.
   // null�� ���� Ȥ�� �ʵ忡�� �츮�� �ƹ��� �޼ҵ� ȣ�� ���� �Ұ����ϴ�.
   
   // null vs new String()
   // null: ������ Ȯ�� �ȵ�. ���� �ƹ��� �۾��� �� �� ����
   // new String(): ��Ʈ�� ������ Ȯ�� �Ǿ��� �츮�� �޼ҵ� ȣ����� �۾��� ������. �ٸ� �ƹ��� ���ڵ� ���� ���� �� ������ �� String ""
   
   
   // ����������(Access Modifier)
   // ���������ڶ� �ش� �ʵ� Ȥ�� �޼ҵ带 �ܺ� Ŭ���� ��� ���� ���������� �������ش�.
   // public > protected > package > private ������ ���� ���� ������ ��������.
   // A. public: �ۺ����� �ش� �ʵ� Ȥ�� �޼ҵ带 �ܺ� ��Ű���� �ٸ� Ŭ���������� ���� �����ϰ� �����Ѵ�.
   // B. protected: ������Ƽ��� �ش� Ŭ������ ���� ��Ű���� �ٸ� Ŭ�����鵵 ���� �����ϴ�. 
   //               ���� �ٸ� ��Ű����� �� Ŭ������ ��ӹ޴� Ŭ�����鸸 ���� �����ϴ�.
   // C. package: ��Ű���� �ش� Ŭ������ ���� ��Ű���� �ٸ� Ŭ�����鸸 ���� �����ϴ�.
   //             ���� �ٸ� ��Ű���� ��� ���� �Ҽ� ����.
   //             �̹� �ڹٿ��� package�� default��� �ܾ �ٸ� ����� �ο��س��� ������
   //             �ݵ�� ��Ű�� ���� �����ڸ� ������ ������ �ƹ��� ���� �����ڸ� �������� �ʾƾ� �Ѵ�!
   // D. private: �����̺��� ���� ��Ű���� �ٸ� ��Ű���� �ܺ� Ŭ������ ������ ��δ� ���ƹ�����.
   
   // ���⼭ �츮�� ���� ���� ����ϴ� ���� �����ڴ� �����ϱ��?
   // ������ private�̴�.
   
   // �������� ����ȭ �׸��� ĸ��ȭ ��� ���� ������ ���� �츮�� Ŭ�������� �ܺΰ� ���� ���� ����ϴ� �޼ҵ带 �����ϰ���
   // ��� �ʵ� �׸��� �ܺΰ� �ʿ�� ���� �ʴ� �޼ҵ���� ��δ� private���� �����Ѵ�.
   // ������ �ʵ尡 private���� �Ǿ������� ���̻� �ٸ� Ŭ�������� �� �ʵ忡 ���� �ʱ�ȭ�ϰų� ȣ���Ҽ� ����.
   // �׷��� �츮�� �޼ҵ带 ���ؼ� ���� �����ϰ� �޼ҵ带 ���ؼ� �ش� �ʵ��� ���簪�� ȣ���ؾ� �Ѵ�.
   // �̷��� �޼ҵ带 �̿��ؼ� ���� �����ϰ� ȣ���ϴ� ���� ĸ��ȭ ��� �Ѵ�.
   // �ʵ忡 ���� �����ϴ� �޼ҵ带 setter ��� �ϰ�
   // ���� �޼ҵ�� ������ ���� ����� �����.
   // public void set�ʵ��(�ʵ�Ÿ�� �ʵ��){
   //    this.�ʵ�� = (�޼ҵ��� �Ķ����)�ʵ��;
   // }
   
   // �ʵ��� ���簪�� ȣ���ϴ� �޼ҵ带 getter ��� �ϰ�
   // getter �޼ҵ�� ������ ���� ����� �����.
   // public �ʵ�Ÿ�� get�ʵ��(){
   //     return �ʵ��;
   // }
   
	// ���part 1.
	// ����� �ϴ� ���� : �θ� Ŭ������ �޼ҵ带 �ڽ� Ŭ������ �� ������ ���ϰ� �޾� ����ϱ�����.
	// �ڹ��� ��� Ŭ����( ���� �����, �ڹٰ� �����, �ٸ� ȸ�簡 �����) ���� ����� �θ�Ŭ������ �ٷ� java.lang.Object�̴�.
	// �� java.lang.Object��� Ŭ������
	// �ڹٰ� �������ִ� �⺻ ������, equals(), toString() ���� �޼ҵ���� ����� �����Ǿ��ִ�.
	// ��, �ſ� �θ������ϰ� ��������ִ�.
	
	// ���� ��� equals()�� ��쿡�� �Ķ���ͷ� �Ѿ�� ��ü��
	// �� equals() �޼ҵ带 �����ϴ� ��ü�� ���� ��ü���� Ȯ���ϴ� �޼ҵ��ε�
	// ���� �츮�� ���ϴ� equals()�񱳴� ��ü�� �ʵ尪 ���� �񱳿��� ������
	// java.lang.Object�� �ּҰ� �񱳸� �Ѵ�.
	// public booean equals(Object obj){
	//		return this == obj;
	// }
	
	// ���� �츮�� java.lang.Object�� �޼ҵ带 ����� ������
	// �ش� Ŭ�������� ������ ���־�� �Ѵ�.
	
	// �̷��� �θ�Ŭ�����κ��� ��ӹ��� �޼ҵ带 �ڽ� Ŭ������
	// ������ ���ִ� ���� �������̵� �̶�� �Ѵ�.
	// �� �������̵��� �� �� �����ؾ��� ����
	// �θ�Ŭ������ ������ �޼ҵ��� �����(ex:public booean equals(Object obj) )��
	// �ڽ� Ŭ������ �Ȱ��� �������־�� �Ѵٴ� ���̴�.
	
	// System.out.println()�� �Ķ���ͷ� ��ü�� �־��ָ� ��� �ɱ��?
	// �׷��� System.out.println�� �Ķ���ͷ� �Ѿ�� ��ü�� toString()�� �����Ų
	// ������� ����Ѵ�.
	
	//
	

}


















