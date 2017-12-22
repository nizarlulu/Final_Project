/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author nezar_lulu
 */
public class DBoperations {

    Connection conect = null;
    ResultSet result = null;
    PreparedStatement prs = null;

    public ResultSet finduser(String user, String pass) {
        try {
            conect = DBconnection.getCon();
            prs = conect.prepareStatement("select * from users where name=? and password=?");
            prs.setString(1, user);
            prs.setString(2, pass);
            result = prs.executeQuery();

        } catch (Exception e2) {

        }
        return result;
    }
    
        public ResultSet findproduct(String name) {
        try {
            conect = DBconnection.getCon();
            prs = conect.prepareStatement("select * from products where name=?");
            prs.setString(1, name);
            result = prs.executeQuery();

        } catch (Exception e2) {

        }
        return result;
    }

}
