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
public class studentsBook {

    private int studentsBookID;
    private int studentID;
    private int bookID;
    private String bookName;
    private int bookGenreID;
    private int authorID;
    private int ISBN_No;
    private String bookStatus;
    private int PublisherID;
    private String dateOfTookBook;

    public studentsBook() {
    }

    public studentsBook(int studentsBookID, int studentID, int bookID, String bookName, int bookGenreID, int authorID, int ISBN_No, String bookStatus, int PublisherID, String dateOfTookBook) {
        this.studentsBookID = studentsBookID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.bookName = bookName;
        this.bookGenreID = bookGenreID;
        this.authorID = authorID;
        this.ISBN_No = ISBN_No;
        this.bookStatus = bookStatus;
        this.PublisherID = PublisherID;
        this.dateOfTookBook = dateOfTookBook;
    }

    /**
     * @return the studentsBookID
     */
    public int getStudentsBookID() {
        return studentsBookID;
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
     * @return the bookID
     */
    public int getBookID() {
        return bookID;
    }

    /**
     * @param bookID the bookID to set
     */
    public void setBookID(int bookID) {
        this.bookID = bookID;
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
     * @return the dateOfTookBook
     */
    public String getDateOfTookBook() {
        return dateOfTookBook;
    }

    /**
     * @param dateOfTookBook the dateOfTookBook to set
     */
    public void setDateOfTookBook(String dateOfTookBook) {
        this.dateOfTookBook = dateOfTookBook;
    }

}
