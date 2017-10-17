package practice.ch14;

import practice.ch13.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BeatBoxWithSerialAndRestore extends BeatBox{

    public static void main(String[] args){
        new BeatBoxWithSerialAndRestore().buildGUI();
    }

    @Override
    protected void buildGUI() {
        super.buildGUI();
        JButton serialzelt = new JButton("serialzelt");
        serialzelt.addActionListener(new MySendListener());
        buttonBox.add(serialzelt);

        JButton restore = new JButton("restore");
        restore.addActionListener(new MyReadInListener());
        buttonBox.add(restore);

    }

    private class MySendListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            boolean[] checkboxState = new boolean[256];

            for (int i = 0; i < 256; i++) {

                JCheckBox check = (JCheckBox) checkboxList.get(i);
                if (check.isSelected()) {
                    checkboxState[i] = true;
                }
            }

            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File("Checkbox.ser"));
                ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
                os.writeObject(checkboxState);
            } catch (FileNotFoundException e1) {
                System.out.println("FileNotFound, New File \"Checkbox.ser\" Failed.");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("ObjectOutputStream failed.");
                e1.printStackTrace();
            }
        } // close method
    } // close inner class

    private class MyReadInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean[] checkboxState = null;

            try {
                FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
                ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
                checkboxState = (boolean[]) objectInputStream.readObject();

            } catch (FileNotFoundException e1) {
                System.out.println("FileNotFound, New File \"Checkbox.ser\" Failed.");
                e1.printStackTrace();
            } catch (IOException e1) {
                System.out.println("ObjectInputStream failed.");
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }

            for (int i = 0; i < 256; i++) {
                JCheckBox checkBox = (JCheckBox) checkboxList.get(i);
                if (checkboxState[i]) {
                    checkBox.setSelected(true);
                } else {
                    checkBox.setSelected(false);
                }
            }

            sequencer.stop();
            buildTrackAndStart();
        } // close method
    } // close inner class
} // close class
