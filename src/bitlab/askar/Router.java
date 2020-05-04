package bitlab.askar;

import java.net.ServerSocket;
import java.net.Socket;

public class Router {
    public static void main(String []args){

        try {
            ServerSocket server = new ServerSocket(4444);
            System.out.println("WAITING FOR A CONNECTION");
            int id = 1;

            while (true){
                Socket socket = server.accept();
                System.out.println("CLIENT CONNECTED");

                Server clientHandlerServer = new Server(socket, ++id);
                clientHandlerServer.start();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
