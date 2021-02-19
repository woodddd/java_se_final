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
		ArrayList<BoardDTO> temp = new ArrayList<>(); // 임시어레이리스트 temp 를 사용하는 이유는 원본을 private로 보호하기 위하여 사용한다.
		temp.addAll(list);// add명령어와 같이 여러개의 어레이리스트를 temp 이후에 추가하는것. temp 는 아무런 값을 가지고 있지 않으므로 현 문장에서는 list의 어레이리스트 저장값을 복사하는게 됨.
		return temp;
	}
	
	public BoardDTO selectOne(int index) {
		return list.get(index); //get(index)를 하게 되면 index 번호에 맞는 객체를 가져오게됨
	}
	
	public void update(int index, BoardDTO b) {
		list.set(index,  b);// set - index 값에 맞는 어레이리스트(index) 에 b객체를 넣음
	}
	public void delete(int index) {
		list.remove(index);
	}
}

