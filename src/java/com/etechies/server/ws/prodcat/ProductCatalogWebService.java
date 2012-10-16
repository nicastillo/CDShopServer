/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.ws.prodcat;

//import com.etechies.server.beans.CDList;
import com.etechies.server.beans.Product;
import com.etechies.server.dbagent.DBAgent;
import java.util.ArrayList;
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
    @WebMethod(operationName = "getProductCatalog")
    public ArrayList<Product> getProductCatalog() {
        //TODO write your implementation code here:
        DBAgent agent = new DBAgent();
        ArrayList<Product> products;
        products = agent.getProductCatalog();
   
        
        return products;
    }
    
        /**
     * Web service operation
     */
//    @WebMethod(operationName = "getProductList")
//    public ArrayList<Product> getProductList(@WebParam(name = "categoryId") String categoryId) {
//        //TODO write your implementation code here:
//        DBAgent agent = new DBAgent();
//        ArrayList<Product> products;
//        products = agent.getProductCatalog();
//   
//        
//        return products;
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
    public ArrayList<String> getCategoryList() {
        DBAgent agent = new DBAgent();
        ArrayList<String> list;
        list = agent.getCategoryList();
        
        
        //TODO write your implementation code here:
        return list;
    }
}
