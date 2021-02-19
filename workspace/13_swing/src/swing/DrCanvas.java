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
   
   
   //ĵ���� ȭ�鿡 �����Ÿ��� ���ַ���
   //���� �������� �׸��� �׸��� ���������� �׸��� �� �׷� ���� ��,
   //���� �׸��� ȭ�鿡 ȣ���� �ָ� �ȴ�.
   
   
   @Override
	public void update(Graphics g) { //repaint() �� �����ϸ� update -> paint ������ ȣ���Ѵ�.
	   
	   Dimension d = this.getSize(); //��ȯ���� Dimension �� �簢 ������ ũ�⸦ ������ �ִ�.
	   //this - ������.  ���� �������� ũ�⸦ d �� �����ض�
	   
	   if(bufferG == null) {//bufferG �� null �� ���� �׸��� �׸��� ���� ���� ó���ۿ� ����.
		   bufferImage = createImage(d.width,d.height);//ĵ������ ũ�⸸ŭ �̹����� �����ض�
		   bufferG = bufferImage.getGraphics();//������ �̹����� ���� �̹����� ����ϰ� ������ bufferG���ٰ� �׸��� �׸��Ŵ�.
	   }
	   
	   //�����( ��ǻ� ����� ���� �ƴ� ������� ���� �������� ��������°�
	   Color c = this.getBackground();// ���� Canvas �������� ������	   
	   bufferG.setColor(c);
	   bufferG.fillRect(0, 0, d.width, d.height);
	   
	   
	   int x1,y1,x2,y2,z1,z2;
	      this.list = mp.getList();
	      
	      //���콺�� �巡�� �� �� �ʿ��� ������ mp �� ��������Ƿ� mp��ü�ε� �Ѱ� �߰����־���.
	      
	      x1 = Integer.parseInt(mp.getX1T().getText().trim());//trim() �� ���ڿ� �յڿ� ������ �ִٸ� ���ڿ��� �����Ѵ�.
	      y1 = Integer.parseInt(mp.getY1T().getText().trim());
	      x2 = Integer.parseInt(mp.getX2T().getText().trim());
	      y2 = Integer.parseInt(mp.getY2T().getText().trim());
	      z1 = Integer.parseInt(mp.getZ1T().getText().trim());
	      z2 = Integer.parseInt(mp.getZ2T().getText().trim());
	      
	      //��
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
	      //����
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
	        	 bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));//Math.min(x1, x2) �� ����� ����. x��ǥ�� y��ǥ�� ������ ( ����������) ���� �ٲ��ֱ� ���ؼ� min�� ����Ͽ���.
	         }else if(mp.getRect().isSelected()) {
	        	 bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	         }else if(mp.getRoundRect().isSelected()){
	        	 bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), 50, 50);
	         }
	      }
	      
	      if(mp.getPen().isSelected()) {
	    	  bufferG.drawLine(x1, y1, x2, y2);
	    	  
	      }
	      
	      //repaint�� ȣ��Ǹ� �׸��� �� �������� ������
	      //ArrayList ���� ������ �ϳ��� ������ �ٽ� �׷��ش�.
	      for(int i = 0; i < list.size() ; i++) {
	         ShapeDTO dto = list.get(i);
	      //for(ShapeDTO dto : mp.getList()){
	      // �̷��� ����ص� ������ ����
	      
	      
	      //���� mp.getX1T���� ȭ�鿡 �ƹ��� ���� �Է����� ���� �����̹Ƿ� ���� ���� �����ε�,
	      //���� Integer�������� �ٲ������ ����Ͽ� NumberFormatException ������ �߻��ϰԵ�.
//	      x1 = Integer.parseInt(mp.getX1T().getText().trim());//trim() �� ���ڿ� �յڿ� ������ �ִٸ� ���ڿ��� �����Ѵ�.
//	      y1 = Integer.parseInt(mp.getY1T().getText().trim());
//	      x2 = Integer.parseInt(mp.getX2T().getText().trim());
//	      y2 = Integer.parseInt(mp.getY2T().getText().trim());
//	      z1 = Integer.parseInt(mp.getZ1T().getText().trim());
//	      z2 = Integer.parseInt(mp.getZ2T().getText().trim());
	      //1. x1T �� ���� ���� ������
	      //2. ���ڿ��� ������ "100"�� ���������� �ٲ۴� "100" ---> 100
	      
	         x1 = dto.getX1T();
	         y1 = dto.getY1T();
	         x2 = dto.getX2T();
	         y2 = dto.getY2T();
	         z1 = dto.getZ1T();
	         z2 = dto.getZ2T();
	      
	      //��
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
	      
	      
	         //����
	         if(dto.getFill()) {
	            if(dto.getShape() == Figure.LINE){//enum �Լ��� ����� ���������� public final static �� ������ �����Ƿ� Ŭ������ �޶� ����� �����ϴ�.
	            	bufferG.drawLine(x1, y1, x2, y2);
	            }else if(dto.getShape() == Figure.CIRCLE) {
	            	bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));// ���콺��
	            }else if(dto.getShape() == Figure.RECT) {
	            	bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
	            }else if(dto.getShape() == Figure.ROUNDRECT) { 
	            	bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
	            
	               //���̿� ���̴� ������ �� �� �����Ƿ� Math.abs(x2-x1) �� ����Ͽ� ���̿� ���̸� ����� ������ش�.
	            }
	         }else{
	            if(dto.getShape() == Figure.LINE) {
	            	bufferG.drawLine(x1, y1, x2, y2);
	            }else if(dto.getShape() == Figure.CIRCLE) {
	            	bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));//Math.min(x1, x2) �� ����� ����. x��ǥ�� y��ǥ�� ������ ( ����������) ���� �ٲ��ֱ� ���ؼ� min�� ����Ͽ���.
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
   public void paint(Graphics g) { //�׸��� ĵ������ �׸� �� �̱� ������ DrCanvas�� paint�� �����������
     g.drawImage(bufferImage, 0, 0, this);
      
   }
}