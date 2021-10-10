/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.bookDeliverySettings;
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
public class servicesBookDeliverySettings {

    public void vtUpdate(int ID, int bookDeliveryTime, int lateDeliveryPenalty, int takeBookLimit) {
        String query = "update bookdeliverysettings set bookDeliveryTime=?, lateDeliveryPenalty=?, takeBookLimit=? where ID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookDeliveryTime);
            preparedStmt.setInt(2, lateDeliveryPenalty);
            preparedStmt.setInt(3, takeBookLimit);
            preparedStmt.setInt(4, ID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookdeliverysettings update " + ex);
        }
    }
    

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select ID,bookDeliveryTime,lateDeliveryPenalty,takeBookLimit from bookdeliverysettings";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int ID = rs.getInt(1);
                int bookDeliveryTime = rs.getInt(2);
                int lateDeliveryPenalty = rs.getInt(3);
                int takeBookLimit = rs.getInt(4);
                model.addRow(new Object[]{ID, bookDeliveryTime, lateDeliveryPenalty, takeBookLimit});
            }
        } catch (Exception ex) {
            System.out.print("Services bookdeliverysettings getCon " + ex);
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

    public ArrayList<bookDeliverySettings> load(int List) {
        //  model.removeAllElements();
        //  model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select ID,bookDeliveryTime,lateDeliveryPenalty,takeBookLimit from bookdeliverysettings";
        ArrayList<bookDeliverySettings> bookDeliverySettingsList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookDeliverySettings dep;
            int counter = 0;
            while (rs.next()) {
                int ID = rs.getInt(1);
                int bookDeliveryTime = rs.getInt(2);
                int lateDeliveryPenalty = rs.getInt(3);
                int takeBookLimit = rs.getInt(4);
                dep = new bookDeliverySettings(ID, bookDeliveryTime, lateDeliveryPenalty, takeBookLimit);
            }
        } catch (SQLException ex) {
            System.out.print("bookdeliverysettings line 92 :" + ex);
        }
        return bookDeliverySettingsList;
    }

    public int[] list(int ID, int bookDeliveryTime, int lateDeliveryPenalty, int takeBookLimit) {
        Statement stmt = null;
        String query = "select ID,bookDeliveryTime,lateDeliveryPenalty,takeBookLimit from bookdeliverysettings";
        int[] list = new int[4];
        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookDeliverySettings dep;
            int counter = 0;
            while (rs.next()) {
                ID = rs.getInt(1);
                bookDeliveryTime = rs.getInt(2);
                lateDeliveryPenalty = rs.getInt(3);
                takeBookLimit = rs.getInt(4);
                list[0] = ID;
                list[1] = bookDeliveryTime;
                list[2] = lateDeliveryPenalty;
                list[3] = takeBookLimit;
            }
        } catch (SQLException ex) {
            System.out.print("bookdeliverysettings line 92 :" + ex);
        }
        return list;

    }

    public int GetdepartmentID(ArrayList<bookDeliverySettings> bookDeliverySettingsList, int index) {
        bookDeliverySettings delivery = bookDeliverySettingsList.get(index);
        return delivery.getBookDeliverySettingsID();
    }

    public String getBookDeliverySettingstID(int ID, Connection con, Statement stmt) {
        String query = "select bookDeliveryTime,lateDeliveryPenalty,takeBookLimit from bookdeliverysettings where ID=?";
        String bookDeliveryTime = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                bookDeliveryTime = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return bookDeliveryTime;
    }
}
