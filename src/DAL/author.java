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
public class author {
     private int authorID;
    private String authorName;
    
     public author() {
    }

    public author(int authorID, String authorName) {
        this.authorID=authorID;
        this.authorName=authorName;
    }

    /**
     * @return the authorID
     */
    public int getAuthorID() {
        return authorID;
    }
     public int setAuthorID() {
        return authorID;
    }

    /**
     * @return the authorName
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * @param authorName the authorName to set
     */
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
   
}
