import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Customer extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField nameField, phoneField;
    JButton addBtn, searchBtn;

    public Customer(){

        setTitle("Customer Management");
        setSize(400,250);
        setLayout(null);
        setLocationRelativeTo(null);

        l1 = new JLabel("Customer Name");
        l1.setBounds(30,40,120,25);
        add(l1);

        nameField = new JTextField();
        nameField.setBounds(160,40,180,25);
        add(nameField);

        l2 = new JLabel("Phone");
        l2.setBounds(30,90,120,25);
        add(l2);

        phoneField = new JTextField();
        phoneField.setBounds(160,90,180,25);
        add(phoneField);

        addBtn = new JButton("Add");
        addBtn.setBounds(70,150,100,30);
        add(addBtn);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(200,150,100,30);
        add(searchBtn);

        addBtn.addActionListener(this);
        searchBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        try{

            Connection con = DBConnection.getConnection();

            if(e.getSource()==addBtn){

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO customers(name,phone) VALUES(?,?)");

                ps.setString(1,nameField.getText());
                ps.setString(2,phoneField.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,"Customer Added");

            }

            if(e.getSource()==searchBtn){

                PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM customers WHERE phone=?");

                ps.setString(1,phoneField.getText());

                ResultSet rs = ps.executeQuery();

                if(rs.next()){

                    nameField.setText(rs.getString("name"));

                }else{

                    JOptionPane.showMessageDialog(this,"Customer Not Found");

                }

            }

            con.close();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(this,ex.getMessage());

        }

    }

}
