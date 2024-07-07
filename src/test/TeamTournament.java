
package test;

import java.sql.*;
import javax.swing.JOptionPane;
public class TeamTournament implements iTournament{
    ConnectionToDB con = new ConnectionToDB();
    Connection TeamCon = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement psmnt = null;
    ResultSet res = null;
    
    private String Teamname, LeaderContact,LeaderName;

    @Override
    public String getName() {
       return Teamname;
    }

    @Override
    public String getContact() {
    return LeaderContact;
    }

    public void setTeamname(String Teamname) {
        this.Teamname = Teamname;
    }

    public void setLeaderContact(String LeaderContact) {
        this.LeaderContact = LeaderContact;
    }

    public void setLeaderName(String LeaderName) {
        this.LeaderName = LeaderName;
    }

    public String getLeaderName() {
        return LeaderName;
    }
    public boolean TeamEntry(String Teamname,String LeaderName,String LeaderContact) {
        boolean b = false;
        String sql = "insert into TeamTournament(TeamName,LeaderName,LeaderContact)values('" + Teamname + "','" + LeaderName + "','" + LeaderContact + "')";
        try {
            stmt = TeamCon.createStatement();
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
