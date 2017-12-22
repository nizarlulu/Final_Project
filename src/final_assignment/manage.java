/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_assignment;

import DB.DBconnection;
import GUI.managegui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nezar_lulu
 */
public class manage extends JFrame {

    static managegui registergui = new managegui();
    static Connection con;
    static ResultSet rs;

    public manage() {
        registergui.setVisible(true);

        registergui.add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new addproduct();
                    registergui.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        registergui.edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new editproduct();
                    registergui.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        registergui.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    new delete();
                    registergui.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        registergui.print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    con = DBconnection.getCon();
                    try {
                        Statement set = con.createStatement();
                        rs = set.executeQuery("SELECT * FROM products");
                    } catch (SQLException ex) {
                        Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("done!!");
                    File f = new File("output.txt");
                    FileWriter fw;
                    try {
                        fw = new FileWriter(f);
                        while (rs.next()) {
                            fw.append("ID: ");
                            fw.append(rs.getString(1));
                            fw.append(",Name: ");
                            fw.append(rs.getString(2));
                            fw.append(",Weight: ");
                            fw.append(rs.getString(3));
                            fw.append(",Data: ");
                            fw.append(rs.getString(4));
                            fw.append("),new record:( ");
                        }
                        fw.flush();
                        fw.close();
                        JOptionPane.showMessageDialog(null, "Exported Successfully");
                    } catch (IOException ex) {
                        Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(manage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
}
