package main.java.OOP.assignment_problems;


    import java.util.Arrays;

    public class Playlist {

        private String[] songs;
        private int songCount;

        // Constructor
        public Playlist(int maxSize) {
            songs = new String[maxSize];
            songCount = 0;
        }

        // Add a song
        public void addSong(String song) {
            if (songCount < songs.length) {
                songs[songCount] = song;
                songCount++;
            }
        }

        // Return a copy of the songs
        public String[] getSongs() {
            return Arrays.copyOf(songs, songCount);
        }

        // Return number of songs
        public int getSongCount() {
            return songCount;
        }

        // Main method
        public static void main(String[] args) {

            Playlist p = new Playlist(10);

            p.addSong("Song A");
            p.addSong("Song B");

            String[] copy = p.getSongs();

            // Change the returned copy
            copy[0] = "Hacked";

            System.out.println("Playlist songs:");

            for (String song : p.getSongs()) {
                System.out.println(song);
            }

            System.out.println("Song count: " + p.getSongCount());
        }
    }

