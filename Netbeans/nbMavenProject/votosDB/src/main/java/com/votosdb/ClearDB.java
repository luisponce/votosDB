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
public class ClearDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection c = DBOps.getInstance().ConnectDB();
            
            Statement stm = c.createStatement();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ClearDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
