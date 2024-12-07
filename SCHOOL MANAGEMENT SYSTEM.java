import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SchoolManagementSystem {

    // Main Method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SchoolManagementSystem::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        // Create the frame
        JFrame frame = new JFrame("School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        // Create the table and its model
        String[] columnNames = {"ID", "Name", "Grade"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable studentTable = new JTable(tableModel);

        // Create input fields
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(10);
        JTextField gradeField = new JTextField(10);

        // Add panel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);

        // Create buttons
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        // Add action listener for the Add button
        addButton.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String grade = gradeField.getText();

            if (!id.isEmpty() && !name.isEmpty() && !grade.isEmpty()) {
                tableModel.addRow(new Object[]{id, name, grade});
                idField.setText("");
                nameField.setText("");
                gradeField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add action listener for the Delete button
        deleteButton.addActionListener(e -> {
            int selectedRow = studentTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a row to delete!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Add table to a scroll pane
        JScrollPane tableScrollPane = new JScrollPane(studentTable);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tableScrollPane, BorderLayout.CENTER);

        // Make the frame visible
        frame.setVisible(true);
    }
}