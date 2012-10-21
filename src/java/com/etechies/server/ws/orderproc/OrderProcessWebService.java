/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etechies.server.ws.orderproc;

import com.etechies.server.dbagent.beans.Account;
import com.etechies.server.dbagent.beans.POrder;
import com.etechies.server.dbagent.dao.AccountDAO;
import com.etechies.server.dbagent.dao.POrderDAO;
import com.etechies.server.shoppingcart.ShoppingCart;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Nat
 */
@WebService(serviceName="OrderProcessWebService")
public class OrderProcessWebService {

    /**
     * Web service operation
     * Gets the information of a user
     * @param uname - the user's username 
     * @return the account information of a user
     */
    @WebMethod(operationName = "getAccountInfo")
    public Account getAccountInfo(@WebParam(name = "uname") String uname) {
        AccountDAO accDAO = new AccountDAO();
        Account acc = accDAO.getAccountInfo(uname);
        return acc;
    }

    /**
     * Creates a new account and returns a message if the account was created successfully or not
     * @param uname - the user's username 
     * @param upassword - the user's password
     * @param fname - the user's first name
     * @param lname - the user's last name
     * @param street the user's street
     * @param province - the user's province
     * @param zip - the user's postal code
     * @param country - the user's country code
     * @param phone - the user's phone number
     * @return the number of rows affected by the execution of the query
     */
    @WebMethod(operationName = "createAccount")
    public String createAccount(@WebParam(name = "uname") @XmlElement(required=true) String uname, 
                                @WebParam(name = "upassword") @XmlElement(required=true) String upassword, 
                                @WebParam(name = "fname") @XmlElement(required=true) String fname, 
                                @WebParam(name = "lname") @XmlElement(required=true) String lname, 
                                @WebParam(name = "street")@XmlElement(required=true) String street, 
                                @WebParam(name = "province") @XmlElement(required=true) String province, 
                                @WebParam(name = "zip") @XmlElement(required=true) String zip, 
                                @WebParam(name = "country")@XmlElement(required=true) String country, 
                                @WebParam(name = "phone") String phone) {
        String message;
        AccountDAO accDAO = new AccountDAO();
        int rows = 0;
        boolean e = false;
            try {
                rows = accDAO.createAccount(uname, upassword, fname, lname, street, province, zip, country, phone);
            } catch (Exception ex) {
                Logger.getLogger(OrderProcessWebService.class.getName()).log(Level.SEVERE, null, ex);
                e = true;
            }
        
        if (rows > 0){
            message = "Account succesfully created";
        } else if (e == true ){
            message = "Failed to create account: Ursername is already taken"; 
        } else {
            message = "Failed to create account: Please make sure all fields are complete";
        
            
        }
        //TODO write your implementation code here:
        return message;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "createOrder")
    public POrder createOrder(@WebParam(name = "userId") int userId,  @WebParam(name = "cart") ShoppingCart cart) {
        POrderDAO poDAO = new POrderDAO();
        POrder po;
        po = new POrder();
        
        int rows = 0;
        
        try {
                po = poDAO.createOrder(userId, cart);
            } catch (Exception ex) {
                Logger.getLogger(OrderProcessWebService.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return po;
    }
    
       @WebMethod(operationName = "confirmOrder")
    public boolean confirmOrder(@WebParam(name = "orderId") int orderId, @WebParam(name = "paymentInfo") boolean paymentInfo) {
        POrderDAO poDAO = new POrderDAO();
        boolean ok;
        try {
            ok = poDAO.confirmOrder(orderId, paymentInfo);
        } catch (Exception ex) {
            Logger.getLogger(OrderProcessWebService.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        //TODO write your implementation code here:
        return ok;
    }
       
        @WebMethod(operationName = "denyOrder")
    public boolean denyOrder(@WebParam(name = "orderId") int orderId, @WebParam(name = "paymentInfo") boolean paymentInfo) {
        POrderDAO poDAO = new POrderDAO();
        boolean ok;
        try {
            ok = poDAO.denyOrder(orderId, paymentInfo);
        } catch (Exception ex) {
            Logger.getLogger(OrderProcessWebService.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        //TODO write your implementation code here:
        return ok;
    }
        
           @WebMethod(operationName = "getOrder")
    public POrder getOrder(@WebParam(name = "orderId") int orderId) {
        POrderDAO poDAO = new POrderDAO();
        POrder order;
        order = poDAO.getOrder(orderId);
        //TODO write your implementation code here:
        return order;
    }
}
