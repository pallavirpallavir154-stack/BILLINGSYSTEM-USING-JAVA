import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    JButton productBtn, customerBtn, billingBtn, exitBtn;

    public Dashboard() {

        setTitle("Billing System Dashboard");
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title = new JLabel("Billing System Dashboard");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(100,30,300,30);
        add(title);

        productBtn = new JButton("Product Management");
        productBtn.setBounds(130,90,220,40);
        add(productBtn);

        customerBtn = new JButton("Customer Management");
        customerBtn.setBounds(130,150,220,40);
        add(customerBtn);

        billingBtn = new JButton("Generate Bill");
        billingBtn.setBounds(130,210,220,40);
        add(billingBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(130,270,220,40);
        add(exitBtn);

        productBtn.addActionListener(this);
        customerBtn.addActionListener(this);
        billingBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==productBtn){
            new Product();
        }

        if(e.getSource()==customerBtn){
            new Customer();
        }

        if(e.getSource()==billingBtn){
            new Billing();
        }

        if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}
