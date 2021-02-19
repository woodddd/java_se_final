package io;

import javax.swing.table.DefaultTableModel;

public interface Score { //인터페이스에는 추상메소드와 상수만이 담길 수 있다.

   public void input(ScoreDTO dto);

   public void print(DefaultTableModel model);

   public void save();

   public void search(DefaultTableModel model);

   public void tot_desc();

   public void load();

}