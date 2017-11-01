package practice.ch16;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Version 1.0 -> 3.0 -> 5.0 -> 4.0 -> 6.0 TreeSet
 * use the compareTo() on object which was added in TreeSet
 */
public class Jukebox8 {

    ArrayList<Song> songList = new ArrayList<>();

    public static void main(String[] args){
        new Jukebox8().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        Collections.sort(songList);
        System.out.println(songList);
        TreeSet<Song> songTreeSet = new TreeSet<>();
        songTreeSet.addAll(songList);
        System.out.println(songTreeSet);
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

    class SongBad implements Comparable <SongBad>
    {
        String title;
        String artist;
        String rating;
        String bpm;


     public SongBad(String t, String a, String r, String b) {
            title = t;
            artist = a;
            rating = r;
            bpm = b;
        }
        public boolean equals(Object aSong) {
            SongBad s = (SongBad) aSong;
            return getTitle().equals(s.getTitle());
        }

        //leaving this out makes this a bad form of song.  Uncomment this to get rid of the duplicates
//        public int hashCode() {
//            return title.hashCode();
//        }

        public int compareTo(SongBad s)
        {
            return title.compareTo(s.getTitle());
        }

        public String getArtist()
        {
            return artist;
        }

        public String getBpm()
        {
            return bpm;
        }

        public String getRating()
        {
            return rating;
        }

        public String getTitle()
        {
            return title;
        }

        public String toString() {
            return title;
        }

    }
} // close class
