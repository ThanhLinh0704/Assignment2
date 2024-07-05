/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package page.Homepage;

import GraphBase.UserVertex;
import components.Item_Person;
import dao.GraphOfConnectionData;
import java.util.Map;
import model.Session;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author trunk
 */
public class Menu_Left extends javax.swing.JPanel {

    /**
     * Creates new form RightPanel
     */
    public Menu_Left() {
        initComponents();
        init();
    }

    private void init() {
        listPerson.setLayout(new MigLayout());
        showPeople();
    }
    
    private void showPeople() {
        int userId = Session.getUserID();
        GraphOfConnectionData graphOfConnectionData = new GraphOfConnectionData();

        UserVertex user = graphOfConnectionData.graph.getUser(userId);

        for (Map.Entry<UserVertex, Integer> entry : user.adjList.entrySet()) {
            String userName = entry.getKey().firstName + " " + entry.getKey().lastName;
            int id = entry.getKey().id;
            
            listPerson.add(new Item_Person(userName, id), "wrap");
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
        setForeground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(236, 694));
        setMinimumSize(new java.awt.Dimension(236, 694));

        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        listPerson.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout listPersonLayout = new javax.swing.GroupLayout(listPerson);
        listPerson.setLayout(listPersonLayout);
        listPersonLayout.setHorizontalGroup(
            listPersonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
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
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        SearchFriend searchFriend = new SearchFriend();
        searchFriend.setVisible(true);
        searchFriend.pack();
        searchFriend.setLocationRelativeTo(null);
        System.out.println("TEST");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane listPerson;
    // End of variables declaration//GEN-END:variables
}
