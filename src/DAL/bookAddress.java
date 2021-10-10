package DAL;

/**
 *
 * @author fahri
 */
public class bookAddress {

    private int bookAddressID;
    private String columnNumber;
    private int shelfNumber;

    public bookAddress() {
    }

    public bookAddress(int bookAddressID, String columnNumber, int shelfNumber) {
        this.bookAddressID=bookAddressID;
        this.columnNumber=columnNumber;
        this.shelfNumber=shelfNumber;
    }

    public bookAddress(int bookAddressID, String columnNumber) {
         this.bookAddressID=bookAddressID;
        this.columnNumber=columnNumber;
    }
    
    public bookAddress(int bookAddressID, int shelfNumber) {
        this.bookAddressID=bookAddressID;
        this.shelfNumber=shelfNumber;
    }

    /**
     * @return the bookAddressID
     */
    public int getBookAddressID() {
        return bookAddressID;
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
