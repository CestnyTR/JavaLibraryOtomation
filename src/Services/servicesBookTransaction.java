/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.bookTransaction;
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
public class servicesBookTransaction {
    public void vtAdd(int studentID, String bookTakeDate) {
        String query = "insert into bookTransaction(book) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, studentID);
            preparedStmt.setString(2, bookTakeDate);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services BookTransaction add" + ex);
        }
    }

    public void vtUpdate(int bookTransactionID, int studentID, String bookTakeDate) {
        String query = "update booktransaction set studentID=? where bookTransactionID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookTransactionID);
            preparedStmt.setInt(2, studentID);
            preparedStmt.setString(2, bookTakeDate);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookTransaction update" + ex);
        }
    }

    public void vtDelete(int bookTransactionID) {
        String query = "insert into booktransaction(bookTransactionID) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookTransactionID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookTransaction delete" + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select bookTransactionID,studentID,bookTakeDatefrom booktransaction";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookTransactionID = rs.getInt(1);
                int studentID = rs.getInt(2);
                String bookTakeDate = rs.getString(3);
                model.addRow(new Object[]{bookTransactionID, studentID, bookTakeDate});
            }
        } catch (Exception ex) {
            System.out.print("Services booktransaction getCon" + ex);
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

    public ArrayList<bookTransaction> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select bookTransactionID,studentID,bookTakeDate from booktransaction";
        ArrayList<bookTransaction> bTransactionList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookTransaction bTransaction;
            int counter = 0;
            while (rs.next()) {
                int bookTransactionID = rs.getInt(1);
                String columnNumber = rs.getString(2);
                int shelfNumber = rs.getInt(3);
                bTransaction = new bookTransaction(bookTransactionID, columnNumber, shelfNumber);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı bookadress Hatası" + ex);
        }
        return bTransactionList;
    }

    public int GetBookTransactionID(ArrayList<bookTransaction> bTransactionList, int index) {
        bookTransaction bTransaction = bTransactionList.get(index);
        return bTransaction.getBookTransactionID();
    }

    public String GetBookTransactionID(int GetBookTransactionID, Connection con, Statement stmt) {
        String query = "select bookTransactionID,studentID,bookTakeDate from booktransaction where bookTransactionID=?";
        String studentID = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, GetBookTransactionID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                studentID = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return studentID;

    }
}
