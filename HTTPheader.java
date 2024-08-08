import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HTTPheader {

    public static void main(String[] args) {
        // URL to send the request to 
        String urlString = "https://designer.mocky.io/design";
        
        try {
            // Create a URL object
            URL url = new URL(urlString);
            
            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            // Set the request method
            connection.setRequestMethod("GET");
            
            // Connect to the URL
            connection.connect();
            
            // Get the response headers
            Map<String, List<String>> headers = connection.getHeaderFields();
            
            // Print the headers
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
