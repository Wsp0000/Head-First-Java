package practice.ch16;

public class Song implements Comparable<Song>{
    String title;
    String artist;
    String rating;
    String bpm;

    public Song(String title, String artist, String rating, String bpm) {
        this.title = title;
        this.artist = artist;
        this.rating = rating;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    @Override
    public String toString() {
//        return "Song{" +
//                "title='" + title + '\'' +
//                '}';
//        return title+"/"+artist;
        return title; // from page559 nice to read so simplify the output
    }

    @Override
    public int compareTo(Song s) {
        return title.compareTo(s.getTitle());
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public boolean equals(Object aSong) {
        Song song = (Song) aSong;
        return getTitle().equals(song.getTitle());
    }
}
