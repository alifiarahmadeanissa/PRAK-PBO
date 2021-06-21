
package responsi;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;


public class Responsi {

    public static void main(String[] args) 
    {
        Connector connect = new Connector();
        GUI gui = new GUI();
    }
}
    
    class GUI extends JFrame implements ActionListener
    {
        
        final JLabel lnama = new JLabel ("Nama :");
        final JTextField fnama = new JTextField (50);
        final JLabel lemail = new JLabel ("Email :");
        final JTextField femail = new JTextField (50);
        final JLabel lpassword = new JLabel ("Password :");
        final JTextField fpassword = new JTextField (50);
        final JLabel registerfor = new JLabel ("Register menjadi :");
        final JRadioButton badmin = new JRadioButton ("Admin");
        final JRadioButton buser = new JRadioButton ("User");
        final JButton blogin = new JButton ("Login");
        final JButton bsubmit = new JButton ("Submit");
       
        
        public GUI()
    {
        setTitle("Registrasi");
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
        add(bsubmit);
        add(badmin);
        add(buser);
        add(blogin);
        
        femail.setBounds(200,30,150,20);
	lemail.setBounds(10,30,120,20);
        fnama.setBounds(200,10,150,20);
	lnama.setBounds(10,10,120,20);
	fpassword.setBounds(200,50,150,20);
        lpassword.setBounds(10,50,120,20);
        registerfor.setBounds(10,80,150,20);
        badmin.setBounds(140,80,80,20);
        buser.setBounds(250,80,80,20);
        bsubmit.setBounds(100, 120, 80, 20);
        blogin.setBounds(200,120,80,20);
        
        badmin.setMnemonic(KeyEvent.VK_C);
        buser.setMnemonic(KeyEvent.VK_M);
        
        setVisible(true);
        bsubmit.addActionListener(this);
        blogin.addActionListener(this);
        
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
            
            if (e.getSource()==bsubmit)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="insert into login values ('"+ nama + "','" + email + "','" + password+ "','"+ role+ "')";
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            connect.statement.close();
            connect.koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
            
                }
            else if (e.getSource()==blogin)
            {Login login = new Login();}
            
        }
    }

    
    
