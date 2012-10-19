/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.shoppingcart;

import com.etechies.server.dbagent.beans.Product;
import java.util.ArrayList;

/**
 *
 * @author Nat
 */
public class ShoppingCart {
   ArrayList<ShoppingCartItem> items;
   int numOfItems;
   Double total;
   
   public ShoppingCart() {
    items = new ArrayList<ShoppingCartItem>();
    numOfItems = 0;
    total = 0.0;
    }
   
   
   
   public void addItem(Product cd) {
        ShoppingCartItem cartItems = new ShoppingCartItem(cd);
        items.add(cartItems);
        
        
        
//        for (ShoppingCartItem sci : items) {
//
//            if (sci.getCd().getCdId() == cd.getCdId()) {
//
//                newItem = false;
//                sci.incrementQuantity();
//                sci.setAmount();
//            }
        }

   public void remove(Product cd){
       ShoppingCartItem cartItems = new ShoppingCartItem(cd);
       items.remove(cartItems);
     
    }
   
    public ArrayList<ShoppingCartItem> getItems() {

        return items;
    }

        public int getNumberOfItems() {
        numOfItems = items.size();
        return numOfItems;
    }
            
        public Double getSubtotal(){
        
        Double subtotal = 0.0;
        
            for (ShoppingCartItem cartItems : items) {

                Product cd = (Product) cartItems.getCd();
                subtotal += cd.getPrice();
            }
            return subtotal;
        }
        
        public Double getTotal() {
               Double total = 0.0;
               total = (this.getSubtotal()*(1.16));
               return total;
           }
}


