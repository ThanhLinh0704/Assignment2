/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

public class UserDAO implements DAOInterface<User> {

    public static User getInstanceUser() {
        return new User();
    }

    @Override
    public int insert(User t) {

        try {
            Connection connection = DBConnection.getConnection();
            Statement st = connection.createStatement();

            String sql = "INSERT INTO users (username, password, firstname, gender, email, address, lastName, DOB, region)"
                    + " VALUES ('" + t.getUseName() + "' , '" + t.getPassword() + "' , '" + t.getFirstName() + "' , '" + t.getGender() + "' , '" + t.getEmail() + "' , '" + t.getAddress() + "' , '" + t.getLastName() + "' , '" + t.getDayofBirth() + "' , '" + t.getRegion() + "')";
            st.executeUpdate(sql);

            System.out.println("Ban da thuc thi");
            DBConnection.closeConnection(connection);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;

    }

    @Override
    public int update(User t) {

        return 0;

    }

    @Override
    public int delete(User t) {

        return 0;

    }

    @Override
    public ArrayList<User> selectAll() {
        ArrayList<User> result = new ArrayList<User>();
        try {
            Connection connection = DBConnection.getConnection();
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("username");

                User user = new User(username);

                result.add(user);

            }
            DBConnection.closeConnection(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public User selectById(User t) {
        return null;
    }

    @Override
    public ArrayList<User> selecByCondition(String condition) {
        return null;
    }
    
    public boolean isUsernameExists(String userName) {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT COUNT(*) FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
            DBConnection.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

}
