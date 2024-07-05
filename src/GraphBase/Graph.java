package GraphBase;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trunk
 */
public class Graph {

    private Set<UserVertex> vertices;
    private static Graph instance;

    public Graph() {
        this.vertices = new HashSet<>();

    }

    public static Graph getSignleTonGraph() {
        if (instance == null) {
            return new Graph();
        }
        return instance;
    }

    public UserVertex getUser(int id) {
        for (UserVertex user : this.vertices) {
            if (user.id == id) {
                return user;
            }
        }
        return null;
    }

    public void addUserToGraph(int id, String firstName, String lastName) {
        this.vertices.add(new UserVertex(id, firstName, lastName));
    }

    public void addEdge(int u, int v, int weight) {
        UserVertex userU = this.getUser(u);
        UserVertex userV = this.getUser(v);

        userU.adjList.put(userV, weight);

    }


    public Set<UserVertex> getVertices() {
        return vertices;
    }

    public void display() {
        this.vertices.stream().forEach(vertex -> {
            System.out.print(vertex.id + " -> ");
            vertex.adjList.entrySet().forEach(entry -> System.out.print("(" + entry.getKey().id + ", " + entry.getValue() + ")"));
            System.out.println();

        });
    }

    public boolean checkConnection(UserVertex user1, UserVertex user2) {
        UserVertex user = this.getUser(user1.id);
        for (Map.Entry<UserVertex, Integer> entry : user.adjList.entrySet()) {
            if (user2.id == entry.getKey().id) {
                return true;
            }
        }
        return false;
    }
}