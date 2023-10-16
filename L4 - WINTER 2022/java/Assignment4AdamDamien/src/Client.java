// Adam Di Cioccio and Damien Manno
//// Daniel Cormier - Lab section 304
//// April 17, 2022

// imports
import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ObjectOutputStream oos;

    private boolean loop;
    private String host;
    private int port;
    private String name;

    // default constructor
    Client() {
        loop = true;
    }

    // parameterized constructor that takes in users input from dialog window
    Client (String host, int port, String name) {
        this.host = host;
        this.port = port;
        this.name = name;
        loop = true;
    }

    // main run function for client
    @Override
    public void run() {
        try {
            // create new socket with inputted ip and port
            client = new Socket(host, port);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            oos = new ObjectOutputStream(client.getOutputStream());

            // send the server name in order to set users name
            oos.writeObject(name);
            oos.flush();

            // first thread
            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();

            // second thread
            InputHandler2 inHandler2 = new InputHandler2();
            Thread t2 = new Thread(inHandler2);
            t2.start();

        } catch (IOException e){
            shutdown();
        }
    }

    // shutdown method for user
    public void shutdown() {
        loop = false;
        try {
            in.close();
            out.close();
            if(!client.isClosed()) {
                client.close();
            }
        } catch (IOException e) {
        }
    }

    public void sendCommand(String command) {
        try {
            oos = new ObjectOutputStream(client.getOutputStream());

            oos.writeObject(command);
            oos.flush();
        } catch (IOException e) {
            shutdown();
        }
    }

    // first thread for input handler
    class InputHandler implements Runnable {

        @Override
        public void run() {
            try {

                BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
                while (loop) {
                    String message = inReader.readLine();
                    if (message.equals("/bye")) {
                        out.println(message);
                        inReader.close();
                        shutdown();
                    } else {
                        out.println(message);
                    }
                }
            } catch (IOException e) {
                shutdown();
            }
        }
    }

    // second thread for input handler
    class InputHandler2 implements Runnable {

        @Override
        public void run() {
            try {
                // prints out message to console and chat box
                String inMessage;
                while((inMessage = in.readLine()) != null) {
                    System.out.println(inMessage);
                    PiccrossGame.output.append(inMessage + "\n");
                }
            } catch (IOException e) {
            }
        }
    }
}
