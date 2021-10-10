/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author fahri
 */
public class bookTransaction {

    private int bookTransactionID;
    private int studentID;
    private String bookTakeDate;

    public bookTransaction() {
        
    }

    public bookTransaction(int bookTransactionID, String columnNumber, int shelfNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the bookTransactionID
     */
    public int getBookTransactionID() {
        return bookTransactionID;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the bookTakeDate
     */
    public String getBookTakeDate() {
        return bookTakeDate;
    }

    /**
     * @param bookTakeDate the bookTakeDate to set
     */
    public void setBookTakeDate(String bookTakeDate) {
        this.bookTakeDate = bookTakeDate;
    }

}
