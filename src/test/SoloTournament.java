/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author Shahzaib
 */
public class SoloTournament implements iTournament {

    ConnectionToDB con = new ConnectionToDB();
    Connection SoloCon = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement psmnt = null;
    ResultSet res = null;
    
   private String name, contact;

    public SoloTournament() {
    }

    public SoloTournament(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     @Override
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
   

    public boolean Entry(String name, String contact) {
        boolean b = false;
        String sql = "insert into SoloTournament(PlayerName,Contact)values('" + name + "','" + contact + "')";
        try {
            stmt = SoloCon.createStatement();
            int res = stmt.executeUpdate(sql);  //to update the database
            if (res > 0) {

                b = true;
            } else {

                b = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
}

