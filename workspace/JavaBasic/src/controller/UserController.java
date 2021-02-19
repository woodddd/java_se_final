package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
   //로그인 메소드
   private ArrayList<UserDTO> list;
   public UserController() {
      list = new ArrayList<>();
      UserDTO u1 = new UserDTO();
      u1.setId(1);
      u1.setUserId("admin");
      u1.setPassword("111");
      u1.setNickname("운영자");
      
      UserDTO u2 = new UserDTO();
      u2.setId(2);
      u2.setUserId("a");
      u2.setPassword("222");
      u2.setNickname("사용자 a");
      
      UserDTO u3 = new UserDTO();
      u3.setId(3);
      u3.setUserId("b");
      u3.setPassword("333");
      u3.setNickname("사용자 b");
      
      list.add(u1);
      list.add(u2);
      list.add(u3);
   }
   
   public boolean isDuplivatedUserId(String id) {
	   for(UserDTO u : list) {
		   if(u.getUserId().equals(id)) {  //u 에 담겨있는 모든 어레이리스트의 userid와 현재 들어오는 userid 를 비교하여 같은 것이 있으면 true를 반환
			   return true;
		   }
	   }
	   return false;
   }
   
   public UserDTO logIn(UserDTO attempt) {
      UserDTO logIn = null;
      for(UserDTO u : list) {
    	  //만약 배열이나 리스트처럼 한가지 데이터타입이 여러개 모여있을 경우
    	  //0번 인덱스부터 끝까지 하나씩 뽑아내서 u 라고 부른다.
    	  if(attempt.getUserId().equals(u.getUserId()) && attempt.getPassword().equals(u.getPassword())) { //파라미터로 들어온 attempt의 userid와 password 가 현재 list에 저장되어있는 값들과 같은지 비교하는것
    		  logIn = u;
    	  }
      }
      return logIn;
   }
   
   public void insert(UserDTO u) {
	   list.add(u);
   }
}