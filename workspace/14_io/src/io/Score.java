package io;

import javax.swing.table.DefaultTableModel;

public interface Score { //�������̽����� �߻�޼ҵ�� ������� ��� �� �ִ�.

   public void input(ScoreDTO dto);

   public void print(DefaultTableModel model);

   public void save();

   public void search(DefaultTableModel model);

   public void tot_desc();

   public void load();

}