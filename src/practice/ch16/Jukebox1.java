package practice.ch16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * version 1.0 ArrayList for sort purpose and add title
 * Read File and Parse it
 * add each Song title to ArrayList
 */
public class Jukebox1 {

    ArrayList<String> songList = new ArrayList<String>();

    public static void main(String[] args){
        new Jukebox1().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
    }

    void getSongs() {
        File file = new File("SongList.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");
        songList.add(tokens[0]);
    }
} // close class
