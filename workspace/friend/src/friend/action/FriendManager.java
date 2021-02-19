package friend.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener,ListSelectionListener{
   private JLabel infoL, analyL, listL, nameL, telL, genderL, hobL, spaceL, space2L;
   private JTextField nameT, tel2T, tel3T;
   private JComboBox<String> tel1;
   private JTextArea analyT;
   private JList<FriendDTO> listT;
   private DefaultListModel<FriendDTO> model;
   private JButton regiBtn, modiBtn, trashBtn, deleBtn;
   private JRadioButton man, woman;
   private JCheckBox read, movie, music, game, shopping;
   
   
   public FriendManager() {
      //JLabel ����
      infoL = new JLabel("���������Է�");
      analyL = new JLabel("���������м�");
      listL = new JLabel("��ü���");
      nameL = new JLabel("��        �� :");
      telL = new JLabel("��ȭ��ȣ : ");
      genderL = new JLabel("��        �� :");
      hobL = new JLabel("��        �� :");
      spaceL = new JLabel(" - ");
      space2L = new JLabel(" - ");
      
      //JTextField ����
      nameT = new JTextField(7);
      tel2T = new JTextField(3);
      tel3T = new JTextField(3);
      
      String[] number = {"010","02","031","032","033"};
      tel1 = new JComboBox<String>(number);
      
      analyT = new JTextArea();
      
      model = new DefaultListModel<FriendDTO>();
      listT = new JList<FriendDTO>(model);
      
      regiBtn = new JButton("���");
      modiBtn = new JButton("����");
      deleBtn = new JButton("����");
      trashBtn = new JButton("�����");
      
      
      regiBtn.setEnabled(true);
      modiBtn.setEnabled(false);
      trashBtn.setEnabled(false);
      deleBtn.setEnabled(false);
      
      man = new JRadioButton("����",true);
      man.setBackground(new Color(250, 100, 100));
      woman = new JRadioButton("����");
      woman.setBackground(new Color(250, 100, 100));
      
      ButtonGroup group = new ButtonGroup();
      group.add(man);
      group.add(woman);
      
      read = new JCheckBox("����");
      movie = new JCheckBox("��ȭ");
      music = new JCheckBox("����");
      game = new JCheckBox("����");
      shopping = new JCheckBox("����");
      read.setBackground(new Color(250, 100, 100));
      movie.setBackground(new Color(250, 100, 100));
      music.setBackground(new Color(250, 100, 100));
      game.setBackground(new Color(250, 100, 100));
      shopping.setBackground(new Color(250, 100, 100));
      
      infoL.setBounds(150, 10, 200, 20);
      listL.setBounds(450, 10, 200, 20);
      analyL.setBounds(260, 320, 190, 20);
      
      setBackground(new Color(128, 128, 192));

      
      JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      p1.add(nameL);
      p1.add(nameT);
      p1.setBounds(10, 50, 200, 25);
      p1.setBackground(new Color(250, 100, 100));

      JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      p2.add(telL);
      p2.add(tel1);
      p2.add(spaceL);
      p2.add(tel2T);
      p2.add(space2L);
      p2.add(tel3T);
      p2.setBounds(10, 90, 300, 30);
      p2.setBackground(new Color(250, 100, 100));
      
      JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      p3.add(genderL);
      p3.add(man);
      p3.add(woman);
      p3.setBounds(10, 130, 200, 30);
      p3.setBackground(new Color(250, 100, 100));
      
      JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
      p4.add(hobL);
      p4.add(read);
      p4.add(movie);
      p4.add(music);
      p4.add(game);
      p4.add(shopping);
      p4.setBounds(10, 170, 350, 30);
      p4.setBackground(new Color(250, 100, 100));
      
      JPanel p5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
      p5.add(regiBtn);
      p5.add(modiBtn);
      p5.add(deleBtn);
      p5.add(trashBtn);
      p5.setBounds(10, 210, 300, 50);
      p5.setBackground(new Color(250, 100, 100));
      
      analyT.setBounds(20, 350, 600, 110);
      listT.setBounds(380, 50, 230, 250);
      
      Container c = this.getContentPane();
      c.setBackground(new Color(250, 100, 100));
      c.add(infoL);
      c.add(listL);
      c.add(analyL);
      c.add(p1);
      c.add(p2);
      c.add(p3);
      c.add(p4);
      c.add(p5);
      c.add(analyT);
      c.add(listT);
      
      //2.������ ����
      setLayout(null);
      setBounds(700, 300, 650, 530);
      setVisible(true);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      //��� ���ڵ带 ������ JList�� �Ѹ��� (�ܼ� ���� �� ����� �Ͽ��� ���� �����Ͱ� ��������.)
      FriendDAO dao = FriendDAO.getInstance();
      List<FriendDTO> dtolist = dao.getFriendList();
      for(FriendDTO dto: dtolist) { //�����ͺ��̽��� ����Ǿ� �ִµ����͸� �����ͼ� �ٽ� �𵨿� ����ش�.
         model.addElement(dto);
      }
   }//FriendManager();
   
   public void event() {
      
      regiBtn.addActionListener(this);
      modiBtn.addActionListener(this);
      deleBtn.addActionListener(this);
      trashBtn.addActionListener(this);
      
      listT.addListSelectionListener(this);
      
   }
   
   
   @Override
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == regiBtn) {
         
         insertarticle();
        
      }else if(e.getSource() == modiBtn) {
         updateArticle();
      }else if(e.getSource() == deleBtn) {
         deleteArticle();
      }else if(e.getSource() == trashBtn) {
         clear();
      }
      
   }
   

   private void updateArticle() {
      
      String name = nameT.getText();
         
      String tel1 = (String) this.tel1.getSelectedItem();
      
      String tel2 = (String) this.tel2T.getText();
      
      String tel3 = (String) this.tel3T.getText();
      int gender = 0;
      if(man.isSelected()) gender = 0;
      else if(woman.isSelected()) gender = 1;
      
      
      //read, movie, music, game, shopping;
      int read = this.read.isSelected() ? 1 : 0;
      int movie = this.movie.isSelected() ? 1 : 0;
      int music = this.music.isSelected() ? 1 : 0;
      int game = this.game.isSelected() ? 1 : 0;
      int shopping = this.shopping.isSelected() ? 1 : 0;
      
      FriendDTO dto = listT.getSelectedValue();//���� ���õ� dto ��ü�� ������´�.
      
      dto.setName(name);
      dto.setTel1(tel1);
      dto.setTel2(tel2);
      dto.setTel3(tel3);
      dto.setGender(gender);
      dto.setRead(read);
      dto.setMovie(movie);
      dto.setMusic(music);
      dto.setGame(game);
      dto.setShopping(shopping);
      FriendDAO dao = FriendDAO.getInstance(); //�̱������� ����
      
      int su = dao.updateArticle(dto);//dao �� dinsertAticle �޼ҵ带 ���.
         
      analyT.setText("\n\t\t" + su + "���� ���� ����������ϴ�");
      
   }

   private void deleteArticle() {
      
      FriendDTO dto = listT.getSelectedValue();
      
      FriendDAO dao = FriendDAO.getInstance();
      
      int su = dao.deleteArticle(dto);
      
      model.remove(listT.getSelectedIndex());
      
      clear();
       analyT.setText("\n\t\t"+su+"���� ���� �����Ǿ����ϴ�");
      
      
            
   }

   private void clear() {
         nameT.setText("");
         tel1.setSelectedItem("010");
         tel2T.setText("");
         tel3T.setText("");
         man.setSelected(true);
         woman.setSelected(false);
         read.setSelected(false);
         movie.setSelected(false);
         music.setSelected(false);
         game.setSelected(false);
         shopping.setSelected(false);
         
         analyT.setText("");
         
         regiBtn.setEnabled(true);
         modiBtn.setEnabled(false);
         deleBtn.setEnabled(false);
         trashBtn.setEnabled(false);
   }

   public void insertarticle() {
       //������
      String name = nameT.getText();
      
      String tel1 = (String) this.tel1.getSelectedItem();
      
      String tel2 = (String) this.tel2T.getText();
      
      String tel3 = (String) this.tel3T.getText();
      int gender = 0;
      if(man.isSelected()) gender = 0;
      else if(woman.isSelected()) gender = 1;
      
      
      //read, movie, music, game, shopping;
      int read = this.read.isSelected() ? 1 : 0;
      int movie = this.movie.isSelected() ? 1 : 0;
      int music = this.music.isSelected() ? 1 : 0;
      int game = this.game.isSelected() ? 1 : 0;
      int shopping = this.shopping.isSelected() ? 1 : 0;
      
      //FriendDTO
      FriendDTO dto = new FriendDTO();
      dto.setName(name);
      dto.setTel1(tel1);
      dto.setTel2(tel2);
      dto.setTel3(tel3);
      dto.setGender(gender);
      dto.setRead(read);
      dto.setMovie(movie);
      dto.setMusic(music);
      dto.setGame(game);
      dto.setShopping(shopping);
         
      //DB
      FriendDAO dao = FriendDAO.getInstance(); //�̱������� ����
      int seq = dao.getSeq();//������ ��ü�κ��� ���� �޾ƿ���
      
      dto.setSeq(seq);//dao Ŭ�������� �޾ƿ� Seq�� dto�� seq�� �����Ѵ�.(��ü�� seq��ȣ ����)
      int su = dao.insertArticle(dto);//dao �� dinsertAticle �޼ҵ带 ���.
         
      //����
      clear();//�Է��� �������� ���� ����Ʈ�� �־��ְ� �ش� �ؽ�Ʈ�ʵ带 �ʱ�ȭ������.
      analyT.setText("\n\t\t" + su + "���� ���� ����������ϴ�");
      
      model.addElement(dto);
      
      
   }

   @Override
   public void valueChanged(ListSelectionEvent e) {
      System.out.println("������ index��ȣ" + listT.getSelectedIndex());//���� �ι��� ����. ���콺 �������� �ѹ�, ������� �ѹ�
      
      FriendDTO dto = listT.getSelectedValue();//getSelectedValue()��FrienddtoŸ���� ��ȯ�Ͽ� �ּҰ��� dto���� �Ѱ��ְԵȴ�.
      
      
      if(e.getValueIsAdjusting()) {//�ߺ��� ����

      nameT.setText(dto.getName());
      tel1.setSelectedItem(dto.getTel1());
      tel2T.setText(dto.getTel2());
      tel3T.setText(dto.getTel3());
      if(dto.getGender() == 0) {
         man.setSelected(true);
      }else if(dto.getGender() == 1) {
         woman.setSelected(true);
      }
      read.setSelected(dto.getRead() == 1 ? true : false);
      movie.setSelected(dto.getMovie() == 1 ? true : false);
      music.setSelected(dto.getMusic() == 1 ? true : false);
      game.setSelected(dto.getGame() == 1 ? true : false);
      shopping.setSelected(dto.getShopping() == 1 ? true : false);
         
      analyT.setText("");
      
      regiBtn.setEnabled(false);
      modiBtn.setEnabled(true);
      deleBtn.setEnabled(true);
      trashBtn.setEnabled(true);
      }//if
   }
   
   public static void main(String[] args) {
      new FriendManager().event();
   }


}