
package responsi;

import java.sql.*;
import java.lang.String;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/dataresponsi?serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "fia";
    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            System.out.println("Koneksi gagal");
        }
    }

    
}