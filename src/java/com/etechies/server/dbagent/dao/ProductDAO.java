package com.etechies.server.dbagent.dao;
import com.etechies.server.dbagent.DBAgent;
import com.etechies.server.dbagent.beans.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aman
 */
public class ProductDAO {
    
    DBAgent dba=new DBAgent();
    
    public ArrayList<Product> getProductList (String category){
        
        String[] param = {category};
        ArrayList<Product> cdlist = new ArrayList<Product>();
        //Product cd = new Product();
        try {
            ResultSet rs = dba.getQueryResult("get_products_by_category",param);
                while(rs.next()){
                Product cd = new Product();
                cd.setCdId(rs.getString("cdid"));
                cd.setCategory(rs.getString("category"));
                cd.setPrice(rs.getDouble("price"));
                cd.setTitle(rs.getString("title"));
                   cdlist.add(cd);
            }
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
        }
        return cdlist;
    }
    
    /* 
     * @param
     * @returns
     */  
    
    
      public ArrayList<Product> getProductList(){
        ResultSet rs;
        ArrayList<Product> products = new ArrayList<Product>();
        //String[] category = {categoryId};
        try { 
        rs = dba.getQueryResult("get_products", null);
          while (rs.next()) {
            Product p = new Product();
            p.setCdId(rs.getString("cdid"));
            p.setCategory(rs.getString("category"));
            p.setTitle(rs.getString("title"));
            p.setPrice(rs.getDouble("price"));
            products.add(p);
            } 
        } catch (SQLException e){
            System.out.println(e);
        }
        return products;
    }
    
    
        /*
         * 
         */
        public Product getProductInfo (String cdId){
        
        String[] param = {cdId};
        Product p = new Product();
        try {
            ResultSet rs = dba.getQueryResult("get_product_by_cdid",param);
                while(rs.next()){
                p.setCdId(rs.getString("cdid"));
                p.setCategory(rs.getString("category"));
                p.setPrice(rs.getDouble("price"));
                p.setTitle(rs.getString("title"));
            }
        } catch (SQLException ex) {
            System.out.println("MySql Error" + ex);
        }
        return p;
    }
    
    
    

    

}
