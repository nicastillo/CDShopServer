/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.ws.prodcat;

//import com.etechies.server.beans.CDList;
import com.etechies.server.dbagent.beans.Product;
import com.etechies.server.dbagent.dao.CategoryDAO;
import com.etechies.server.dbagent.dao.ProductDAO;
import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Aman
 */
@WebService(serviceName = "ProductCatalogWebService")
public class ProductCatalogWebService {

    
     /**
     * Web service operation
     * Gets a list of CDs
     * @param categoryId - the category
     * @returns List of the products of a certain category
     */
    @WebMethod(operationName = "getProductList")
    public ArrayList<Product> getProductList(@WebParam(name = "categoryId") String categoryId) {
        ProductDAO prodDAO = new ProductDAO();
        ArrayList<Product> prodList;
        if (categoryId==null){
            prodList = prodDAO.getProductList();
        } else {
            prodList = prodDAO.getProductList(categoryId);
        } 
        return prodList;
    }


    /**
     * Web service operation
     * Gets a CD's information
     * @param productId - the CD's unique identifier
     * @returns the product information of a certain CD
     */
    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "productId") String productId) {
        ProductDAO prodDAO = new ProductDAO();
        //Product product = new Product();
        Product product = prodDAO.getProductInfo(productId);
        return product;
    }

    /**
     * Web service operation
     * Gets all the categories
     * @returns a list of all categories
     */
    @WebMethod(operationName = "getCategoryList")
    public ArrayList<String> getCategoryList() {
        CategoryDAO catDAO = new CategoryDAO();
        ArrayList<String> list;
        list = catDAO.getCategoryList();
        return list;
    }
}
