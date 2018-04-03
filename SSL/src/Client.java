import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;
 
public class Client {
     
    static final int port = 5000;
 
    public static void main(String[] args) throws IOException {
         
    	SSLSocketFactory sslSocketFactory = (SSLSocketFactory)SSLSocketFactory.getDefault();
	    Socket socket = sslSocketFactory.createSocket("localhost", port);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader bufferedReader = new BufferedReader(isr);
	    Scanner scanner = new Scanner(System.in);
	    while(true){
	        System.out.println("Enter something:");
			String inputLine = scanner.nextLine();
			if(inputLine.equals("q")){
			        break;
			}
	     
		    out.println(inputLine);
		    System.out.println(bufferedReader.readLine());
	    }   
    }
     
}