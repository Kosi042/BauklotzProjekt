package bauklotzProjekt;
import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;


public class Client {
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    /**
     * This constructor for a simple client only in a local network
     * to connect to the robot or tracking server
     * @param port The port to connect with
     */
    public Client(int port) {
        try {
            socket = new Socket("localhost",port);
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
        } catch (IOException e) {
            System.out.println("Client wasn't created.");
        }

    }

    /**
     * Sends a message to the robot or tracking server
     * @param message The message you want to sent to the server
     */
    public void send(String message) {

        System.out.println("Sending: "+ message);
        writer.println(message);
        received();
    }

    /**
     * Wating from an answer from the server
     * @return The answer from the server
     */
    public void received(){
        String answer = null;
        try {
            answer = reader.readLine();
        } catch(Exception e){
            System.out.println("received methode didn't work.");
        }
        System.out.println("Received: " + answer);
    }



}
