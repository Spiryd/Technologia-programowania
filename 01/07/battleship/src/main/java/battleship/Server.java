package battleship;

import java.net.*;

public class Server {
    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(2137))
        {
            System.out.println("Server listening on port 2137");

            while(true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("new Client connected");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
