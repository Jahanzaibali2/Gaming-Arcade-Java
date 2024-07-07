
package test;

import java.sql.*;
import javax.swing.JOptionPane;

public class Account extends Person{
   
    ConnectionToDB con = new ConnectionToDB();
    Connection PersonCon = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement psmnt = null;
    ResultSet res = null;
    
    private int timePlayed,total;
   
   

    public int getTotal() {
        return total;
    }

    public Account(int timePlayed, int total, String game, String console) {
        this.timePlayed = timePlayed;
        this.total = total;
        this.game = game;
        this.console = console;
    }


    public void setTotal(int total) {
        this.total = total;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
   private String game,console;

    public Account(int timePlayed, String game, String console, String name, String phoneNumber) {
        super(name, phoneNumber);
        this.timePlayed = timePlayed;
        this.game = game;
        this.console = console;
    }

    public Account() {
    }
   public int[] getAnalysis(){
       String str="Select Hours, Total from Gaming";
       int data[]=new int[2];
       try {
            psmnt = PersonCon.prepareStatement(str);
            res = psmnt.executeQuery();
            while (res.next()) {
                timePlayed=timePlayed+res.getInt("Hours");
                total=total+res.getInt("Total");
            }
            data[0]=timePlayed;
            data[1]=total;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
          
        }
       return data;
   }
    
    public boolean Input(String Console, String Game, String Hours, String Total) {
        boolean b = false;
        String sql = "insert into Gaming(Console,Game,Hours,Total)values('" + Console + "','" + Game + "','" + Hours + "','" + Total + "')";

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
   
   public boolean review(String review) {
        boolean b = false;
        String sql = "insert into Review(Reviews)values('" + review + "')";

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
