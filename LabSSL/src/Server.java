import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

public class Server {

	static final int port=8000;
	
	public static void main(String[] args) throws IOException{
		
		SSLServerSocketFactory sf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		ServerSocket serverSocket = sf.createServerSocket(port);
		
		System.out.println("Server Socket Started");
		
		Socket socket = serverSocket.accept();
		System.out.println("Server Socket Accepted");

		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		InputStreamReader isr = new InputStreamReader(socket.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		
		String line;
		
		while( (line=br.readLine()) != null){
			System.out.println(line);
			out.println(line);
		}
		
		
	}
}
