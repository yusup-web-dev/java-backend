/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.pembayaran;
import com.form.pembayaran.form_jurusan;
/**
 *
 * @author rpl
 */
public class code_jurusan {
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
}