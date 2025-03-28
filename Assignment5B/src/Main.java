import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	static int sequentialSearch(Album[] arr, String name) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].getName().compareToIgnoreCase(name) == 0)
				return i;
		}
		return -1;
	}
	
	static void insertionSort(Song[] arr, int n) 
    { 
        if (n <= 1)
        {
            return; 
        }

        insertionSort( arr, n-1 );
       
        Song last = arr[n-1];
        int j = n-2;
       
        while (j >= 0 && arr[j].getDuration() > last.getDuration())
        { 
            arr[j+1] = arr[j];
            j--; 
        } 
        arr[j+1] = last;
    }
	
	static int binarySearch(Song[] arr, String x) 
    { 
        int l = 0, r = arr.length - 1; 
  
        // Loop to implement Binary Search 
        while (l <= r) { 
  
            // Calculatiing mid 
            int m = l + (r - l) / 2; 
  
            int res = x.compareToIgnoreCase(arr[m].getName()); 
  
            // Check if x is present at mid 
            if (res == 0) 
                return m; 
  
            // If x greater, ignore left half 
            if (res > 0) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        return -1; 
    } 

	static Album[] convertAlbumsToList(ArrayList<Album> albums) {
		Album[] toReturn = new Album[albums.size()];
		
		for (int i = 0; i < albums.size(); i++) {
			toReturn[i] = albums.get(i);
		}
		
		return toReturn;
	}
	
	static Song[] convertSongsToList(ArrayList<Song> songs) {
		Song[] toReturn = new Song[songs.size()];
		
		for (int i = 0; i < songs.size(); i++) {
			toReturn[i] = songs.get(i);
		}
		
		return toReturn;
	}
	
	static boolean run(ArrayList<Album> albums, ArrayList<Song> songs) throws Exception{
		
		int choice = -1;
		System.out.println("1. Search for an album");
		System.out.println("2. Search for a Song");
		System.out.println("3. Quit");
		String choiceString = scanner.nextLine();
		
		choice = Integer.parseInt(choiceString);
		
		switch(choice) {
		case 1:
			System.out.println("Enter the name of the album you are looking for.");
			String albumSearch = scanner.nextLine();
			int albumLocation = sequentialSearch(convertAlbumsToList(albums), albumSearch);
			if (albumLocation > -1) {
				System.out.println(albums.get(albumLocation).toString());
			}
			else
				System.err.println("Album is not found.");
			return true;
		case 2:
			System.out.println("Enter the name of the album you are looking for.");
			String songSearch = scanner.nextLine();
			Song[] songsArray = convertSongsToList(songs);
			insertionSort(songsArray, songsArray.length);
			int songLocation = binarySearch(songsArray, songSearch);
			if (songLocation > -1) {
				System.out.println(albums.get(songLocation).toString());
			}
			else
				System.err.println("Album is not found.");
			return true;
		case 3: 
			System.out.println("Exiting....");
			return false;
			
		default:
			System.err.println("Invalid input. Please choose number 1-3");
			return true;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File songsFile = new File("." + File.separator + "data" + File.separator + "Songs.txt");
		File albumsFile = new File("." + File.separator + "data" + File.separator + "Artists.txt");
		
		String line;
		ArrayList<Song> songs = new ArrayList<>();
		ArrayList<Album> albums = new ArrayList<>();
		
		try(BufferedReader reader = new BufferedReader(new FileReader(albumsFile))){
			
			while ((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				Artist artist = new Artist(info[0]);
				for (int i = 1; i < info.length; i++) {
					albums.add(new Album(info[i], artist));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedReader reader = new BufferedReader(new FileReader(songsFile))){
			
			while ((line = reader.readLine()) != null) {
				String[] song = line.split(",");
				Song s = new Song(song[3], song[2], song[0], Double.parseDouble(song[1]));
				songs.add(s);
				
				int search = sequentialSearch(convertAlbumsToList(albums), song[3]);
				if (search > -1) {
					Album songAlbum = albums.remove(search);
					songAlbum.addSong(s);
					albums.add(songAlbum);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean running = true;
		while (running) {
			try{
				running = run(albums, songs);
			}
			catch(Exception e) {
				System.err.println("Invalid input");
			}
		}
		
	}

}
