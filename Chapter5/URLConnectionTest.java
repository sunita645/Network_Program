
package Chapter5;

import java.io.*;
import java.net.*;
import java.util.Date;

public class URLConnectionTest {

	public static void main(String[] args) throws Exception {
		try {
			URL u = new URL("https://run.mocky.io/v3/d97d5760-a430-4262-aa70-08e5d4c29015");
			URLConnection uc = u.openConnection();
			System.out.println("Content-type: " +uc.getContentType());
			
		}
		catch(MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
