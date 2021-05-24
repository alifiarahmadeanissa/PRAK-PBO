
package kuis;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;




public class KUIS {

    public static void main(String[] args) 
   {
	GUI gui = new GUI();
   }
}

class GUI extends JFrame implements ActionListener
{
    String email, username, nama, password, date, tempat, domisili, jk, kisah;
    final JTextField femail = new JTextField(60);
    JLabel lemail = new JLabel("Email ");
    final JTextField fusername = new JTextField(80);
    JLabel lusername = new JLabel("Username ");
    final JTextField fpassword = new JTextField(16);
    JLabel lpassword= new JLabel("Password ");
    final JTextField fnama = new JTextField(30);
    JLabel lnama = new JLabel("Nama Lengkap ");
    final JTextField fdate = new JTextField();
    JLabel ldate = new JLabel("Date ");
    final JTextField ftempat = new JTextField(30);
    JLabel ltempat = new JLabel("Tempat Lahir ");
    final JRadioButton rlaki = new JRadioButton ("Laki-Laki", true) ;
    final JRadioButton rpr = new JRadioButton ("Perempuan") ;
    JLabel ljk = new JLabel ("Jenis Kelamin");
     final JTextField fdom = new JTextField(30);
    JLabel ldom = new JLabel("Domisili ");
     final JTextArea fkisah = new JTextArea();
    JLabel lkisah = new JLabel("Tentang Kamu ");
    
    JButton btntampilkan = new JButton("Tampilkan");
    JButton btnsimpan = new JButton("Simpan");
    
    public GUI() 
   {
	setTitle("Formulir Identitas");
	setDefaultCloseOperation(3);
	setSize(550,400);
        
        setLayout(null);
        add(femail);
        add(lemail);
        add(fusername);
        add(lusername);
        add(fpassword);
        add(lpassword);
        add(fnama);
        add(lnama);
        add(ldate);
        add(fdate);
        add(ftempat);
        add(ltempat);
        add(rlaki);
        add(rpr);
        add(ljk);
        add(fdom);
        add(ldom);
        add(fkisah);
        add(lkisah);
        add(btntampilkan);
        add(btnsimpan);
        
        femail.setBounds(200,10,150,20);
	lemail.setBounds(10,10,120,20);
        fusername.setBounds(200,30,150,20);
	lusername.setBounds(10,30,120,20);
	fpassword.setBounds(200,50,150,20);
        lpassword.setBounds(10,50,120,20);
        fnama.setBounds(200,70,150,20);
        lnama.setBounds(10,70,120,20);
        fdate.setBounds(200,90,150,20);
        ldate.setBounds(10,90,120,20);
        ftempat.setBounds(200,110,150,20);
        ltempat.setBounds(10,110,120,20);
        rlaki.setBounds(200,130,100,20);
        rpr.setBounds(300,130,150,20);
        ljk.setBounds(10,130,100,20);
        fdom.setBounds(200,150,150,20);
        ldom.setBounds(10,150,120,20);
        fkisah.setBounds(200,170,150,80);
        lkisah.setBounds(10,170,120,20);
        btntampilkan.setBounds(150,300,100,20);
        btnsimpan.setBounds(270,300,100,20);
        
        rlaki.setMnemonic(KeyEvent.VK_C);
        rpr.setMnemonic(KeyEvent.VK_M);
      
        
        setVisible(true);
        btntampilkan.addActionListener(this);
        btnsimpan.addActionListener(this);
        
}
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String email = femail.getText();
        String username = fusername.getText();
        String password = fpassword.getText();
        String nama = fnama.getText();
        String JenKel="";
            if (rlaki.isSelected()){
            JenKel = rlaki.getText();
            }else{
            JenKel = rpr.getText();
            }
        String tl = ftempat.getText();
        String date = fdate.getText();
        String dom = fdom.getText();
        String kisah = fkisah.getText();
       
                
        if(e.getSource() == btntampilkan)
            {
            if(email.contains("@upnyk.ac.id"))
                {   
                if(username.contains("!@#$%^&*()_+=-[]{}|/"))
                    {JOptionPane.showMessageDialog(null,"Tidak boleh menggunakan simbol");}
                else
                    {
                    JOptionPane.showMessageDialog(null, "email = " + email+
                    "\nusername = " + username +
                    "\npassword = " + password +
                    "\nnama = " + nama +
                    "\nJenis Kelamin = " + JenKel +
                    "\nTTL = " + tl + ", " + date +
                    "\nasal = " + dom +
                    "\ncerita = " + kisah);
                    }
                }
            else 
            {JOptionPane.showMessageDialog(null,"Email harus email upnyk");}
            }

        else if(e.getSource() == btnsimpan)
            {
            if(email.contains("upnyk.ac.id"))
            {   
                if(username.contains("!@#$%^&*()_+=-[]{}|/"))
                    {JOptionPane.showMessageDialog(null,"Tidak boleh menggunakan simbol");}
                else
                {
                String teks = "email = " + email+
                    "\nusername = " + username +
                    "\npassword = " + password +
                    "\nnama = " + nama +
                    "\nJenis Kelamin = " + JenKel +
                    "\nTTL = " + tl + ", " + date +
                    "\nasal = " + dom +
                    "\ncerita = " + kisah;
                
                String path = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\KUIS\\txtfile\\output.txt";
                try {
                    FileWriter fw = new FileWriter(path);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(teks);
                    bw.close();
                } catch (IOException f)
                {}
                
                }
            }
            else 
            {JOptionPane.showMessageDialog(null,"Email harus email upnyk");}
        }
    }
}
