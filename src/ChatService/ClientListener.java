/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatService;

import java.io.InputStream;
import java.net.Socket;
import page.Homepage.Chat;
import page.Homepage.ChatComponent.ChatBody;
import page.Homepage.Home;

/**
 *
 * @author trunk
 */
public class ClientListener implements Runnable{
    private Socket socket;
    private InputStream input;

    public ClientListener(Socket socket) {
        this.socket = socket;
        try {
            this.input = socket.getInputStream();
        } catch (Exception e) {
            System.out.println("Server is not working");
        }
    }
    
    public void run(){
        try {
            byte[] buffer = new byte[1024];
            int byteRead;
            while((byteRead = input.read(buffer)) != -1){
                String message = new String(buffer, 0, byteRead);
                
                
                String[] format_message = message.split(" ");
                int recieverID = Integer.parseInt(format_message[0]);
                String content = "";
                
                for(int i = 1; i < format_message.length - 1; i++){
                    content += format_message[i] + " ";
                }
                
                int senderID = Integer.parseInt(format_message[format_message.length - 1]);
                ChatBody chatBody = Home.chat.getBody();
                int currentUserID = chatBody.currentUserId;
                if(senderID == currentUserID){
                    chatBody.addItemLeft(content);
                    chatBody.repaint();
                    chatBody.revalidate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
