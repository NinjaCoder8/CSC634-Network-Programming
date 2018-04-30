import java.io.IOException;
import java.net.UnknownHostException;

public class JThread implements Runnable {
   private Thread t;
   private int threadID;
   private String threadName;
   
   public JThread(String name, int ID) {
      threadName = name;
      threadID = ID;
      System.out.println("Creating " +  threadName );
   }
   
   public void run(){
      System.out.println("Running " +  threadName );
		try {
			Peer p = new Peer("localhost", (2000 + threadID));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
      try {
         for(int i = 4; i > 0; i--) {
            //System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.

            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }
   
   public void start () throws UnknownHostException, IOException {
      System.out.println("Starting " +  threadName );
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}