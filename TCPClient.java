import java.net.*;
import java.io.*;
public class TCPClient {
    static int num;
    static int port;
    static String host;
    static String pro;

    public TCPClient(int x, String s, int p,String pro) {
        try {
            num = x;
            host = s;
            port = p;
            pro = pro;
            start();
        } catch (Exception e) {
            System.out.println("Error!!!!!");
        }
    }

    public void start() throws Exception {
        try {
            System.out.print("InputFromClient: ");
            String Pattern = "The number is: " + num + " from client " + host + " on port " + port + "via" + pro;
            Socket clientSocket = new Socket(host, port);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(Pattern + '\n');
            inFromServer.readLine();
            System.out.println(Pattern);
            clientSocket.close();
        } catch (SocketException e) {
            System.out.println("Error!!! something went wrong");
        }
    }
}