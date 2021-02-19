package day0918;

public class Board {

	private String title;   //제목
	private String content; //내용
	private String name;    //작성자
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContetn() {
		return content;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public Board() {
		title = new String();
		content = new String();
		name = new String();
	}
	
	public Board(String title, String content, String name) {
		this.title = title;
		this.content = content;
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Board) {
			Board b = (Board)obj;
			if(title.equals(b.title) && name.equals(b.name)) {
				return true;
			}
		}
		return false;
	}
}
