import javax.swing.*;
import java.awt.event.*;

public class Billing extends JFrame implements ActionListener{

    JLabel customerLabel, amountLabel;

    JTextField customerField;
    JTextField amountField;

    JButton generateBtn;

    public Billing(){

        setTitle("Generate Bill");

        setSize(400,280);

        setLayout(null);

        setLocationRelativeTo(null);

        customerLabel = new JLabel("Customer");

        customerLabel.setBounds(30,40,100,25);

        add(customerLabel);

        customerField = new JTextField();

        customerField.setBounds(140,40,180,25);

        add(customerField);

        amountLabel = new JLabel("Amount");

        amountLabel.setBounds(30,90,100,25);

        add(amountLabel);

        amountField = new JTextField();

        amountField.setBounds(140,90,180,25);

        add(amountField);

        generateBtn = new JButton("Generate Bill");

        generateBtn.setBounds(110,170,150,35);

        add(generateBtn);

        generateBtn.addActionListener(this);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e){

        double amount = Double.parseDouble(amountField.getText());

        double gst = amount * 0.18;

        double total = amount + gst;

        String bill =
                "\n******** BILL ********\n\n"+
                "Customer : "+customerField.getText()+
                "\nAmount : ₹"+amount+
                "\nGST (18%) : ₹"+gst+
                "\n------------------------"+
                "\nGrand Total : ₹"+total+
                "\n\nThank You!\n";

        JTextArea area = new JTextArea(bill);

        area.setEditable(false);

        JOptionPane.showMessageDialog(this,new JScrollPane(area),"Invoice",JOptionPane.INFORMATION_MESSAGE);

    }

}
