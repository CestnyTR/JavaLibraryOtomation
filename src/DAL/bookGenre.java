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
public class bookGenre {

    private int bookGenreID;
    private String bookGenre;

    public bookGenre() {
    }

    public bookGenre(int bookGenreID, String bookGenre) {
        this.bookGenreID = bookGenreID;
        this.bookGenre = bookGenre;
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
     * @return the bookGenre
     */
    public String getBookGenre() {
        return bookGenre;
    }

    /**
     * @param bookGenre the bookGenre to set
     */
    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

}
