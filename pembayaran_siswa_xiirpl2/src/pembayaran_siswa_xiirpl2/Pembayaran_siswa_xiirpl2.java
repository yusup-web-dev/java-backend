/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembayaran_siswa_xiirpl2;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author rpl
 */
public class Pembayaran_siswa_xiirpl2 {
    public Connection con;
    public Statement stat;
    Connection Connect = null;
    
    public Connection getCon(){
           try{
    this.Connect = DriverManager.getConnection
    ("jdbc:mysql://localhost:3306/dblatihan_xiirpl2", "root", "");
    JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
     }catch (Exception e){
         JOptionPane.showMessageDialog(null, "Gagal Koneksi");
         System.out.println(e.getMessage());
         e.printStackTrace();
           }
           return this.Connect;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       new Pembayaran_siswa_xiirpl2().getCon();
    }
    
    public Connection getcon() {
        throw new UnsupportedOperationException("Not Support yet.");
    }
    
}
