package loop;

public class WhileTest {

	public static void main(String[] args) {
		
		int a = 0;
		
//		while(a < 10) { // 만약 while(true)로 하게 되면 무한루프가됨.
//			a++;
//			System.out.printf("%-3d",a);
//			
//		}
		
		
		
//		while(true){
//			a++;
//			System.out.printf("%-3d",a);
//			
//			if(a == 10) {
//				break;
//			}
//			
//		}
		
		
		
		while(a < 10){
			
			System.out.print(++a + "  ");//선행 증가
		}

	}

}
