/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.pembayaran;

import com.form.pembayaran.form_biodata;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pembayaran_siswa_xiirpl2.Pembayaran_siswa_xiirpl2;
/**
 * 
 * @author rpl
 */
public class code_biodata {
    
    ResultSet res = null;
    Statement stat = null;
    Connection con = new Pembayaran_siswa_xiirpl2().getCon();
    
    
     public void bersih(form_biodata b){
        b.jtnis.setText("");
        b.jtnama.setText("");
        b.jtalamat.setText("");
        b.jtnotelfon.setText("0");
        b.jtcarinis.setText("");
        b.jcjeniskelamin.setSelectedItem("- pilihan -");
        b.jckdjurusan.setSelectedItem("- pilihan -");
    }
     
     
      public void kunci(form_biodata k){
        k.jtnis.setEnabled(false);
        k.jtnama.setEnabled(false);
        k.jtalamat.setEnabled(false);
        k.jtnotelfon.setEnabled(false);
        k.jcjeniskelamin.setEnabled(false);
        k.jckdjurusan.setEnabled(false);
        k.jbubah.setEnabled(false);
        k.jbhapus.setEnabled(false);
        k.jbsimpan.setEnabled(false);
        
        
     }
      
       
      public void buka_kunci(form_biodata bk){
        bk.jtnis.setEnabled(true);
        bk.jtnama.setEnabled(true);
        bk.jtalamat.setEnabled(true);
        bk.jtnotelfon.setEnabled(true);
        bk.jcjeniskelamin.setEnabled(true);
        bk.jckdjurusan.setEnabled(true);
        bk.jtcarinis.setEnabled(true);
        bk.jbsimpan.setEnabled(true);
        bk.jtnis.requestFocus(true);
    }
      
      public void tampildata(form_biodata td) {
          DefaultTableModel tbbiodata = new DefaultTableModel();
          tbbiodata.addColumn("NIS");
          tbbiodata.addColumn("Nama");
          tbbiodata.addColumn("Alamat");
          tbbiodata.addColumn("No Telfon");
          tbbiodata.addColumn("Jenis Kelamin");
          tbbiodata.addColumn("Kode Jurusn");
          try{
              String sql = "select*from biodata";
              Statement stat = con.createStatement();
              ResultSet res = stat.executeQuery(sql);
              while (res.next()) {
                  tbbiodata.addRow(new Object[]{
                      res.getString(1),  res.getString(2),
                      res.getString(3),  res.getString(4),
                      res.getString(5),  res.getString(6)});
                  }
                   td.jtablebiodata.setModel(tbbiodata);
                } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Data gagal tampil" + e);                   
               }
      }
      
      
      public void tampil_jurusan(form_biodata tj){
          tj.jckdjurusan.removeAllItems();
          try{
              String sql = "select*from jurusan";
              Statement stat = con.createStatement();
              ResultSet res = stat.executeQuery(sql);
              while (res.next()) {
                  tj.jckdjurusan.addItem(res.getString("kd_jurusan"));
              }
              res.last();
              int jumlahdata = res.getRow();
              res.first();
              
          } catch (Exception e) {
              
          }
      }
      
      public void simpan(form_biodata s){
          if (s.jtnis.getText().isEmpty()
          || s.jtnama.getText().isEmpty()
          || s.jtalamat.getText().isEmpty()
          || s.jtnotelfon.getText().isEmpty()
          || s.jcjeniskelamin.getSelectedItem().equals("-Pilihan")
          || s.jckdjurusan.getSelectedItem().equals("-Pilihan")
           ) {
              JOptionPane.showMessageDialog(null, "Harap Lengkapi Data", "Warning",
              JOptionPane.INFORMATION_MESSAGE );
          } else {
              String nis = s.jtnis.getText();
              String nama = s.jtnama.getText();
              String alamat = s.jtalamat.getText();
              String notelf = s.jtnotelfon.getText();
              String jakel = (String) s.jcjeniskelamin.getSelectedItem();
              String kdjur = (String)  s.jckdjurusan.getSelectedItem();
              
              try {
                  
                  String sql = "insert into biodata(nis,nama,alamat,no_telpon,jenis_kelamin,kd_jurusan)value"
                          + "('"+nis+"','"+nama+"','"+alamat+"','"+notelf+"',"
                          + "'"+jakel+"','"+kdjur+"')";
                  
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
      
      public void cari_data(form_biodata cd){
          
          DefaultTableModel tabbiodata = new DefaultTableModel();
          
          tabbiodata.addColumn("NIS");
          tabbiodata.addColumn("Nama");
          tabbiodata.addColumn("Alamat");
          tabbiodata.addColumn("No Telfon");
          tabbiodata.addColumn("Jenis Kelamin");
          tabbiodata.addColumn("Kode Jurusan");
          
          try{
               String cari = cd.jtcarinis.getText();
               Statement stat = this.con.createStatement();
               String sql = "select*from biodata where nis like '%" + cari + "%'";
               ResultSet res = stat.executeQuery(sql);
                while (res.next()) {
                  tabbiodata.addRow(new Object[]{
                      res.getString(1),  res.getString(2),
                      res.getString(3),  res.getString(4),
                      res.getString(5),  res.getString(6)
                  });
                  
                  cd.jtnis.setText(res.getString(1));
                  cd.jtnama.setText(res.getString(2));
                  cd.jtalamat.setText(res.getString(3));
                  cd.jtnotelfon.setText(res.getString(4));
                  cd.jcjeniskelamin.setSelectedItem(res.getString(5));
                  cd.jckdjurusan.setSelectedItem(res.getString(6));
                  
                 }
                cd.jtablebiodata.setModel(tabbiodata);
          } catch (Exception e) {
              JOptionPane.showMessageDialog(null, "Gagal Cari Data" + e);
          }
      }
      
      
      public void klik_table(form_biodata kt) {
          int row = kt.jtablebiodata.getSelectedRow();
          kt.jtnis.setText(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          kt.jtnama.setText(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          kt.jtalamat.setText(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          kt.jtnotelfon.setText(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          kt.jcjeniskelamin.setSelectedItem(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          kt.jckdjurusan.setSelectedItem(kt.jtablebiodata.getModel().getValueAt(row,0).toString());
          
          kt.jbhapus.setEnabled(true);
          kt.jbubah.setEnabled(true);
          kt.jbsimpan.setEnabled(false);
      }
         
}



      
