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
public class publisher {

    private int publisherID;
    private String publisher;

    public publisher() {
    }

    public publisher(int publisherID, String publisher) {
        this.publisherID =publisherID;
        this.publisher = publisher;
    }

    /**
     * @return the publisherID
     */
    public int getPublisherID() {
        return publisherID;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

}
