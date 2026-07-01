import javax.swing.*;
import java.awt.event.*;

public class Billing extends JFrame implements ActionListener {

    JLabel customerLabel, amountLabel;

    JTextField customerField;
    JTextField amountField;

    JButton generateBtn;
    JButton clearBtn;

    public Billing() {

        setTitle("Billing System");
        setSize(400,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        customerLabel = new JLabel("Customer Name");
        customerLabel.setBounds(30,40,120,25);
        add(customerLabel);

        customerField = new JTextField();
        customerField.setBounds(160,40,180,25);
        add(customerField);

        amountLabel = new JLabel("Amount");
        amountLabel.setBounds(30,90,120,25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(160,90,180,25);
        add(amountField);

        generateBtn = new JButton("Generate Bill");
        generateBtn.setBounds(50,180,130,35);
        add(generateBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(210,180,130,35);
        add(clearBtn);

        generateBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clearBtn) {

            customerField.setText("");
            amountField.setText("");
            return;
        }

        if (e.getSource() == generateBtn) {

            try {

                String customer = customerField.getText();

                if(customer.isEmpty()){
                    JOptionPane.showMessageDialog(this,"Enter Customer Name");
                    return;
                }

                double amount = Double.parseDouble(amountField.getText());

                new Invoice(customer, amount);

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(this,
                        "Please enter a valid amount.");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        ex.getMessage());

            }

        }

    }

}
