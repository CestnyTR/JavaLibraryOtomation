/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.publisher;
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
public class servicesPublisher {
    
    public void vtAdd(String publisher) {
        String query = "insert into publisher(publisher) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, publisher);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services publisher add" + ex);
        }
    }

    public void vtUpdate(int publisherID, String publisher) {
        String query = "update publisher set publisher=? where publisherID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, publisher);
            preparedStmt.setInt(2, publisherID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services publisher update " + ex);
        }
    }

    public void vtDelete(int bookGenreID) {
        String query = "delete from publisher where publisherID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookGenreID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services publisherID delete " + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select publisherID,publisher from publisher";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int publisherID = rs.getInt(1);
                String publisher = rs.getString(2);
                model.addRow(new Object[]{publisherID, publisher});
            }
        } catch (Exception ex) {
            System.out.print("Services publisher getCon" + ex);
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

    public ArrayList<publisher> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select publisherID,publisher from publisher";
        ArrayList<publisher> publisherList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            publisher pub;
            int counter = 0;
            while (rs.next()) {
                int publisherID = rs.getInt(1);
                String publisher = rs.getString(2);
                pub = new publisher(publisherID, publisher);
                publisherList.add(pub);
                model.addElement(publisher);
            }
        } catch (SQLException ex) {
            System.out.print("publisher line 112 :" + ex);
        }
        return publisherList;
    }

    public int GetPublisherID(ArrayList<publisher> publisherList, int index) {
        publisher pub = publisherList.get(index);
        return pub.getPublisherID();
    }

    public String GetPublisherID(int publisherID, Connection con, Statement stmt) {
        String query = "select publisher from publisher where publisherID=?";
        String publisher = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, publisherID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                publisher = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return publisher;
    }
}
