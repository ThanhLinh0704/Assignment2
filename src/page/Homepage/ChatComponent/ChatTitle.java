/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage.ChatComponent;

/**
 *
 * @author trunk
 */
public class ChatTitle extends javax.swing.JPanel {

    /**
     * Creates new form ChatTitle
     */
    public ChatTitle() {
        initComponents();
        //setUsername("Toi Ten La Tran Xuan Chien, Toi Den Tu Vinh Phuc Viet Nam");
    }
    
    
    
    public void setUsername(String username){
        jLabel1.setText(username);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        imageAvatar2 = new components.ImageAvatar();

        setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Name");

        imageAvatar2.setAlignmentX(1.0F);
        imageAvatar2.setAlignmentY(1.0F);
        imageAvatar2.setBorderSize(2);
        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icon/avt.png"))); // NOI18N
        imageAvatar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageAvatar2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void imageAvatar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageAvatar2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_imageAvatar2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private components.ImageAvatar imageAvatar2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
