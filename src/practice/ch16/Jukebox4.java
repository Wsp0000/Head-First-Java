package practice.ch16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Version 1.0 -> 3.0 -> 5.0 -> 4.0 Duplicate input record on SongListMore.txt
 * change File source from SongList.txt to SongListMore.txt
 */
public class Jukebox4 {

    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args){
        new Jukebox4().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        Jukebox5.ArtistCompare artistCompare = new Jukebox5.ArtistCompare();
        Collections.sort(songList,artistCompare);

        System.out.println(songList);
    }

    void getSongs() {
        File file = new File("SongListMore.txt");
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
