/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage;


import net.miginfocom.swing.MigLayout;
import page.Homepage.ChatComponent.ChatBody;
import page.Homepage.ChatComponent.ChatBottom;
import page.Homepage.ChatComponent.ChatTitle;
import page.Homepage.ChatComponent.SingleTonChatBottom;
import page.Homepage.ChatComponent.SingleTonChatTitle;

/**
 *
 * @author trunk
 */
public class Chat extends javax.swing.JPanel {
    
//    private ChatBody chatBody = new ChatBody();
//    private ChatBottom chatBottom = new ChatBottom();
    /**
     * Creates new form RightPanel
     * 
     * 
     */
    
    
    private ChatTitle chatTitle = SingleTonChatTitle.getChatTitle();
    private static ChatBody chatBody = new ChatBody();
    private ChatBottom chatBottom = SingleTonChatBottom.getBottomChat();
    
    public Chat() {
        
        
        initComponents();
        init();
        
        
    }
    
    public void init(){
        this.setLayout(new MigLayout("fillx", "0 [fill] 0", ""));
        this.add(chatTitle, "wrap");
        this.add(chatBody, "wrap");
        this.add(chatBottom, "wrap");
            
        
    }
    
    public ChatBody getBody(){
        return chatBody;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 255)));
        setMaximumSize(new java.awt.Dimension(763, 694));
        setName(""); // NOI18N
        setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
}
