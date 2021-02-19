package swing;

enum Figure{
   LINE , CIRCLE, RECT, ROUNDRECT, PEN
}


//객체가 생성되는 시점은 Mouse가 도형을 다 그려 릴리즈 될 때 이다.
//그 때마다 객체를 생성하고 객체를 어레이리스트에 저장해야 한다.
//도형 1개에 대한 정보
public class ShapeDTO {
   
//   public static final int LINE = 0;
//   public static final int CIRCLE = 1;
//   public static final int RECT = 2;
//   public static final int ROUNDRECT = 3;
//   public static final int PEN = 4;
   
   private int x1T, y1T, x2T, y2T, z1T, z2T;
   private boolean fill;
   private Figure shape;
   private int color;
   
   public ShapeDTO(MsPaint mp) {
      //MsPaint 데이터를 받아올거임.
      this.x1T = Integer.parseInt(mp.getX1T().getText().trim());
      this.y1T = Integer.parseInt(mp.getY1T().getText().trim());
      this.x2T = Integer.parseInt(mp.getX2T().getText().trim());
      this.y2T = Integer.parseInt(mp.getY2T().getText().trim());
      this.z1T = Integer.parseInt(mp.getZ1T().getText().trim());
      this.z2T = Integer.parseInt(mp.getZ2T().getText().trim());
      
      this.fill = mp.getFill().isSelected();
      
      if(mp.getLine().isSelected()) {
         shape = Figure.LINE;
      }else if(mp.getCircle().isSelected()) {
         shape = Figure.CIRCLE;
      }else if(mp.getRect().isSelected()) {
         shape = Figure.RECT;
      }else if(mp.getRoundRect().isSelected()) {
         shape = Figure.ROUNDRECT;
      }else if(mp.getPen().isSelected()) {
    	  shape = Figure.PEN;
    	  
      }
      
      color = mp.getCombo().getSelectedIndex();
      
   }//생성자
   
   
   //게터
   public int getX1T() {
      return x1T;
   }
   public int getY1T() {
      return y1T;
   }
   public int getX2T() {
      return x2T;
   }
   public int getY2T() {
      return y2T;
   }
   public int getZ1T() {
      return z1T;
   }
   public int getZ2T() {
      return z2T;
   }
   public boolean getFill() {
      return fill;
   }
   public Figure getShape() {
      return shape;
   }
   public int getColor() {
      return color;
   }
   
   //세터
   public void setX1T(int x1t) {
      x1T = x1t;
   }
   public void setY1T(int y1t) {
      y1T = y1t;
   }
   public void setX2T(int x2t) {
      x2T = x2t;
   }
   public void setY2T(int y2t) {
      y2T = y2t;
   }
   public void setZ1T(int z1t) {
      z1T = z1t;
   }
   public void setZ2T(int z2t) {
      z2T = z2t;
   }
   public void setFill(boolean fill) {
      this.fill = fill;
   }
   public void setShape(Figure shape) {
      this.shape = shape;
   }
   public void setColor(int color) {
      this.color = color;
   }
   
}