/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage;

import ChatService.ChatClient;
import model.Session;
import net.miginfocom.swing.MigLayout;


public class Home extends javax.swing.JLayeredPane {

    public static Chat chat = new Chat();
    public static ChatClient chatClient = new ChatClient(Session.getUserID());
    public Home() {
        initComponents();
        init();
    }
    
    

    private void init() {

        
        chatClient.startClient();
        
        this.setLayout(new MigLayout());
        

        this.setLayout(new MigLayout("fillx, filly", "0[pref, fill]5[]5[]0", "0[]0"));

        this.add(new Menu_Left());
        this.add(chat);
        this.add(new Menu_Right());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 700, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


}
