/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author trunk
 */
public class TextOfChatting {
    private int id;
    private int friendshipID;
    private String content;
    private Timestamp timeOfText;
    
    public TextOfChatting(){
        
    }

    public TextOfChatting(int id, int friendshipID, String content, Timestamp timeOfText) {
        this.id = id;
        this.friendshipID = friendshipID;
        this.content = content;
        this.timeOfText = timeOfText;
    }

    public TextOfChatting(int friendshipID, String content, Timestamp timeOfText) {
        this.friendshipID = friendshipID;
        this.content = content;
        this.timeOfText = timeOfText;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFriendshipID() {
        return friendshipID;
    }

    public void setFriendshipID(int friendshipID) {
        this.friendshipID = friendshipID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimeOfText() {
        return timeOfText;
    }

    public void setTimeOfText(Timestamp timeOfText) {
        this.timeOfText = timeOfText;
    }
    
    
}
