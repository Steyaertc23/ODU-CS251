
public class Song {
	private String album, artist, name;
	private double duration;
	
	public Song(String album, String artist, String name, double duration) {
		this.album = album;
		this.artist = artist;
		this.name = name;
		this.duration = duration;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getName() {
		return name;
	}
	
	public double getDuration() {
		return duration;
	}
}
