/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage.ChatComponent;

import ChatService.ChatClient;
import dao.TextDAO;
import database.DBConnection;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.ScrollBar;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.sql.Timestamp;
import model.Session;
import model.TextOfChatting;

/**
 *
 * @author trunk
 */

public class ChatBottom extends javax.swing.JPanel {

    
    public JButton button;
    public JIMSendTextPane txt;
    public ChatBottom() {
        // start client
//        chatClient = new ChatClient(Session.getUserID());
//        chatClient.startClient();
        initComponents();
        
        init();
    }
    
    public void init(){
        
        setLayout(new MigLayout());
        JScrollPane scroll = new JScrollPane();
        txt = new JIMSendTextPane();
        
        scroll.setViewportView(txt);
        scroll.setBorder(null);
        scroll.setViewportBorder(null);
        this.add(scroll, "h 100%, w 100%");
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("filly", "0[]0", "0[bottom]0"));
        button = new JButton();
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setText("SEND");
        panel.add(button, "h 100%, w 100%");
        this.add(panel, "h 100%");
        

        
    }
    
    
    public void saveTextToDB(String text, int userID, int friendID){
        
        
        int friendshipID = 0;
        try {
            
            Connection c = DBConnection.getConnection();
            
            Statement st = c.createStatement();
            
            String sqlGetFriendShipID = "Select * from friendships where userID = " + userID + " and friendID = " + friendID ;
            
                        
            ResultSet rs = st.executeQuery(sqlGetFriendShipID);
            
            
            
            
            while(rs.next()){
                
                friendshipID = rs.getInt("id");
               
                        
            }
            
            
            
            LocalDateTime now = LocalDateTime.now();
            
            Timestamp timestamp = Timestamp.valueOf(now);
            
            System.out.println(timestamp.toString());
            TextOfChatting txt = new TextOfChatting(friendshipID, text, timestamp);
            
            TextDAO textDAO = new TextDAO();
            
            textDAO.insert(txt);

            DBConnection.closeConnection(c);
            
            
            
                    
        } catch (Exception e) {
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setForeground(new java.awt.Color(0, 0, 255));
        setDoubleBuffered(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
