package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
   //�α��� �޼ҵ�
   private ArrayList<UserDTO> list;
   public UserController() {
      list = new ArrayList<>();
      UserDTO u1 = new UserDTO();
      u1.setId(1);
      u1.setUserId("admin");
      u1.setPassword("111");
      u1.setNickname("���");
      
      UserDTO u2 = new UserDTO();
      u2.setId(2);
      u2.setUserId("a");
      u2.setPassword("222");
      u2.setNickname("����� a");
      
      UserDTO u3 = new UserDTO();
      u3.setId(3);
      u3.setUserId("b");
      u3.setPassword("333");
      u3.setNickname("����� b");
      
      list.add(u1);
      list.add(u2);
      list.add(u3);
   }
   
   public boolean isDuplivatedUserId(String id) {
	   for(UserDTO u : list) {
		   if(u.getUserId().equals(id)) {  //u �� ����ִ� ��� ��̸���Ʈ�� userid�� ���� ������ userid �� ���Ͽ� ���� ���� ������ true�� ��ȯ
			   return true;
		   }
	   }
	   return false;
   }
   
   public UserDTO logIn(UserDTO attempt) {
      UserDTO logIn = null;
      for(UserDTO u : list) {
    	  //���� �迭�̳� ����Ʈó�� �Ѱ��� ������Ÿ���� ������ ������ ���
    	  //0�� �ε������� ������ �ϳ��� �̾Ƴ��� u ��� �θ���.
    	  if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) { //�Ķ���ͷ� ���� attempt�� userid�� password �� ���� list�� ����Ǿ��ִ� ����� ������ ���ϴ°�
    		  logIn = u;
    	  }
      }
      return logIn;
   }
   
   public void insert(UserDTO u) {
	   list.add(u);
   }
}