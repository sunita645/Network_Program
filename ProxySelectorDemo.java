 import java.io.*;
 import java.net.*;
 import java.util.*;

 public class ProxySelectorDemo extends ProxySelector {
     private List<URI> failed = new ArrayList<>();

     public List<Proxy> select(URI uri) {
         List<Proxy> result = new ArrayList<>();
         if (failed.contains(uri) || "http".equalsIgnoreCase(uri.getScheme())) {
             result.add(Proxy.NO_PROXY);
         } else {
             SocketAddress proxyAddress = new InetSocketAddress("proxy.example.com", 8000);
             Proxy proxy = new Proxy(Proxy.Type.HTTP, proxyAddress);
             result.add(proxy);
         }
         return result;
     }

     public void connectFailed(URI uri, SocketAddress ad dress, IOException ex) {
         failed.add(uri);
     }

     public static void main(String[] args) {
         // Set the custom proxy selector as the default
         ProxySelector.setDefault(new ProxySelectorDemo());

         try {
             // Example URI to test the proxy selection
             URI uri = new URI("http://www.facebook.com");
             ProxySelector proxySelector = ProxySelector.getDefault();
             List<Proxy> proxies = proxySelector.select(uri);

             for (Proxy proxy : proxies) {
                 System.out.println("Proxy type: " + proxy.type());
                 System.out.println("Proxy address: " + proxy.address());
             }
         } catch (URISyntaxException e) {
             e.printStackTrace();
         }
     }
 }
