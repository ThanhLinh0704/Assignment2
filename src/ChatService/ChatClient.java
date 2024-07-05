/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatService;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author trunk
 */
public class ChatClient {
    private static final String url = "localhost";
    private static final int PORT = 5000;
    OutputStream output;
    private int id;
    
    public ChatClient(int id){
        this.id = id;
    }
    
    
    public void startClient(){
        try {
            
            Socket socket = new Socket(url, PORT);
            
            output = socket.getOutputStream();
            
            output.write((id +"").getBytes());
            
            System.out.println("Connected to server");
            
            ClientListener client = new ClientListener(socket);
            
            new Thread(client).start();
            
            //Scanner sc = new Scanner(System.in);
//            while(true){
//                
//                
//                
//                output.write(message.getBytes());
//            
//            }
        } catch (Exception e) {
            System.out.println("Can not connect to server, error: ChatClient");
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message){
        try {
            output.write(message.getBytes());
        } catch (Exception e) {
            System.out.println("Can't not sent message");
            e.printStackTrace();
        }
    }

}
