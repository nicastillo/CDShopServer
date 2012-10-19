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
    
    public POrder createOrder(String uname, ShoppingCart cart){
        POrder order = new POrder();
        String cdid = null;
        //String pri
         int rows=0;
         int id = 0;
         ResultSet rs;
        if (cart == null){
            System.out.print("there is nothing in your cart");
        }
        AccountDAO adao = new AccountDAO();
        id = adao.getUserId(uname);
        String userid = Integer.toString(id);
       
        String status = "ORDERED";
        String[] POInfo = {userid, status};
        
	try{
           rows = dba.executeSQL("create_order", POInfo);
           
        } catch(SQLException e) {
            System.out.println(e);
        }
        
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
                
             } catch(SQLException e) {
                 System.out.println(e);
             }
        }
        try {
            rs = dba.getQueryResult("get_order", POInfo);
              while (rs.next()){
                  order.setUserId(rs.getInt("userid"));
                  order.setOrderId(rs.getInt("orderid"));
                  order.setStatus("status");
              }
         } catch(SQLException e) {
                 System.out.println(e);
         }  

           
        
        
        return order;
    }
    
    public boolean confirmOrder(POrder order, int paymentInfo){
       
        boolean ok = false;
        int counter = 0;
	int rows = 0;
	String orderid = Integer.toString(order.getOrderId());
        //String[] POInfo = {orderid};
      
        if (paymentInfo > 0){
            String status = "Processed";
            String[] POInfo = {orderid, status};
            try{
               rows = dba.executeSQL("confirm_order", POInfo);
               ok = true;
            } catch(SQLException e) {
                System.out.println(e);
            }
        } else {
            
            ok = false;
        }
        return ok;
    }
}
