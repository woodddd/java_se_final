package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DrCanvas extends Canvas{
   private MsPaint mp;
   private ArrayList<ShapeDTO> list;
   
   private Image bufferImage;
   private Graphics bufferG;
   
   public DrCanvas(MsPaint mp) {
      this.mp = mp;
      this.setBackground(new Color(255,200,255));
      
      addKeyListener(new KeyAdapter() {
    	  @Override
    	public void keyPressed(KeyEvent e) {
    		  if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
    			  System.exit(0);
    		  }
    	}
      });
      
   }
   
   
   //캔버스 화면에 깜빡거림을 없애려면
   //버퍼 영역에서 그림을 그리고 최종적으로 그림이 다 그려 졌을 때,
   //최종 그림을 화면에 호출해 주면 된다.
   
   
   @Override
	public void update(Graphics g) { //repaint() 를 실행하면 update -> paint 순으로 호출한다.
	   
	   Dimension d = this.getSize(); //반환값인 Dimension 은 사각 영역의 크기를 가지고 있다.
	   //this - 컨버스.  현재 컨버스의 크기를 d 에 저장해라
	   
	   if(bufferG == null) {//bufferG 가 null 인 경우는 그림을 그리지 않은 가장 처음밖에 없다.
		   bufferImage = createImage(d.width,d.height);//캔버스의 크기만큼 이미지를 생성해라
		   bufferG = bufferImage.getGraphics();//생성한 이미지를 버퍼 이미지로 사용하고 앞으로 bufferG에다가 그림을 그릴거다.
	   }
	   
	   //지우기( 사실상 지우는 것이 아닌 배경색상과 같은 색상으로 덮어버리는것
	   Color c = this.getBackground();// 현재 Canvas 바탕색을 얻어오기	   
	   bufferG.setColor(c);
	   bufferG.fillRect(0, 0, d.width, d.height);
	   
	   
	   int x1,y1,x2,y2,z1,z2;
	      this.list = mp.getList();
	      
	      //마우스를 드래그 할 때 필요한 정보는 mp 가 담고있으므로 mp객체로도 한개 추가해주었음.
	      
	      x1 = Integer.parseInt(mp.getX1T().getText().trim());//trim() 은 문자열 앞뒤에 공백이 있다면 문자열을 제거한다.
	      y1 = Integer.parseInt(mp.getY1T().getText().trim());
	      x2 = Integer.parseInt(mp.getX2T().getText().trim());
	      y2 = Integer.parseInt(mp.getY2T().getText().trim());
	      z1 = Integer.parseInt(mp.getZ1T().getText().trim());
	      z2 = Integer.parseInt(mp.getZ2T().getText().trim());
	      
	      //색
	      switch(mp.getCombo().getSelectedIndex()) {
	      case 0 : bufferG.setColor(new Color(255,0,0));
	         break;
	      case 1 : bufferG.setColor(new Color(0,255,0));
	         break;
	      case 2 : bufferG.setColor(new Color(0,0,255));
	         break;
	      case 3 : bufferG.setColor(new Color(255,0,255));
	         break;
	      case 4 : bufferG.setColor(new Color(0,255,255));
	         break;
	      }
	      //도형
	      if(mp.getFill().isSelected()) {
	         if(mp.getLine().isSelected()){
	        	 bufferG.drawLine(x1, y1, x2, y2);
	         }else if(mp.getCircle().isSelected()) {
	        	 bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	         }else if(mp.getRect().isSelected()) {
	        	 bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	         }else if(mp.getRoundRect().isSelected()) {
	        	 bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), 50, 50);
	         }
	      }else{
	         if(mp.getLine().isSelected()) {
	        	 bufferG.drawLine(x1, y1, x2, y2);
	         }else if(mp.getCircle().isSelected()) {
	        	 bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));//Math.min(x1, x2) 을 사용한 이유. x좌표와 y좌표를 왼쪽위 ( 제일작은값) 으로 바꿔주기 위해서 min을 사용하였다.
	         }else if(mp.getRect().isSelected()) {
	        	 bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	         }else if(mp.getRoundRect().isSelected()){
	        	 bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), 50, 50);
	         }
	      }
	      
	      if(mp.getPen().isSelected()) {
	    	  bufferG.drawLine(x1, y1, x2, y2);
	    	  
	      }
	      
	      //repaint가 호출되면 그림이 다 없어지기 때문에
	      //ArrayList 안의 도형을 하나씩 꺼내서 다시 그려준다.
	      for(int i = 0; i < list.size() ; i++) {
	         ShapeDTO dto = list.get(i);
	      //for(ShapeDTO dto : mp.getList()){
	      // 이렇게 사용해도 동일한 문장
	      
	      
	      //현재 mp.getX1T에는 화면에 아무런 값을 입력하지 않은 상태이므로 값이 없는 상태인데,
	      //값을 Integer형식으로 바꿔버리라 명령하여 NumberFormatException 에러가 발생하게됨.
//	      x1 = Integer.parseInt(mp.getX1T().getText().trim());//trim() 은 문자열 앞뒤에 공백이 있다면 문자열을 제거한다.
//	      y1 = Integer.parseInt(mp.getY1T().getText().trim());
//	      x2 = Integer.parseInt(mp.getX2T().getText().trim());
//	      y2 = Integer.parseInt(mp.getY2T().getText().trim());
//	      z1 = Integer.parseInt(mp.getZ1T().getText().trim());
//	      z2 = Integer.parseInt(mp.getZ2T().getText().trim());
	      //1. x1T 에 들어온 값을 꺼낸다
	      //2. 문자열로 가져온 "100"을 정수형으로 바꾼다 "100" ---> 100
	      
	         x1 = dto.getX1T();
	         y1 = dto.getY1T();
	         x2 = dto.getX2T();
	         y2 = dto.getY2T();
	         z1 = dto.getZ1T();
	         z2 = dto.getZ2T();
	      
	      //색
	         switch(dto.getColor()) {
	         case 0 : bufferG.setColor(new Color(255,0,0));
	            break;
	         case 1 : bufferG.setColor(new Color(0,255,0));
	            break;
	         case 2 : bufferG.setColor(new Color(0,0,255));
	            break;
	         case 3 : bufferG.setColor(new Color(255,0,255));
	            break;
	         case 4 : bufferG.setColor(new Color(0,255,255));
	            break;
	         }
	      
	      
	         //도형
	         if(dto.getFill()) {
	            if(dto.getShape() == Figure.LINE){//enum 함수의 상수는 내부적으로 public final static 을 가지고 있으므로 클래스가 달라도 사용이 가능하다.
	            	bufferG.drawLine(x1, y1, x2, y2);
	            }else if(dto.getShape() == Figure.CIRCLE) {
	            	bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));// 마우스를
	            }else if(dto.getShape() == Figure.RECT) {
	            	bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	            }else if(dto.getShape() == Figure.ROUNDRECT) { 
	            	bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
	            
	               //길이와 높이는 음수가 될 수 없으므로 Math.abs(x2-x1) 를 사용하여 길이와 높이를 양수로 만들어준다.
	            }
	         }else{
	            if(dto.getShape() == Figure.LINE) {
	            	bufferG.drawLine(x1, y1, x2, y2);
	            }else if(dto.getShape() == Figure.CIRCLE) {
	            	bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));//Math.min(x1, x2) 을 사용한 이유. x좌표와 y좌표를 왼쪽위 ( 제일작은값) 으로 바꿔주기 위해서 min을 사용하였다.
	            }else if(dto.getShape() == Figure.RECT) {
	            	bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	            }else if(dto.getShape() == Figure.ROUNDRECT){
	            	bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
	            }
	            
	            
	         }//if
	         if(dto.getShape() == Figure.PEN) {
	        	 bufferG.drawLine(x1, y1, x2, y2);
	           }
	      }//for
	   
	   paint(g);
	}
   
   
   @Override
   public void paint(Graphics g) { //그림을 캔버스에 그릴 것 이기 때문에 DrCanvas에 paint를 생성해줘야함
     g.drawImage(bufferImage, 0, 0, this);
      
   }
}