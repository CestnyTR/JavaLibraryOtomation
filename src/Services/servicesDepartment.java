/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.department;
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
public class servicesDepartment {

    public void vtAdd(int facultyID, String departmentName) {
        String query = "insert into department(facultyID,departmentName) values(?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, facultyID);
            preparedStmt.setString(2, departmentName);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services departmentadd " + ex);
        }
    }

    public void vtUpdate(int departmentID, int facultyID, String departmentName) {
        String query = "update department set departmentName=? where departmentID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, departmentName);
            preparedStmt.setInt(2, departmentID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services department update " + ex);
        }
    }

    public void vtDelete(int departmentID) {
        String query = "delete from department where departmentID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, departmentID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services department delete " + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select departmentID,facultyID,departmentName from department";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int departmentID = rs.getInt(1);
                int facultyID = rs.getInt(2);
                String departmentName = rs.getString(3);
                String faculty = new servicesFaculty().getFacultyID(facultyID, con, stmt);

                model.addRow(new Object[]{departmentID, faculty, departmentName});
            }
        } catch (Exception ex) {
            System.out.print("Services department getCon " + ex);
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

    public ArrayList<department> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select departmentID,facultyID,departmentName from department";
        ArrayList<department> departmentList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            department dep;
            int counter = 0;
            while (rs.next()) {
                int departmentID = rs.getInt(1);
               // int facultyID = rs.getInt(2);
                String departmentName = rs.getString(3);
                dep = new department(departmentID, departmentName);
                departmentList.add(dep);
                model.addElement(departmentName);
            }
        } catch (SQLException ex) {
            System.out.print("department line 112 :" + ex);
        }
        return departmentList;
    }

    public int GetdepartmentID(ArrayList<department> departmentList, int index) {
        department dep = departmentList.get(index);
        return dep.getDepartmentID();
    }

    public int[] getFacultyByID(int ID) {
        int[] faculty = new int[1];
        Statement stmt = null;
        String query = "select facultyID from faculty where facultyID=?";
        ArrayList<department> publisherList = new ArrayList<>();
        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            department dep;
            if (rs.next()) {
                int facultyID = rs.getInt(1);
                faculty[0] = facultyID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return faculty;
    }

    public String getDepartmentID(int departmentID, Connection con, Statement stmt) {
        String query = "select departmentID,departmentName from department where departmentID=?";
        String departmentName = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, departmentID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                departmentName = rs.getString(2);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return departmentName;
    }

}
