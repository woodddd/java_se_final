package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ġȯ�ϴ� ���α׷��� �ۼ��Ͻÿ�
String Ŭ������ �޼ҵ带 �̿��Ͻÿ�
��ҹ��� ������� ������ ����Ͻÿ�

[������]
���ڿ� �Է� : aabba
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbba
1�� ġȯ

���ڿ� �Է� : aAbbA
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbba
1�� ġȯ

���ڿ� �Է� : aabbaa
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : cc
ccbbcc
2�� ġȯ

���ڿ� �Է� : AAccaabbaaaaatt
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddccddbbddddatt
4�� ġȯ

���ڿ� �Է� : aabb
���� ���ڿ� �Է� : aaaaa
�ٲ� ���ڿ� �Է� : ddddd
�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�

indexOf()
replace(??, ??)
 */

public class StringTest2 {

	public static void main(String[] args) throws IOException {
//		String str = "aabbaa";
//		System.out.println(str.replace("aa", "tt"));//replace �� ������ �ٲٴ°� �ƴ�. ��� ����� �ٲ���.
//		System.out.println("str = " + str);
//		
//		System.out.println(str.indexOf("a")); // 0��° ��ġ���� ã�� ����
//		System.out.println(str.indexOf("a",2)); // 2��° ��ġ���� ã�� ����
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str,target,replaceing;
		int index;
		int count;
		
		System.out.print("���ڿ� �Է� : ");
		str = br.readLine();
		
		System.out.print("ã�� ���ڿ� �Է� : ");
		target = br.readLine();
		
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		replaceing = br.readLine();

		if(str.length() < target.length()) {
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�.");
		}else {
			str = str.toLowerCase(); //toLowerCase �޼ҵ� ���� ������ ���� �ٲ��� �ʱ� ������ �ٽ� ������ �� �־�� ��.
			target = target.toLowerCase();
			
			index = count = 0;
			
			while((index = str.indexOf(target, index)) != -1) {
				
				index += target.length();
				count ++;
			}
			System.out.println(str.replace(target,replaceing));
			System.out.println(count + "�� ġȯ");
		}
		
	}

}









