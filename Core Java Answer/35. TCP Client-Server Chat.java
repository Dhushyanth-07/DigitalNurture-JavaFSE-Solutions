// Server
import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started. Waiting for client...");
        
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected");
        
        BufferedReader in = new BufferedReader(
            new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        
        BufferedReader consoleReader = new BufferedReader(
            new InputStreamReader(System.in));
        
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Client: " + inputLine);
            System.out.print("Server: ");
            String response = consoleReader.readLine();
            out.println(response);
        }
    }
}

// Client
import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        
        BufferedReader consoleReader = new BufferedReader(
            new InputStreamReader(System.in));
        
        String userInput;
        while ((userInput = consoleReader.readLine()) != null) {
            out.println(userInput);
            System.out.println("Server: " + in.readLine());
        }
    }
}