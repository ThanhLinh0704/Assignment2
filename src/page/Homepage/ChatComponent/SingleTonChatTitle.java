/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package page.Homepage.ChatComponent;

/**
 *
 * @author trunk
 */
public class SingleTonChatTitle {
    private static ChatTitle instance;
    public static ChatTitle getChatTitle(){
        if(instance == null){
            return instance = new ChatTitle();
        }
        return instance;
    }
}
