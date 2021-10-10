/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.students;
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
public class servicesStudents {

    public boolean check = false;
    public static int studentID;
    public static String studentName;

    public void vtAdd(String name, int studentNumber, String password, int facultyID, int departmentID, String studentE_Mail) {
        String query = "insert into students(name,studentNumber,password,facultyID,departmentID,studentE_Mail) values(?,?,?,?,?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, studentNumber);
            preparedStmt.setString(3, password);
            preparedStmt.setInt(4, facultyID);
            preparedStmt.setInt(5, departmentID);
            preparedStmt.setString(6, studentE_Mail);

            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services students add " + ex);
        }
    }

    public void vtUpdate(int studentID, String name, int studentNumber, String password, int facultyID, int departmentID, String studentE_Mail) {
        String query = "update students set name=?,studentNumber=?,password=?,facultyID=?,departmentID=?,studentE_Mail=? where studentID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, name);
            preparedStmt.setInt(2, studentNumber);
            preparedStmt.setString(3, password);
            preparedStmt.setInt(4, facultyID);
            preparedStmt.setInt(5, departmentID);
            preparedStmt.setString(6, studentE_Mail);
            preparedStmt.setInt(7, studentID);

            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services studentID update " + ex);
        }
    }

    public void vtDelete(int studentID) {
        String query = "delete from students WHERE studentID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services studentID delete " + ex);
        }
    }

    public void studentsLogin(String num, String pass) {
        Statement stmt = null;
        String query = "select studentID,name,studentNumber,password from students ";
        Connection con = new DBConnector().getConnection();
        String sNum;
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int StudentID = rs.getInt(1);
                String sName = rs.getString(2);
                studentName = sName;
                int studentNumber = rs.getInt(3);
                sNum = String.valueOf(studentNumber);
                String password = rs.getString(4);
                if (num.equalsIgnoreCase(sNum)) {
                    if (!pass.equalsIgnoreCase(password)) {
                    } else {
                        check = true;
                        studentID = StudentID;
                        break;
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
        String query = "select studentID,name,studentNumber,password,facultyID,departmentID,studentE_Mail from students";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int studentID = rs.getInt(1);
                String name = rs.getString(2);
                int studentNumber = rs.getInt(3);
                String password = rs.getString(4);
                int facultyID = rs.getInt(5);
                int departmentID = rs.getInt(6);
                String studentE_Mail = rs.getString(7);
                String faculty = new servicesFaculty().getFacultyID(facultyID, con, stmt);
                String department = new servicesDepartment().getDepartmentID(departmentID, con, stmt);
                model.addRow(new Object[]{studentID, name, studentNumber, password, faculty, department, studentE_Mail});
            }
        } catch (Exception ex) {
            System.out.print("Services student getCon: " + ex);
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

    public ArrayList<students> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select studentID,name,studentNumber,password,facultyID,departmentID,studentE_Mail from students";
        ArrayList<students> studentsList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            students student;
            int counter = 0;
            while (rs.next()) {
                int studentID = rs.getInt(1);
                String name = rs.getString(2);
                int studentNumber = rs.getInt(3);
                String password = rs.getString(4);
                int facultyID = rs.getInt(5);
                int departmentID = rs.getInt(5);
                String studentE_Mail = rs.getString(6);
                student = new students(studentID, name, studentNumber, password, facultyID, departmentID, studentE_Mail);
            }
        } catch (SQLException ex) {
            System.out.print("book line 137 : " + ex);
        }
        return studentsList;
    }

    public int[] getDepartmentByID(int ID) {
        int[] department = new int[1];
        Statement stmt = null;
        String query = "select departmentID from department where departmentID=?";
        ArrayList<students> publisherList = new ArrayList<>();
        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            students student;
            if (rs.next()) {
                int departmentID = rs.getInt(1);
                department[0] = departmentID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return department;
    }

    public int[] getFacultyByID(int ID) {
        int[] faculty = new int[1];
        Statement stmt = null;
        String query = "select facultyID from faculty where facultyID=?";
        ArrayList<students> facultyList = new ArrayList<>();
        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            students student;
            if (rs.next()) {
                int facultyID = rs.getInt(1);
                faculty[0] = facultyID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return faculty;
    }

    public int GetStudentID(ArrayList<students> studentsList, int index) {
        students student = studentsList.get(index);
        return student.getStudentID();
    }

    public String GetStudentID(int studentID, Connection con, Statement stmt) {
        String query = "select name from students where StudentID=? ";
        String name = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası " + ex);
        }
        return name;
    }
}
