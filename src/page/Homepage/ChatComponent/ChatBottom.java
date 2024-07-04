/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage.ChatComponent;

import database.DBConnection;
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

/**
 *
 * @author trunk
 */

public class ChatBottom extends javax.swing.JPanel {


    public ChatBottom() {
        initComponents();
        this.init(); 
    }
    
    private void init(){
        setLayout(new MigLayout("fillx, filly", "", ""));
        JScrollPane scroll = new JScrollPane();
        JIMSendTextPane txt = new JIMSendTextPane();
        scroll.setViewportView(txt);
        this.add(scroll, "h 100%, w 100%");
        
        
        JPanel panel = new JPanel();
        panel.setLayout(new MigLayout("", "", ""));
        JButton button = new JButton();
        button.setText("SEND");
        panel.add(button, "h 100%");
        this.add(panel, "h 100%");
        
        button.addActionListener(new ActionListener() {
            
            

            @Override
            public void actionPerformed(ActionEvent e) {
                ChatBody chatBody = SingleTonBodyChat.getBodyChat();
                String text = txt.getText().trim();
                if(!text.isEmpty()){
                    chatBody.addItemRight(text);
                    txt.setText("");
                    txt.grabFocus();
                    
                    // save text to db
                    
                }else{
                    txt.grabFocus();
                }
            }
            
        });
        
    }
    
    
    private void saveTextToDB(String text, int userID, int friendID){
        try {
            
            Connection c = DBConnection.getConnection();
            
            Statement st = c.createStatement();
            
            String sqlGetFriendShipID = "Seclect id from friendships where userID = " + userID + " and friendID = " + friendID ;
                        
            ResultSet rs = st.executeQuery(sqlGetFriendShipID);
            
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            System.out.println(formattedDateTime);  
            
            int friendshipID = 0;
            while(rs.next()){
                friendshipID = rs.getInt("id");
            }
            
            
            
            
            
            
            DBConnection.closeConnection(c);
                    
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
