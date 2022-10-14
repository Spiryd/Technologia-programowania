package battleship;

import java.io.*;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        try 
        {
            Socket socket = new Socket("localhost", 2137);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        

    }
}
