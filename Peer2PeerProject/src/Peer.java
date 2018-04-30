import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Peer {

	ServerSocket socket;
	String ipv4Address;
	int port;
	
	public Peer(String host, int port) throws UnknownHostException, IOException{
		this.ipv4Address = host;
		this.port = port;
		this.socket = new ServerSocket(port);
	}
	
}
