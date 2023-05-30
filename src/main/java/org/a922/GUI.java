package org.a922;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class GUI extends JFrame{
    private final JTextField textFieldStudentNumber,textFieldStudentName,textFieldCourseName;
    public GUI(){
        super("康Sir管理系统");
        Container container=getContentPane();
        container.setLayout(new FlowLayout());
        textFieldStudentNumber=new JTextField(10);
        textFieldStudentName=new JTextField(10);
        textFieldCourseName=new JTextField(10);

        Icon iconCreate,iconExit,iconFind,iconPig,iconSave,iconTrash;
        iconCreate=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/Create.png"))));
        iconExit=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/Exit.png"))));
        iconFind=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/Find.png"))));
        iconPig=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/pig.png"))));
        iconSave=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/Save.png"))));
        iconTrash=new ImageIcon((Objects.requireNonNull(getClass().getResource("/icons/Trash.png"))));

        JLabel jLabelStudentNumber=new JLabel("学号");
        JPanel panelStudentNumber=new JPanel();
        panelStudentNumber.add(new JLabel("学号"));
        panelStudentNumber.add(textFieldStudentNumber);

        JPanel panelStudentName=new JPanel();
        panelStudentName.add(new JLabel("姓名"));
        panelStudentName.add(textFieldStudentName);

        JPanel panelCourseName=new JPanel();
        panelCourseName.add(new JLabel("课程名"));
        panelCourseName.add(textFieldCourseName);

        container.add(panelStudentNumber);
        container.add(panelStudentName);
        container.add(panelCourseName);
        setSize(300,200);
        setVisible(true);
    }
}
