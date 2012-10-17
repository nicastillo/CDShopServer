/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent.dao;

import com.etechies.server.dbagent.DBAgent;
import com.etechies.server.dbagent.beans.Account;
import com.etechies.server.dbagent.beans.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nat
 */
public class AccountDAO {
    DBAgent dba=new DBAgent();
    
    public Account getAccountInfo (String uname, String upassword){
        
        String[] param = {uname, upassword};
        Account account = new Account();
        try {
            ResultSet rs = dba.getQueryResult("get_account", param);
                while(rs.next()){
                    account.setUserId(rs.getInt("userid"));
                    account.setFname(rs.getString("fname"));
                    account.setLname(rs.getString("lname"));
                }
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
        }
        return account;
    }
    
}
