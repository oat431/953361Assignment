import java.net.*;
import java.io.*;
public class TCPServer {
    public static void main(String[] args) throws Exception {
        try {
            String clientSentence;
            String capitalizedSentence;
            ServerSocket welcomeSocket = new ServerSocket(8000);
            System.out.println("server: Waiting for client to connect\n");

            while (true) {
                Socket connectionSocket = welcomeSocket.accept();
                System.out.println("server: Connection established\n");
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                clientSentence = inFromClient.readLine();
                capitalizedSentence = clientSentence.toUpperCase() + '\n';
                outToClient.writeBytes(capitalizedSentence);
                System.out.println(capitalizedSentence);
            }
        } catch (SocketException e) {
            System.out.println("Error!!! something went wrong");

        }

    }
}