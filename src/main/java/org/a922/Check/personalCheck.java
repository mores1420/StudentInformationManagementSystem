package org.a922.Check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class personalCheck {
    public static void qqq(){
        Object[][] data = {
        };

        // 表头
        String[] columnNames = { "用户名", "密码" };




        // 创建JTable对象
        JTable table = new JTable(data, columnNames);

        // 创建JScrollPane并将JTable添加到其中，以支持滚动
        JScrollPane scrollPane = new JScrollPane(table);

        // 创建JFrame并将JScrollPane添加到其中
        JFrame frame = new JFrame("Table Example");
        frame.add(scrollPane);



        // 设置JFrame的大小、关闭操作和可见性
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,2));
        JButton changeButton = new JButton("修改");
        changeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        buttonPanel.add(changeButton);
        frame.getContentPane().add(buttonPanel);
        buttonPanel.setVisible(true);

    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                qqq();

            }
        });
    }
}
