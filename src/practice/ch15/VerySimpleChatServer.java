package practice.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * simple chat server
 * without checking message type or other something unknown issue
 */
public class VerySimpleChatServer {
    /**
     * clientOutputStreams to save all connected client socket's OutputSteams (chained to PrintWriter)
     */
    ArrayList clientOutputStreams;

    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }

    /**
     * new ArrayList to clientOutputSteams
     * wait client, if client connected new a Socket and Thread to handle that client
     */
    public void go() {
        clientOutputStreams = new ArrayList();
        /**
         *new ServerSocket to wait client connect
         * when client connected then new a socket to which client
         * add a client socket'clientOutputStreams which chained with PrintWriter to the clientOutputStreams
         * new Thread handle each client
         */
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(printWriter);

                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("got a connection");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // close go method

    /**
     * inner class
     * when client connected then new a socket for that client
     */
    public class ClientHandler implements Runnable {

        BufferedReader bufferedReader;
        Socket socket;

        /**
         * constructor with clientSocket
         * and read client message
         * @param clientSocket serverSocket.accept() generate
         */
        public ClientHandler(Socket clientSocket) {
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(isReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // close constructor

        /**
         * thread job
         * read client message
         * and let server send it
         */
        @Override
        public void run() {
            String message;
            try {
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                } // close while
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // close run
    } // close inner class

    /**
     * send client message immediately to each client outputStream
     * @param message clientMessage
     */
    public void tellEveryone(String message) {

        Iterator iterator = clientOutputStreams.iterator();
        while (iterator.hasNext()) {
            try {
                PrintWriter printWriter = (PrintWriter) iterator.next();
                printWriter.println(message);
                printWriter.flush();
            } catch (Exception ex) {
                // catch don't show up maybe iterator.next() return Object cause.
                ex.printStackTrace();
            }
        } // close while
    } // close tellEveryone method
} // close class
