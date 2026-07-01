import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Product extends JFrame implements ActionListener {

    JLabel l1,l2,l3;

    JTextField nameField;
    JTextField priceField;
    JTextField quantityField;

    JButton addBtn;
    JButton updateBtn;
    JButton deleteBtn;
    JButton searchBtn;

    public Product(){

        setTitle("Product Management");
        setSize(450,350);
        setLocationRelativeTo(null);
        setLayout(null);

        l1=new JLabel("Product Name");
        l1.setBounds(30,40,100,25);
        add(l1);

        nameField=new JTextField();
        nameField.setBounds(150,40,200,25);
        add(nameField);

        l2=new JLabel("Price");
        l2.setBounds(30,90,100,25);
        add(l2);

        priceField=new JTextField();
        priceField.setBounds(150,90,200,25);
        add(priceField);

        l3=new JLabel("Quantity");
        l3.setBounds(30,140,100,25);
        add(l3);

        quantityField=new JTextField();
        quantityField.setBounds(150,140,200,25);
        add(quantityField);

        addBtn=new JButton("Add");
        addBtn.setBounds(20,220,80,30);
        add(addBtn);

        updateBtn=new JButton("Update");
        updateBtn.setBounds(110,220,90,30);
        add(updateBtn);

        deleteBtn=new JButton("Delete");
        deleteBtn.setBounds(210,220,90,30);
        add(deleteBtn);

        searchBtn=new JButton("Search");
        searchBtn.setBounds(310,220,90,30);
        add(searchBtn);

        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        searchBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        try{

            Connection con=DBConnection.getConnection();

            if(e.getSource()==addBtn){

                String sql="INSERT INTO products(name,price,quantity) VALUES(?,?,?)";

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setString(1,nameField.getText());
                ps.setDouble(2,Double.parseDouble(priceField.getText()));
                ps.setInt(3,Integer.parseInt(quantityField.getText()));

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,"Product Added");

            }

            if(e.getSource()==searchBtn){

                String sql="SELECT * FROM products WHERE name=?";

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setString(1,nameField.getText());

                ResultSet rs=ps.executeQuery();

                if(rs.next()){

                    priceField.setText(rs.getString("price"));
                    quantityField.setText(rs.getString("quantity"));

                }else{

                    JOptionPane.showMessageDialog(this,"Product Not Found");

                }

            }

            if(e.getSource()==updateBtn){

                String sql="UPDATE products SET price=?,quantity=? WHERE name=?";

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setDouble(1,Double.parseDouble(priceField.getText()));
                ps.setInt(2,Integer.parseInt(quantityField.getText()));
                ps.setString(3,nameField.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,"Product Updated");

            }

            if(e.getSource()==deleteBtn){

                String sql="DELETE FROM products WHERE name=?";

                PreparedStatement ps=con.prepareStatement(sql);

                ps.setString(1,nameField.getText());

                ps.executeUpdate();

                JOptionPane.showMessageDialog(this,"Product Deleted");

            }

            con.close();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(this,ex.getMessage());

        }

    }

}
