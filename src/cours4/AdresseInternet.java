package cours4;

import java.net.*;
import java.io.IOException;


public class AdresseInternet {

	public static void main(String[] args) {

		try{
			//InetAddress is a class in package java.net
			//and represents an Internet Protocol=IP address
			//InetAddress  monAdresse = InetAddress.getByName("smtp.laposte.net");
			InetAddress  monAdresse = InetAddress.getByName("uhb.fr");
			//InetAddress  monAdresse = InetAddress.getLocalHost();
			
			System.out.println(monAdresse.getHostName());
			System.out.println(monAdresse.getHostAddress());
			System.out.println(monAdresse.getAddress());
			System.out.println(monAdresse.isAnyLocalAddress());
			System.out.println(monAdresse.isLoopbackAddress());
			System.out.println(monAdresse.isLinkLocalAddress());
			System.out.println(monAdresse.isSiteLocalAddress());
			System.out.println(monAdresse.isMulticastAddress());
			System.out.println(monAdresse.isReachable(100));

			} catch (UnknownHostException exp){
				System.out.println("machine inconnue");
			} catch (IOException e) {
				System.out.println("machine non atteignable");
			}
			
	}

}
