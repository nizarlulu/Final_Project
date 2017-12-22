/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import GUI.addgui;
import static final_assignment.registergui.con;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nezar_lulu
 */
public class addproduct extends JFrame {

    static Connection con;
    PreparedStatement st;
    static ResultSet rsname;
    static ResultSet rspass;
    static addgui addgui = new addgui();

    public addproduct() throws SQLException {
        addgui.setVisible(true);
        addgui.Buttonadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String date = addgui.date.getText();
                String name = addgui.name.getText();
                String weight = addgui.weight.getText();
                String q = "insert into products(name,weight,entry_date) VALUES (?,?,?)";
                try {
                    con = DBconnection.getCon();
                    st = con.prepareStatement(q);
                    st.setString(1, name);
                    st.setString(2, weight);
                    st.setString(3, date);
                    st.executeUpdate();
                    st.close();
                    System.out.println("the product inserted");
                    DBconnection db = new DBconnection();
                    db.getproductData();
                } catch (SQLException ex) {
                    System.err.println("Got an exception!");
                    System.err.println(ex.getMessage());
                }
            }

        });

    }

}
