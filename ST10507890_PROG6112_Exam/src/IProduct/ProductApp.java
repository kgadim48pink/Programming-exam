package IProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Student
 */

public class ProductApp extends JFrame {
    // Declaring the GUI components sothey can be used in different methods
    private JTextField txtCustomerName;
    private JTextField txtPrice;
    private JComboBox<String> cmbProduct;
    private JButton btnProcess;

    public ProductApp() {
        // Show on the main window
        setTitle("Product App");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); 
        
        // The customers Name, Label and Text Box
        JLabel lblCustomer = new JLabel("Customer Name:");
        lblCustomer.setBounds(30, 30, 120, 25);
        add(lblCustomer);
        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(150, 30, 200, 25);
        add(txtCustomerName);

        // Dropdown Label and Combo Box
        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 80, 120, 25);
        add(lblProduct);
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        cmbProduct.setBounds(150, 80, 200, 25);
        add(cmbProduct);

        // The Price Label and Text Box
        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 130, 120, 25);
        add(lblPrice);
        txtPrice = new JTextField();
        txtPrice.setBounds(150, 130, 200, 25);
        add(txtPrice);

        // The Process Button
        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(150, 180, 200, 30);
        add(btnProcess);

        // Telling the button what to do when clicked
        btnProcess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processData();
            }
        });
    }

    // This method only runs when the PROCESS button is clicked
    private void processData() {
        try {
            // You must read the text from the boxes and dropdown
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();
            
            // Convert the price text into a number. This might fail if the user types letters instead.
            double price = Double.parseDouble(txtPrice.getText().trim());

            // Doing the math required by the assignment
            double vat = price * 0.15;        // 15% VAT
            double commission = price * 0.05; // 5% Commission
            double total = price + vat + commission; // Price + VAT + Commission

            // Create a message that will pop up in the popup box
            String message = String.format(
                "Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                customerName, productName, vat, commission, total
            );
            // Display the popup message box to the user
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save the same information to the text file
            saveToFile(customerName, productName, vat, commission, total);

        } catch (NumberFormatException ex) {
            // If a user typed letters instead of numbers for the price, show an error
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // This method writes the data into 'data.txt'
    private void saveToFile(String name, String product, double vat, double commission, double total) {
        // The true in FileWriter means append (Continue adding to the end, but don't overwrite old data)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write("DATA LOG\n");
            writer.write("******************************************\n");
            writer.write("Customer Name: " + name + "\n");
            writer.write("Product: " + product + "\n");
            writer.write("VAT: R " + vat + "\n");
            writer.write("COMMISSION: R " + commission + "\n");
            writer.write("TOTAL: R " + total + "\n");
            writer.write("******************************************\n\n");
            writer.flush();
        } catch (IOException e) {
            // If the file can't be created show an error
            JOptionPane.showMessageDialog(this, "Error saving to file.", "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Start the GUI safely on a standard Java practice
        SwingUtilities.invokeLater(() -> {
            new ProductApp().setVisible(true);
        });
    }

    public void setTitle(String product_App) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setSize(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}  

