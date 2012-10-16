/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent;

import com.etechies.server.beans.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aman
 * @author Natalia
 */
public class DBAgent {

    PropPicker objProp = new PropPicker();
    
    public int executeQueries(String queryId) throws SQLException {
        ConnectionPool cp = null;
        PreparedStatement pstmt = null;
        int rows = 0;
        Connection conn = cp.getConnection();
        try {
            String query = objProp.getQuery(queryId);
            pstmt = conn.prepareStatement(query);
            rows = pstmt.executeUpdate();          
      } catch (SQLException e){
            System.out.println(e.getMessage());
      } 
        return rows;
    }
    
    public ResultSet getQueryResult(String queryId) throws SQLException{    
        ConnectionPool cp = new ConnectionPool();
        Connection conn = cp.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = objProp.getQuery(queryId);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();          
      } catch (SQLException e){
            System.out.println(e.getMessage());
      } 
        return rs;
        
    }


    public ArrayList<String> getCategoryList(){
        ResultSet rs;
        ArrayList<String> categories = new ArrayList<String>();     
        try { 
        rs = getQueryResult("get_categories");
          while (rs.next()) {
            //Product p = new Product();
            //rs.getString("category");
            categories.add(rs.getString("category"));
            } 
        } catch (SQLException e){
            System.out.println(e);
        }
        return categories;
    }
    
    
    public Product getProductInfo(int productId) {
        // SQL Queries here
        
        //ResultSet queryResult = executeQueries();
        // Get CD Row from CD Database Table
        
        Product bean = new Product();
        bean.category = "Rock";
        bean.cdId = 2;
        bean.title = "Linkin Park";
        bean.price = 10.00;
        
        return bean;
    }
    
    
    /**
     *
     * @param categoryid
     * @return
     */
//    public CDList getProductList (int categoryid){
//        return null;
//    }
    
}
