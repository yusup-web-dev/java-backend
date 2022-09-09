/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.pembayaran;

import com.form.pembayaran.form_user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import pembayaran_siswa_xiirpl2.Pembayaran_siswa_xiirpl2;

/**
 *
 * @author rpl
 */
        public class code_user {
    
    ResultSet res = null;
    Statement stat = null;
    Connection con = new Pembayaran_siswa_xiirpl2().getCon();
    
     public void bersih(form_user b){
        b.jtkduser.setText("");
        b.jtnamalengkap.setText("");
        b.jtnotelfon.setText("");
        b.jtusername.setText("0");
        b.jppassword.setText("");
    }
    
    
     public void kunci(form_user k){
        k.jtkduser.setEnabled(false);
        k.jtnamalengkap.setEnabled(false);
        k.jtnotelfon.setEnabled(false);
        k.jtusername.setEnabled(false);
        k.jppassword.setEnabled(false);
        k.jbsimpan.setEnabled(false);
    }
     
      public void buka_kunci(form_user sbb){
        sbb.jtkduser.setEnabled(true);
        sbb.jtnamalengkap.setEnabled(true);
        sbb.jtnotelfon.setEnabled(true);
        sbb.jtusername.setEnabled(true);
        sbb.jppassword.setEnabled(true);
    }
}
