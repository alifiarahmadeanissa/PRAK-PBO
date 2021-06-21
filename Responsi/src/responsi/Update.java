
package responsi;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class Update extends JFrame implements ActionListener {

        
        final JLabel lnama = new JLabel ("Nama :");
        final JTextField fnama = new JTextField (50);
        final JLabel warning = new JLabel ("Semua dapat diganti kecuali email");
        final JLabel lemail = new JLabel ("Email :");
        final JTextField femail = new JTextField (50);
        final JLabel lpassword = new JLabel ("Password :");
        final JTextField fpassword = new JTextField (50);
        final JLabel registerfor = new JLabel ("Register menjadi :");
        final JRadioButton badmin = new JRadioButton ("Admin");
        final JRadioButton buser = new JRadioButton ("User");
        final JButton bupdate = new JButton ("Update");
       
        
        public Update()
    {
        setTitle("Update");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        add(femail);
        add(lemail);
        add(fnama);
        add(lnama);
        add(fpassword);
        add(lpassword);
        add(registerfor);
        add(badmin);
        add(buser);
        add(bupdate);
        
        femail.setBounds(200,30,150,20);
	lemail.setBounds(10,30,120,20);
        fnama.setBounds(200,10,150,20);
	lnama.setBounds(10,10,120,20);
	fpassword.setBounds(200,50,150,20);
        lpassword.setBounds(10,50,120,20);
        registerfor.setBounds(10,80,150,20);
        badmin.setBounds(140,80,80,20);
        buser.setBounds(250,80,80,20);
        bupdate.setBounds(200,120,80,20);
        
        badmin.setMnemonic(KeyEvent.VK_C);
        buser.setMnemonic(KeyEvent.VK_M);
        
        setVisible(true);
        bupdate.addActionListener(this);

        
    }
        
        @Override
        public void actionPerformed(ActionEvent e) {

        String nama = fnama.getText();
        String email = femail.getText();
        String password = fpassword.getText();
        String role = "";
            if (badmin.isSelected())
            {
            role = badmin.getText();
            }else{
            role = buser.getText();
            }
            
            if (e.getSource()==bupdate)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="UPDATE login SET nama='"+nama+"', password='"+password+"', role ='"+ role+ "' WHERE email = '"+email+"'";
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
