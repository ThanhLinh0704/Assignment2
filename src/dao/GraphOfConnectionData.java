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

    public void loadUser() {
        try {
            Connection c = DBConnection.getConnection();
            Statement st = c.createStatement();
            String sql = "select userID from users";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("userID");
                graph.addUserToGraph(id);

            }
            DBConnection.closeConnection(c);
        } catch (Exception e) {
        }
    }

    public void loadUserConnection() {
        try {
            Connection c = DBConnection.getConnection();
            Statement st = c.createStatement();
            String sql1 = "select userID, friendID rom friendships";
            ResultSet rs1 = st.executeQuery(sql1);
            while (rs1.next()) {
                int userID = rs1.getInt("userID");
                int friendID = rs1.getInt("friendID");

                String sql2 = "select region from users where userID = " + userID;
                String sql3 = "selcet region fron users where userID = " + friendID;
                ResultSet rs2 = st.executeQuery(sql2);
                ResultSet rs3 = st.executeQuery(sql3);

                String region1 = "";
                String region2 = "";
                while (rs2.next()) {
                    region1 = rs2.getString("region");

                }

                while (rs3.next()) {
                    region2 = rs3.getString("region");
                }

                int weight = this.getWeight(region1, region2);

                this.graph.addEdge(userID, friendID, weight);

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

}
