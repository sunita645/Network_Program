package Chapter5;

import java.io.*;
import java.net.*;

public class SourceViewer {

	public static void main(String[] args) {
		 
		if(args.length>0) {
			try {
				URL u = new URL("https://run.mocky.io/v3/7def8ab9-7e25-4db2-8b6f-182f9bd94af4");
				URLConnection uc = u.openConnection();
				InputStream raw = uc.getInputStream();
				InputStream buffer = new BufferedInputStream(raw);
				
				//chain the inputstream to a reader
				Reader r = new InputStreamReader(buffer);
				int c;
				while((c=r.read())!=-1) {
					System.out.print((char)c);
				}
			}
			catch(MalformedURLException e) {
				System.out.println(args[0]+ "is not a parseable URL");
			}
			catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

