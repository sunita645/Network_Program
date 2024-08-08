import java.net.*;
import java.io.UnsupportedEncodingException;
public class Decoder {

	public static void main(String[] args) {
		try {
			System.out.println(URLDecoder.decode("This string has spaces","UTF-8"));
			System.out.println(URLDecoder.decode("This+string+has+plus","UTF-8"));
			System.out.println(URLDecoder.decode("This~string~has~tiled","UTF-8"));
			System.out.println(URLDecoder.decode("This:string:has:colons","UTF-8"));
			System.out.println(URLDecoder.decode("This/string/has/slashes","UTF-8"));
			System.out.println(URLDecoder.decode("This=string=has=equals=signs","UTF-8"));
			System.out.println(URLDecoder.decode("This&string&has&ampersands","UTF-8"));
			System.out.println(URLDecoder.decode("This(string) has (Parenthesis)","UTF-8"));
			
		//	System.out.println(URLDecoder.decode("This काठमाडौं spaces","UTF-32"));
			
		}
		catch(UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM doesn't support UTF-8");
		}

	}

}
