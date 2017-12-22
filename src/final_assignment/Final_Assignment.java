/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nezar_lulu
 */
public class Final_Assignment {

    /**
     * @param args the command line arguments
     */
//    static Statement st;
//    static Connection con;
//    ResultSet rs;
//    PreparedStatement pst;
//
//    public static void main(String[] args) {
//        new Thread(new Final_Assignment()).start();
//    }
//
//    @Override
//    public void run() {
//        try {
//            java.sql.Connection connect = DriverManager.getConnection(
//                    "jdbc:mysql://127.0.0.1/fms?user=root&password=123456");
//            System.out.println(connect);
//        } catch (Exception e) {
//            System.out.println("Error" + e);
//        }
//    }
//}
   public static void main(String[] args) {
      try {
            new mainscreen();
      } catch (SQLException ex) {
            Logger.getLogger(Final_Assignment.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}

