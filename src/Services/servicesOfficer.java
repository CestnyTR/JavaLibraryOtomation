/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.officer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahri
 */
public class servicesOfficer {

    public boolean check = false;

    public void vtAdd(String officerName, String officerUserName, String officerPassword) {
        String query = "insert into officer(officerName,officerUserName,officerPassword) values(?,?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, officerName);
            preparedStmt.setString(2, officerUserName);
            preparedStmt.setString(3, officerPassword);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services officer add " + ex);
        }
    }

    public void vtUpdate(int officerID, String officerName, String officerUserName, String officerPassword) {
        String query = "update officer set officerName=?, officerUserName=? , officerPassword=? where officerID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, officerName);
            preparedStmt.setString(2, officerUserName);
            preparedStmt.setString(3, officerPassword);
            preparedStmt.setInt(4, officerID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services officer update " + ex);
        }
    }

    public void vtDelete(int officerID) {
        String query = "delete from officer WHERE officerID=?";
        try {
            Connection con = new DBConnector().getConnection();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, officerID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services officer delete " + ex);
        }
    }

    public void officerLogin(String num, String pass) {
        Statement stmt = null;
        String query = "select officerUserName,officerPassword from officer ";
        Connection con = new DBConnector().getConnection();
        String sNum;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String officerUserName = rs.getString(1);
                String officerPassword = rs.getString(2);
                if (num.equalsIgnoreCase(officerUserName)) {
                    if (!pass.equalsIgnoreCase(officerPassword)) {
                    } else {
                        check = true;
                    }
                }
            }
        } catch (Exception sql) {
            System.out.println("login error" + sql);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select officerID,officerName,officerUserName,officerPassword from officer";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int officerID = rs.getInt(1);
                String officerName = rs.getString(2);
                String officerUserName = rs.getString(3);
                String officerPassword = rs.getString(4);
                model.addRow(new Object[]{officerID, officerName, officerUserName, officerPassword});
            }
        } catch (Exception ex) {
            System.out.print("Services officer getCon " + ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return model;
    }

    public ArrayList<officer> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select officerID,officerName,officerUserName,officerPassword from officer";
        ArrayList<officer> officerList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            officer Officer;
            int counter = 0;
            while (rs.next()) {
                int officerID = rs.getInt(1);
                String officerName = rs.getString(2);
                String officerUserName = rs.getString(3);
                String officerPassword = rs.getString(4);
                Officer = new officer(officerID, officerName, officerUserName, officerPassword);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicesAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return officerList;
    }

    public int GetOfficerID(ArrayList<officer> officerList, int index) {
        officer Officer = officerList.get(index);
        return Officer.getOfficerID();
    }

    public String GetOfficerID(int officerID, Connection con, Statement stmt) {
        String query = "select officerName from officer where officerID=?";
        String officerName = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, officerID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                officerName = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return officerName;
    }
}
