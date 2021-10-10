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
public class books {

    private int bookID;
    private String bookName;
    private int bookGenreID;
    private int authorID;
    private int ISBN_No;
    private String bookStatus;
    private int PublisherID;
    private String columnNumber;
    private int shelfNumber;

    public books() {
    }

    public books(int bookID, String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID,String columnNumber, int shelfNumber) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookGenreID = bookGenreID;
        this.authorID = authorID;
        this.ISBN_No = ISBN_No;
        this.bookStatus = bookStatus;
        this.PublisherID = PublisherID;
        this.columnNumber=columnNumber;
        this.shelfNumber=shelfNumber;
    }

    /**
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @return the bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @param bookName the bookName to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @return the bookGenreID
     */
    public int getBookGenreID() {
        return bookGenreID;
    }

    /**
     * @param bookGenreID the bookGenreID to set
     */
    public void setBookGenreID(int bookGenreID) {
        this.bookGenreID = bookGenreID;
    }

    /**
     * @return the authorID
     */
    public int getAuthorID() {
        return authorID;
    }

    /**
     * @param authorID the authorID to set
     */
    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    /**
     * @return the ISBN_No
     */
    public int getISBN_No() {
        return ISBN_No;
    }

    /**
     * @param ISBN_No the ISBN_No to set
     */
    public void setISBN_No(int ISBN_No) {
        this.ISBN_No = ISBN_No;
    }

    /**
     * @return the bookStatus
     */
    public String getBookStatus() {
        return bookStatus;
    }

    /**
     * @param bookStatus the bookStatus to set
     */
    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * @return the PublisherID
     */
    public int getPublisherID() {
        return PublisherID;
    }

    /**
     * @param PublisherID the PublisherID to set
     */
    public void setPublisherID(int PublisherID) {
        this.PublisherID = PublisherID;
    }

    /**
     * @return the columnNumber
     */
    public String getColumnNumber() {
        return columnNumber;
    }

    /**
     * @param columnNumber the columnNumber to set
     */
    public void setColumnNumber(String columnNumber) {
        this.columnNumber = columnNumber;
    }

    /**
     * @return the shelfNumber
     */
    public int getShelfNumber() {
        return shelfNumber;
    }

    /**
     * @param shelfNumber the shelfNumber to set
     */
    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

}
