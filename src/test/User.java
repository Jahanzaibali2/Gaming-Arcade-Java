
package test;

import java.sql.*;
import javax.swing.JOptionPane;

public class User extends Person{
    
    ConnectionToDB con=new ConnectionToDB();
    Connection UserCon=con.EstablishConnection();
    Statement stmt=null;
    PreparedStatement psmnt=null;
    ResultSet res=null;
    
  
    private static String userName,password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String userName, String password, String name, String phoneNumber, String email, String age, String adress) {
        super(name, phoneNumber, email, age, adress, password);
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }
    
    public boolean LoginDetails(String name, String password) {
        boolean b = false;
        String sql = "insert into User(UserName,pass)values('" + name + "','" + password + "')";

        try {
            stmt = PersonCon.createStatement();
            int res = stmt.executeUpdate(sql);  //to update the database
            if (res > 0) {
                //JOptionPane.showMessageDialog(null,"Signed Up");
                b = true;
            } else {
                //JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return b;
    }
    
    
 
 }
    
    
