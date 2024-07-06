/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage;

import components.Item_AddPerson;
import dao.UserDAO;
import java.util.List;
import model.User;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author trunk
 */
public class Search extends javax.swing.JPanel {

    /**
     * Creates new form RightPanel
     */
    public Search() {
        initComponents();
        init();
    }

    private void init() {
        listPerson.setLayout(new MigLayout());
        showPeople();
    }
    
    UserDAO userDAO = new UserDAO();
    
    private void showPeople() {
    List<User> users = userDAO.selectAll(); 
    for (int i = 0; i < users.size(); i++) {
        listPerson.add(new Item_AddPerson(users.get(i).getUseName(), users.get(i).getIduser()), "wrap");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        listPerson = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(236, 694));
        setMinimumSize(new java.awt.Dimension(236, 694));

        listPerson.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout listPersonLayout = new javax.swing.GroupLayout(listPerson);
        listPerson.setLayout(listPersonLayout);
        listPersonLayout.setHorizontalGroup(
            listPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        listPersonLayout.setVerticalGroup(
            listPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(listPerson);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane listPerson;
    // End of variables declaration//GEN-END:variables
}
