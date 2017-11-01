package practice.ch16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Version 1.0 -> 3.0 add Song instance to ArrayList
 * (modified) add each Song instance to ArrayList instead of Song instance title
 * to attain the previous reason, Class Song need to implement Comparable
 * use String.compareTo() on Song.title.compareTo()
 */
public class Jukebox3 {

    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args){
        new Jukebox3().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
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

        Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        songList.add(nextSong);
    }
} // close class
