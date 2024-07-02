/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author laptop lenovo
 */
public class DBConnection {

//    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/user";
    public static Connection getConnection() {
        Connection c = null;
//            MysqlDataSource dataSource = new MysqlDataSource();
//            dataSource.setServerName("localhost");
//            dataSource.setPort(3306);
//            dataSource.setDatabaseName("user");

        try {
            String url = "jdbc:mysql://localhost:3306/users";
            String username = "root";
            String passwords = "@Linh07042004";
            c = DriverManager.getConnection(url, username, passwords);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {
        }
    }

//    public static void addUser() {
//        try {
//            Connection connection = getConnection();
//            Statement st = connection.createStatement();
//            String sql = "INSERT INTO user(iduser, useName, password, fullName, gender, email, address)"
//                    + "VALUES (\"H2\",\"linhlt\",\"123456\",\"lelinh\",\"1\",\"ling@gmail.com\",\"hanoi\")";
//
//            int check = st.executeUpdate(sql);
//            if (check > 0) {
//                System.out.println("seccessful");
//            }
//            closeConnection(connection);
//        } catch (SQLException e) {
//        }
//    }
}
