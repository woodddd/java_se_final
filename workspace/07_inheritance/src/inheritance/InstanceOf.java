package inheritance;

class AA{
	
}

class BB extends AA{
	
}

public class InstanceOf {

	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		AA aa3 = aa;
		if(aa instanceof AA) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
		
		AA aa4 = bb; // 부모 = 자식 //현재 bb라는 영역 안에는 aa 가 존재하기 때문에 받을 수 있음
		if(bb instanceof AA) System.out.println(("1. TRUE")); // bb는 AA를 포함하고 있기 때문에 형변환이 가능함.
		else System.out.println("1. FALSE");
		
		BB bb2 = (BB)aa2; // 자식클래스는 부모클래스를 직접 받을 수 없음 자식 = (자식) 부모
		if(aa2 instanceof BB) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
		//BB bb3 = (BB)aa3;
		if(aa3 instanceof BB) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
	 }

}

// aa instanceof AA
//aa가 가리키는 곳에 클래스 AA 가 있는냐?
//aa가 AA 형변환(casting)이 가능하냐?