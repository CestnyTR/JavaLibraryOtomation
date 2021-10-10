/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAL.bookGenre;
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
public class servicesBookGenre {

    public void vtAdd(String bookGenre) {
        String query = "insert into bookgenre(bookGenre) values(?)";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, bookGenre);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookGenre add" + ex);
        }
    }

    public void vtUpdate(int bookGenreID, String bookGenre) {
        String query = "update bookgenre set bookGenre=? where bookGenreID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, bookGenre);
            preparedStmt.setInt(2, bookGenreID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookGenre update" + ex);
        }
    }

    public void vtDelete(int bookGenreID) {
        String query = "delete from bookgenre where bookGenreID=?";
        Connection con = new DBConnector().getConnection();
        try {
            Statement stm = (Statement) con.createStatement();
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookGenreID);
            preparedStmt.execute();
        } catch (Exception ex) {
            System.out.print("Services bookGenre delete" + ex);
        }
    }

    public DefaultTableModel bring(DefaultTableModel model) {
        model.getDataVector().removeAllElements();
        Statement stmt = null;
        String query = "select bookGenreID,bookGenre from bookgenre";
        Connection con = new DBConnector().getConnection();

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int bookGenreID = rs.getInt(1);
                String bookGenre = rs.getString(2);
                model.addRow(new Object[]{bookGenreID, bookGenre});
            }
        } catch (Exception ex) {
            System.out.print("Services bookGenre getCon" + ex);
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

    public ArrayList<bookGenre> load(DefaultComboBoxModel model) {
        model.removeAllElements();
        model.addElement(new texts().choose());
        Statement stmt = null;
        String query = "select bookGenreID,bookGenre from bookgenre";
        ArrayList<bookGenre> bookGenreList = new ArrayList<>();

        try {
            Connection con = new DBConnector().getConnection();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            bookGenre bGenre;
            int counter = 0;
            while (rs.next()) {
                int bookGenreID = rs.getInt(1);
                String bookGenre = rs.getString(2);
                bGenre = new bookGenre(bookGenreID, bookGenre);
                bookGenreList.add(bGenre);
                model.addElement(bookGenre);
            }
        } catch (SQLException ex) {
            System.out.print("bookGenre line 112 :" + ex);
        }
        return bookGenreList;
    }

    public int GetID(ArrayList<bookGenre> bookGenreList, int index) {
        bookGenre bGenre = bookGenreList.get(index);
        return bGenre.getBookGenreID();
    }

    public String getbookGenreID(int bookGenreID, Connection con, Statement stmt) {
        String query = "select bookGenre from bookgenre where bookGenreID=?";
        String bookGenre = "";
        try {
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, bookGenreID);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                bookGenre = rs.getString(1);
            }
        } catch (SQLException ex) {
            System.out.print("Veritabanı Getirme Hatası" + ex);
        }
        return bookGenre;
    }
}
