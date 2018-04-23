/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocp.jdbc;

/**
 *
 * @author PietroS
 */
import java.sql.*;

public class MyFirstDatabaseConnection {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:derby:zoo";
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY );
                ResultSet rs = stmt.executeQuery("select name from animal")) {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }
    }
}
