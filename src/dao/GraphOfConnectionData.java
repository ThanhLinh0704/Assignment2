/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import GraphBase.Graph;
import database.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;


/**
 *
 * @author trunk
 */
public class GraphOfConnectionData {

    public Graph graph = Graph.getSignleTonGraph();

    private String[] regions = {"Bac", "Trung", "Nam"};




    public GraphOfConnectionData() {
        
        this.loadUser();
        this.loadUserConnection();
        
    }




    public void loadUser() {

        try {
            Connection c = DBConnection.getConnection();
            Statement st = c.createStatement();
            String sql = "select userID, firstname, lastname from users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("userID");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                graph.addUserToGraph(id, firstName, lastName);

            }
            DBConnection.closeConnection(c);
        } catch (Exception e) {
        }
    }


    public void loadUserConnection() {

        int[][] friendshipsArray = new int[20][20];
        
        try {
            Connection c = DBConnection.getConnection();
            Statement st = c.createStatement();
            String sql1 = "select userID, friendID, level from friendships";
            ResultSet rs1 = st.executeQuery(sql1);
            while (rs1.next()) {
                int userID = rs1.getInt("userID");
                int friendID = rs1.getInt("friendID");
                int level = rs1.getInt("level");
                System.out.println(userID + " " + friendID + " " + level);
                this.graph.addEdge(userID, friendID, level);
                

            }

            

            DBConnection.closeConnection(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getWeight(String g1, String g2) {
        int index1 = Arrays.asList(regions).indexOf(g1);
        int index2 = Arrays.asList(regions).indexOf(g2);
        return Math.abs(index1 - index2);
    }


    public static void main(String[] args) {
        GraphOfConnectionData gr = new GraphOfConnectionData();

        gr.graph.display();

    }


}
