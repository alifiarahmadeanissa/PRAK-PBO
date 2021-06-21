
package responsi;

import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;


    
    class Login extends JFrame implements ActionListener
    {
        final JLabel lemail = new JLabel ("Email :");
        final JTextField femail = new JTextField (50);
        final JLabel lpassword = new JLabel ("Password :");
        final JPasswordField fpassword = new JPasswordField (50);
        final JButton blogin = new JButton ("Login");

        public Login()
    {
        setTitle("Login");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        add(femail);
        add(lemail);
        add(fpassword);
        add(lpassword);
        add(blogin);
        
        femail.setBounds(200,30,150,20);
	lemail.setBounds(10,30,120,20);
	fpassword.setBounds(200,50,150,20);
        lpassword.setBounds(10,50,120,20);
        blogin.setBounds(190,100,80,20);
        
        setVisible(true);
        blogin.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = femail.getText();
        String password = fpassword.getText();

        
        if (e.getSource()==blogin)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="select * FROM login where email = '" + email + "' AND password= '"+ password +"';" ;
            connect.resultset = connect.statement.executeQuery(query);
            if(connect.resultset.next())
            {
                if(email.equals(connect.resultset.getString("email")) && password.equals(connect.resultset.getString("password")) && "Admin".equals(connect.resultset.getString("role")))
                   {Admin admin = new Admin();}
                
            else if(email.equals(connect.resultset.getString("email")) && password.equals(connect.resultset.getString("password")))
                   {User user = new User();}
             else
                {
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
            }

            connect.statement.close();
            connect.koneksi.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Login kasian!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
            
                }
    }
    }