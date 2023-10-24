import java.util.ArrayList;
import java.util.Scanner;

class Song {
    private String title;
    private String artist;
    private int playCount;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.playCount = 0;
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

public class MusicPlayer {
    public static void main(String[] args) {
        ArrayList<Song> playlist = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a new song");
            System.out.println("2. Remove a song");
            System.out.println("3. List all songs");
            System.out.println("4. List songs by play count");
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
                    Song song = new Song(title, artist);
                    playlist.add(song);
                    System.out.println("Song added to the playlist.");
                    break;
                case 2:
                    System.out.print("Enter the index of the song to remove: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < playlist.size()) {
                        playlist.remove(index);
                        System.out.println("Song removed from the playlist.");
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case 3:
                    System.out.println("List of all songs:");
                    for (int i = 0; i < playlist.size(); i++) {
                        System.out.println(i + ". " + playlist.get(i));
                    }
                    break;
                case 4:
                    System.out.print("Enter the minimum play count: ");
                    int minPlayCount = scanner.nextInt();
                    System.out.println("List of songs with more than " + minPlayCount + " plays:");
                    for (Song s : playlist) {
                        if (s.getPlayCount() > minPlayCount) {
                            System.out.println(s);
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
