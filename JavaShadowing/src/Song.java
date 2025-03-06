
public class Song {

	String name;
	public class PersonWhoWroteIt {
		String artist;
		
		PersonWhoWroteIt(String name) {
			artist= name;
		}
		
		void printer(String song, String user) {
			System.out.println(user + " likes the song ");
			System.out.println(song);
			System.out.println(" by the artist: " + artist);
		}
	}
	
	PersonWhoWroteIt artist;
	
	public Song() {
		name = "";
	}
	
	public Song(String name) {
		this.name = name;
	}
	
	public void changeName(String name) {
		this.name = name;
	}
	
	public String returnName() {
		return name;
	}
	
	public void changeArtist(PersonWhoWroteIt artist) {
		this.artist = artist;
	}
	
	public PersonWhoWroteIt PersonWhoWroteItreturner() {
		return artist;
	}
	
	public PersonWhoWroteIt newArtistInplace(String name) {
		return new PersonWhoWroteIt(name);
	}
	
	public void printSong(String userName) {
		artist.printer(name, userName);
	}
}
