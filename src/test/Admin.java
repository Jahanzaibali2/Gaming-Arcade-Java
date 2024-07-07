
package test;

import java.sql.*;
import javax.swing.JOptionPane;

public class Admin extends Person {
    
    ConnectionToDB con=new ConnectionToDB();
    Connection AdminCon=con.EstablishConnection();
    Statement stmt=null;
    PreparedStatement psmnt=null;
    ResultSet res=null;
    
    private static String userName,password;

    public Admin(String userName, String password, String name, String phoneNumber, String email, String age, String adress) {
        super(name, phoneNumber, email, age, adress, password);
        this.userName = userName;
        this.password = password;
    }

    public Admin() {
    }
    

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

    public boolean LoginAdmin(String uname ,String upass)
    {
        boolean b=false;
        String loginString ="select * from Admin where UserName='"+uname+"' and Password='"+upass+"'";
        
        try
        {
            psmnt = AdminCon.prepareStatement(loginString);
            res = psmnt.executeQuery();
            if (res.next())
            {
                b=true;
            }
            else
            {
                b=false;
            }
        }
        catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                    b=false;
                }
        return b;
    }
    
    
}
