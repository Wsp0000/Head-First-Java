package practice.ch14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardPlayer {

    private JFrame frame;
    private JTextArea display;
    private JButton nextButton;
    private boolean isShowAnswer;
    private QuizCard currentCard;
    private int nextCardIndex;
    private ArrayList<QuizCard> cardList;

    public static void main(String[] args){
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    public void go() {
        // build and display gui

        frame = new JFrame("Quiz Card Player");
        JPanel mainPanel = new JPanel();

        display = new JTextArea(10,20);
        Font bigFont = new Font("sanserif", Font.BOLD,24);

        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);
        JScrollPane qScrollPane = new JScrollPane(display);
        qScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(qScrollPane);

        nextButton = new JButton("Show Question");
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardAndShowAnswerListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    } // close go method

    private void makeCard(String lineToParse) {
        // called by loadFile method, takes a line from the file
        // and parses into two pieces - question and answer - and creates a new QuizCard
        // and adds it to the ArrayList called CardList
        String[] result = lineToParse.split("/");
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card);
        System.out.println("made a card");
    }

    private class NextCardAndShowAnswerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isShowAnswer) {
                // show the answer because they've seen the question
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                // show the next question
                if (nextCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    // there no more cards!
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }
    }

    private void showNextCard() {
        currentCard = cardList.get(nextCardIndex);
        nextCardIndex++;
        display.setText(currentCard.getQuestion());
        nextButton.setText("Show Answer");
        isShowAnswer = true; //want to show Answer? yes.
    }

    private class OpenMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    private void loadFile(File file) {
        // must build an ArrayList of cards, by reading them from a text file
        // called from the OpenMenuListener event handler, reads the file one line at a time
        // and tells the makeCard() method to make a new card out of the line
        // (one line in the file holds both the question and answer, separated by a "/")
        cardList = new ArrayList<QuizCard>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null ) {
                makeCard(line);
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("couldn't read the card file");
            e.printStackTrace();
        }

        // now time to start by showing the first card
        showNextCard();
    }
} // close class
