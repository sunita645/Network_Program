package Chapter5;

import java.io.*;
import java.net.*;
import java.util.Date;

 class URLConnectionDemo {
 
	public static void main(String[] args) throws Exception { 
		
		int c;
		URL hp = new URL("https://run.mocky.io/v3/7def8ab9-7e25-4db2-8b6f-182f9bd94af4");
		URLConnection hpCon = hp.openConnection();
		
		//get Date
		long d = hpCon.getDate();
		if(d==0){
			System.out.println("No  date information");
		}
		else {
			System.out.println("Date: " + new Date(d));
		}
		
		//get Content type
		
		System.out.println("Content type " +hpCon.getContentType());
		
		//get expiration date
		d=hpCon.getExpiration();
		if(d==0) {
			System.out.println(" NO Expiration date");
		}
		else {
			System.out.println("Expires : " +new Date(d));
		}
		
		//get Last Modified date
		d=hpCon.getLastModified();
		if(d==0) {
			System.out.println(" NO last-modified information");
		}
		else {
			System.out.println("Last Modified : " +new Date(d));
		}
		
		//get content length
		int len = hpCon.getContentLength();
		if(len==-1) {
			System.out.println("Content lenth Unavailable");
		}
		else {
			System.out.println("Conent-length" +len);
			if(len >=0) {
				System.out.println("===Content===");
				InputStream input = hpCon.getInputStream();
				int i = len;
				while(((c=input.read())!=-1)) {
					System.out.print((char)c);
				}
				input.close();
			}
			else {
				System.out.println("No content available");
			}
		}

	}

}
