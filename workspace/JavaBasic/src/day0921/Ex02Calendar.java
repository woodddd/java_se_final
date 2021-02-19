package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// ��¥�� ����ϴ� Calendar Ŭ����
public class Ex02Calendar {
   public static void main(String[] args) throws NumberFormatException, IOException {
      //�ڹٿ��� ��¥�� ����ϴ� Ŭ������ �پ��ϰ� �غ�Ǿ�������
      //���߿��� �ڹٰ� 1.8���� ���ķ� �����ϴ� ��¥ ���Ŭ������
      //�� Calendar Ŭ�����̴�.
      
      //Ķ���� ��ü�� 
      //�����ڸ� ���� �ʱ�ȭ�� �� �� ����
      //�׻� Calendar.getInstance()�� ����ð��� �ʱ�ȭ���־�� �Ѵ�!!!!
      Calendar cal = Calendar.getInstance();
      
      //Calendar ��ü�� �ѹ� ����
      System.out.println("cal: "+cal);
      
      //Calendar ��ü�� ����, �츮�� �״� �˰� ���� ���� ������ �����ؼ�
      //�ſ� �˾ƺ��� ���� ���°� ���´�.
      
      //���� �� ����� �� ���ڰ� �ٹз���
      //DateFormat�̶�� Ŭ���� ��ü�� �̿��ؼ�
      //�츮�� �� �ٸ��־�� �Ѵ�.
      //���� ���� ���̴� DateFormatŬ������ SimpleDateFormat�� �ִ�.
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��");
      //���� yyyy�� MM�� dd�� HH�� mm�� ss�ʸ� �����ϸ�
      //yyyy: ������ 4�ڸ� ���ڷ� ǥ��
      //MM: ���� 2�ڸ� ���ڷ� ǥ��. ���� 1~9�� �̸� �տ� 0�� �ٿ��ش�.
      //dd: �ش� ���� ����°������ 2�ڸ� ���ڷ� ǥ��.
      //HH: �ð��� 0~23�� ���·� ǥ��
      //mm: �ð��� 0~59�� 2�ڸ��� ǥ��
      //ss: �ʸ� 2�ڸ��� ǥ��
      
      System.out.println(sdf.format(cal.getTime()));
      
      //�׷��� 
      //��-��-�� ��-��-�� ��
      //��: 4�ڸ�
      //��, ��, ��, ��, ���� ��� 1�ڸ��� ���ڸ��θ� ǥ���ҷ���
      sdf = new SimpleDateFormat("yyyy-M-d h:m:s");
      System.out.println(sdf.format(cal.getTime()));
      
      //�׷��� �츮�� ����ڷκ��� ����� �ú��ʸ� �Է¹޾ƺ���.
      //�̶��� Calendar ��ü�� set(��, ��, ��, ��, ��, ��)�� ����ϸ� �ȴ�.
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      System.out.print("��: ");
      int year = Integer.parseInt(bufferedReader.readLine());
      System.out.print("��: ");
      int month = Integer.parseInt(bufferedReader.readLine()) - 1;
      System.out.print("��: ");
      int day = Integer.parseInt(bufferedReader.readLine());
      
      System.out.print("��: ");
      int hour = Integer.parseInt(bufferedReader.readLine());
      System.out.print("��: ");
      int minute = Integer.parseInt(bufferedReader.readLine());
      System.out.print("��: ");
      int second = Integer.parseInt(bufferedReader.readLine());
      //cal.set(year, month, day, hour, minute, second);
      //Ķ�������� �ϳ� �����ؾ��� ����
      //���� ��� 1~12�� �ƴ�
      //0~11�� �ν��ϱ� ������
      //���� 5���� �Է��ϰ� �ʹٸ� 4 ��� �Է��ؾ��Ѵ�.
      System.out.println(sdf.format(cal.getTime()));
   }
}













