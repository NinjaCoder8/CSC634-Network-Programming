import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    private static Socket socket;

    public static void main(String[] args)
    {
        try
        {

            int port = 19999;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server Started and listening to the port 19999");

            //Server is running always. This is done using this while(true) loop
            while(true)
            {
            	System.out.println("hehe");
                //Reading the message from the client
                socket = serverSocket.accept();
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                String request = br.readLine();
                System.out.println("Message received from client is "+request);


                String version = request.charAt(0) + "";
                String opcode = request.charAt(1) + "";
                String offset = request.substring(2,6) ;
                String fileID = request.substring(6,10) ;
                String oldChecksum = request.substring(10,84) ;
                String filename = request.substring(84, request.length()) ;

                int charCode = Integer.parseInt(filename, 2);
                String str = new Character((char)charCode).toString();

                
                
                //Sending the response back to the client.
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);

                String returnMessage;
                try
                {
                	returnMessage="test\n";
                    bw.write(returnMessage);
                    System.out.println("Message sent to the client is "+returnMessage);
                    bw.flush();
                	returnMessage="test\n";
                    bw.write(returnMessage);
                    System.out.println("Message sent to the client is "+returnMessage);
                    bw.flush();
                	returnMessage="test\n";
                    bw.write(returnMessage);
                    System.out.println("Message sent to the client is "+returnMessage);
                    bw.flush();
                }
                catch(NumberFormatException e)
                {
                    //Input was not a number. Sending proper message back to client.
                    returnMessage = "Please send a proper number\n";
                }


            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                socket.close();
            }
            catch(Exception e){}
        }
    }
}