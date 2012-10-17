package com.etechies.server.dbagent.dao;
import com.etechies.server.dbagent.beans.Product;
import com.etechies.server.dbagent.DBAgent;
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
                cd.setCategory(category=rs.getString("category"));
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
    
    
      public ArrayList<Product> getProductCatalog(){
        ResultSet rs;
        ArrayList<Product> products = new ArrayList<Product>();
        //String[] category = {categoryId};
        try { 
        rs = dba.getQueryResult("get_products", null);
          while (rs.next()) {
            Product p = new Product();
            p.setTitle(rs.getString("title"));
            p.setPrice(rs.getDouble("price"));
            p.setCategory(rs.getString("category"));
            
//            p.title = rs.getString("title");
//            p.price = rs.getDouble("price");
//            p.category = rs.getString("category");
            products.add(p);
            } 
        } catch (SQLException e){
            System.out.println(e);
        }
        return products;
    }
    
    
    
    
    
    
    
//    public ArrayList<Product> getProductCatalog (){
//        
//       // String[] param = {category};
//        ArrayList<Product> cdlist=null;
//        Product cd=new Product();
//        ResultSet rs = dba.getQueryResult("get_products",null);
//        try {
//            while(rs.next()){
//            cd.cdId=rs.getString("cdid");
//            cd.category=rs.getString("category");
//            cd.price=rs.getDouble("price");
//            cd.title=rs.getString("title");
//               cdlist.add(cd);
//            }
//        } catch (SQLException ex) {
//            System.out.println("MySql Error" + ex);
//        }
//        return cdlist;
//    }
    

}