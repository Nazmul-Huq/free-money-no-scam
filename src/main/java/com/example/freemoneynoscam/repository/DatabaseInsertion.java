package com.example.freemoneynoscam.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInsertion {

    static Connection getConnection(String databaseName){
        try {
            //Define URL of database server for database named databaseName on the localhost with the default port number 3306.
            String url = "jdbc:mysql://localhost:3306/" + databaseName;

            //Get a connection to the database for a user named root with password admin
            Connection con = DriverManager.getConnection(url,"root","dAtAmAtiker2021");
            return con;

        }catch (Exception e){
            return null;
        }
    }

    public boolean addData(String email){

        try
        {
            //Get a connection to the database for a user named root
            Connection con = getConnection("free_money");

            Statement stmt =  con.createStatement();

            String insertData = "INSERT INTO `user_emails` (`email`) VALUE ('"+email+"')";

            stmt.executeUpdate(insertData);
            con.close();
            return true;
        } catch( Exception e ) {
            e.printStackTrace();
            return false;
        }//end catch
    }
} // class ends here
