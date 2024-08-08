import java.net.*;
public class URLSplitter {

	public static void demoURL(String myURL) {
	 
			try {
				URL u = new URL(myURL);
				System.out.println("Protocol: " +u.getProtocol()); 
				System.out.println("Host: " + u.getHost( ));
				System.out.println("Path: " +u.getPath());
				System.out.println("The user info is: " +u.getUserInfo());
				System.out.println("Port " +u.getPort());
				System.out.println("ref " +u.getRef());
				System.out.println("QUERY string  "+u.getQuery());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	
		public static void main(String[]args) {
			String googleURL ="https://www.google.com/search?q=hello+world&oq=hello+world+&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIHCAEQABiABDIHCAIQABiABDIHCAMQLhiABDIHCAQQABiABDIHCAUQABiABDINCAYQLhivARjHARiABDIHCAcQABiABDIHCAgQABiABDIHCAkQABiABNIBCDUyMzhqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8";
			demoURL(googleURL);
		}
}


