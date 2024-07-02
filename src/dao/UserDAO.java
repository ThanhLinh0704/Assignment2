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

            String sql = "INSERT INTO user (iduser, userName, password, firstName, gender, email, address, lastName)"
                    + " VALUES ('" + t.getIduser() + "' , '" + t.getUseName() + "' , '" + t.getPassword() + "' , '" + t.getFirstName() + "' , '" + t.getGender() + "' , '" + t.getEmail() + "' , '" + t.getAddress() + "' , '" + t.getLastName() + "')";
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
        return null;
    }

    @Override
    public User selectById(User t) {
        return null;
    }

    @Override
    public ArrayList<User> selecByCondition(String condition) {
        return null;
    }

}
