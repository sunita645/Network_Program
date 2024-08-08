package Chapter7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PacketReceiveDemo {

    public static void main(String[] args) {
        try {
            System.out.println("Binding to Local Port 2000");
            // Create a Datagram Socket, bound to the 
            // specific port 2000
            DatagramSocket socket = new DatagramSocket(2000);
            System.out.println("Bound to the Local port " + socket.getLocalPort());
            
            // Create a Datagram Packet, containing a 
            // maximum buffer of 256 bytes
            DatagramPacket packet = new DatagramPacket(new byte[256], 256);
            
            // Receive a packet - remember by default 
            // this is a blocking operation
            socket.receive(packet);
            System.out.println("Packet Received ");
            
            // Display packet information
            InetAddress remote_addr = packet.getAddress();
            System.out.println("Sent by: " + remote_addr.getHostAddress());
            System.out.println("Sent from: " + packet.getPort());
            
            // Display packet contents, by reading
            // from byte array
            ByteArrayInputStream bin = new ByteArrayInputStream(packet.getData());
            
            // Display only up to the length of the 
            // original UDP Port
            for (int i = 0; i < packet.getLength(); i++) {
                int data = bin.read();
                if (data == -1) {
                    break;
                } else {
                    System.out.print((char) data);
                }
            }
            
            socket.close();
        } catch (IOException ioe) {
            System.err.println("Error -" + ioe);
        }
    }
}
