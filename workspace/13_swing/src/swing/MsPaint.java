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
      fill = new JCheckBox("ä���");
      
      //JRadioButton
      line = new JRadioButton("��");
      circle = new JRadioButton("��");
      rect = new JRadioButton("�簢��",true);//(text,boolean) boolean�� true�� ������ �Ǹ� �����ڽ��� üũ�� ������
      roundRect = new JRadioButton("�ձٻ簢��");
      pen = new JRadioButton("����");
      ButtonGroup group = new ButtonGroup();
      //radioButton�� �ϳ��� ���õǸ� �ϳ��� ���� �Ǿ�� �ϱ� ������ ������ư�� �׷����� ���������.
      group.add(line);
      group.add(circle);
      group.add(rect);
      group.add(roundRect);
      group.add(pen);
      //�̿Ͱ��� ������ư�� �׷����� ���� �Ǹ� ������ư�� ȿ���� ���� �� ����.
      
      
      //JComboBox
      String color[] = {"����","�ʷ�","�Ķ�","����","�ϴ�"};
      combo = new JComboBox<String>(color);
      
      //JButton
      draw = new JButton("�׸���");
      
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
      setVisible(true); //ù ������ ����� setVisible �� ���鼭 paint �� �ѹ� �����̵�.
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
          
      
      //�̺�Ʈ
      draw.addActionListener(this);
      
      
      
      canvas.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {//setText�� �ؽ�Ʈ�ʵ尡 �����ϴ¸޼ҵ�
            x1T.setText(e.getX() + "");//���� + ���ڿ�
            y1T.setText(e.getY() + "");
         }
         
         
         @Override
         public void mouseReleased(MouseEvent e) {//���콺�� ������ ���� �� ��ǥ�� ���콺���� ���� �� ���� ��ǥ�� ������ ���ڸ����� Ŭ���� �� ��
            if(Integer.parseInt(x1T.getText()) == (e.getX()) && Integer.parseInt(y1T.getText()) == (e.getY())) {
            	return;//�巡�׸� ���� �ʾ����Ƿ� ��ü���߰���������
            }
        	 
             list.add(new ShapeDTO(MsPaint.this));  
             
             //��̸���Ʈ�� �����鼭 ��ü���� ShapeDTO�� ����
            
         }
         
         
         //MouseListener�� Dragged�� ������ ���� ���� 
         //���� �޼ҵ带 ���� canvas�� MouseListener �̺�Ʈ�� ����ϰڴٰ� ���ߴµ� MouseListener
         //�ȿ��� Dragged�� ���� ������ ������ �̺�Ʈ �ȿ� �ִ� �޼ҵ常 ������ ��� �Ѵ�.
         
//         @Override
//         public void mouseDragged(MouseEvent e) {
//            x2T.setText(e.getX() + "");
//            y2T.setText(e.getY() + "");
//            
//            canvas.repaint();
//            System.out.println("�巡��");
//         }
         //�� �ڵ尡 ������ ���� ���� ������ MouseAdapter�� �߻�޼ҵ带 ��� ������ �ֱ� �����̴�.
      }); 
      //���� ������� �� �� �־����� �巡�׵�� ���콺 ��� �����ʿ� �����Ƿ� �̺�Ʈ�� ���콺 ��� �����ʷ� ������ �־��
      //���������� ����� �� �ִ�.
      canvas.addMouseMotionListener(new MouseAdapter() {
         
         @Override
         public void mouseDragged(MouseEvent e) {
        	 
            x2T.setText(e.getX() + "");
            y2T.setText(e.getY() + "");
            
            
            canvas.repaint();//��̿� �ִ� ���� �ٽ� �׷��ְ�, ���� �׸����ִ°͵��׸�
            //repaint �� ����Ǹ� update() - paint() ������ ȣ����
            
            //��
            if(getPen().isSelected()) {
            	
       		 list.add(new ShapeDTO(MsPaint.this));//������Ʈ �� ��ü�� ��̿� ����
       		 
//       		 x1T = x2T;
//       		 y1T = y2T;
       		x1T.setText(x2T.getText()); //��̿� ������ �� x2,y2��ǥ�� ���� ���������� �ٲ��� 
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
