package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�� ����, ������ ������ ���� �����ϴ� ���α׷��� �ۼ��غ����� (���ɽð� ������)
//���� �� ������ 4���Դϴ�.
//�� ���� �ִ� �л����� 10���Դϴ�.
//���� �Է��� �ȵ� ����
//�Է��� �ȵǾ��ٰ� ��µǰ� �ϼ���.

//�Է��� �����ϸ�
//������� �Է��� �ް�
//�� ���� �л����� �Է¹ް�
//�׸��� �׹� �л����� ������ ������ ���� ��� �Է¹ް� �ϼ���.
public class Ex03MultiArray02 {
   //�ִ� �л� �� üũ�� ���
   final static int STUDENT_SIZE = 10;
   //���� �� ����
   final static int CLASS_NUMBER = 4;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      // �Է��� ������ ����� BufferedReader ���� (= ��ü) ����
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      // ������ ������ int[][][] scoreArray ����
      int[][][] scoreArray = new int[CLASS_NUMBER][][];
      //�� �ڵ��� �ǹ̴�
      //scoreArray�� int�� 3���� �迭�ε� int 2���� �迭�� CLASS_NUMBER�� ��ŭ ���ִ� ��� �ǹ̰� �ȴ�.
      
      //�츮�� scoreArray[0]�� ����ҷ���
      //�� 0���� � ũ���� 2���� �迭�� �̷�����ִ����� �����ؾ��Ѵ�.
      //scoreArray[0] = new int[stduentSize][]
      //�̷��� ������
      //scoreArray�� 0�� �ε����� studentSize�� ũ���� 2���� �迭�̴�.
      
      //scoreArray[0] = new int[studentSize][3]
      //�̷��� ������
      //scoreArray�� 0�� �ε����� int�� 3�� ���ִ� int 1���� �迭�� studentSize ��ŭ ���ִ� int 2���� �迭�̴�.
      
      
      //scoreArray[0]�� ������ ���ϴ°�?
      //scoreArray[0][3]
      //scoreArray[0][3][1] 
      
      //scoreArray[classNumber] = new int[studentNumber][3] �� �ǹ̴�
      //scoreArray�� classNumber �ε����� int 2���� �迭�̰� ũ��� 2������ studentNumber, 1������ 3�� ũ��� �ǹ��̴�.
      
      //int[4] �� int�� 4�� ���ִ�
      //int[2][4] �� 
      //       int�� 4�� ���ִ� �迭��
      //       2�� ���մ�.
      
      //int [5][2][4] ��
      //      int�� 4�� ���ִ� �迭��
      //      2�� �𿩼� �ϳ��� �迭�� �ǰ�
      //      �׷��� �迭�� 5�� ���ִ� ��� �ǹ̰� �ȴ�.
      // int[][][] arr = int[5][2][4] 
      //    -arr[0]: int[2][4] 
      //       arr[0][0]: int[4]
      //         arr[0][0][0]: int
      //         arr[0][0][1]: int
      //         arr[0][0][2]: int
      //         arr[0][0][3]: int
      //       arr[0][1]:  int[4]
      //         int, int, int, int
      //    -arr[1]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[2]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[3]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[4]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      
      
      // int[] arr = new int[5]
      // �̰� int�� 5�� ���ΰ��̴�.
      
      // int[][] arr = new int[3][5]
      // �̰��� int[]�� 3���� ���ΰ� arr�̴�
      // �׷��ٸ� arr[0]�� �����ΰ�?
      // int[5] �̴�
      // �� �ڼ��ϰ� ���ϸ� arr[0]�� int �迭�� �迭�̴�
      
      // int[][][] arr = new int[2][3][5]
      // �̰��� int[][]�� 2�� ���ΰ� arr�̴�
      // �׷��ٸ� arr[0]�� �����ΰ�?
      // int[3][5]
      // �� �ڼ��ϰ� ���ϸ� arr[0]�� int �迭�� ���ִ� �迭�� ���ִ� ���̴�.
      // ���⼭
      // arr[0]�� ���� 2���� �迭(int[3][5])�� �ִ�.
      // arr[0][0]�� ���� 1���� �迭(int[5])�� �ִ�.
      // arr[0][0][0]�� ���� int�� �ִ�.
      
      
      
      while(true) {
         //�޴� �޼ҵ� ȣ��
         showMenu();
         int choice = Integer.parseInt(bufferedReader.readLine());
         if(choice == 1) {
            //������ �Է��ϱ�
            
            //1. ���� �����Ѵ�.
            int classNumber = selectClassNumber(bufferedReader);
            //2. �л� �Ը� �����Ѵ�.
            int studentSize = selectStudentSize(bufferedReader);
            //3. for���� �̿��ؼ� �л��� ������ ���ʴ�� �־��ش�.
            
            //Ŭ�����ѹ��� 0
            //studentSize �� 4
            //scoreArray[0] �� int�� 3�� ���ִ� �迭�� 4���� ���ִ� 2���� �迭�̴�
            
            //Ŭ���� �ѹ��� 1
            //studentSize�� 6
            //scoreArray[1] �� int�� 3�� ���ִ� �迭�� 6�� ���ִ� 2���� �迭�̴�
            
            //Ŭ���� �ѹ��� 2
            //studentSize�� 7
            //scoreArray[2] �� int�� 3�� ���ִ� �迭�� 7�� ���ִ� 2���� �迭�̴�
            
            //Ŭ���� �ѹ��� 3
            //studentSize�� 2
            //scoreArray[3] �� int�� 3�� ���ִ� �迭�� 2�� ���ִ� 2���� �迭�̴�
            
            //�׷��ٸ�
            //scoreArray�� 2���� �迭�� 4�� ���ִ� 3���� �迭�� �ȴ� -> o
            
            //int[][][] scoreArray = new int[CLASS_NUMBER][][]��
            //scoreArray�� int 2���� �迭�� CLASS_NUMBER ��ŭ ���ִ� 3���� �迭�̴�
            
            //�׷��ٸ� scoreArray[0]�� �����ΰ�?
            //1. int
            //2. int[]
            //3. int[][] -> o
            //4. int[][][]
            
            //int[] arr = new int[5]
            //��� �ϸ�
            //int[0] �� int�� �ȴ�.
            
            // scoreArray[classNumber] = new int[studentSize][3]; 
            // scoreArray�� classNumber �ε�����
            // int 2���� �迭�̴�
            // 2���� �迭�ε� int�� 3�����ִ� �迭�� studentSize�� ��ŭ ���ִ� �迭�̴�.
            
            // ������ �迭 ���� ��쿡��
            // ����+������ ���
            // �δ� ������ �����ϸ� ���ϴ�!
            // �ߴ� �Ҵ� �д� ����
            // ���簡 �𿩼� �д�
            // �д밡 �𿩼� �Ҵ�
            // �Ҵ밡 �𿩼� �ߴ�
            
            // ���� ī�װ��� �����غ���
            // ���� - ��� - �ѽ�   - �ƺ��վ߽�
            //                - �����վ߽�
            //                - �谡��
            //                - �ٸ����
            //          - �߽�
            //          - �Ͻ�
            //          - ���
            //    - �Ŷ��
            //    - ����
            
            
            
            
            scoreArray[classNumber] = new int[studentSize][3];
            for(int i = 0; i < scoreArray[classNumber].length; i++) {
               System.out.println((i+1)+"�� �л��� ���� �Է�");
               scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1);
               scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2);
               scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3);
            }
            
         }else if(choice == 2) {
            //������ ����ϱ�
            //1. ���� �Է¹޴´�.
            int classNumber = selectClassNumber(bufferedReader);
            
            //2. �ش� ���� �ʱ�ȭ�Ǿ����� üũ�Ѵ�.
            if(scoreArray[classNumber] == null) {
               //���� �ʱ�ȭ �ȵ������Ƿ� ��� �޽��� ���
               System.out.println("���� �Է��� ���� ���� ���Դϴ�.");
            }else {
            //3. �ʱ�ȭ �Ǿ������� ����Ѵ�.
               for(int i = 0; i < scoreArray[classNumber].length; i++) {
                  System.out.println("=======================");
                  System.out.println((i+1)+"�� �л��� ����");
                  System.out.printf("����: %3d�� ����: %3d�� ����: %3d��\n", 
                        scoreArray[classNumber][i][0], scoreArray[classNumber][i][1], scoreArray[classNumber][i][2]);
               }
            }
         }else if(choice == 3) {
            System.out.println("������ּż� �����մϴ�.");
            break;
         }else {
            System.out.println("�߸��Է��ϼ̽��ϴ�.");
         }
      }
   }
   static void showMenu() {
      System.out.println("======================");
      System.out.println("��Ʈ����б� �������� ���α׷�");
      System.out.println("======================");
      System.out.println("|\t1. �Է�\t|");
      System.out.println("|\t2. ���\t|");
      System.out.println("|\t3. ����\t|");
   }
   static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException {
      System.out.println("���� �������ּ���");
      System.out.print("> ");
      int classNumber = Integer.parseInt(reader.readLine());
      while(classNumber < 1 || classNumber > CLASS_NUMBER) {
         System.out.println("�߸��Է��ϼ̽��ϴ�.");
         System.out.println("���� �������ּ���");
         System.out.print("> ");
         classNumber = Integer.parseInt(reader.readLine());
      }
      
      return classNumber - 1;
   }
   static int selectStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
      System.out.println("�л� ���ڸ� �������ּ���");
      System.out.print("> ");
      int studentSize = Integer.parseInt(reader.readLine());
      
      while(studentSize < 0 || studentSize > STUDENT_SIZE) {
         System.out.println("�߸��Է��ϼ̽��ϴ�.");
         System.out.println("�л� ���ڸ� �������ּ���");
         System.out.print("> ");
         studentSize = Integer.parseInt(reader.readLine());
      }
      
      return studentSize;
   }
   static int validateScore(BufferedReader reader, int code) throws NumberFormatException, IOException {
      String message = new String();
      switch(code) {
      case 1:
         message = "����";
         break;
      case 2:
         message = "����";
         break;
      case 3:
         message = "����";
         break;
      }
      message += " ������ �Է����ּ���.";
      System.out.println(message);
      System.out.print("> ");
      int score = Integer.parseInt(reader.readLine());
      while(score < 0 || score > 100) {
         System.out.println("�߸� �Է��ϼ̽��ϴ�.");
         System.out.println(message);
         System.out.print("> ");
         score = Integer.parseInt(reader.readLine());
      }
      
      return score;
   }
}












