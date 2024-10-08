package Chapter7;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;

public class EchoServer {
    // UDP port to which service is bound
    public static final int SERVICE_PORT = 9876;  // Changed to a higher port number
    
    // Max size of packet, large enough for almost any client
    public static final int BUFSIZE = 4096;
    
    // Socket used for reading and writing UDP packets
    private DatagramSocket socket;
    
    public EchoServer() {
        try {
            // Bind to the specified UDP Port, to listen
            // for incoming data packets
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port " + socket.getLocalPort());
        } catch (Exception e) {
            System.err.println("Unable to bind port: " + e.getMessage());
        }
    }

    public void serviceClients() {
        if (socket == null) {
            System.err.println("Socket is not initialized. Exiting.");
            return;
        }

        // Create a buffer large enough for incoming packets
        byte[] buffer = new byte[BUFSIZE];
        for (;;) {
            try {
                // Create a DatagramPacket for reading 
                // UDP packets
                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
                // Receive incoming packets
                socket.receive(packet);
                System.out.println("Packet received from " + packet.getAddress() + ":" + packet.getPort() + " of length " + packet.getLength());
                // Echo the packet back - address and port
                // are already set for us!
                socket.send(packet);
            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
            }
        }
    }
    
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.serviceClients();
    }
}
