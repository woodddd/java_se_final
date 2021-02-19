package friend.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import friend.bean.FriendDTO;

public class FriendDAO {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String username = "c##java";
   private String password = "bit";
   
   private static FriendDAO instance;
   
   public FriendDAO() {
      try {
         Class.forName(driver);
         System.out.println("����̹� �ε� ����");
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }//������
   
   public void getConnection() {
      try {
         conn = DriverManager.getConnection(url,username,password);
         System.out.println("���� ����");
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }

   public static FriendDAO getInstance() { //����ƽ�� ���� ���� ���� ó�� �� �� ��.
      if(instance == null) { //getInstance �� ���� ó�� ����� ���� null ���� ������ ����!
         synchronized(FriendDAO.class) {//���� �������� �����尡 ���,���� ���� �ϰ� �� �� db���� ������ ���� ��ü���� �ϸ� �ȵǱ� ������ �Ѱ��� ��ü�� �̿��ϱ� ���Ͽ� �ش� ������ �������.
            instance = new FriendDAO();//ó�� ������ �� �� 1���� ����ȴ� - ����ȭ(synchronized)
         }
      }
      return instance;
   }

   public int insertArticle(FriendDTO dto) {
      int su = 0;
      String sql = "insert into friend values(?,?,?,?,?,?,?,?,?,?,?)";
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, dto.getSeq());
         pstmt.setString(2, dto.getName());
         pstmt.setString(3, dto.getTel1());
         pstmt.setString(4, dto.getTel2());
         pstmt.setString(5, dto.getTel3());
         pstmt.setInt(6, dto.getGender());
         pstmt.setInt(7, dto.getRead());
         pstmt.setInt(8, dto.getMovie());
         pstmt.setInt(9, dto.getMusic());
         pstmt.setInt(10, dto.getGame());
         pstmt.setInt(11, dto.getShopping());
         
         su = pstmt.executeUpdate();//������ ���� ���� ��ȯ
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return su;
   }//�޼ҵ� �ݤ��°�

   public int getSeq() { //db�� ���� Seq �ѹ��� �޾ƿ������� ���
      int seq = 0;
      String sql = "select seq_friend.nextval from dual";
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);//����
         rs = pstmt.executeQuery();//����
         
         rs.next(); //������ ���̺�(dual) �� �Էµ� ���� �ϳ��ۿ� ���� ������ while���� ������ �ʾƵ� �ȴ�.
         //rs.next()�� �����ϰ� �Ǹ� 1��° ���ڵ� ���� �����Ͽ� ���� �����ϸ� true/ ������ false �� �ϰ� �ȴ�.
         seq = rs.getInt(1);// ���� �÷������� nextval �� ������ �Ǵµ�, �÷����� ����ϱ� �ָ��ϴϱ� 1��° �ʵ��� ���� ��������� ���� ����.
         //���� ������ ���̺� dual �� �� 1���� �ʵ�� 1���� ���ڵ常�� �����Ѵ�. �׷��� next�� ����Ű�� ���� �������� �ϸ� seq���� ������ �� �ִ� ���̴�.
         
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) {
               rs.close();
            }
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
         }catch(SQLException e) {
            e.printStackTrace();
         }   
      }
      
      System.out.println("seq  = " + seq);
      return seq;
   }//getSeq();

   public List<FriendDTO> getFriendList() {
      List<FriendDTO> dtoList = new ArrayList<FriendDTO>();//List�� �������̽� �̱� ������ new�� �� ���� 
      String sql = "select * from friend order by seq";
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);//����
         rs = pstmt.executeQuery();//����
         
         while(rs.next()) {
            FriendDTO dto = new FriendDTO();
            
            dto.setSeq(rs.getInt("seq"));
            dto.setName(rs.getString("name"));
            dto.setTel1(rs.getString("tel1"));
            dto.setTel2(rs.getString("tel2"));
            dto.setTel3(rs.getString("tel3"));
            dto.setGender(rs.getInt("gender"));
            dto.setRead(rs.getInt("read"));
            dto.setMovie(rs.getInt("movie"));
            dto.setMusic(rs.getInt("music"));
            dto.setGame(rs.getInt("game"));
            dto.setShopping(rs.getInt("shopping"));
            
            dtoList.add(dto);
                     
         }
      } catch (SQLException e) {
         
         e.printStackTrace();
      } finally {
         try {
            if(rs != null) {
               rs.close();
            }
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
         }catch(SQLException e) {
            e.printStackTrace();
         }   
      }
      
      
      return dtoList;
   }

   
   public int updateArticle(FriendDTO dto) {
      int su = 0;
      String sql = "update friend set seq=?, name=?, tel1=?,tel2=?, tel3=?, gender=?, read=?, movie=?, music=?, game=?, shopping=? where seq =  " + dto.getSeq() ;
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, dto.getSeq());
         pstmt.setString(2, dto.getName());
         pstmt.setString(3, dto.getTel1());
         pstmt.setString(4, dto.getTel2());
         pstmt.setString(5, dto.getTel3());
         pstmt.setInt(6, dto.getGender());
         pstmt.setInt(7, dto.getRead());
         pstmt.setInt(8, dto.getMovie());
         pstmt.setInt(9, dto.getMusic());
         pstmt.setInt(10, dto.getGame());
         pstmt.setInt(11, dto.getShopping());
         
         su = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }finally {
         try {
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return su;
   }

   public int deleteArticle(FriendDTO dto) {
      int su = 0;
      String sql = "delete friend where seq = " + dto.getSeq();
      getConnection();
      
      try {
         pstmt = conn.prepareStatement(sql);
         su = pstmt.executeUpdate();
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         try {
            if(pstmt != null) {
               pstmt.close();
            }
            if(conn != null) {
               conn.close();
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return su;
   }
   

}