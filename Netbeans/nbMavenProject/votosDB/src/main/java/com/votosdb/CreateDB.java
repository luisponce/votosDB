/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.votosdb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisponcedeleon
 */
public class CreateDB {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection c = DBOps.ConnectDB();
            
            Statement stm = c.createStatement();
            
            
            
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
