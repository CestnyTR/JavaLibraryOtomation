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
public class bookDeliverySettings {

    private int ID;
    private int bookDeliveryTime;
    private int lateDeliveryPenalty;
    private int takeBookLimit;

    public bookDeliverySettings(int ID, int bookDeliveryTime, int lateDeliveryPenalty, int takeBookLimit) {
        this.ID = ID;
        this.bookDeliveryTime = bookDeliveryTime;
        this.lateDeliveryPenalty = lateDeliveryPenalty;
        this.takeBookLimit = takeBookLimit;

    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the bookDeliveryTime
     */
    public int getBookDeliveryTime() {
        return bookDeliveryTime;
    }

    /**
     * @param bookDeliveryTime the bookDeliveryTime to set
     */
    public void setBookDeliveryTime(int bookDeliveryTime) {
        this.bookDeliveryTime = bookDeliveryTime;
    }

    /**
     * @return the lateDeliveryPenalty
     */
    public int getLateDeliveryPenalty() {
        return lateDeliveryPenalty;
    }

    /**
     * @param lateDeliveryPenalty the lateDeliveryPenalty to set
     */
    public void setLateDeliveryPenalty(int lateDeliveryPenalty) {
        this.lateDeliveryPenalty = lateDeliveryPenalty;
    }

    /**
     * @return the takeBookLimit
     */
    public int getTakeBookLimit() {
        return takeBookLimit;
    }

    /**
     * @param takeBookLimit the takeBookLimit to set
     */
    public void setTakeBookLimit(int takeBookLimit) {
        this.takeBookLimit = takeBookLimit;
    }

    public int getBookDeliverySettingsID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
