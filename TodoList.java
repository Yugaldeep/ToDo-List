package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TodoList extends JFrame {
    private DefaultListModel<String> todoListModel;
    private JList<String> todoList;
    private JTextField taskField;
    private JButton addButton;
    private JButton deleteButton;

    public TodoList() {
        
        setTitle("To-Do List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
  
        JPanel panel = new JPanel(new BorderLayout());
        
        todoListModel = new DefaultListModel<>();
        todoList = new JList<>(todoListModel);
        
        JScrollPane scrollPane = new JScrollPane(todoList);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        
        taskField = new JTextField();
        inputPanel.add(taskField, BorderLayout.CENTER);

        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        inputPanel.add(addButton, BorderLayout.EAST);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        inputPanel.add(deleteButton, BorderLayout.WEST);

        panel.add(inputPanel, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    private void addTask() {
        String task = taskField.getText();
        if (!task.isEmpty()) {
            todoListModel.addElement(task);
            taskField.setText("");
        }
    }

    private void deleteTask() {
        int selectedIndex = todoList.getSelectedIndex();
        if (selectedIndex != -1) {
            todoListModel.remove(selectedIndex);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TodoList();
            }
        });
    }
}
