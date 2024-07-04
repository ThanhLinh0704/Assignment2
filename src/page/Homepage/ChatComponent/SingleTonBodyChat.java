/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package page.Homepage.ChatComponent;

/**
 *
 * @author trunk
 */
public class SingleTonBodyChat {
    private static ChatBody bodyChat;
    
    public static ChatBody getBodyChat(){
        if(bodyChat == null){
            bodyChat = new ChatBody();
            
        }
        return bodyChat;
    }
    
    
}
