import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Song class to represent individual songs
class Song {
    private String title;
    private String artist;
    private int playCount;

    // Constructor to initialize Song object with title, artist, and playcount
    public Song(String title, String artist, int playCount) {
        this.title = title;
        this.artist = artist;
        this.playCount = playCount;
    }

    // Getter methods to access attributes of the Song
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayCount() {
        return playCount;
    }

    // Method to increment the playcount of the song
    public void incrementPlayCount() {
        playCount++;
    }

    // Override toString to provide a meaningful string representation of the song
    @Override
    public String toString() {
        return title + " by " + artist + " (" + playCount + " plays)";
    }
}

// Define the main class for the song playlist application
public class SongPlaylist1 {
    public static void main(String[] args) {
        // Create a list to store the songs in the playlist
        List<Song> playlist = new ArrayList<>();

        // Create an initial playlist with 10 songs and different play counts
      //song 1
        playlist.add(new Song("Ehnna Sohna", "Arjit Singh", 5));
       
        //song 2
        playlist.add(new Song("295", "Sidhu", 8));
        
        //song 3
        playlist.add(new Song("lala", "Eminem", 12));
       
        //song 4
        playlist.add(new Song("Amplifier", "Imran Khan", 3));
      
        //song 5
        playlist.add(new Song("Shape of you", "ED Sheeran", 6));
       
        //song 6
        playlist.add(new Song("do you know", "Diljit Dosanjh", 10));
       
        //song 7
        playlist.add(new Song("kadi de hans bol", "Atif Aslam", 15));
      
        //song 8
        playlist.add(new Song("pathaan", "Salman Khan", 2));
       
        //song 9
        playlist.add(new Song("chamak challo", "Sharukh Khan", 7));
       
        //song 10
        playlist.add(new Song("yh", "Bob Marley", 4));

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main loop for user interaction
        while (true) {
            // Display menu options
            System.out.println("Options:");
            System.out.println("1. Add a new song to the playlist");
            System.out.println("2. Remove a song from the playlist");
            System.out.println("3. Display the list of songs with play counts");
            System.out.println("4. Display songs with play count above 4");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            // Read user input for the menu choice
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            // Perform actions based on user choice
            switch (choice) {
                case 1:
                    // Add a new song to the playlist
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
                    // Remove a song from the playlist
                    System.out.print("Enter the song number of the song to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < playlist.size()) {
                        playlist.remove(index - 1);
                        System.out.println("Song removed from the playlist.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    // Display the list of songs with play counts
                    System.out.println("List of songs with play counts:");
                    for (Song song : playlist) {
                        System.out.println(song);
                    }
                    break;
                case 4:
                    // Display songs with play count above 5
                    System.out.println("Songs with play count above 5:");
                    for (Song song : playlist) {
                        if (song.getPlayCount() > 4) {
                            System.out.println(song);
                        }
                    }
                    break;
                case 5:
                    // Exit the program
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
