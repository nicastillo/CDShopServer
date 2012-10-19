/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author Aman
 * Class to retrieve database connection object and to read properties from properties file.
 */
public class ConnectionPool {
    
    
   // DbAgentUtil objProp = null;
    /**
     * Method getConnection. Used from connection pooling example provided on course web-site.
     *
     * @return Connection object
     */
    public Connection getConnection()throws SQLException{
        Connection con = null;
        PropPicker objProp = new PropPicker();
        try {
            InitialContext ctx = new InitialContext();
            if (ctx == null){
                System.out.println("JNDI problem. Cannot get InitialContext.");
            }
            DataSource dataSource;
            dataSource = (DataSource) ctx.lookup(objProp.getProperty("context"));
            
            if (dataSource != null) {
                con = dataSource.getConnection();
            }
            else {
                System.out.println("Failed to lookup datasource.");
            }
            
        } catch (NamingException e) {
            System.out.println("Cannot get connection: " + e);
        } catch(SQLException e){
            System.out.println("Cannot get connection: " + e);
        }
            return con;
    }
         
    
      
        
 
    
}

    

