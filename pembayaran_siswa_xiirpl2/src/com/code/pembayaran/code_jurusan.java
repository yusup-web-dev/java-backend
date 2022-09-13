/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.pembayaran;
import com.form.pembayaran.form_biodata;
import com.form.pembayaran.form_jurusan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pembayaran_siswa_xiirpl2.Pembayaran_siswa_xiirpl2;
/**
 *
 * @author rpl
 */
public class code_jurusan {
    
    ResultSet res = null;
    Statement stat = null;
    Connection con = new Pembayaran_siswa_xiirpl2().getCon();
    
    public void bersih(form_jurusan b){
        b.jtkdjurusan.setText("");
        b.jtnamajurusan.setText("");
        b.jtketuajurusan.setText("");
        b.jtjmlkelas.setText("0");
        b.jtcarikdjurusan.setText("");
    }
    
    
     public void kunci(form_jurusan k){
        k.jtkdjurusan.setEnabled(false);
        k.jtnamajurusan.setEnabled(false);
        k.jtketuajurusan.setEnabled(false);
        k.jtjmlkelas.setEnabled(false);
        k.jbubah.setEnabled(false);
        k.jbhapus.setEnabled(false);
        k.jbsimpan.setEnabled(false);
    }
     
      public void buka_kunci(form_jurusan bk){
        bk.jtkdjurusan.setEnabled(true);
        bk.jtnamajurusan.setEnabled(true);
        bk.jtketuajurusan.setEnabled(true);
        bk.jtjmlkelas.setEnabled(true);
        bk.jbsimpan.setEnabled(true);
        bk.jtkdjurusan.requestFocus(true);
    }
      
        public void tampildata(form_jurusan td) {
          DefaultTableModel tbjurusan = new DefaultTableModel();
          tbjurusan.addColumn("KD Jurusan");
          tbjurusan.addColumn("Nama Jurusan");
          tbjurusan.addColumn("Ketua Jurusan");
          tbjurusan.addColumn("Jml Kelas");
         
          try{
              String sql = "select*from jurusan";
              Statement stat = con.createStatement();
              ResultSet res = stat.executeQuery(sql);
              while (res.next()) {
                  tbjurusan.addRow(new Object[]{
                      res.getString(1),  res.getString(2),
                      res.getString(3),  res.getString(4)});
                  }
                   td.jtablejurusan.setModel(tbjurusan);
                } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Data gagal tampil" + e);                   
               }
      }
        public void simpan(form_jurusan s){
          if (s.jtkdjurusan.getText().isEmpty()
          || s.jtnamajurusan.getText().isEmpty()
          || s.jtketuajurusan.getText().isEmpty()
          || s.jtjmlkelas.getText().isEmpty()
           ) {
              JOptionPane.showMessageDialog(null, "Harap Lengkapi Data", "Warning",
              JOptionPane.INFORMATION_MESSAGE );
          } else {
              String kdjur = s.jtkdjurusan.getText();
              String namajur = s.jtnamajurusan.getText();
              String ketuajur = s.jtketuajurusan.getText();
              String jmlkelas = s.jtjmlkelas.getText();
              
              try {
                  
                  String sql = "insert into jurusan(kd_jurusan,nama_jurusan,ketua_jurusan,jml_kelas)value"
                          + "('" + kdjur + "','" + namajur + "','" + ketuajur + "','" + jmlkelas + "')";
                  
                  stat = con.createStatement();
                  stat.execute(sql);
                  bersih(s);
                  JOptionPane.showMessageDialog(null,"Data Tersimpan");
                  tampildata(s);

                  
              }catch (Exception e){
                  JOptionPane.showMessageDialog(null, "Proses Menyimpan Gagal",
                          "Error", JOptionPane.ERROR_MESSAGE);
                  System.out.println(e.getMessage());
                  e.printStackTrace();
}
           }
          } 

      


    public void cari_data(form_jurusan cd){
          
          DefaultTableModel tabjurusan = new DefaultTableModel();
          
          tabjurusan.addColumn("KD JURUSAN");
          tabjurusan.addColumn("NAMA JURUSAN");
          tabjurusan.addColumn("KETUA JURUSAN");
          tabjurusan.addColumn("JUMLAH KELAS");
          
        
          
          try{
               String cari = cd.jtcarikdjurusan.getText();
               Statement stat = this.con.createStatement();
               String sql = "select*from jurusan where kd_jurusan like '%" + cari + "%'";
               ResultSet res = stat.executeQuery(sql);
                while (res.next()) {
                  tabjurusan.addRow(new Object[]{
                      res.getString(1),  res.getString(2),
                      res.getString(3),  res.getString(4)
//                      res.getString(5),  res.getString(6)
                  });
                  
                  cd.jtkdjurusan.setText(res.getString(1));
                  cd.jtnamajurusan.setText(res.getString(2));
                  cd.jtketuajurusan.setText(res.getString(3));
                  cd.jtjmlkelas.setText(res.getString(4));
//                  cd.jcjeniskelamin.setSelectedItem(res.getString(5));
//                  cd.jckdjurusan.setSelectedItem(res.getString(6));
                  
                 }
                cd.jtablejurusan.setModel(tabjurusan);
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Gagal Cari Data" + e);
          }
      }
    
      public void klik_table(form_jurusan kt) {
          int row = kt.jtablejurusan.getSelectedRow();
          kt.jtkdjurusan.setText(kt.jtablejurusan.getModel().getValueAt(row,0).toString());
          kt.jtnamajurusan.setText(kt.jtablejurusan.getModel().getValueAt(row,1).toString());
          kt.jtketuajurusan.setText(kt.jtablejurusan.getModel().getValueAt(row,2).toString());
          kt.jtjmlkelas.setText(kt.jtablejurusan.getModel().getValueAt(row,3).toString());
//          kt.jcjeniskelamin.setSelectedItem(kt.jtablejurusan.getModel().getValueAt(row,4).toString());
//          kt.jckdjurusan.setSelectedItem(kt.jtablejurusan.getModel().getValueAt(row,5).toString());
          
          kt.jbhapus.setEnabled(true);
          kt.jbubah.setEnabled(true);
          kt.jbsimpan.setEnabled(false);
      }
      
      
      
        public void ubah(form_jurusan u) {
          try {
              Statement stat = con.createStatement();
              String sql = "update jurusan set kd_jurusan = '" + u.jtkdjurusan.getText()
                      +"',"+" nama_jurusan = '" + u.jtnamajurusan.getText()
                      +"',"+" ketua_jurusan = '" + u.jtketuajurusan.getText()
                      +"',"+" jml_kelas = '" + u.jtjmlkelas.getText()
                      +"'"+ "where kd_jurusan = '" + u.jtkdjurusan.getText()+ "'";
              stat.executeUpdate(sql);
              bersih(u);
              tampildata(u);
              JOptionPane.showMessageDialog(null, "Data telah diubah");
              u.jbsimpan.setEnabled(true);
              u.jbubah.setEnabled(false);
              u.jbhapus.setEnabled(false);
          }catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Data gagal diubah", "Error", JOptionPane.ERROR_MESSAGE);
              System.out.println(e.getMessage());
          }
       }
      
      public void hapus(form_jurusan h) {
          try {
              int pesan = JOptionPane.showConfirmDialog(null, "Yakin ingin di hapus??", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
              if (pesan == JOptionPane.YES_OPTION) {
                  Statement stat = con.createStatement();
                  stat.executeUpdate("delete from jurusan where kd_jurusan='" + h.jtkdjurusan.getText() + "'");
              }
              bersih(h);
              tampildata(h);
          }catch (Exception e) {
              JOptionPane.showMessageDialog(null, "gagal" + e);
          }
      }

}



