/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage.ChatComponent;

import database.DBConnection;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author trunk
 */
public class ChatBody extends javax.swing.JPanel {

    /**
     * Creates new form ChatBody
     */
    public ChatBody() {
        initComponents();
        init();
        
        
//        addItemLeft("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//
//        addItemRight("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//
//        addItemLeft("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        addItemRight("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//
//        addItemLeft("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//        addItemLeft("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        
//        addItemRight("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//        addItemRight("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        addItemLeft("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//
//        addItemRight("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//
//        addItemLeft("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//
//        addItemRight("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//
//        addItemLeft("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//        addItemLeft("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        
//        addItemRight("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//        addItemRight("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        
//        addItemLeft("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//
//        addItemRight("I am trying to get a scrollPane working correctly, but not having any luck. The picture drawn in the center panel is quite large and goes off the screen. I visited");
//        addItemRight("She was in a hurry. Not the standard hurry when you're in a rush to get someplace, but a frantic hurry. The type of hurry where a few seconds could mean life or death. She raced down the road ignoring speed limits and weaving between cars. She was only a few minutes away when traffic came to a dead standstill on the road ahead. ");
//        
        loadText(2, 1);
        
    }
    
    public void init(){
        
        body.setLayout(new MigLayout("fillx"));
        sp.setVerticalScrollBar(new JScrollBar());
        sp.getVerticalScrollBar().setBackground(Color.WHITE);
        sp.getVerticalScrollBar().setUnitIncrement(30);
        
        
    }
    
    public void addItemLeft(String text){
        ChatLeft item = new ChatLeft();
        item.setText(text);
        body.add(item, "wrap, w :: 60%");
        body.repaint();
        body.revalidate();
        
    }
    
    
    public void addItemRight(String text){
        ChatRight item = new ChatRight();
        item.setText(text);
        body.add(item, "wrap, al right, w :: 60%");
        body.repaint();
        body.revalidate();
    }
    
    
    public void loadText(int friendID, int userID){
        try {
            Connection c = DBConnection.getConnection();
            
            Statement st = c.createStatement();
            
            String sqlGetFriendship1 = "SELECT id FROM friendships WHERE userID = + " +  userID + " AND friendID =  " +  friendID;
            
            ResultSet rsFriendship1 = st.executeQuery(sqlGetFriendship1);
            int friendship1 = 0;
            while(rsFriendship1.next()){
                friendship1 = rsFriendship1.getInt("id");
            }
            System.out.println(friendship1);
            
            
            String sqlGetFriendship2 = "SELECT id FROM friendships WHERE userID = + " + friendID  + " AND friendID =  " +  userID;
            ResultSet rsFriendship2 = st.executeQuery(sqlGetFriendship2);
            int friendship2 = 0;
            while(rsFriendship2.next()){
                friendship2 = rsFriendship2.getInt("id");
            }
            System.out.println(friendship2);
            
            String sql1 = "SELECT * FROM textofchatting WHERE friendshipid = " + friendship1 + " UNION ALL " + "(SELECT * FROM textofchatting WHERE friendshipid = " + friendship2 +") ORDER BY timeoftext";
            
            ResultSet rs = st.executeQuery(sql1);
            int i = 1;
            while(rs.next()){
                int friendshipID = rs.getInt("friendshipid");
                String content = rs.getString("content");
                System.out.println(content);
                
                
               
                
                
                if(friendship1 == friendshipID){
                    this.addItemRight(content);
                    
                }
                else if(friendship2 == friendshipID){
                    this.addItemLeft(content);
                }
                System.out.println(i++);
            }
            
            DBConnection.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sp = new javax.swing.JScrollPane();
        body = new javax.swing.JPanel();

        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        body.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 711, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        sp.setViewportView(body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables



}
