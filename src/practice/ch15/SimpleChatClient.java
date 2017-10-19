package practice.ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleChatClient {

    JTextField outgoingTextField;
    PrintWriter printWriter;
    Socket socket;

    //refactor for read function
    BufferedReader bufferedReader;
    JTextArea incomingTextArea;

    public static void main(String[] args) {
        new SimpleChatClient().go();
    }

    public void go() {
        setUpNetworking();
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incomingTextArea = new JTextArea(15,50);
        incomingTextArea.setLineWrap(true);
        incomingTextArea.setWrapStyleWord(true);
        incomingTextArea.setEditable(false);
        JScrollPane qScrollPane = new JScrollPane(incomingTextArea);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        outgoingTextField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();

        mainPanel.add(qScrollPane);
        mainPanel.add(outgoingTextField);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(600,350);
        frame.setVisible(true);
    } // close go method

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1",5000);
            printWriter = new PrintWriter(socket.getOutputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            System.out.println("networking established");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            printWriter.println(outgoingTextField.getText());
            printWriter.flush();

            outgoingTextField.setText("");
            outgoingTextField.requestFocus();
        }
    } // close inner class

    private class IncomingReader implements Runnable {
        @Override
        public void run() {
            String message;
            try {
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println("read "+message);
                    incomingTextArea.append(message+"\n");
                } // close while
            } catch (IOException e) {
                e.printStackTrace();
            }
        } // close run
    } // close inner class
} // close class
