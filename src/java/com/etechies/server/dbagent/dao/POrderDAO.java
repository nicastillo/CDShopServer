/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.dao;

import com.etechies.server.dbagent.DBAgent;
import com.etechies.server.dbagent.beans.POrder;
import com.etechies.server.dbagent.beans.POrderItems;
import com.etechies.server.dbagent.beans.Product;
import com.etechies.server.shoppingcart.ShoppingCart;
import com.etechies.server.shoppingcart.ShoppingCartItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nat
 */
public class POrderDAO {
    DBAgent dba = new DBAgent();
    
    public POrder createOrder(int userId, ShoppingCart cart) throws Exception{
        POrder order = new POrder();
        String cdid = null;
        //String pri
         int rows=0;
         int id = 0;
         ResultSet rs;
        

        String userid = Integer.toString(userId);
       
        String status = "ORDERED";
        String[] POInfo = {userid, status};
        //String[] POInfo2 = {orderid};
        
	try{
           rows = dba.executeSQL("create_order", POInfo);
           dba.startTransaction();
           
        } catch(SQLException e) {
            System.out.println(e);
            dba.rollBack();
        }
        dba.endTransaction();
        ArrayList<ShoppingCartItem> cartitems = cart.getItems();
        for (ShoppingCartItem i: cartitems){
            POrderItems poi = new POrderItems();
            poi.setCdId(i.getCdid());
            poi.setPrice(i.getPrice());
            cdid = poi.getCdId();
            String price = Double.toString(poi.getPrice());
            String[] POItemInfo = {cdid,price};

            try{
                rows+= dba.executeSQL("fill_order_items", POItemInfo);
                dba.startTransaction();
                
             } catch(SQLException e) {
                 System.out.println(e);
                 dba.rollBack();
             }
            dba.endTransaction();
        }
        try {
            rs = dba.getQueryResult("get_order", null);
              while (rs.next()){
                  order.setUserId(rs.getInt("userid"));
                  order.setOrderId(rs.getInt("poid"));
                  order.setStatus("status");
              }
         } catch(SQLException e) {
                 System.out.println(e);
         }  

           
     
        return order;
    }
    
    public boolean confirmOrder(int orderId, boolean paymentInfo) throws Exception{
        boolean ok = false;
	int rows = 0;
	//String orderid = Integer.toString(order.getOrderId());
        String orderid = Integer.toString(orderId);
        //String[] POInfo = {orderid};
      
        //if (paymentInfo = true){
            String status = "PROCESSED";
            String[] POInfo = {status,orderid};
            try{
               rows = dba.executeSQL("confirm_order", POInfo);
               dba.startTransaction();
               ok = true;
            } catch(SQLException e) {
                System.out.println(e);
                dba.endTransaction();
            }
            dba.endTransaction();
        //} else {
            
            //ok = false;
        //}
        return ok;
    }
    
    
    public boolean denyOrder(int orderId, boolean paymentInfo) throws Exception{
        boolean ok = false;
	int rows = 0;
        String orderid = Integer.toString(orderId);
            String status = "DENIED";
            String[] POInfo = {status, orderid};
            try{
               rows = dba.executeSQL("confirm_order", POInfo);
               dba.startTransaction();
               ok=true;
            } catch(SQLException e) {
                System.out.println(e);
                ok=false;
                dba.endTransaction();
            }
            dba.endTransaction();
        return ok;
    }
    
    public POrder getOrder(int poid){
        
        POrder order = new POrder();
        ResultSet rs;
        String orderid = Integer.toString(poid);
        String[] POInfo = {orderid};
        
        try {
            rs = dba.getQueryResult("get_order", POInfo);
              while (rs.next()){
                  order.setUserId(rs.getInt("userid"));
                  order.setOrderId(rs.getInt("poid"));
                  order.setStatus("status");
              }
         } catch(SQLException e) {
                 System.out.println(e);
         }  
        return order;
    }
}
