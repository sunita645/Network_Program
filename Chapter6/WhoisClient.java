package Chapter6;
import java.net.*;
import java.io.*;

public class WhoisClient {
 
	public final static int DEFAULT_PORT=443;
	public final static String DEFAULT_HOST="lookup.icann.org";
	
	public static void main(String[] args) {
		InetAddress server;
		try {
			server = InetAddress.getByName(DEFAULT_HOST);
		}
		catch(UnknownHostException e){
			System.err.println("Error: could not locate default host " + DEFAULT_HOST);
			System.err.println("Check to make sure you are connected to the internet and that DNS is");
			System.err.println("Usage: java WhoisClient host and port");
			return;
			
		}
		int port = DEFAULT_PORT;
		try {
			Socket theSocket = new Socket(server,port);
			Writer out = new OutputStreamWriter(theSocket.getOutputStream(),"8859_1");
			for (int i=0;i<args.length; i++)
				out.write(args[i] + " ");
			out.write("\r\n");
			out.flush();
			InputStream raw = theSocket.getInputStream();
			InputStream in = new BufferedInputStream(theSocket.getInputStream());
			int c;
			while((c=in.read())!=-1)
				System.out.write(c);
		}
		catch(IOException e) {
			System.err.println(e);
		}
	}

}
