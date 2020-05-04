package bitlab.askar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Server extends  Thread{

    public Socket socket;
    public int clientId;

    public Server(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
    }

    public void run(){
        try{
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Product product;

            while (true){
                if ( (product = (Product)ois.readObject()) !=null){
                    System.out.println("#" + clientId + " |" + product.toString());

                    oos.writeObject("HELLO CLIENT");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
