/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.dao;

/**
 *
 * @author Nat
 */
public class POrderItemsDAO {
    private String cdid;
    private int poid;
    private String price;

    /**
     * @return the cdid
     */
    public String getCdid() {
        return cdid;
    }

    /**
     * @param cdid the cdid to set
     */
    public void setCdid(String cdid) {
        this.cdid = cdid;
    }

    /**
     * @return the poid
     */
    public int getPoid() {
        return poid;
    }

    /**
     * @param poid the poid to set
     */
    public void setPoid(int poid) {
        this.poid = poid;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }
}
