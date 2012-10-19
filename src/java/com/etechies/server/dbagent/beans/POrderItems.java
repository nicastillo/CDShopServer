/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.beans;

/**
 *
 * @author Nat
 */
public class POrderItems {
    private String cdId;
    private int poId;
    private Double price;

    public POrderItems(){
	}
    public POrderItems(String cdId, int poId, Double price){
		this.cdId=cdId;
		this.poId=poId;
		this.price=price;
	}
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
     * @return the poId
     */
    public int getPoId() {
        return poId;
    }

    /**
     * @param poId the poId to set
     */
    public void setPoId(int poId) {
        this.poId = poId;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }
}
