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
            String sql1 = "select userID, friendID from friendships";
            ResultSet rs1 = st.executeQuery(sql1);
            while (rs1.next()) {
                int userID = rs1.getInt("userID");
                int friendID = rs1.getInt("friendID");

                System.out.println(userID + " " + friendID);
                
                friendshipsArray[userID][friendID] = 1;

            }

            System.out.println("oke1");

            for (int i = 0; i < friendshipsArray.length; i++) {
                for (int j = 0; j < friendshipsArray[i].length; j++) {
                    if (friendshipsArray[i][j] == 1) {
                        int userID = i;
                        int friendID = j;
                        
                        String sqlGetRegionOfUser = "select region from users where userID = " + userID;
                        String sqlGetRegionOfFriend = "select region from users where userID = " + friendID;
                        
                        
                        ResultSet rs2 = st.executeQuery(sqlGetRegionOfUser);
                        
                        
                        String region1 = "";
                        String region2 = "";
                        while (rs2.next()) {
                            region1 = rs2.getString("region");
                            
                        }
                        
                        rs2.close();
                        
                        ResultSet rs3 = st.executeQuery(sqlGetRegionOfFriend);
                        
                        while (rs3.next()) {
                            region2 = rs3.getString("region");
                            
                        }
                        
                        rs3.close();

                        int weight = this.getWeight(region1, region2);
                        
                        this.graph.addEdge(userID, friendID, weight);
                        
                        
                        
                    }
                }
                

                

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
