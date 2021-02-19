package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaint extends JFrame implements ActionListener{
   private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
   private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
   private JCheckBox fill;
   private JRadioButton line, circle, rect, roundRect, pen;
   private JComboBox<String> combo;
   private JButton draw;
   private DrCanvas canvas;
   private ArrayList<ShapeDTO> list;
   
   public MsPaint() {
      //JLabel
      x1L = new JLabel("x1");
      y1L = new JLabel("y1");
      x2L = new JLabel("x2");
      y2L = new JLabel("y2");
      z1L = new JLabel("z1");
      z2L = new JLabel("z2");
      
      //JTextField
      x1T = new JTextField("0",4);
      y1T = new JTextField("0",4);
      x2T = new JTextField("0",4);
      y2T = new JTextField("0",4);
      z1T = new JTextField("50",4);
      z2T = new JTextField("0",4);
      
      //JCehckBox
      fill = new JCheckBox("채우기");
      
      //JRadioButton
      line = new JRadioButton("선");
      circle = new JRadioButton("원");
      rect = new JRadioButton("사각형",true);//(text,boolean) boolean에 true를 누르게 되면 라디오박스에 체크가 들어가있음
      roundRect = new JRadioButton("둥근사각형");
      pen = new JRadioButton("연필");
      ButtonGroup group = new ButtonGroup();
      //radioButton은 하나가 선택되면 하나가 해제 되어야 하기 때문에 라디오버튼은 그룹으로 묶어줘야함.
      group.add(line);
      group.add(circle);
      group.add(rect);
      group.add(roundRect);
      group.add(pen);
      //이와같이 라디오버튼을 그룹으로 묶게 되면 라디오버튼의 효과를 얻을 수 있음.
      
      
      //JComboBox
      String color[] = {"빨강","초록","파랑","보라","하늘"};
      combo = new JComboBox<String>(color);
      
      //JButton
      draw = new JButton("그리기");
      
      canvas = new DrCanvas(this);
      
      list = new ArrayList<ShapeDTO>();
      
      
      JPanel northP = new JPanel();
      northP.add(x1L);
      northP.add(x1T);
      northP.add(x2L);
      northP.add(x2T);
      northP.add(y1L);
      northP.add(y1T);
      northP.add(y2L);
      northP.add(y2T);
      northP.add(z1L);
      northP.add(z1T);
      northP.add(z2L);
      northP.add(z2T);
      northP.add(fill);
      
      JPanel southP = new JPanel();
      
      southP.add(line);
      southP.add(circle);
      southP.add(rect);
      southP.add(roundRect);
      southP.add(pen);
      southP.add(combo);
      southP.add(draw);
      
      Container c = this.getContentPane();
      
      c.add("South", southP);
      c.add("Center", canvas);
      c.add("North", northP);
      
      setBounds(500,200,700,500);
//      setResizable(false);
      setVisible(true); //첫 생성자 실행시 setVisible 이 들어가면서 paint 가 한번 실행이됨.
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
          
      
      //이벤트
      draw.addActionListener(this);
      
      
      
      canvas.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {//setText는 텍스트필드가 제공하는메소드
            x1T.setText(e.getX() + "");//숫자 + 문자열
            y1T.setText(e.getY() + "");
         }
         
         
         @Override
         public void mouseReleased(MouseEvent e) {//마우스를 누르고 있을 때 좌표와 마우스에서 손을 뗄 때의 좌표가 같으면 제자리에서 클릭만 한 것
            if(Integer.parseInt(x1T.getText()) == (e.getX()) && Integer.parseInt(y1T.getText()) == (e.getY())) {
            	return;//드래그를 하지 않았으므로 객체를추가하지않음
            }
        	 
             list.add(new ShapeDTO(MsPaint.this));  
             
             //어레이리스트에 담으면서 객체값을 ShapeDTO에 저장
            
         }
         
         
         //MouseListener는 Dragged를 가지고 있지 않음 
         //위의 메소드를 보면 canvas가 MouseListener 이벤트를 사용하겠다고 말했는데 MouseListener
         //안에는 Dragged가 없기 때문에 무조건 이벤트 안에 있는 메소드만 정의해 줘야 한다.
         
//         @Override
//         public void mouseDragged(MouseEvent e) {
//            x2T.setText(e.getX() + "");
//            y2T.setText(e.getY() + "");
//            
//            canvas.repaint();
//            System.out.println("드래그");
//         }
         //이 코드가 에러가 나지 않은 이유는 MouseAdapter가 추상메소드를 모두 가지고 있기 때문이다.
      }); 
      //위의 결과에서 알 수 있었듯이 드래그드는 마우스 모션 리스너에 있으므로 이벤트를 마우스 모션 리스너로 지정해 주어야
      //정상적으로 사용할 수 있다.
      canvas.addMouseMotionListener(new MouseAdapter() {
         
         @Override
         public void mouseDragged(MouseEvent e) {
        	 
            x2T.setText(e.getX() + "");
            y2T.setText(e.getY() + "");
            
            
            canvas.repaint();//어레이에 있는 값을 다시 그려주고, 현재 그리고있는것도그림
            //repaint 가 실행되면 update() - paint() 순으로 호출함
            
            //펜
            if(getPen().isSelected()) {
            	
       		 list.add(new ShapeDTO(MsPaint.this));//리페인트 후 객체를 어레이에 저장
       		 
//       		 x1T = x2T;
//       		 y1T = y2T;
       		x1T.setText(x2T.getText()); //어레이에 저장한 후 x2,y2좌표를 펜의 시작점으로 바꿔줌 
        	y1T.setText(y2T.getText());
        	
            }
            
            
         }
         
      });
      
   }//MsPaint()
   

   public JTextField getX1T() {
      return x1T;
   }


   public JTextField getY1T() {
      return y1T;
   }


   public JTextField getX2T() {
      return x2T;
   }


   public JTextField getY2T() {
      return y2T;
   }


   public JTextField getZ1T() {
      return z1T;
   }


   public JTextField getZ2T() {
      return z2T;
   }


   public JCheckBox getFill() {
      return fill;
   }


   public JRadioButton getLine() {
      return line;
   }


   public JRadioButton getCircle() {
      return circle;
   }


   public JRadioButton getRect() {
      return rect;
   }


   public JRadioButton getRoundRect() {
      return roundRect;
   }


   public JRadioButton getPen() {
      return pen;
   }


   public JComboBox<String> getCombo() {
      return combo;
   }

   public ArrayList<ShapeDTO> getList(){
      return list;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      
      canvas.repaint();
      
   }
   
   
   
   public static void main(String[] args) {
      new MsPaint();

   }

}
