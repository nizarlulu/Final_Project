/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import DB.DBoperations;
import GUI.maingui;
import final_assignment.registergui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nezar_lulu
 */
public class mainscreen {

    //maingui mainscreengui=new maingui();
    static Connection con;
    static PreparedStatement st;
    static ResultSet rs;
    static DBoperations dBoperations;
    static maingui mainscreengui;
    DBconnection db;

    public mainscreen() throws SQLException {

        dBoperations = new DBoperations();
        mainscreengui = new maingui();
        mainscreengui.setVisible(true);
        new Thread(new DBconnection()).start();
        mainscreengui.LOGIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] pass = mainscreengui.pass.getPassword();
                String passString = new String(pass);
                String name = mainscreengui.name.getText();
                
                rs = dBoperations.finduser(name,passString);
                //rspass = dBoperations.findbypass(passString);
                try {
            if (rs.next()) {
                System.out.println("loggen in");
               new manage();
               mainscreengui.setVisible(false);

            }else{
            JOptionPane.showMessageDialog(null, "wrong user name or password");
            }
                } catch (SQLException ex) {
                    Logger.getLogger(mainscreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //JButton login = mainscreengui.LOGIN;

        mainscreengui.jButton2.addActionListener(new ActionListener() {
  
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                 //registergui registergui=
                         new registergui();
                         mainscreengui.setVisible(false);
                 //mainscreengui.setVisible(false);
                 //registergui.setVisible(false);
                } catch (SQLException ex) {
                   Logger.getLogger(mainscreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
