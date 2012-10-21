///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.etechies.server.shoppingcart;
//
//import com.etechies.server.dbagent.beans.Product;
//import com.etechies.server.dbagent.dao.ProductDAO;
//import java.util.ArrayList;
//
///**
// *
// * @author Nat
// */
//public class ShoppingCart {
//   ArrayList<Product> items;
//   int numOfItems;
//   Double total;
//   
//   public ShoppingCart() {
//    items = new ArrayList<Product>();
//    numOfItems = 0;
//    total = 0.0;
//    }
//   
//   
//   
//   public void addItem(String cdid) {
//       Product product = new Product();
//       ProductDAO pDAO = new ProductDAO();
//       product = pDAO.getProductInfo(cdid);
//       
//       
//        items.add(product);
//        
//        
//        
////        for (ShoppingCartItem sci : items) {
////
////            if (sci.getCd().getCdId() == cd.getCdId()) {
////
////                newItem = false;
////                sci.incrementQuantity();
////                sci.setAmount();
////            }
//        }
//
//   public void remove(String cdid){
//       Product product = new Product();
//       product.setCdId(cdid);
//       items.remove(product);
//     
//    }
//   
//    public ArrayList<Product> getItems() {
//        
//        return items;
//    }
//
//        public int getNumberOfItems() {
//        numOfItems = items.size();
//        return numOfItems;
//    }
//            
//        public Double getSubtotal(){
//        
//        Double subtotal = 0.0;
//        
//            for (Product cartItems : items) {
//
//                //Product cd = (Product) cartItems.g(;
//                subtotal += cartItems.getPrice();
//            }
//            return subtotal;
//        }
//        
//        public Double getTotal() {
//               Double totalamount;
//               totalamount = this.getSubtotal()*(1.16);
//               return totalamount;
//           }
//}
//
//
