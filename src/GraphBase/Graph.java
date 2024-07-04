package GraphBase;

import java.util.HashSet;
import java.util.Set;
import model.User;

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

    public void addUserToGraph(int id) {
        this.vertices.add(new UserVertex(id));
    }

    public void addEdge(int u, int v, int weight) {
        UserVertex userU = this.getUser(u);
        User userV = this.getUser(v);

        if (userU != null) {
            if (userV == null) {
                this.vertices.add(new UserVertex(v));
            }
            userU.adjList.put(userV, weight);
        }
    }

    public void display() {
        this.vertices.stream().forEach(vertex -> {
            System.out.print(vertex.id + " -> ");
            vertex.adjList.entrySet().forEach(entry -> System.out.print("(" + entry.getKey().id + ", " + entry.getValue() + ")"));
            System.out.println();

        });
    }
}
