
package responsi;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;


public class Delete1 extends JFrame implements ActionListener {

    final JLabel lhapus = new JLabel("Judul yang akan dihapus :");
    final JTextField fhapus = new JTextField(30);
    final JButton bhapus = new JButton("Hapus");

    public Delete1() {
       
        setTitle("Delete");
	setDefaultCloseOperation(3);
	setSize(400,300);
        
        setLayout(null);
        add(fhapus);
        add(lhapus);
        add(bhapus);
        
        fhapus.setBounds(170,10,80,20);
        lhapus.setBounds(10,10,150,20);
        bhapus.setBounds(130,80,100,20);
        
        setVisible(true);
        bhapus.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String hapus = fhapus.getText();
        if (e.getSource()==bhapus)
            {
            try {
            Connector connect = new Connector();
            connect.statement = connect.koneksi.createStatement();
            String query ="DELETE FROM cerita WHERE judul = '"+ hapus +"'";
            connect.statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            connect.statement.close();
            connect.koneksi.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
            }
            }
    }
    


