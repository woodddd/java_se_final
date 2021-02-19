package exception;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PackmanTeacher extends Frame implements KeyListener, Runnable {
   private Image img;
   private int sel=2;
   private int x=225, y=225;
   private int mx, my;
   
   public PackmanTeacher() {
      img = Toolkit.getDefaultToolkit().getImage("pacman.png"); //이미지 불러오기
            
      setResizable(false);
      setBounds(700, 200, 500, 500);
      setVisible(true);
      addWindowListener(new WindowAdapter(){
         @Override
         public void windowClosing(WindowEvent e){
            System.exit(0);
         }
      });
      
      //이벤트
      this.addKeyListener(this);
      
      //스레드 생성
      Thread t = new Thread(this);
      //스레드 실행
      t.start();
   }
   
   @Override
   public void paint(Graphics g) {
      g.drawImage(img, 
            
            x, y, x+50, y+50, //화면위치
            
            sel*50, 0, sel*50+50, 50, //이미지위치 
            this);
   }
   
   @Override
   public void run() {
      while(true) {
         if(sel%2==0) sel++;
         else sel--;
         
         x += mx;
         y += my;
         
         repaint();
         try {
            Thread.sleep(100); // 기본이 1/1000초
         } catch (InterruptedException e) {
            e.printStackTrace();
         } 
      }//while      
   }

   @Override
   public void keyPressed(KeyEvent e) {
      if(e.getKeyCode() == KeyEvent.VK_ESCAPE){ //27
         System.exit(0);
      
      }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
         sel=0;
         mx = -10; my = 0;
      }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
         sel=2;
         mx = 10; my = 0;
         
      }else if(e.getKeyCode() == KeyEvent.VK_UP) {
         sel=4;
         mx = 0; my = -10;
         
      }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
         sel=6;
         mx = 0; my = +10;
         
      }
   }

   @Override
   public void keyReleased(KeyEvent e) {}

   @Override
   public void keyTyped(KeyEvent e) {}
   
   public static void main(String[] args) {
      new PackmanTeacher();

   }

}









