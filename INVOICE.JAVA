import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoice extends JFrame {

    JTextArea invoiceArea;

    public Invoice(String customer, double amount) {

        setTitle("Invoice");
        setSize(500,600);
        setLocationRelativeTo(null);

        invoiceArea = new JTextArea();
        invoiceArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        invoiceArea.setEditable(false);

        double gst = amount * 0.18;
        double grandTotal = amount + gst;

        String billNo = "INV" + System.currentTimeMillis();
        String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());

        String invoice =
                "========================================\n" +
                "          ABC BILLING SYSTEM\n" +
                "========================================\n\n" +
                "Invoice No : " + billNo + "\n" +
                "Date       : " + date + "\n" +
                "Customer   : " + customer + "\n\n" +
                "----------------------------------------\n" +
                "Subtotal   : ₹" + String.format("%.2f", amount) + "\n" +
                "GST (18%)  : ₹" + String.format("%.2f", gst) + "\n" +
                "----------------------------------------\n" +
                "Grand Total: ₹" + String.format("%.2f", grandTotal) + "\n" +
                "========================================\n" +
                "      THANK YOU! VISIT AGAIN.\n" +
                "========================================";

        invoiceArea.setText(invoice);

        add(new JScrollPane(invoiceArea));

        setVisible(true);
    }
}
