package day0921;
//����� ver

public class Board {
	//�ʵ�
	//�Խñ� ��ȣ, ����, ����, �ۼ���
	
	private int id;
	private String title;
	private String content;
	private String writer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Board) {
			Board b = (Board) o;
			if(id == b.id && title.contentEquals(b.title)) {
				return true;
			}
		}
		
		return false;
	}
}
