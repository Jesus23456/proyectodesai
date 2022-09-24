package com.isil.sesion1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class MainApp {

    public static void main(String[] args) throws Exception{

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "123456"
        );

        Statement stmt= con.createStatement();

        int resultUpdate = stmt.executeUpdate("update Users set phone='92223331' where name='Messi'");

        ResultSet result = stmt.executeQuery("Select * From Users");
        //"Select * From Users where name='Ronaldo'"

        while(result.next()){
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));

        }
    }

}
