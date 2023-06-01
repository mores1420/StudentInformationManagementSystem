package org.a922.Check;

import javax.swing.*;

public class gradeCheck {

    // 表格数

    public static void fff(){
        Object[][] data = {
        };

        // 表头
        String[] columnNames = { "学号", "课程号", "成绩" };

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
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                      fff();

            }
        });

    }
}

