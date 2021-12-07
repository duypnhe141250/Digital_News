/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Administrator
 */
public class DBContext {

    public Connection getConnection() throws Exception {
        try {
            String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, userID, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "DigitalNews";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123";

    public void closeRS(ResultSet rs) throws Exception {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void closePS(PreparedStatement st) throws Exception {
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void closeCon(Connection con) throws Exception {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            throw ex;
        }
    }

}
