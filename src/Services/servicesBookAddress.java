/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.bookAddress;
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
public class servicesBookAddress {

    public void vtAdd(String columnNumber, int shelfNumber) {
        String query = "insert into bookaddress(columnNumber,shelfNumber) values(?,?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, columnNumber);
            preparedStmt.setInt(2, shelfNumber);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookAddress add " + ex);
        }
    }

    public void vtUpdate(int bookAddressID, String columnNumber, int shelfNumber) {
        String query = "update bookaddress set columnNumber=?,shelfNumber=? where bookAddressID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, columnNumber);
            preparedStmt.setInt(2, shelfNumber);
            preparedStmt.setInt(3, bookAddressID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookAddress update " + ex);
        }
    }

    public void vtDelete(int bookAddressID) {
        String query = "DELETE FROM bookaddress WHERE bookAddressID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookAddressID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookAddress delete" + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select bookAddressID,columnNumber,shelfNumber from bookaddress";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookAddressID = rs.getInt(1);
                String columnNumber = rs.getString(2);
                int shelfNumber = rs.getInt(3);
                model.addRow(new Object[]{bookAddressID, columnNumber, shelfNumber});
            }
        } catch (Exception ex) {
            System.out.print("Services bookaddress getCon" + ex);
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

    public ArrayList<bookAddress> loadColl(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select bookAddressID,columnNumber from bookaddress";
        ArrayList<bookAddress> bAddressListColl = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookAddress bAddress;
            int counter = 0;
            while (rs.next()) {
                int bookAddressID = rs.getInt(1);
                String columnNumber = rs.getString(2);
                bAddress = new bookAddress(bookAddressID, columnNumber);
                bAddressListColl.add(bAddress);
                model.addElement(columnNumber);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı bookadress Hatası" + ex);
        }
        return bAddressListColl;
    }
        public ArrayList<bookAddress> loadShelf(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select bookAddressID,shelfNumber from bookaddress";
        ArrayList<bookAddress> bAddressListShelf = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookAddress bAddress;
            int counter = 0;
            while (rs.next()) {
                int bookAddressID = rs.getInt(1);
                int shelfNumber = rs.getInt(2);
                bAddress = new bookAddress(bookAddressID, shelfNumber);
                bAddressListShelf.add(bAddress);
                model.addElement(shelfNumber);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı bookadress Hatası" + ex);
        }
        return bAddressListShelf;
    }
    

    public int GetBookAddressID(ArrayList<bookAddress> bAddressList, int index) {
        bookAddress bAddress = bAddressList.get(index);
        return bAddress.getBookAddressID();
    }

    public String getBookAddressID(int bookAddressID, Connection con, Statement stmt) {
        String query = "select bookAddressID,columnNumber,shelfNumber from bookaddress where bookAddressID=?";
        String columnNumber = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookAddressID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                columnNumber = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return columnNumber;

    }
}
