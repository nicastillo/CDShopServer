/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent;

import com.etechies.server.dbagent.beans.Product;
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
    Connection conn = null;
    ConnectionPool cp = null;
    PropPicker prop = new PropPicker(); 
    public DBAgent(){
        try {
            /*creating a coonection to mysql database */
        cp=new ConnectionPool();
        conn=cp.getConnection();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed. " + e.getMessage());
            conn= null;
        }
    }
    
    public int executeSQL(String queryId, String[] parameters) throws SQLException {
        PreparedStatement pstmt = null;
        int intRows = 0;
        ResultSet rs = null;
        //conn = cp.getConnection();
        try {
            String query = prop.getQuery(queryId);
            pstmt = conn.prepareStatement(query);
            if (parameters!= null) {
                for (int i = 0; i < parameters.length; i++) {
                    pstmt.setString((i + 1), parameters[i]);
                }
            }
                intRows = pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys(); 
                if ( rs != null && rs.next() ) 
                { 
                    intRows = rs.getInt(1); 
                }           
            intRows = pstmt.executeUpdate();          
      } catch (SQLException e){
            System.out.println(e.getMessage());
      } 
        return intRows;
    }
    
    public ResultSet getQueryResult(String queryId, String[] parameters){    
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String query = prop.getQuery(queryId);
            pstmt = conn.prepareStatement(query);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    pstmt.setString((i + 1), parameters[i]);
                }
            }
            rs = pstmt.executeQuery();          
        } catch (SQLException e){
            System.out.println(e.getMessage());
            //this.rollBack();
        }
//        } finally {
//            if (rs != null) {
//                try {
//                  rs.close();
//                } catch (SQLException e) {
//                } // nothing we can do
//            }
//            if (pstmt != null) {
//                try {
//                    pstmt.close();
//              } catch (SQLException e) {
//              } // nothing we can do
//            }
//            if (conn != null) {
//              try {
//                conn.close();
//              } catch (SQLException e) {
//              } // nothing we can do
//            }
//        }
        return rs;
        
    }
    /* Use wth either endTransaction() or rollBack() */
    public void startTransaction() throws Exception {
        conn.setAutoCommit(false);
    }

    public void endTransaction() throws Exception {
        /* Commits the changes made in the database to the database. */
        conn.commit();
        /* Close the connection */
        conn.close();
    }

    public void rollBack() throws Exception {
        /* In case of an exception or error roll back the changes from database. 
         */
        conn.rollback();
    }
    
//    public Product getProductInfo(int productId) {
//        // SQL Queries here
//        
//        //ResultSet queryResult = executeSQL();
//        // Get CD Row from CD Database Table
//        
//        Product bean = new Product();
//        bean.category = "Rock";
//        //bean.cdId = 2;
//        bean.title = "Linkin Park";
//        bean.price = 10.00;
//        
//        return bean;
//    }
    
}
