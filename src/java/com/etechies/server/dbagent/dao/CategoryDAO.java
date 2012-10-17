/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.dao;

import com.etechies.server.dbagent.DBAgent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nat
 */
public class CategoryDAO {
    
    DBAgent dba=new DBAgent();
    
    public ArrayList<String> getCategoryList(){
        
        //String category= null;
        ArrayList<String> catList = new ArrayList<String>();
        try {
            ResultSet rs = dba.getQueryResult("get_categories", null);
                while(rs.next()){
                //category=rs.getString("category");            
                   //catList.add(category);
                   catList.add(rs.getString("category"));
                }
        } catch (SQLException ex) {
            System.out.println("MySql Error: " + ex);
            
        }
        return catList;
    }
}
    
   
