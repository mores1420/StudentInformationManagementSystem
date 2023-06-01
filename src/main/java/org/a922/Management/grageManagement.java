package org.a922.Management;

import org.a922.SQLManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class grageManagement {
    private static DefaultTableModel tableModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ddd();
            }
        });
    }


    //学生管理系统GUI
    public static void ddd() {
        // 创建主窗口
        JFrame frame = new JFrame("学生管理系统");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400); // 设置窗口大小

        // 创建表格面板
        JPanel tablePanel = new JPanel(new BorderLayout());

        // 创建表格模型
        tableModel = new DefaultTableModel();
        tableModel.addColumn("学号");
        tableModel.addColumn("课程名");
        tableModel.addColumn("成绩");

        // 创建表格
        JTable table = new JTable(tableModel);

        // 创建滚动面板，将表格添加到其中
        JScrollPane scrollPane = new JScrollPane(table);

        // 将滚动面板添加到表格面板
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();

        // 创建增加按钮

        // 创建删除按钮

        // 创建修改按钮
        JButton editButton = new JButton("修改成绩");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });
        buttonPanel.add(editButton);

        // 创建查看按钮
        JButton viewButton = new JButton("查看");
        viewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewStudent();
            }
        });
        buttonPanel.add(viewButton);

        // 创建显示按钮
        JButton showButton = new JButton("显示");
        showButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showStudents();
            }
        });
        buttonPanel.add(showButton);


        JButton addButton = new JButton("添加成绩");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });
        buttonPanel.add(addButton);

        // 将表格面板和按钮面板添加到主窗口
        frame.getContentPane().add(tablePanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // 居中显示窗口
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }

    private static void addStudent() {
        // 创建对话框
        JDialog dialog = new JDialog();
        dialog.setTitle("添加成绩");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setSize(300, 200);

        // 创建文本框和标签
        JLabel nameLabel = new JLabel("学号:");
        JTextField nameField = new JTextField(20);

        JLabel ageLabel = new JLabel("课程:");
        JTextField ageField = new JTextField(20);

        JLabel genderLabel = new JLabel("成绩:");
        JTextField genderField = new JTextField(20);

        // 创建确定按钮
        JButton okButton = new JButton("确定");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String age = ageField.getText();
                String gender = genderField.getText();

                // 将学生信息添加到表格模型
                tableModel.addRow(new Object[]{name, age, gender});
                SQLManagement.sqlManagement.addStudentData(name,age,gender);

                // 关闭对话框
                dialog.dispose();
            }
        });

        // 创建面板，将文本框、标签和按钮添加到面板
        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(genderLabel);
        panel.add(genderField);
        panel.add(okButton);

        // 将面板添加到对话框
        dialog.getContentPane().add(panel);

        // 设置对话框位置并显示
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    private static void deleteStudent() {
        int selectedRow = tableModel.getRowCount() - 1;

        if (selectedRow >= 0) {
            // 删除选中行
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "没有选中的学生！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void editStudent() {
        int selectedRow = tableModel.getRowCount() - 1;

        if (selectedRow >= 0) {
            // 创建对话框
            JDialog dialog = new JDialog();
            dialog.setTitle("修改学生");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setSize(300, 200);

            // 获取选中行的学生信息
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String age = (String) tableModel.getValueAt(selectedRow, 1);
            String gender = (String) tableModel.getValueAt(selectedRow, 2);

            // 创建文本框和标签，并设置初始值
            JLabel nameLabel = new JLabel("学号:");
            JTextField nameField = new JTextField(20);
            nameField.setText(name);

            JLabel ageLabel = new JLabel("课程名:");
            JTextField ageField = new JTextField(20);
            ageField.setText(age);

            JLabel genderLabel = new JLabel("成绩:");
            JTextField genderField = new JTextField(20);
            genderField.setText(gender);

            // 创建确定按钮
            JButton okButton = new JButton("确定");
            okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String newName = nameField.getText();
                    String newAge = ageField.getText();
                    String newGender = genderField.getText();

                    // 更新表格模型中的学生信息
                    tableModel.setValueAt(newName, selectedRow, 0);
                    tableModel.setValueAt(newAge, selectedRow, 1);
                    tableModel.setValueAt(newGender, selectedRow, 2);
                    SQLManagement.sqlManagement.editStudentData(newName,newAge,newGender);

                    // 关闭对话框
                    dialog.dispose();
                }
            });

            // 创建面板，将文本框、标签和按钮添加到面板
            JPanel panel = new JPanel(new GridLayout(4, 2));
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(ageLabel);
            panel.add(ageField);
            panel.add(genderLabel);
            panel.add(genderField);
            panel.add(okButton);

            // 将面板添加到对话框
            dialog.getContentPane().add(panel);

            // 设置对话框位置并显示
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "没有选中的学生！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void viewStudent() {
        int selectedRow = tableModel.getRowCount() - 1;

        if (selectedRow >= 0) {
            // 获取选中行的学生信息
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String age = (String) tableModel.getValueAt(selectedRow, 1);
            String gender = (String) tableModel.getValueAt(selectedRow, 2);

            // 显示学生信息
            JOptionPane.showMessageDialog(null, "姓名: " + name + "\n年龄: " + age + "\n性别: " + gender, "学生信息", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "没有选中的学生！", "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void showStudents() {
        JOptionPane.showMessageDialog(null, new JScrollPane(new JTable(tableModel)), "学生列表", JOptionPane.PLAIN_MESSAGE);
    }
}





