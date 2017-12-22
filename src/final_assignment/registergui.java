/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import DB.DBoperations;
import GUI.maingui;
import GUI.register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nezar_lulu
 */
public class registergui extends JFrame {

    static Connection con;
    PreparedStatement st;
    static ResultSet rsname;
    static ResultSet rspass;
    static register registergui = new register();

    public registergui() throws SQLException {
        registergui.setVisible(true);

        registergui.register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = registergui.username.getText();
                char[] password = registergui.password.getPassword();
                String passwordstring = new String(password);
                char[] confirmpass = registergui.confpass.getPassword();
                String confirmpassstring = new String(confirmpass);
                String email = registergui.email.getText();
                String age = registergui.age.getText();
                String phone = registergui.phone.getText();
                if (passwordstring.equals(confirmpassstring)) {
                    String q = "insert into users(name,password,email,age,phone_number) VALUES (?,?,?,?,?)";
                    try {
                        con = DBconnection.getCon();
                        st = con.prepareStatement(q);
                        st.setString(1, username);
                        st.setString(2, passwordstring);
                        st.setString(3, email);
                        st.setString(4, age);
                        st.setString(5, phone);
                        st.executeUpdate();
                        st.close();
                        System.out.println("the user inserted");
                        DBconnection db = new DBconnection();
                        db.getuserData();
                    } catch (SQLException ex) {
                        System.err.println("Got an exception!");
                        System.err.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The password and the confirmpassword must be the same");
                }
            }
        });
    }

}
