
package responsi;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Update1 extends JFrame implements ActionListener {

        
        final JLabel lnama = new JLabel ("Nama :");
        final JTextField fnama = new JTextField (50);
        final JLabel ljudul = new JLabel ("Judul :");
        final JTextField fjudul = new JTextField (50);
        final JLabel lcerita = new JLabel ("Cerita :");
        final JTextField fcerita = new JTextField (200);
        final JButton bupdate = new JButton ("Update");
       
        
        public Update1()
    {
        setTitle("Update");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        add(fnama);
        add(lnama);
        add(fjudul);
        add(ljudul);

        add(bupdate);
        

        fnama.setBounds(200,10,150,20);
	lnama.setBounds(10,10,120,20);
	fjudul.setBounds(200,50,150,20);
        ljudul.setBounds(10,50,120,20);

        bupdate.setBounds(200,120,80,20);
        
        setVisible(true);
        bupdate.addActionListener(this);

        
    }
        
        @Override
        public void actionPerformed(ActionEvent e) {

        String nama = fnama.getText();
        String cerita = fcerita.getText();
        String judul = fjudul.getText();
            if (e.getSource()==bupdate)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="UPDATE login SET nama='"+nama+"', judul='"+judul+"', cerita ='"+ cerita+ "' WHERE nama = '"+nama+"'";
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

