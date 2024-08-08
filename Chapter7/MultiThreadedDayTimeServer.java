package Chapter7;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class MultiThreadedDayTimeServer {

	public final static int PORT = 5025; 

	private static class DaytimeThread extends Thread{
		private Socket connection;  

		public DaytimeThread(Socket connection) {
			this.connection = connection; 
		}

		@Override
		public void run() { 
			try {
				Writer out = new OutputStreamWriter(connection.getOutputStream()); 
				java.util.Date now = new java.util.Date(); 
				out.write(now.toString() + "\r\n");
				out.flush();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}finally {
				try {
					connection.close();
				} catch (Exception e2) {
					//ignore
				}
			}
		}
	}

	public static void main(String[] args) {
		try(ServerSocket server = new ServerSocket(PORT)) {
			while(true) {
				try {
					System.out.println(">>waiting connection>> ..");
					Socket connection = server.accept(); 
					Thread task = new DaytimeThread(connection); 
					task.start();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				} 
			} 
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}



}