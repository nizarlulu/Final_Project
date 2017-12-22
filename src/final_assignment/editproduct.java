/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import DB.DBoperations;
import GUI.editgui;
import static final_assignment.addproduct.addgui;
import static final_assignment.mainscreen.dBoperations;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author nezar_lulu
 */
public class editproduct extends JFrame {

    static Connection con;
    static PreparedStatement st;
    static ResultSet rs;
    static editgui editgui = new editgui();
    static DBoperations dBoperations;

    public editproduct() throws SQLException {

        editgui.setVisible(true);
        dBoperations = new DBoperations();
        // String name = editgui.name.getText();
        editgui.getdata.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String namefound = editgui.namefound.getText();
                    rs = dBoperations.findproduct(namefound);
                    if (rs.next()) {
                        String name = rs.getString(2);
                        String weight = rs.getString(3);
                        String date = rs.getString(4);

                        editgui.name.setText(name);
                        editgui.weight.setText(weight);
                        editgui.date.setText(date);
                        System.out.println("Product found");

                    } else {
                        System.out.println("Product not found");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(editproduct.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        editgui.Editbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String date = editgui.date.getText();
                String name = editgui.name.getText();
                String weight = editgui.weight.getText();
                String namefound = editgui.namefound.getText();
                String update = "UPDATE products SET name = ?, weight = ?, entry_date = ? WHERE name = ?";
                try {
                    con = DBconnection.getCon();
                    st = con.prepareStatement(update);
                    st.setString(1, name);
                    st.setString(2, weight);
                    st.setString(3, date);
                    st.setString(4, namefound);
                    st.executeUpdate();
                    st.close();
                    System.out.println("the product alterd");
                    DBconnection db = new DBconnection();
                    db.getproductData();
                } catch (SQLException ex) {
                    System.err.println("Got an exception!");
                    System.err.println(ex.getMessage());
                }
            }

        }
        );
    }
}
