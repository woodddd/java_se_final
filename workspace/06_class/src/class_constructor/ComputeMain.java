package class_constructor;
/*
x�� y�� ���� �޾Ƽ� ��,��,��,���� ���Ͻÿ�

Ŭ������ : Compute
�ʵ�      : x, y, sum, sub, mul, div
�޼ҵ�   : �����ڸ� ���ؼ� �����͸� ����
        calc() - ��, ��, ��, ���� ���
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
[������]
X      Y      SUM      SUB      MUL      DIV
320      258
256		 125
452      365	
*/
public class ComputeMain {

	public static void main(String[] args) {

		//��ü �迭
//		Compute[] ar = new Compute[3]; //��ü�迭
		//���⼭ �߿��� ��! ���⼭ new �� Compute Ŭ������ ������ ���� �ƴϴ�. ���� �ڷ��� Compute Ŭ���� Ÿ���� ���� 3���� �迭�� ������ ���̴�.
//		ar[0] = new Compute(320, 258);
//		ar[1] = new Compute(256, 125);
//		ar[2] = new Compute(452, 365);
		
		//Compute[] ar = {new Compute(320, 258),new Compute(256, 125),new Compute(452, 365)};
		//����ó���� ��� ������
		
		Compute[] ar = new Compute[]{new Compute(320,258),
                new Compute(256, 125),
                new Compute(452, 365)};		
		
		ar[0].calc();
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV");
		System.out.println();
		for(int i = 0 ; i < ar.length ; i++) {
			ar[i].calc();
			
			System.out.println(ar[i].getX() + "\t"
					+ ar[i].getY() + "\t"
					+ ar[i].getSum() + "\t"
					+ ar[i].getSub() + "\t"
					+ ar[i].getMul() + "\t"
					+ ar[i].getDiv());
			System.out.println();
		}
		
	}

}
