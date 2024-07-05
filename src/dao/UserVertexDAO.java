/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import GraphBase.UserVertex;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author trunk
 */
public class UserVertexDAO implements DAOInterface<UserVertex>{

    @Override
    public int insert(UserVertex t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(UserVertex t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(UserVertex t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<UserVertex> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserVertex selectById(UserVertex t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<UserVertex> selecByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public ArrayList<UserVertex> selectByName(String name){
        ArrayList<UserVertex> userVertexs = new ArrayList<>();
        try {
            Connection c = DBConnection.getConnection();
            Statement st = c.createStatement();
            String sql = "select userID, firstname, lastname from users where firstname like '%" + name + "%' OR lastname like '%" + name + "%'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("userID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                UserVertex userVertex = new UserVertex(id, firstname, lastname);
                userVertexs.add(userVertex);
            }
            
            DBConnection.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userVertexs;
    }
    
}
