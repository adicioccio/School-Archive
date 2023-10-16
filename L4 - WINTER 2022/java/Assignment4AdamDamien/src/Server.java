// Adam Di Cioccio and Damien Manno
//// Daniel Cormier - Lab section 304
//// April 17, 2022

// imports
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// implement run() command
public class Server implements Runnable {

    private Vector<UserHandler> users; // array list of the users (connections)
    private ServerSocket server; // server socket
    private ExecutorService executor; // executor service pool

    private boolean loop; // boolean for while loops
    private static int port; // provided port

    // default constructor
    public Server() {
        // initialize vector and loop variable
        users = new Vector<>();
        loop = true;
    }

    // run the server on start up
    public void run() {
        try {
            // create server with args[0] as the port
            server = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
            System.out.println("Server Online!");

            // keep looping until user connects
            while(loop) {
                // set client equal to incoming connection
                Socket client = server.accept();
                // initialize handler
                UserHandler handler = new UserHandler(client);
                // add user into vector
                users.add(handler);
                // execution
                executor.execute(handler);
            }
        } catch (Exception e) {
            // if error shutdown
            shutdown();
        }

    }

    // broadcast method that shows message for all users
    public void broadcast(String message) {
        // loop thru vector
        for (UserHandler uh : users) {
            // if user not null print message
            if (uh != null) {
                uh.out.println(message);
            }
        }
    }

    // shutdown method that shuts server down
    public void shutdown() {
        try {
            loop = false;
            executor.shutdown();
            if (!server.isClosed()) {
                server.close();
            }
            for (UserHandler uh : users) {
                uh.shutdown();
            }
        } catch (IOException e) {
        }
    }


    class UserHandler implements Runnable {
        // user handler utilities
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private ObjectInputStream oos;
        private String name;

        // default constructor
        public UserHandler(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                out = new PrintWriter(client.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                oos = new ObjectInputStream(client.getInputStream());

                // get name from client object input
                name = (String) oos.readObject();

                // show on server and every client that user connected
                System.out.println(name + " has connected.");
                broadcast(name + " joined the chat.");

                String message;
                while((message = in.readLine()) != null) {
                    // rename users name
                    if (message.startsWith("/name")) {
                        String[] messageSplit = message.split(" ", 2);
                        if (messageSplit.length == 2) {
                            broadcast(name + " renamed themselves to " + messageSplit[1]);
                            System.out.println(name + " renamed themselves to " + messageSplit[1]);
                            name = messageSplit[1];
                            out.println("Successfully changed name to " + name);
                        } else {
                            out.println("No name inputted.");
                        }
                    // get all users that are online and display
                    } else if (message.startsWith("/who")) {
                        out.println("--- Players Online (" + users.size() + ") ---");
                        for (UserHandler uh : users) {
                            out.println(uh.name);
                        }
                    // display help menu
                    } else if (message.startsWith("/help")) {
                        out.println("   ---   HELP MENU   ---   \n/help - Prints this menu.\n/name - Change your name." +
                                "\n/who  - Gets player list.\n/bye  - Disconnect/Quits.");
                    // disconnect user from server method
                    } else if (message.startsWith("/bye")) {
                        System.out.println(name + " has disconnected.");
                        broadcast(name + " left the chat.");
                        int count = 0;
                        for (UserHandler uh : users) {
                            if (uh.name == name) {
                                out.println(users.remove(count));
                            }
                            count++;
                        }
                        shutdown();
                    // regular chat message
                    } else {
                        broadcast(name + ": " + message);
                    }
                }
            } catch (Exception e) {
                // shutdown if any problems
                shutdown();
                System.out.print("");
            }

        }

        // shutdown method for user
        public void shutdown() {
            try {
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
            }
        }
    }

    public static void main(String[] args) {
        // get port from string args
        port = Integer.parseInt(args[0]);
        // create server and call run method
        Server server = new Server();
        server.run();
    }
}