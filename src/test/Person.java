package test;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Person {

    ConnectionToDB con = new ConnectionToDB();
    Connection PersonCon = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement psmnt = null;
    ResultSet res = null;

    private String name, phoneNumber, email, age, adress, password;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Person(String name, String phoneNumber, String email, String age, String adress, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.adress = adress;
        this.password = password;
    }

    public boolean signUp(String name, String phoneNumber, String email, String adress, String age, String password) {
        boolean b = false;
        String sql = "insert into Person(Name,PhoneNumber,Email,Adress,Age,Password)values('" + name + "','" + phoneNumber + "','" + email + "','" + adress + "','" + age + "','" + password + "')";

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

    public boolean LoginUser(String uname, String upass) {
        boolean b = false;
        String loginString = "select * from Person where Name='" + uname + "' and Password='" + upass + "'";

        try {
            psmnt = PersonCon.prepareStatement(loginString);
            res = psmnt.executeQuery();
            if (res.next()) {
                b = true;
            } else {
                b = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }

    public boolean deleteUser(int id) {
        boolean b = false;
        String sql = "delete from Person where ID='" + id + "'";

        try {
            stmt = PersonCon.createStatement();
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

    public boolean FetchUser(int id) {
        boolean b = false;
        String loginString = "select * from Person where ID='" + id + "'";

        try {
            psmnt = PersonCon.prepareStatement(loginString);
            res = psmnt.executeQuery();
            while (res.next()) {
                name = res.getString("Name");
                phoneNumber = res.getString("PhoneNumber");
                email = res.getString("Email");
                age = res.getString("Adress");
                adress = res.getString("Age");

                b = true;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            b = false;
        }
        return b;
    }


public boolean updateEmp(int ID) {
        boolean b = false;

            String sql = "UPDATE Person SET Name = '" + this.name + "',PhoneNumber = '" + this.phoneNumber + "',Email = '" + this.email + "',Adress = '" + this.adress + "',Age = '" + this.age + "',Password = '" + this.password + "' WHERE ID = '" + ID + "'";

        try {

            stmt = PersonCon.createStatement();
            int res = stmt.executeUpdate(sql);

            if (res > 0) {
                b = true;
            } else {

                JOptionPane.showMessageDialog(null, "Error");
                b = false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return b;

    }
}
