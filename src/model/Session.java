/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author laptop lenovo
 */
public class Session {
    
    private static int userID;
    
    public static void setUserID(int id) {
        userID = id;
    }
    
    public static int getUserID() {
        return userID;
    }
    
    public static void clearSession() {
        userID = -1;
    }
}
