package edu.odu.cs.cs251;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Utils {

	/**
	 * Writes a byte array to a file with a given name. 
	 * 
	 * <p>
	 *  Invokes {@link #writeByteArray(Path, byte[])} by obtaining a Path from
	 * the given String.
	 * </p>
	 * @param fileName Name of file to write to.
	 * @param b Byte array to write.
	 * @throws IOException if any IO errors occur.
	 */
	public static void writeByteArray(String fileName, byte[] b) throws IOException {
		writeByteArray(Path.of(fileName), b);
	}

	/**
	 * Writes a byte array to a given outputPath
	 * @param outputPath Path to output file.
	 * @param b Byte array to write.
	 * @throws IOException if any IO error occurs.
	 */
	public static void writeByteArray(Path outputPath, byte[] b) throws IOException {
		Files.write(outputPath, b);
	}

	/**
	 * Read a byte array from a file with a given name.
	 * 
	 * <p>
	 *  Invokes {@link #readByteArray(Path)} by obtaining a Path from the given String.
	 * </p>
	 * @param fileName Name of file.
	 * @return byte array read from given file.
	 * @throws IOException if any IO errors occur.
	 */
	public static byte[] readByteArray(String fileName) throws IOException {
		return readByteArray(Path.of(fileName));
	}

	/**
	 * Reads a byte array from a given Path. 
	 * @param inputPath Path to file.
	 * @return byte array from given file.
	 * @throws IOException if any IO errors occur.
	 */
	public static byte[] readByteArray(Path inputPath) throws IOException {
		return Files.readAllBytes(inputPath);
	}
	
	/**
	 * Serializes a given object.
	 * @param <T> Type of the object.
	 * @param obj Object to serialize.
	 * @return Object serialized as a byte array.
	 * @throws IOException if an I/O error occurs.
	 */
	public static <T extends Serializable> byte[] serialize(T obj) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);
		oos.close();
		
		return baos.toByteArray();
	}
	
	/**
	 * Deserialize a byte array into an object of a given class.
	 * @param <T> Type of the serialized object.
	 * @param b Byte array of the serialized object.
	 * @param cl Class of the serialized object.
	 * @return Deserialized object of the given class.
	 * @throws IOException if there is an I/O error.
	 * @throws ClassNotFoundException if the given class cannot be found.
	 */
	public static <T extends Serializable> T deserialize(byte[] b, Class<T> cl) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Object o = ois.readObject();
		
		return cl.cast(o);
	}
	
	/**
	 * 
	 * @param progress
	 * @param total
	 */
	public static void progressBar(int progress, int total) {
		int barLength = 50; 
		// Length of the progress bar in characters 
		int completed = (int) ((progress * barLength) / total); 
		StringBuilder bar = new StringBuilder(); 
		bar.append("["); 
		for (int i = 0; i < completed; i++) { 
			bar.append("="); 
		} 
		for (int i = completed; i < barLength; i++) { 
			bar.append(" "); 
		} 
		bar.append("]"); 
		System.out.print("\r" + bar.toString() + " " + progress * 100 / total + "%");
		System.out.flush();
	}
	
	public static void spinningThing(int state) {
		System.out.print("\r%s".formatted("-\\|/".charAt(state)));
	}
}
