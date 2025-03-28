import java.util.ArrayList;

public class Album {
	private String name;
	private int numberSongs;
	private ArrayList<Song> songs;
	private Artist artist;
	private double duration;
	
	public Album(String name, int numberSongs, Artist artist, Song... songs) {
		this.songs = new ArrayList<Song>();
		for (Song s : songs) {
			this.songs.add(s);
		}
		this.name = name;
		this.numberSongs = numberSongs;
		this.artist = artist;
		
	}
	
	public Album(String name, Artist artist) {
		this.name = name;
		this.artist = artist;
		songs = new ArrayList<>();
		duration = 0;
	}
	
	private final void calculateDuration() {
		for (Song s : songs) {
			duration += s.getDuration();
		}
	}
	
	public void addSong(Song newSong) {
		songs.add(newSong);
	}
	
	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumberSongs() {
		return numberSongs;
		
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}
	
	public Artist getArtist() {
		return artist;
	}
	
	public double getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		calculateDuration();
		int seconds = (int) (duration*60) % 60;
		
		
		return "Name: " + name + "\nArtist " + artist.getName() + "\nNumber of Songs: " + numberSongs + 
				"\nTotal Time: "  + (int)(duration % 60) + " minutes "+ seconds + " secs";
	}
}
