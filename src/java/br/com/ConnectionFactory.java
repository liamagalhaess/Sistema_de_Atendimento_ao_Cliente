/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jussarasimoesdecarvalho
 */
public class ConnectionFactory {
    
       public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/barbara?useSSL=false",
                    "root", "05Brub@ju");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexão com o banco fechada!");
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
