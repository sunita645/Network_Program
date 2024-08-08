import java.net.*;

public class FactoryMethod {
	public static void testnetwork(String name) {
	try {
			NetworkInterface ni = NetworkInterface.getByName(name);
			if(ni==null) {
				System.out.println("No such interface : eth0");
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testnetwork("eth0");

	}

}




