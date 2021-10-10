/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.faculty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahri
 */
public class servicesFaculty {
    
    public void vtAdd(String facultyName) {
        String query = "insert into faculty(facultyName) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, facultyName);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services facultyName add " + ex);
        }
    }

    public void vtUpdate(int facultyID, String facultyName) {
        String query = "update faculty set facultyName=? where facultyID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, facultyName);
            preparedStmt.setInt(2, facultyID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services faculty update" + ex);
        }
    }

    public void vtDelete(int facultyID) {
        String query = "delete from faculty where facultyID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, facultyID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services faculty delete " + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select facultyID,facultyName from faculty";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int facultyID = rs.getInt(1);
                String facultyName = rs.getString(2);
                model.addRow(new Object[]{facultyID, facultyName});
            }
        } catch (Exception ex) {
            System.out.print("Services facultyID getCon " + ex);
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

    public ArrayList<faculty> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select facultyID,facultyName from faculty";
        ArrayList<faculty> facultyList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            faculty fac;
            int counter = 0;
            while (rs.next()) {
                int facultyID = rs.getInt(1);
                String facultyName = rs.getString(2);
                fac = new faculty(facultyID, facultyName);
                facultyList.add(fac);
                model.addElement(facultyName);
                
            }
        } catch (SQLException ex) {
            System.out.print("faculty line 112 :" + ex);
        }
        return facultyList;
    }

    public int GetFacultyID(ArrayList<faculty> facultyList, int index) {
        faculty fac = facultyList.get(index);
        return fac.getFacultyID();
    }

    public String getFacultyID(int facultyID, Connection con, Statement stmt) {
        String query = "select facultyName from faculty where facultyID=?";
        String facultyName = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, facultyID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                facultyName = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return facultyName;
    }
}
