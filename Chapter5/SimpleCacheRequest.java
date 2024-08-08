package Chapter5;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class SimpleCacheRequest extends CacheRequest {
		private ByteArrayOutputStream out = new ByteArrayOutputStream(); 
		
		public OutputStream getBody() throws IOException { 
			return out; 
			} 
		
		public void abort() { 
			out.reset(); 
			}
		
		public byte[] getData() { 
			if (out.size() == 0) return null;
			else return out.toByteArray();
		 }
		}

