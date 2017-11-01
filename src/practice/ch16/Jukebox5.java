package practice.ch16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Version 1.0 -> 3.0 -> 5.0 add inner Class Comparator
 * (add) inner Class ArtistCompare implement Comparator: sort by compare the Artist name
 */
public class Jukebox5 {

    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args){
        new Jukebox5().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);

        ArtistCompare artistCompare = new ArtistCompare();
        Collections.sort(songList,artistCompare);

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

    static class ArtistCompare implements Comparator<Song> {
        @Override
        public int compare(Song o1, Song o2) {
            return o1.getArtist().compareTo(o2.getArtist());
        }
    }
} // close class
