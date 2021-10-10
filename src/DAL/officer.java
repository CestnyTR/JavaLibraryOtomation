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
public class officer {

    private int officerID;
    private String officerName;
    private String officerUserName;
    private String officerPassword;

    public officer() {
    }

    public officer(int officerID, String officerName, String officerUserName, String officerPassword) {
        this.officerID = officerID;
        this.officerName = officerName;
        this.officerUserName = officerUserName;
        this.officerPassword = officerPassword;
    }

    /**
     * @return the officerID
     */
    public int getOfficerID() {
        return officerID;
    }

    /**
     * @return the officerName
     */
    public String getOfficerName() {
        return officerName;
    }

    /**
     * @param officerName the officerName to set
     */
    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    /**
     * @return the officerUserName
     */
    public String getOfficerUserName() {
        return officerUserName;
    }

    /**
     * @param officerUserName the officerUserName to set
     */
    public void setOfficerUserName(String officerUserName) {
        this.officerUserName = officerUserName;
    }

    /**
     * @return the officerPassword
     */
    public String getOfficerPassword() {
        return officerPassword;
    }

    /**
     * @param officerPassword the officerPassword to set
     */
    public void setOfficerPassword(String officerPassword) {
        this.officerPassword = officerPassword;
    }

}
