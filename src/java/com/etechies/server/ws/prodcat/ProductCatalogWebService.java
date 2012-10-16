/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.ws.prodcat;

import com.etechies.server.beans.Product;
//import com.etechies.server.beans.CDList;
import com.etechies.server.dbagent.DBAgent;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Aman
 */
@WebService(serviceName = "ProductCatalogWebService")
public class ProductCatalogWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "getProductInfo")
//    public Product getProductInfo(@WebParam(name = "ProductID") int ProductID) {
//        //TODO write your implementation code here:
//        DBAgent agent = new DBAgent();
//        Product tempBean = agent.getProductInfo(1);
//        return tempBean;
//    }
    
    /**
     * Web service operation
     */
//    @WebMethod(operationName = "getProductList")
//    public CDList getProductList(@WebParam(name = "ProductID") int ProductID) {
//        //TODO write your implementation code here:
//        DBAgent agent = new DBAgent();
//        Product tempBean = agent.getProductInfo(1);
//        
//        CDList list = new CDList();
//        list.cd = new Product[5];
//        list.cd[0] = tempBean;
//        list.cd[1] = tempBean;
//        list.cd[2] = tempBean;
//        list.cd[3] = tempBean;
//        list.cd[4] = tempBean;
//        
//        return list;
//    }

//    /**
//     * Web service operation
//     */
//    @WebMethod(operationName = "getProductInfo")
//    public Product getProductInfo(@WebParam(name = "productId") int productId) {
//        //TODO write your implementation code here:
//        return null;
//    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCategoryList")
    public String getCategoryList() {
        //TODO write your implementation code here:
        return null;
    }
}
