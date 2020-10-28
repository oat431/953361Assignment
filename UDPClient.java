import java.net.*;
import java.io.*;
public class UDPClient {
    static int num;
    static int port;
    static String host;
    public String pro;

    public UDPClient(int x, String s, int p,String pro) throws Exception {
        try {
            num = x;
            host = s;
            port = p;
            this.pro = pro;
        } catch (Exception e) {
            System.out.println("Error!!!!!");
        }
        start();
    }

    public void start() throws Exception {
        try {
            System.out.print("Are you sure to continue(Y/n): ");
            String Pattern = "The number is: " + num + " from client " + host + " on port " + port + "via" + this.pro;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(host);
            String sentence = inFromUser.readLine().toUpperCase();
            if (sentence.equals("Y")) {
                byte[] sendData = Pattern.getBytes();
                byte[] receiveData = new byte[1024];
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                clientSocket.send(sendPacket);
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + modifiedSentence);
                clientSocket.close();
            } else if (sentence.equals("N")) {
                System.out.println("Close");
                clientSocket.close();
            } else {
                System.out.println("Please select only Y (y) or N (n)");
            }

        } catch (SocketException e) {
            System.out.println("Error!!!");
        }
    }
}