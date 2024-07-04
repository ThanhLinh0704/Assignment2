package GraphBase;

import java.util.HashMap;
import model.User;

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
    public HashMap<User, Integer> adjList;

    public UserVertex() {
    }

    public UserVertex(int id) {
        this.id = id;
        //this.adjList = new ArrayList<>();
        this.adjList = new HashMap<>();
    }

}
