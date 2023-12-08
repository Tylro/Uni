/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamh
 */
public class JDBCUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {

            DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); 
            
            String url = "jdbc:mySQL://localhost:3306/ql_thuvien";
            String username = "root";
            String password = "";
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conn;
    } 
    public static void closeConnection(Connection conn) {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    } 
    
}
    