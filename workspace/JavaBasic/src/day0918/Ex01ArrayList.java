package day0918;

import java.util.ArrayList;

import day0916.Car;

// ArrayUtil(�����Ҵ�)�� ����:
// �츮�� �ʿ��� �� ���� �Ź� ����� �޼ҵ���� �� ����� �־�� �Ѵ�.
// ������ Student �迭�� Car �迭�� �����Ҵ��� �����ϴ�.
// ���� �츮�� �Խ��� �����? �� �ش��ϴ� �޼ҵ���� ������־�� �ϰ�
// ȸ��? ȸ���� ������־�� �Ѵ�!!!
// ���� ��� ������?..
//

public class Ex01ArrayList {

	public static void main(String[] args) {
		// �ڹٿ��� ArrayList��� Ŭ������ �����Ѵ�.
		// �� ArrayList�� �츮�� �����Ҵ����� �����س��� ��� ��ɵ��� �˾Ƽ� ������ �ִ�.
		// ���� ���ø��̶�°��� ����ؼ�
		// ��� Ŭ������ �����Ҵ� �޼ҵ带 ���� ���� ���ص� ��밡���ϴ�.
		
		// ArrayList�� �� �� ������ �� 2����
		// 1. ���ø����� Ŭ������ ���� �� �ִ�!
		//    Q) "�����.. �⺻�� ������Ÿ���� ��̸���Ʈ�� �����?"
		//    A)��. �⺻�� ������ Ÿ���� ������� ���մϴ�.
		//    �׷��� �ڹٰ� �⺻�� ������Ÿ���� Ŭ����ó�� ����� ���� ����Ŭ����(wrapper Ŭ����)�� �����մϴ�.
		//    int -> Integer, double -> Double ���
		// 2. ArrayList�� ���������� �ش� Ŭ������ equals() �޼ҵ带 ���������� ����ϱ� ������
		//    �츮�� ���� Ŭ������ equals() �޼ҵ带 ��Ȯ�ϰ� �����ϴ� ���� �߿��ϴ�.
		
		// ArrayList�� java.util ��Ű���� �����Ƿ� �츮�� import �ؾ��Ѵ�.
		
		// ArrayList �����ϱ�
		// ArrayList<Ŭ�����̸�> list = new ArrayList<>();
		ArrayList<Car> carList = new ArrayList<>();
		
		Car c1 = new Car("a", "typeA", 2000, 1000000, "a");
		Car c2 = new Car("b", "typeB", 2001, 2000000, "b");
		Car c3 = new Car("c", "typeC", 2002, 3000000, "c");
		Car c4 = new Car("d", "typeD", 2003, 4000000, "d");
		Car c5 = new Car("e", "typeE", 2004, 5000000, "e");

		// 1. ArrayList�� ����ũ�⸦ �˾ƺ����� size()�� �̿��ϸ� �ȴ�.
		System.out.println("carList.size(): " + carList.size());
		
		// 2. ArrayList�� ���ο� ��ü�� �߰��� ������ add() �޼ҵ带 �̿��ϸ� �ȴ�.
		carList.add(c1);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c2);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c3);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c4);
		System.out.println("carList.size(): " + carList.size());
		
		// 3. ArrayList���� �ش� ��ġ�� �ִ� ��ü��
		System.out.println("carList.get(1)" + carList.get(1));
		// get���� ȣ���� ��ü�� �迭�� ���° ĭ�� �ִ� ��ü�� ó�� �츮�� �� ��ü�� �޼ҵ带 ������ �� �� �ִ�.
		System.out.println("carList.get(0).getType(): " + carList.get(0).getType());
	
		// 4. ��� ����Ʈ���� ��ü�� ������ ������ 2���� ����� �����ϴ�.
		//	A) �ε����� �����ϱ�
		//		�ε����� ������ ������ remove(index)�� �ϸ� �ȴ�.
		System.out.println("carList.get(0) : " + carList.get(0));
		carList.remove(0);
		System.out.println("carList.get(0) : " + carList.get(0));
		System.out.println("carList.size()" + carList.size());
	
		//	B) ��ü�� �����ϱ�
		//		��ü�� ������ ������ �ش� ��ü�� equals()�� true�� ������ ��ü�� �־��ָ� �ȴ�.
		Car c44 = new Car("d", "typeD", 2003, 4000000, "d");
		Car c55 = new Car("e", "typeE", 2004, 5000000, "e");
		
		System.out.println("c4.equals(c44): " + c4.equals(c44));
		System.out.println("carList.size(): " + carList.size());
		carList.remove(c44);
		System.out.println("carList.size(): " + carList.size());
		carList.remove(c55);
		System.out.println("carList.size(): " + carList.size());
		// remove�� ��ü�� ���������
		// ArrayList�� �ش� ��̸���Ʈ�� ó������ ������
		// �Ķ���ͷ� �Ѿ�� ��ü�� �� ĭ�� equals()�� �����ؼ�
		// true�� ������ ĭ�� �����Ѵ�.
		// ���� remove�� �Ѱ��ִ� ��ü�� equals()�� true�� ������ ��ü�� ��� ����Ʈ�� ������
		// �ƹ��͵� �������� �ʴ´�.
		
		// carList�� �ִ� �ֵ�: c1 c2 c3 c4
		// remove(0) ���� : c2 c3 c4
		// remove(c44) ���� : c2, c3
		
		// 5. carList���� �ش� ��ü�� index�� �ñ��ϸ� indexOf() �޼ҵ带 �����ϸ� �ȴ�.
		System.out.println("carList.indexof(c2): " + carList.indexOf(c2));
		//	���� �ش� ����Ʈ�� �� ��ü�� �������� ������ -1�� ���ϵȴ�.
		System.out.println("carList.indexOf(c4) " + carList.indexOf(c4));
		
		// 6. carList���� �ش� ��ü�� �����ϴ��� �������� �ʴ����� üũ�� ������ contains() �޼ҵ带 �����ϸ� �ȴ�.
		System.out.println("carList.contains(c2): " + carList.contains(c2));
		System.out.println("carList.contains(c4): " + carList.contains(c4));
		
		// ����, ArrayList�� ����� ����ϰ� �ʹٸ�,
		// �츮�� < > �� �־��� Ŭ������
		// equals()�� ��Ȯ�ϰ� ����� �ִ� ���� �߿��ϴ�!
		
		
	}

}
