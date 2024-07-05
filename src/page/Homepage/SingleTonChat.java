/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package page.Homepage;

/**
 *
 * @author trunk
 */
public class SingleTonChat {
    private static Chat chat;
    
    public static Chat getChat(){
        if(chat == null){
            chat = new Chat();   
        }
        return chat;
    }
}
