import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		String personWhoWroteIt, name;
		Song song;
		Song[] songList;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the number of songs");
		int noOfSongs = in.nextInt();
		in.nextLine();
		songList = new Song[noOfSongs];
		
		for (int i = 0; i < noOfSongs; i++) {
			System.out.println("Enter the song name");
			name = in.nextLine();
			
			
			System.out.println("Enter the name of the person who wrote it");
			personWhoWroteIt = in.nextLine();
			
			song = new Song(name);
			songList[i] = song;
			song.changeArtist(song.newArtistInplace(personWhoWroteIt));
		}
		
		// Make it an arraylist for fun
		ArrayList<Song> songlist = Converter(songList);
		System.out.println("Enter your name: ");
		String usersName = in.nextLine();
		System.out.println("\n");
		for (Song s : songlist) {
			s.printSong(usersName);
		}
		in.close();
	}
	
	public static ArrayList<Song> Converter(Song[] arr) {
		ArrayList<Song> arrList = new ArrayList<Song>();
		
		for (Song s : arr) {
			arrList.add(s);
		}
		
		return arrList;
	}
}
