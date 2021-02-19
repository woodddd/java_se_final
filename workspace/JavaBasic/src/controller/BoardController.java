package controller;

import java.util.ArrayList;

import model.BoardDTO;

public class BoardController {
	private ArrayList<BoardDTO> list;
	
	public BoardController() {
		list = new ArrayList<>();
	}
	public void add(BoardDTO b) {
		list.add(b);
	}
	
	public ArrayList<BoardDTO> selectAll(){
		ArrayList<BoardDTO> temp = new ArrayList<>(); // �ӽþ�̸���Ʈ temp �� ����ϴ� ������ ������ private�� ��ȣ�ϱ� ���Ͽ� ����Ѵ�.
		temp.addAll(list);// add��ɾ�� ���� �������� ��̸���Ʈ�� temp ���Ŀ� �߰��ϴ°�. temp �� �ƹ��� ���� ������ ���� �����Ƿ� �� ���忡���� list�� ��̸���Ʈ ���尪�� �����ϴ°� ��.
		return temp;
	}
	
	public BoardDTO selectOne(int index) {
		return list.get(index); //get(index)�� �ϰ� �Ǹ� index ��ȣ�� �´� ��ü�� �������Ե�
	}
	
	public void update(int index, BoardDTO b) {
		list.set(index,  b);// set - index ���� �´� ��̸���Ʈ(index) �� b��ü�� ����
	}
	public void delete(int index) {
		list.remove(index);
	}
}

