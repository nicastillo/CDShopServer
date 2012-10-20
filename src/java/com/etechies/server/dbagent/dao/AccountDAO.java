/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.dao;

import com.etechies.server.dbagent.DBAgent;
import com.etechies.server.dbagent.beans.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nat
 */
public class AccountDAO {
    DBAgent dba=new DBAgent();
    
    
    
    /* Gets all the revelant information of a spefic account
     * @param uname - the user's username
     * @returns An account object that contains all the data
     * 
     */
    
    public Account getAccountInfo (String uname){       
        String[] param = {uname};
        Account account = new Account();
        try {
            ResultSet rs = dba.getQueryResult("get_account_info", param);
                while(rs.next()){
                    account.setUserId(rs.getInt("userid"));
                    account.setUpassword(rs.getString("upassword"));
                    account.setFname(rs.getString("fname"));
                    account.setLname(rs.getString("lname"));
                    account.setStreet(rs.getString("street"));
                    account.setProvince(rs.getString("province"));
                    account.setZip(rs.getString("zip"));
                    account.setCountry(rs.getString("country"));
                    account.setPhone(rs.getString("phone"));
                }
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
        }
        return account;
    }
    
    
    public int createAccount(String uname, String upassword, String fname, String lname, String street, String province, String zip, String country, String phone) throws Exception{
        
        String[] accountInfo = {uname, upassword, fname, lname};
        String [] addressInfo = {street, province, zip, country, phone};
        int rows=0;
        try {
            rows = dba.executeSQL("create_account", accountInfo);
            dba.startTransaction();
            
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
            dba.rollBack();
            
        }
        dba.endTransaction();
        
        try{
            rows = dba.executeSQL("fill_address", addressInfo);
            dba.startTransaction();
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
            dba.rollBack();
        }
        dba.endTransaction();
        return rows;
    }
    
    
    
    public int getUserId (String uname){       
        String[] param = {uname};
        //Account account = new Account();
        int userid = 0;
        try {
            ResultSet rs = dba.getQueryResult("get_user_id", param);
                while(rs.next()){
                    userid = rs.getInt("userid");
                }
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
        }
        return userid;
    }
    
}
