/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import model.TextOfChatting;

/**
 *
 * @author trunk
 */
public class TextDAO implements DAOInterface<TextOfChatting>{

    @Override
    public int insert(TextOfChatting t) {
        try {
            Connection c = DBConnection.getConnection();
            
            String sql = "Insert into textofchatting(friendshipID, content, timeoftext) values (?, ?, ?)";
            
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setInt(1, t.getFriendshipID());
            pst.setString(2, t.getContent());
            pst.setTimestamp(3, t.getTimeOfText());
            
            pst.execute();
            
            
            DBConnection.closeConnection(c);
        } catch (Exception e) {
        }
        
        return 0;
    }

    @Override
    public int update(TextOfChatting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(TextOfChatting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TextOfChatting> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TextOfChatting selectById(TextOfChatting t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TextOfChatting> selecByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
