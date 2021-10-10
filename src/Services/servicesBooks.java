/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.books;
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
public class servicesBooks {

    public void vtAdd(String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID, String columnNumber, int shelfNumber) {
        String query = "insert into books(bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID,columnNumber,shelfNumber) values(?,?,?,?,?,?,?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, bookName);
            preparedStmt.setInt(2, bookGenreID);
            preparedStmt.setInt(3, authorID);
            preparedStmt.setInt(4, ISBN_No);
            preparedStmt.setString(5, bookStatus);
            preparedStmt.setInt(6, PublisherID);
            preparedStmt.setString(7, columnNumber);
            preparedStmt.setInt(8, shelfNumber);

            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services books add " + ex);
        }
    }

    public void vtUpdate(int bookID, String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID, String columnNumber, int shelfNumber) {
        String query = "update books set bookName=?,bookGenreID=?,authorID=?,ISBN_No=?,bookStatus=?,PublisherID=?,columnNumber=?,shelfNumber=? where bookID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, bookName);
            preparedStmt.setInt(2, bookGenreID);
            preparedStmt.setInt(3, authorID);
            preparedStmt.setInt(4, ISBN_No);
            preparedStmt.setString(5, bookStatus);
            preparedStmt.setInt(6, PublisherID);
            preparedStmt.setString(7, columnNumber);
            preparedStmt.setInt(8, shelfNumber);
            preparedStmt.setInt(9, bookID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services books update " + ex);
        }
    }
    public void vtUpdateStudent(int bookID, String bookStatus) {
        String query = "update books set bookStatus=? where bookID=?";
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
        String query = "delete from books WHERE bookID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services books delete " + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID,columnNumber,shelfNumber from books";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookID = rs.getInt(1);
                String bookName = rs.getString(2);
                int bookGenreID = rs.getInt(3);
                int authorID = rs.getInt(4);
                int ISBN_No = rs.getInt(5);
                String bookStatus = rs.getString(6);
                int publisherID = rs.getInt(7);
                String columnNumber = rs.getString(8);
                int shelfNumber = rs.getInt(9);
                String bookGenre = new servicesBookGenre().getbookGenreID(bookGenreID, con, stmt);
                String author = new servicesAuthor().getAuthorID(authorID, con, stmt);
                String publisher=new servicesPublisher().GetPublisherID(publisherID, con, stmt);

                model.addRow(new Object[]{bookID, bookName, bookGenre, author, ISBN_No, bookStatus, publisher, columnNumber, shelfNumber});
            }
        } catch (Exception ex) {
            System.out.print("Services book getCon " + ex);
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
      public DefaultTableModel bringForStudent(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID from books WHERE bookStatus='OKULDA' ";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookID = rs.getInt(1);
                String bookName = rs.getString(2);
                int bookGenreID = rs.getInt(3);
                int authorID = rs.getInt(4);
                int ISBN_No = rs.getInt(5);
                String bookStatus = rs.getString(6);
                int publisherID = rs.getInt(7);
                String bookGenre = new servicesBookGenre().getbookGenreID(bookGenreID, con, stmt);
                String author = new servicesAuthor().getAuthorID(authorID, con, stmt);
                String publisher=new servicesPublisher().GetPublisherID(publisherID, con, stmt);

                model.addRow(new Object[]{bookID, bookName, bookGenre, author, ISBN_No, bookStatus, publisher});
            }
        } catch (Exception ex) {
            System.out.print("Services book getCon " + ex);
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

    public ArrayList<books> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select bookID,bookName,bookGenreID,authorID,ISBN_No,bookStatus,PublisherID,columnNumber,shelfNumber from books";
        ArrayList<books> bookList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            books book;
            int counter = 0;
            while (rs.next()) {
                int bookID = rs.getInt(1);
                String bookName = rs.getString(2);
                int bookGenreID = rs.getInt(3);
                int authorID = rs.getInt(4);
                int ISBN_No = rs.getInt(5);
                String bookStatus = rs.getString(6);
                int PublisherID = rs.getInt(7);
                String columnNumber = rs.getString(8);
                int shelfNumber = rs.getInt(9);
                book = new books(bookID, bookName, bookGenreID, authorID, ISBN_No, bookStatus, PublisherID, columnNumber, shelfNumber);
            }
        } catch (SQLException ex) {
            System.out.print("book line 143 : " + ex);
        }
        return bookList;
    }

    public int GetBooksID(ArrayList<books> bookList, int index) {
        books book = bookList.get(index);
        return book.getBookID();
    }

    public int[] GetBookGenreByID(int ID) {
        int[] bookGenre = new int[1];
        Statement stmt = null;
        String query = "select bookGenreID from books where bookID=?";
        ArrayList<books> bookGenreList = new ArrayList<>();

        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            books book;
            if (rs.next()) {
                int bookGenreID = rs.getInt(1);
                bookGenre[0] = bookGenreID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bookGenre;
    }

    public int[] GetBookAuthorByID(int ID) {
        int[] author = new int[1];
        Statement stmt = null;
        String query = "select authorID from books where bookID=?";
        ArrayList<books> bookAuthorList = new ArrayList<>();

        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            books book;
            if (rs.next()) {
                int authorID = rs.getInt(1);
                author[0] = authorID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return author;
    }
    public int[] getPublisherByID(int ID) {
        int[] publisher = new int[1];
        Statement stmt = null;
        String query = "select publisherID from books where bookID=?";
        ArrayList<books> publisherList = new ArrayList<>();
        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            books book;
            if (rs.next()) {
                int publisherID = rs.getInt(1);
                publisher[0] = publisherID;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return publisher;
    }
    public int[] GetBookAddressByID(int ID) {
        int[] bookAddress = new int[3];

        Statement stmt = null;
        String query = "select bookID,columnNumber,shelfNumber from books where bookID=?";
        ArrayList<books> bookAddressList = new ArrayList<>();

        Connection con = new DBConnector().getConnection();
        try {
            stmt = con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            books book;
            if (rs.next()) {
                int bookID = rs.getInt(1);
                int columnNumber = rs.getInt(2);
                int shelfNumber = rs.getInt(3);
                bookAddress[0] = bookID;
                bookAddress[1] = columnNumber;
                bookAddress[2] = shelfNumber;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return bookAddress;
    }



    public String getBooksID(int bookID, Connection con, Statement stmt) {
        String query = "select bookName from books where bookID=? ";
        String bookName = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                bookName = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası " + ex);
        }
        return bookName;
    }
}
