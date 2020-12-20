package aplikasi_keuangan;
import java.sql.*;
import javax.swing.*;


public class koneksi {
   public static Connection konek;
  public static Connection getKoneksi() {
        
        if(konek == null) {
            
            try {
                
                String url = "jdbc:mysql://localhost:3306/data_keuangan"; 
                String user = "root";
                String password = "";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                konek = DriverManager.getConnection(url, user, password);
                
                System.out.println("Koneksi Berhasil");
            
            } catch(SQLException ex) {
                
                System.out.println("Koneksi Gagal");
                     
            }
        }
        return konek;
    }  
   public static void main(String[]args) {
        
        getKoneksi();
    }    
}
