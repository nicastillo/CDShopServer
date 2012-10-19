/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etechies.server.ws.orderproc;

import com.etechies.server.dbagent.beans.Account;
import com.etechies.server.dbagent.beans.POrder;
import com.etechies.server.dbagent.dao.AccountDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Nat
 */
@WebService(serviceName="OrderProcessWebSerice")
public class OrderProcessWebSerice {

    /**
     * Web service operation
     * Gets the information of a user
     * @param uname - the user's username 
     * @param upassword - the user's password
     * @return the account information of a user
     */
    @WebMethod(operationName = "getAccountInfo")
    public Account getAccountInfo(@WebParam(name = "uname") String uname, @WebParam(name = "upassword") String upassword) {
        AccountDAO accDAO = new AccountDAO();
        Account acc = accDAO.getAccountInfo(uname, upassword);
        //TODO write your implementation code here:
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
    public String createAccount(@WebParam(name = "uname") String uname, @WebParam(name = "upassword") String upassword, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname, @WebParam(name = "street") String street, @WebParam(name = "province") String province, @WebParam(name = "zip") String zip, @WebParam(name = "country") String country, @WebParam(name = "phone") String phone) throws Exception {
        String message;
        AccountDAO accDAO = new AccountDAO();
        int rows = accDAO.createAccount(uname, upassword, fname, lname, street, province, zip, country, phone);
        
        if (rows > 0){
            message = "Account succesfully created";
        } else {
            message = "Failed to create account: Username is already taken";
            
        }
        //TODO write your implementation code here:
        return message;
    }
}
