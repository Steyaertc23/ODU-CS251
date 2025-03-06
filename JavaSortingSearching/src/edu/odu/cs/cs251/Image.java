package edu.odu.cs.cs251;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Image implements Serializable {
	
	/**
	 * Deserializes a given byte array into a List of Images
	 * @param bytes Byte array
	 * @return List<Image> or null if an exception is thrown
	 */
	public static List<Image> deserializeImageList(byte[] bytes) {
		try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais)) {
			return (ImageList) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error deserializing byte array");
			return null;
		}
	}

	private static final long serialVersionUID = -1541533537921897183L;
	
	private Path path;
	private Set<String> keywords;
	private Date dateCreated;
	private long fileSize;
	
	protected Image() {
		path = null;
		keywords = new HashSet<>();
		dateCreated = Date.from(Instant.now());
		fileSize = 0l;
	}
	
	public Image(Path path, Set<String> keywords, Date dateCreated, long fileSize) {
		this.path = path;
		this.keywords = new HashSet<>(keywords);
		this.dateCreated = dateCreated;
		this.fileSize = fileSize;
	}
	
	public Path getPath() {
		return path;
	}
	
	public long getFileSize() {
		return fileSize;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public boolean hasKeyword(String keyword) {
		return keywords.contains(keyword.toLowerCase());
	}
	
	public boolean addKeyword(String keyword) {
		return keywords.add(keyword.toLowerCase());
	}
	
	public boolean removeKeyword(String keyword) {
		return keywords.remove(keyword.toLowerCase());
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateCreated, fileSize, keywords, path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Image))
			return false;
		Image other = (Image) obj;
		return Objects.equals(dateCreated, other.dateCreated) && fileSize == other.fileSize
				&& Objects.equals(keywords, other.keywords) && Objects.equals(path, other.path);
	}

	@Override
	public String toString() {
		return "Image [path=" + path + ", keywords=" + keywords + ", dateCreated=" + dateCreated + ", fileSize="
				+ fileSize + "]";
	}
	
	public String getCommaSeparated() {
		return "%s,%s,%s,%s".formatted(path, keywords, dateCreated, fileSize);
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		path = Path.of((String) ois.readObject());
		keywords = (Set<String>) ois.readObject();
		dateCreated = (Date) ois.readObject();
		fileSize = ois.readLong();
	}
	
	private void writeObject(ObjectOutputStream ous) throws IOException {
		ous.writeObject(path.toString());
		ous.writeObject(keywords);
		ous.writeObject(dateCreated);
		ous.writeLong(fileSize);
	}
}
