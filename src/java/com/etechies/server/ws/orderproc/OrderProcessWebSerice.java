/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.etechies.server.ws.orderproc;

import com.etechies.server.dbagent.beans.Account;
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

    /** This is a sample web service operation */
    @WebMethod(operationName="hello")
    public String hello(@WebParam(name="name") String txt) {
        return "Hello "+txt+" !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAccountInfo")
    public Account getAccountInfo(@WebParam(name = "uname") String uname, @WebParam(name = "upassword") String upassword) {
        AccountDAO accDAO = new AccountDAO();
        Account acc = accDAO.getAccountInfo(uname, upassword);
        //TODO write your implementation code here:
        return acc;
    }
}
