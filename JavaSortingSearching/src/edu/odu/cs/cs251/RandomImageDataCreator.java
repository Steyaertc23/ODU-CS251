package edu.odu.cs.cs251;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

public class RandomImageDataCreator {
	
	private static final long FILE_SIZE_INCREMENT = 32;
	
	private Random rand;
	private List<String> keywordSet;
	private Path rootPath;
	
	
	public RandomImageDataCreator(List<String> keywordSet, Path rootPath) {
		rand = new Random();
		this.keywordSet = keywordSet;
		this.rootPath = rootPath;
	}
	
	public List<Image> generateRandomImageSet(int numImages) {
		List<Image> images = new ImageList();
		for (int i = 0; i < numImages; i++) {
			images.add(generateRandomImage());
			Utils.progressBar(i, numImages);
		}
		Utils.progressBar(numImages, numImages);
		
		return images;
	}
	
	public Image generateRandomImage() {
		// Generate random file name
		Path filePath = rootPath.resolve(randomFileName(rand.nextInt(1,25)));
		// Choose random subset of keywords
		int numKeywords = rand.nextInt(keywordSet.size());
		Collections.shuffle(keywordSet, rand);
		Set<String> keywords = new HashSet<>(keywordSet.subList(0, numKeywords));
		// Generate random date between now and the beginning of Java epoch
		Date dateCreated = new Date(rand.nextLong(Instant.now().getEpochSecond()));
		// Generate random file size
		long fileSize = (rand.nextLong(5) * FILE_SIZE_INCREMENT) + rand.nextLong(FILE_SIZE_INCREMENT);
		
		return new Image(filePath, keywords, dateCreated, fileSize);
	}
	
	private String randomFileName(int length) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int idx = rand.nextInt(alphabet.length());
			sb.append(alphabet.charAt(idx));
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		List<String> keywords = 
				Arrays.asList("dog", "cat", "food", 
				"nature", "concert", "nighttime",
				"3D", "2D", "technology",
				"holidays", "selfie");
		
		Path rootPath = Path.of("DCIM");
		
		RandomImageDataCreator ridc = new RandomImageDataCreator(keywords, rootPath);
		
		List<Integer> nums = List.of(10, 100, 1000, 10000, 100000, 1000000, 10000000);
		for (Integer n : nums) {
			System.out.println("Generating %d image set...".formatted(n));
			List<Image> images = ridc.generateRandomImageSet(n);
			
			// Write serialized data
			try {
				byte[] serialized = Utils.serialize((Serializable) images);
				Files.write(Path.of("image%d.ser".formatted(n)), serialized);
			} catch (IOException e) {
				System.out.println("Something went wrong. File may not be valid.");
			}
			System.out.println();
		}
	}
}
