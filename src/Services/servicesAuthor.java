/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.author;
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
public class servicesAuthor {

    public void vtAdd(String authorName) {
        String query = "insert into author(authorName) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, authorName);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services author add" + ex);
        }
    }

    public void vtUpdate(int authorID, String authorName) {
        String query = "update author set authorName=? where authorID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, authorName);
            preparedStmt.setInt(2, authorID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services author update" + ex);
        }
    }

    public void vtDelete(int authorID) {
        String query = "delete from author WHERE authorID=?";
        try {
            Connection con = new DBConnector().getConnection();
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, authorID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services author delete " + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select authorID,authorName from author";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int authorID = rs.getInt(1);
                String authorName = rs.getString(2);
                model.addRow(new Object[]{authorID, authorName});
            }
        } catch (Exception ex) {
            System.out.print("Services author getCon" + ex);
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

    public ArrayList<author> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select authorID,authorName from author";
        ArrayList<author> authorList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            author Author;
            int counter = 0;
            while (rs.next()) {
                int authorID = rs.getInt(1);
                String authorName = rs.getString(2);
                Author = new author(authorID, authorName);
                authorList.add(Author);
                model.addElement(authorName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(servicesAuthor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return authorList;
    }

    public int GetAuthorID(ArrayList<author> authorList, int index) {
        author Author = authorList.get(index);
        return Author.getAuthorID();
    }

    public String getAuthorID(int authorID, Connection con, Statement stmt) {
        String query = "select authorName from author where authorID=?";
        String authorName = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, authorID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                authorName = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return authorName;
    }
}
