package org.a922;

import java.sql.*;

public class SQLManagement {
    private static final String url="jdbc:mysql://localhost:3306/student";
    private static final String user="root";
    private static final String password="Ve2DESOlate0.";
    public static SQLManagement sqlManagement=new SQLManagement();
   static {
       try{
           Class.forName("com.mysql.jdbc.Driver");
       }catch (ClassNotFoundException e){
           e.printStackTrace();
       }
   }

   //学生信息表增加信息
   public void addStudentData(String StudentName,String age,String sex){
       try{
           Connection connection=DriverManager.getConnection(url,user,password);
           Statement statement=connection.createStatement();
           String sql = "INSERT INTO s(sno, sn, sa, ss, sd) "
                   + "VALUES ('" + StudentName + "','" + age + "','" + sex + "','value1','value2')";
           statement.executeUpdate(sql);
           statement.close();
           connection.close();
       }catch (SQLException E){
           E.printStackTrace();
       }
   }

   //删除学生信息表信息
   public void delStudentData(String StudentName){
       try {
           Connection connection=DriverManager.getConnection(url,user,password);
           Statement statement=connection.createStatement();
           String sql="delete from s where name='"+StudentName+"'";
           statement.executeUpdate(sql);
           statement.close();
           connection.close();
       }catch (SQLException E){
           E.printStackTrace();
       }
   }

   //更改学生信息表信息
    public void editStudentData(String StudentName,String age,String sex){
       try {
           Connection connection =DriverManager.getConnection(url,user,password);
           Statement statement =connection.createStatement();
           String sql="delete from sc where sno='"+StudentName+"'";
           String sql1 = "INSERT INTO sc(sno, cno, g) "
                   + "VALUES('" + StudentName + "', '" + age + "', '" + sex + "')";
           statement.executeUpdate(sql);
           statement.executeUpdate(sql1);
           statement.close();
           connection.close();
       }catch (SQLException e){
           e.printStackTrace();
       }
    }


   public void sign(){
       try{
           Connection connection=DriverManager.getConnection(url,user,password);
           Statement statement=connection.createStatement();
           System.out.println("数据库链接成功");
           statement.close();
           connection.close();
       }catch (SQLException E){
           E.printStackTrace();
       }
   }


}
