import java.net.*;
public class UDPServer {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("server: Waiting for client to connect");
            DatagramSocket serverSocket = new DatagramSocket(8000);
            byte[] receiveData = new byte[1024];
            byte[] sendData;
            while (true) {
                System.out.println("server: Connection established");
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String word = new String(receivePacket.getData());
                InetAddress IPAddress = receivePacket.getAddress();
                int ports = receivePacket.getPort();
                String capitalizedSentence = word.toUpperCase();
                sendData = capitalizedSentence.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, ports);
                serverSocket.send(sendPacket);
                System.out.println(word);

            }
        } catch (SocketException e) {
            System.out.println("Error!!! something went wrong");
        }
    }
}
