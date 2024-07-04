package GraphBase;

import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author trunk
 */
public class UserVertex {

    public int id;
    public String firstName;
    public String lastName;
    public HashMap<UserVertex, Integer> adjList;

    public UserVertex() {
    }

    public UserVertex(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

        //this.adjList = new ArrayList<>();
        this.adjList = new HashMap<>();
    }

}
