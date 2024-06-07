import java.io.*;
import java.net.*;
public class Client{
    public static void main(String[] args) {

        //initialize
        try(Socket socket = new Socket("localhost",8000)){

            //Input Stream
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF ("Hello echo server from client side");

            //Msg print
            out.close();
            out.flush();
            socket.close();
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}