import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JLabel title, userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton loginBtn, clearBtn;

    public Login() {

        setTitle("Billing System Login");
        setSize(450,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        title = new JLabel("Billing System");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(130,20,250,30);
        add(title);

        userLabel = new JLabel("Username");
        userLabel.setBounds(50,80,100,25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(150,80,200,25);
        add(userField);

        passLabel = new JLabel("Password");
        passLabel.setBounds(50,130,100,25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(150,130,200,25);
        add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(90,190,100,35);
        loginBtn.addActionListener(this);
        add(loginBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(230,190,100,35);
        clearBtn.addActionListener(this);
        add(clearBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==clearBtn){
            userField.setText("");
            passField.setText("");
            return;
        }

        String username = userField.getText();
        String password = String.valueOf(passField.getPassword());

        try{

            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                JOptionPane.showMessageDialog(this,
                        "Login Successful");

                dispose();

                new Dashboard();

            }else{

                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");

            }

            con.close();

        }catch(Exception ex){

            ex.printStackTrace();

            JOptionPane.showMessageDialog(this,
                    ex.getMessage());

        }

    }

}
