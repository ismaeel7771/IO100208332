import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private int playCount;

    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void incrementPlayCount() {
        playCount++;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + playCount + " plays)";
    }
}

public class SongPlaylist1 {
    public static void main(String[] args) {
        List<Song> playlist = new ArrayList<>();

        // Create an initial playlist with 10 songs and different play counts
        playlist.add(new Song("Ehnna Sohna", "Arjit Singh", 5));
        playlist.add(new Song("295", "Sidhu", 8));
        playlist.add(new Song("lala", "Eminem", 12));
        playlist.add(new Song("Amplifier", "Imran Khan", 3));
        playlist.add(new Song("Shape of you", "ED Sheeran", 6));
        playlist.add(new Song("do you know", "Diljit Dosanjh", 10));
        playlist.add(new Song("kadi de hans bol", "Atif Aslam", 15));
        playlist.add(new Song("pathaan", "Salman Khan", 2));
        playlist.add(new Song("chamak challo", "Sharukh Khan", 7));
        playlist.add(new Song("yh", "Bob Marley", 4));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a new song to the playlist");
            System.out.println("2. Remove a song from the playlist");
            System.out.println("3. Display the list of songs with play counts");
            System.out.println("4. Display songs with play count above 4");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter the initial play count: ");
                    int playCount = scanner.nextInt();
                    Song newSong = new Song(title, artist, playCount);
                    playlist.add(newSong);
                    System.out.println("Song added to the playlist.");
                    break;
                case 2:
                    System.out.print("Enter the song number of the song to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < playlist.size()) {
                        playlist.remove(index);
                        System.out.println("Song removed from the playlist.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.println("List of songs with play counts:");
                    for (Song song : playlist) {
                        System.out.println(song);
                    }
                    break;
                  case 4:
                    System.out.println("Songs with play count above 4:");
                    for (Song song : playlist) {
                        if (song.getPlayCount() > 5) {
                            System.out.println(song);
                        }
                    }
                    break;   
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
