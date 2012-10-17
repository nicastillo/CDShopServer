/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etechies.server.dbagent;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class retrieves parameters defined in the database and SQL property files.
 * @author Aman
 */
public class PropPicker {

    /* Returns a specific property from the "databaseparameters.properties" file.
     * @param propName - unique identificator for the property in the properties file
     * @returns the property specified by propName
     */
    public String getProperty(String propName) {
        Properties prop = new Properties();
        try { 
            prop.load(this.getClass().getClassLoader().getResourceAsStream("com/etechies/properties/dbparams.properties"));
        } catch (IOException e) {
            System.out.println("Error reading properties File" + e);
        }
        String propValue = prop.getProperty(propName);
        return propValue;
    }

  
    /* Returns the String of a query from the "sqlproperties.properties" file.
     * @param queryId - unique identificator for the query in the properties file
     * @returns the query specified by queryId
     */
    public String getQuery(String queryId) {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getClassLoader().getResourceAsStream("com/etechies/properties/sqlqueries.properties"));
        } catch (IOException e) {
            System.out.println("Error reading properties File" + e);
        }
        String propValue = prop.getProperty(queryId);
        return propValue;
    
    }
}
    

