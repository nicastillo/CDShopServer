/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Aman
 * @author Natalia
 * This class gets the connection from the ConnetionPool class and is in charge of executing the queries to either update or retrieve data
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
    
    /* This class executes a specific query and updates data in the database
     * @param queryid - the identifier of the sqlqueries.properties file
     * @param parameters - the list of parameters of the query
     * @returns the rows affected by the query
     */
    public int executeSQL(String queryId, String[] parameters) throws SQLException {
        PreparedStatement pstmt = null;
        int intRows = 0;
        ResultSet rs = null;
        try {
            String query = prop.getQuery(queryId);
            pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            if (parameters!= null) {
                for (int i = 0; i < parameters.length; i++) {
                    pstmt.setString((i + 1), parameters[i]);
                }
                intRows = pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys(); 
                if ( rs != null && rs.next() ) 
                { 
                    intRows = rs.getInt(1); 
            } else {
                 intRows = pstmt.executeUpdate();   
                }
            }           
                      
      } catch (SQLException e){
            System.out.println(e.getMessage());
            if (e.getMessage().equals("MySQLIntegrityConstraintViolationException")){
                intRows = 0;
            }
      } 
        return intRows;
    }
    
     /* This class executes a specific query and reads data from the database
     * @param queryid - the identifier of the sqlqueries.properties file
     * @param parameters - the list of parameters of the query
     * @returns the resultset
     */
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
        return rs;
        
    }
    /* Use wth either endTransaction() or rollBack() */
    public void startTransaction() throws Exception {
        conn.setAutoCommit(false);
    }
    
    /* Commits the changes made in the database to the database. */
    public void endTransaction() throws Exception {
        
        conn.commit();
        /* Close the connection */
        //conn.close();
    }

    /* In case of an exception or error roll back the changes from database. 
         */
    public void rollBack() throws Exception {
        
        conn.rollback();
    }
    
}
