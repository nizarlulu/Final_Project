/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import GUI.deletegui;
import static final_assignment.editproduct.con;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nezar_lulu
 */
public class delete {

    static Connection con;
    static PreparedStatement st;
    static ResultSet rs;
    static deletegui deletegui = new deletegui();

    public delete() throws SQLException {
        deletegui.setVisible(true);
        deletegui.deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String delete = deletegui.delete_feild.getText();

                String update = "delete from products where name = ?";
                try {
                    con = DBconnection.getCon();
                    st = con.prepareStatement(update);
                    st.setString(1, delete);
                    st.executeUpdate();
                    st.close();
                    System.out.println("the product has been deleted");
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
