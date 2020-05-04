package bitlab.askar;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String []args){
        Scanner in = new Scanner(System.in);

        try {
            Socket socket = new Socket("localhost",4444);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            while(true){
                String name = in.next();
                int count = in.nextInt();
                oos.writeObject(new Product(name, count));

                String message;
                if((message = (String)ois.readObject()) !=null){
                    System.out.println(message);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
