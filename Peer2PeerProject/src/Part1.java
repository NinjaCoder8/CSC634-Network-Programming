import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Part1 {

	private static final int peersTotal = 5;
	public static JThread[] threads;
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Peer p;
		threads = new JThread[peersTotal];
		for(int i=1; i<=peersTotal; i++){
		      JThread thread = new JThread( "Thread-" + (2000 + i), (2000 + i));
		      threads[i-1] = thread;
		      thread.start();
		}
		Scanner scan = new Scanner(System.in);
		while(true){
			int id=getThreadIdByAvailability();
			if(id == -1){
				System.out.println("No More Available Peers");
				break;
			}
			
			JThread t;
			t = threads[id];
			
			System.out.println("Enter Port Number to connect " + t.getPeerID() + " : ");
			String port = scan.next();
			System.out.println("Enter Max Number of Conenctions for Peer " + t.getPeerID() + " : (-1 for leaving default max) ");
			String connections = scan.next();
			t.connectPeer(Integer.parseInt(port), Integer.parseInt(connections));
		}
	}
	
	public static int getThreadIdByAvailability(){
		for(int i=0; i<peersTotal; i++){
			JThread j = threads[i];
			if(j.getPeer().canEstablishConnections()){
				return i;
			}
		}
		return -1;
	}
}
