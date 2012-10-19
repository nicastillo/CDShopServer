/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.beans;

import java.util.ArrayList;

/**
 *
 * @author Nat
 */
public class POrder {
    private int userId;
    private String status;
    private int orderId;
    private ArrayList<POrderItems> orderItems;

    
    public POrder(){
        
	}
	public POrder(int userId, String status, int orderId, ArrayList<POrderItems> orderItems){
		this.userId=userId;
		this.status=status;
		this.orderId=orderId;
		this.orderItems=orderItems;
	}	
    /**
     * @return the userid
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param int the userid to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the orderItems
     */
    public ArrayList<POrderItems> getOrderItems() {
        return orderItems;
    }

     /**
     * @param orderItems the orderItems to set
     */
    public void setOrderItems(ArrayList<POrderItems> orderItems) {
        //this.setOrderItems(new ArrayList<POrderItems>());
        this.orderItems = orderItems;
    }
}
