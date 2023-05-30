package org.a922;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static org.a922.Management.StudentManagementSystem.bbb;
import static org.a922.Management.classManagement.ccc;
import static org.a922.Management.grageManagement.ddd;
import static org.a922.Management.personalManagement.eee;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // 创建主窗口
        JFrame frame = new JFrame("登录界面");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // 设置窗口大小

        // 创建登录面板
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 2));

        // 创建用户名标签和文本框
        JLabel usernameLabel = new JLabel("用户名:");
        JTextField usernameField = new JTextField(20);

        // 创建密码标签和密码框
        JLabel passwordLabel = new JLabel("密码:");
        JPasswordField passwordField = new JPasswordField(20);

        // 创建角色选择标签和组合框
        JLabel roleLabel = new JLabel("角色:");
        JComboBox<String> roleComboBox = new JComboBox<>(new String[]{"学生", "管理员"});


        // 创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String role = (String) roleComboBox.getSelectedItem();

                // 在这里添加根据用户名、密码和角色进行验证的逻辑
                // ...

                // 模拟登录成功
                JOptionPane.showMessageDialog(frame, "登录成功！\n用户名: " + username + "\n角色: " + role);
                frame.dispose(); // 关闭当前窗口
                if (role.equals("学生")){
                    openNewWindow();
                }else if (role.equals("管理员")){
                    openAdminWindow();
                }

            }
        });

        // 将组件添加到面板
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(roleLabel);
        loginPanel.add(roleComboBox);
        loginPanel.add(loginButton);

        // 将面板添加到窗口
        frame.getContentPane().add(loginPanel);

        // 居中显示窗口
        frame.setLocationRelativeTo(null);

        // 显示窗口
        frame.setVisible(true);
    }

    private static void openNewWindow() {
        // 创建新窗口
        JFrame newFrame = new JFrame("新界面");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(300, 200); // 设置窗口大小


        // 创建按钮1
        JButton button1 = new JButton("学生信息查看");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 创建按钮2
        JButton button2 = new JButton("学生成绩查询");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        // 创建按钮3
        JButton button3 = new JButton("个人信息查询");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();
            }
        });

        // 创建按钮4
        JButton button4 = new JButton("退出");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(newFrame,"退出");
                newFrame.dispose();
            }
        });

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);


        // 将按钮面板添加到窗口
        newFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // 居中显示窗口
        newFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // 居中显示窗口
        newFrame.setLocationRelativeTo(null);

        // 显示窗口
        newFrame.setVisible(true);
    }



    private static void openAdminWindow(){
        // 创建新窗口

        JFrame newFrame = new JFrame("新界面");
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(300, 200); // 设置窗口大小

        // 创建按钮1
        JButton button1 = new JButton("学生信息管理");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                bbb();
            }
        });

        // 创建按钮2
        JButton button2 = new JButton("课程信息管理");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ccc();

            }
        });

        // 创建按钮3
        JButton button3 = new JButton("选课信息管理");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        // 创建按钮4
        JButton button4 = new JButton("成绩信息管理");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ddd();

            }
        });

        //创建按钮5
        JButton button5 = new JButton("个人信息管理");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eee();


            }
        });


        //创建按钮6
        JButton button6 = new JButton("退出");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.dispose();


            }
        });

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);


        // 将按钮面板添加到窗口
        newFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // 居中显示窗口
        newFrame.getContentPane().add(buttonPanel, BorderLayout.CENTER);

        // 居中显示窗口
        newFrame.setLocationRelativeTo(null);

        // 显示窗口
        newFrame.setVisible(true);
    }

}