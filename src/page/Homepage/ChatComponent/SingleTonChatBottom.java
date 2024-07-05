/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package page.Homepage.ChatComponent;

/**
 *
 * @author trunk
 */
public class SingleTonChatBottom {
    private static ChatBottom chatBottom;
    
    public static ChatBottom getBottomChat(){
        if(chatBottom == null){
            chatBottom = new ChatBottom();
            
        }
        return chatBottom;
    }
}
