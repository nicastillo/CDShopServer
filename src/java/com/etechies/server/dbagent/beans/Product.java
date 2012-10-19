/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.beans;

/**
 *
 * @author Aman
 * @author Natalia
 * 
 * Product Bean with getters and setters
 */
public class Product {

    private String cdId;
    private String category;
    private String title;
    private double price;

    /**
     * @return the cdId
     */
    public String getCdId() {
        return cdId;
    }

    /**
     * @param cdId the cdId to set
     */
    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
}
