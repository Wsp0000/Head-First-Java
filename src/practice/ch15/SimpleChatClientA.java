package practice.ch15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleChatClientA {

    JTextField outgoingTextField;
    PrintWriter printWriter;
    Socket socket;

    public static void main(String[] args) {
        new SimpleChatClientA().go();
    }

    public void go() {
        setUpNetworking();
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        outgoingTextField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoingTextField);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(400,500);
        frame.setVisible(true);
    } // close go method

    private void setUpNetworking() {
        try {
            socket = new Socket("127.0.0.1",5000);
            printWriter = new PrintWriter(socket.getOutputStream());
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
} // close class
