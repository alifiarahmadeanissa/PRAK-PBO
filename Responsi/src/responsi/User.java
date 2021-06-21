
package responsi;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class User extends JFrame implements ActionListener{
     Connector connect = new Connector();
    String[][] data = new String[50][4];
    String[] kolom = {"nama", "Judul", "cerita"};
    JTable tabel;
    JFrame window = new JFrame("MY PAGE");
    DefaultTableModel tableModel; 
    JScrollPane scrollPane;
    final JButton bupdate = new JButton("edit");
    final JButton bdelete = new JButton("delete");
    final JButton btambah = new JButton("tambah");


    public User() {

        window.setLayout(null);
        window.add(bupdate);
        window.add(bdelete);
        window.add(btambah);
        window.setSize(550,600);
        bupdate.setBounds(110, 400, 80, 20);
        bdelete.setBounds(200, 400, 80, 20);
        btambah.setBounds(290, 400, 80, 20);
        window.setDefaultCloseOperation(3);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        bupdate.addActionListener(this);
        bdelete.addActionListener(this);
        btambah.addActionListener(this);

        try {
            GUI responsi = new GUI();
            String nama = responsi.fnama.getText();
            Class.forName("com.mysql.jdbc.Driver");
            connect.statement = connect.koneksi.createStatement();
            String query ="select * FROM cerita WHERE nama = '"+nama+"'" ;
            connect.resultset = connect.statement.executeQuery(query);
            int jmlData = 0;
            while (connect.resultset.next()) {
                data[jmlData][0] = connect.resultset.getString("nama");
                data[jmlData][1] = connect.resultset.getString("judul");
                data[jmlData][2] = connect.resultset.getString("cerita");
                jmlData++;
            }
            connect.statement.close();
            connect.koneksi.close();
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
            connect.statement = connect.koneksi.createStatement();
            String query = "Select * from `cerita`";
            ResultSet resultSet = connect.statement.executeQuery(query); //pengambilan data dalam java dari database
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==bdelete)
        {Delete1 delete = new Delete1();}
        else if (e.getSource()==bupdate)
        {Update1 update = new Update1();}
        else if (e.getSource()==btambah)
        {Tambah tambah = new Tambah();}
    }
}
