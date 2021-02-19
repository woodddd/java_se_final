package class_constructor;

enum EnumColor2{
	RED("빨강"),GREEN("초록"),BLUE("파랑"),MAGENTA("보라");
	
	private String colorName;
	
	EnumColor2(String colorName) { //enum의 생성자는 private 나 defualt만 사용할 수 있음
		this.colorName = colorName;
	}
	
	public String getColorName() {
		return colorName;
	}
}

public class EnumMain2 {

	public static void main(String[] args) {
		System.out.println(EnumColor2.RED);
		System.out.println();
		
		for(EnumColor2 data : EnumColor2.values()) {
			System.out.println(data + "\t"
					+ data.ordinal() + "\t"
					+ data.valueOf(data+"") + "\t"
					+ data.getColorName());
		}

	}

}
