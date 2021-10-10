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
public class faculty {

    private int facultyID;
    private String facultyName;

    public faculty() {
    }

    public faculty(int facultyID, String facultyName) {
        this.facultyID = facultyID;
        this.facultyName = facultyName;
    }

    /**
     * @return the facultyID
     */
    public int getFacultyID() {
        return facultyID;
    }

    /**
     * @param facultyID the facultyID to set
     */
    public void setFacultyID(int facultyID) {
        this.facultyID = facultyID;
    }

    /**
     * @return the facultyName
     */
    public String getFacultyName() {
        return facultyName;
    }

    /**
     * @param facultyName the facultyName to set
     */
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

}
