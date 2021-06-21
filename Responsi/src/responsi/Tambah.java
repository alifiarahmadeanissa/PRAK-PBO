
package responsi;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Tambah extends JFrame implements ActionListener {

        
        final JLabel ljudul = new JLabel ("Judul :");
        final JTextField fjudul = new JTextField (50);
        final JLabel lcerita = new JLabel ("Cerita :");
        final JTextField fcerita = new JTextField (200);
        final JButton bupdate = new JButton ("Tambah");
       
        
        public Tambah()
    {
        setTitle("Update");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);

        add(fjudul);
        add(ljudul);
        add(fcerita);
        add(lcerita);
        add(bupdate);
        

	fjudul.setBounds(200,50,150,20);
        ljudul.setBounds(10,50,120,20);
        fcerita.setBounds(200,100,150,20);
        lcerita.setBounds(10,100,120,20);
        bupdate.setBounds(200,150,80,20);
        
        setVisible(true);
        bupdate.addActionListener(this);

        
    }
        
        @Override
        public void actionPerformed(ActionEvent e) {
        GUI gui = new GUI();
        String nama = gui.fnama.getText();
        String cerita = fcerita.getText();
        String judul = fjudul.getText();
            if (e.getSource()==bupdate)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="INSERT INTO cerita (nama, judul, cerita) VALUE('"+nama+"', '"+judul+"','"+cerita+"')";
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            connect.statement.close();
            connect.koneksi.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
            
        }
    }
}


