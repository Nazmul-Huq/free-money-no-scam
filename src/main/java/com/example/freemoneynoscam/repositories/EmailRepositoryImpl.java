package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.model.Email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmailRepositoryImpl implements EmailRepository{

    /**
     * make connection with the database
     * @return
     */
    static Connection getConnection(){
        try {
            //Define URL of database server for database named databaseName on the localhost with the default port number 3306.
            String url = "jdbc:mysql://localhost:3306/free_money";

            //Get a connection to the database for a user named root with password admin
            Connection con = DriverManager.getConnection(url,"root","#####");
            return con;

        }catch (Exception e){
            return null;
        }
    }

    /**
     * get a random email from database
     * @return
     */
    @Override
    public ArrayList<String> fetchSingleEmail() {

        ArrayList<String> emails = new ArrayList<>();
        try
        {
            //Get a connection to the database for a user named root
            Connection con = getConnection();

            String query = "SELECT * FROM `user_emails` ORDER BY RAND () LIMIT 1";
            Statement stmt =  con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String email = rs.getString("email");
                emails.add(email);
            }
            con.close();
            return emails;
        } catch( Exception e ) {
            e.printStackTrace();
            return null;
        }//end catch

    }

    /**
     * get all email from database
     * @return
     */
    @Override
    public ArrayList<String> fetchAllEmails() {
        ArrayList<String> emails = new ArrayList<>();
        try
        {
            //Get a connection to the database for a user named root
            Connection con = getConnection();

            String query = "SELECT * FROM `user_emails`";
            Statement stmt =  con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String email = rs.getString("email");
                emails.add(email);
            }
            con.close();
            return emails;
        } catch( Exception e ) {
            e.printStackTrace();
            return null;
        }//end catch
    }
}
