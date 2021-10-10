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
public class students {

    private int studentID;
    private String name;
    private int studentNumber;
    private String password;
    private int facultyID;
    private int departmentID;
    private String studentE_Mail;

    public students() {
    }

    public students(int studentID, String name, int studentNumber, String password, int facultyID, int departmentID, String studentE_Mail) {
        this.studentID = studentID;
        this.name = name;
        this.studentNumber = studentNumber;
        this.password = password;
        this.facultyID = facultyID;
        this.departmentID = departmentID;
        this.studentE_Mail = studentE_Mail;
    }

    public students(int studentNumber, String password) {
        this.studentNumber = studentNumber;
        this.password = password;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the studentNumber
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the departmentID
     */
    public int getDepartmentID() {
        return departmentID;
    }

    /**
     * @param departmentID the departmentID to set
     */
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    /**
     * @return the studentE_Mail
     */
    public String getStudentE_Mail() {
        return studentE_Mail;
    }

    /**
     * @param studentE_Mail the studentE_Mail to set
     */
    public void setStudentE_Mail(String studentE_Mail) {
        this.studentE_Mail = studentE_Mail;
    }

}
