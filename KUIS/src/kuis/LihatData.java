
package kuis;

import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LihatData extends JFrame {

    Connector connector = new Connector();
    String[][] data = new String[50][9];
    String[] kolom = {"email", "username", "password","nama", "jenis kelamin", "tempat lahir","Date", "Domisili", "Cerita"};
    JTable tabel;
    JFrame window = new JFrame("Lihat Data");
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    String DBurl = "jdbc:mysql://localhost/biodata?serverTimezone=UTC";
    String DBusername = "root";
    String DBpassword = "fia";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    public LihatData() {
        setTitle("Data");
        window.setLayout(null);
        window.setSize(550,600);
      //  window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername, DBpassword);
            statement = koneksi.createStatement();
            String sql = "select * from biodata";
            resultSet = statement.executeQuery(sql);
            int jmlData = 0;
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("email");
                data[jmlData][1] = resultSet.getString("username");
                data[jmlData][2] = resultSet.getString("password");
                data[jmlData][3] = resultSet.getString("nama");
                data[jmlData][4] = resultSet.getString("jk");
                data[jmlData][5] = resultSet.getString("tl");
                data[jmlData][6] = resultSet.getString("date");
                data[jmlData][7] = resultSet.getString("dom");
                data[jmlData][8] = resultSet.getString("kisah");
                jmlData++;
            }
            statement.close();
            koneksi.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
         tabel = new JTable(data,kolom); //tabel merupakan variabel untuk tabelnya dengan isi tablemodel
        scrollPane = new JScrollPane(tabel);
        window.add(scrollPane);
        
        scrollPane.setBounds(20, 35, 500, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    public int getBanyakData(){ //menghitung jumlah baris yg ada pada db
        int jmlData = 0; //nilai awal 0
        try{
            connector.statement = connector.koneksi.createStatement();
            String query = "Select * from `biodata`";
            ResultSet resultSet = connector.statement.executeQuery(query); //pengambilan data dalam java dari database
            while(resultSet.next()){ //ambil nilai dari baris ke 0 sampai baris akhir
                jmlData++;
            }
            return jmlData; //mengembalikan jumlah data ke readtiket
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
        
    }
}
 
