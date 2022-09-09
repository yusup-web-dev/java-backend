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
                  
                  String sql = "insert into jurusan(kd_jurusan,nama_jurusan,ketua_jurusan)value"
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

      }

