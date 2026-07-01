import javax.swing.*;
import java.awt.event.*;

public class Billing extends JFrame implements ActionListener {

    JLabel customerLabel, amountLabel;
    JTextField customerField, amountField;
    JButton generateBtn, clearBtn;

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

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==clearBtn){
            customerField.setText("");
            amountField.setText("");
        }

        if(e.getSource()==generateBtn){

            try{

                String customer = customerField.getText();
                double amount = Double.parseDouble(amountField.getText());

                double gst = amount * 0.18;
                double total = amount + gst;

                String bill =
                        "=========== BILL ===========\n\n" +
                        "Customer : " + customer + "\n" +
                        "Amount   : ₹" + amount + "\n" +
                        "GST 18%  : ₹" + gst + "\n" +
                        "---------------------------\n" +
                        "Total    : ₹" + total + "\n\n" +
                        "Thank You!";

                JTextArea area = new JTextArea(bill);
                area.setEditable(false);

                JOptionPane.showMessageDialog(this, new JScrollPane(area));

            }catch(Exception ex){

                JOptionPane.showMessageDialog(this,
                        "Enter a valid amount.");

            }
        }
    }
}
