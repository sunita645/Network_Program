import java.net.*;
import java.io.UnsupportedEncodingException;
public class EncoderTest {
   
	public static void main(String[] args) {
		try {
			System.out.println(URLEncoder.encode("This string has spaces","UTF-8"));
			System.out.println(URLEncoder.encode("This*string*has*asterisks","UTF-8"));
			System.out.println(URLEncoder.encode("This+string+has+plus","UTF-8"));
			System.out.println(URLEncoder.encode("This:string:has:colons","UTF-8"));
			System.out.println(URLEncoder.encode("This/string/has/slashes","UTF-8"));
			System.out.println(URLEncoder.encode("This~string~has~tiled","UTF-8"));
			System.out.println(URLEncoder.encode("This=string=has=equals=signs","UTF-8"));
			System.out.println(URLEncoder.encode("This&string&has&ampersands","UTF-8"));
			System.out.println(URLEncoder.encode("This(string) has (Parenthesis)","UTF-8"));
			System.out.println(URLEncoder.encode("This.string.has.periods","UTF-8"));
			
			//System.out.println(URLEncoder.encode("This काठमाडौं spaces","UTF-32"));
		}
		catch(UnsupportedEncodingException ex) {
			throw new RuntimeException("Broken VM doesn't support UTF-8");
		}

	}

}
