package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//CardLayout
public class CardTest {
   private Frame frame; //Frame - BorderLayout
   private CardLayout card;
   
   public CardTest() {
      frame = new Frame();
      card = new CardLayout();
      
      frame.setLayout(card);//레이아웃을 카드로 바꿔놓았으므로 색깔이 층층이 쌓여 올라감.카드가 겹쳐있는것을 생각하면됨
      
      //Panel 6장
      Panel[] p = new Panel[6];
      Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW};
      String[] title = {"빨강", "초록", "파랑", "보라", "하늘", "노랑"};
      
      for(int i=0; i<p.length; i++) {
         p[i] = new Panel();
         p[i].setBackground(color[i]);
         
         frame.add(p[i], title[i]);//add는 레이아웃마다 사용 방법이 달라짐. 그래서 카드 레이아웃을 사용하게 되면 ( 패널, 이름) 이런식으로 정의해 준 것임
         
         //이벤트
         p[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               //card.show(frame, "하늘"); // "" 문자열에 해당하는 프레임을 보여줌
               card.next(frame); //클릭시 무조건 다음장으로 넘김
               
            }
         });
      }//for      
      
      frame.setBounds(900,100,300,300);
      frame.setVisible(true);
      
      //이벤트
      frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
               System.exit(0);
            }
         });

   }

   public static void main(String[] args) {
      new CardTest();

   }

}