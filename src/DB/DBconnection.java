/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author nezar_lulu
 */
public class DBconnection implements Runnable {

    static Statement st;
    static Connection con;
    ResultSet rs;
    PreparedStatement pst;



    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/fms", "root", "123456");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        return con;
    }

    public void getuserData() throws SQLException {
        String query = "SELECT * FROM users";
        rs = st.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String email = rs.getString(4);
            int age = rs.getInt(5);
            int phone_number = rs.getInt(6);
            System.out.println("id : " + id
                    + " - name : " + name
                    + " - password : " + password
                    + " - email : " + email
                    + " - age : " + age
            + " - phone_number :"+phone_number
            );
        }
    }

    public void getproductData() throws SQLException {
        String query = "SELECT * FROM products";
        rs = st.executeQuery(query);
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            Float weight = rs.getFloat(3);
            String entry_date = rs.getDate(4).toString();

            System.out.println("id : " + id
                    + " - name : " + name
                    + " - weight : " + weight
                    + " - entry_date : " + entry_date
            );
        }
    }

    @Override
    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/fms", "root", "123456");
            st = con.createStatement();
            System.out.println(con);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
        }
}
