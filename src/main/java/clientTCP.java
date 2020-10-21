import java.io.*;
import java.net.*;

public class clientTCP {
    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;
       // String capitalizedSentence;
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("10.16.228.119", 55555);
        DataOutputStream outToServer =
                new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}
