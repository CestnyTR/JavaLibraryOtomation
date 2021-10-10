/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.studentsBook;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahri
 */
public class servicesStudentsBook {

    public void vtAdd(int studentID, int bookID, String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID, String dateOfTookBook) {
        String query = "insert into studentsbook(studentID,bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,publisherID,dateOfTookBook) values(?,?,?,?,?,?,?,?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentID);
            preparedStmt.setInt(2, bookID);
            preparedStmt.setString(3, bookName);
            preparedStmt.setInt(4, bookGenreID);
            preparedStmt.setInt(5, authorID);
            preparedStmt.setInt(6, ISBN_No);
            preparedStmt.setString(7, bookStatus);
            preparedStmt.setInt(8, PublisherID);
            preparedStmt.setString(9, dateOfTookBook);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services studentsBook add " + ex);
        }
    }

    public void vtUpdate(int studentsBookID, int studentID, int bookID, String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID, String dateOfTookBook) {
        String query = "update studentsbook set bookID=?,dateOfTookBook=? where bookID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentID);
            preparedStmt.setInt(2, bookID);
            preparedStmt.setString(3, bookName);
            preparedStmt.setInt(4, bookGenreID);
            preparedStmt.setInt(5, authorID);
            preparedStmt.setInt(6, ISBN_No);
            preparedStmt.setString(7, bookStatus);
            preparedStmt.setInt(8, PublisherID);
            preparedStmt.setString(9, dateOfTookBook);
            preparedStmt.setInt(10, studentsBookID);

            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services studentsBook update " + ex);
        }
        
    }
    public void vtUpdateStudent(int bookID, String bookStatus) {
        String query = "update studentsbook set bookStatus=? where bookID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);       
            preparedStmt.setString(1, bookStatus);    
            preparedStmt.setInt(2, bookID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services books vtUpdateStudent " + ex);
        }
    }
    public void vtDelete(int bookID) {
        String query = "delete from studentsBook WHERE bookID=?";
        try {
            Connection con = new DBConnector().getConnection();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services studentsBooks delete " + ex);
        }
    }

    public void Date(String dateOfTake) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(dateOfTake);
        } catch (ParseException ex) {
            System.out.println("Services Date eroro line 79 : " + ex);
        }
        long now = date.getTime();
        long timeCalculation = Long.parseLong(dateOfTake) - now;
        long timeCalculationDay = TimeUnit.DAYS.toDays(timeCalculation);
        System.out.println(timeCalculationDay);

    }

    public DefaultTableModel bring(int StudentID,DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select studentsBookID,studentID,bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID,dateOfTookBook from studentsbook where studentID="+StudentID;
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int studentsBookID = rs.getInt(1);
                int studentID = rs.getInt(2);
                int bookID = rs.getInt(3);
                String bookName = rs.getString(4);
                int bookGenreID = rs.getInt(5);
                int authorID = rs.getInt(6);
                int ISBN_No = rs.getInt(7);
                String bookStatus = rs.getString(8);
                int publisherID = rs.getInt(9);
                String dateOfTookBook = rs.getString(10);
                String bookGenre = new servicesBookGenre().getbookGenreID(bookGenreID, con, stmt);
                String author = new servicesAuthor().getAuthorID(authorID, con, stmt);
                String publisher = new servicesPublisher().GetPublisherID(publisherID, con, stmt);
                String students = new servicesStudents().GetStudentID(studentID, con, stmt);
                String book = new servicesBooks().getBooksID(bookID, con, stmt);
                model.addRow(new Object[]{bookID, bookName, bookGenre, author, ISBN_No, bookStatus, publisher, students, dateOfTookBook,studentsBookID});
            }
        } catch (Exception ex) {
            System.out.print("Services studentsBookID getCon 131 " + ex);
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

    public ArrayList<studentsBook> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select studentsBookID,studentID,bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID,dateOfTookBook from studentsbook";
        ArrayList<studentsBook> studentsBookList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            studentsBook sBooks;
            int counter = 0;
            while (rs.next()) {
                int studentsBookID = rs.getInt(1);
                int studentID = rs.getInt(2);
                int bookID = rs.getInt(3);
                String bookName = rs.getString(3);
                int bookGenreID = rs.getInt(4);
                int authorID = rs.getInt(5);
                int ISBN_No = rs.getInt(6);
                String bookStatus = rs.getString(7);
                int PublisherID = rs.getInt(8);
                String dateOfTookBook = rs.getString(4);
                sBooks = new studentsBook(studentsBookID, studentID, bookID, bookName, bookGenreID, authorID, ISBN_No, bookStatus, PublisherID, dateOfTookBook);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicesAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studentsBookList;
    }

    public int GetStudentsBookID(ArrayList<studentsBook> studentsBookList, int index) {
        studentsBook sBooks = studentsBookList.get(index);
        return sBooks.getStudentsBookID();
    }

    public String GetStudentsBookID(int studentsBookID, Connection con, Statement stmt) {
        String query = "select bookID from studentsbook where studentsBookID=?";
        String bookID = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentsBookID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                bookID = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return bookID;
    }
}
