import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SpellChecker {

    private HashMap<String, Integer> dictionaryMap = new HashMap<>();
    private HashMap<String, Integer> fileWordMap = new HashMap<>();
    private int totalWords = 0;
    private int totalCharacters = 0;
    private int totalLines = 0;
    private String longestWord = "";

    /**
     * Reads either a dictionary file or a regular file for analysis.
     * If the file path ends with "dictionary.txt", loads it into dictionaryMap and exits.
     */
    public void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            if (fileName.toLowerCase().endsWith("dictionary.txt")) {
                loadDictionary(reader);
                return;
            }

            while ((line = reader.readLine()) != null) {
                totalLines++;

                String[] words = line.split("\\s+");
                for (String rawWord : words) {
                    String cleanedWord = removeNonAlphaNumeric(rawWord).toLowerCase();
                    if (cleanedWord.isEmpty()) {
                        continue;
                    }
                    totalWords++;
                    if (!wordExistMap(cleanedWord, dictionaryMap)) {
                        System.out.println("Unknown word: " + cleanedWord);
                        continue;
                    }
                    fileWordMap.put(cleanedWord, fileWordMap.getOrDefault(cleanedWord, 0) + 1);
                    totalCharacters += cleanedWord.length();
                    if (cleanedWord.length() > longestWord.length()) {
                        longestWord = cleanedWord;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + fileName);
            e.printStackTrace();
        }
    }

    /**
     * Helper method to load dictionary words into the dictionaryMap.
     */
    private void loadDictionary(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            String word = removeNonAlphaNumeric(line).toLowerCase();
            if (!word.isEmpty()) {
                dictionaryMap.put(word, 1);
            }
        }
    }

    /**
     * Removes any non-alphanumeric characters from a word.
     * 
     * @param word the word to clean
     * @return the cleaned word
     */
    String removeNonAlphaNumeric(String word) {
        return word.replaceAll("[^a-zA-Z0-9]", "");
    }

    /**
     * Checks if a word exists in a given map.
     * 
     * @param word the word to check
     * @param map the map to check against
     * @return true if the word exists in the map, false otherwise
     */
    boolean wordExistMap(String word, HashMap<String, Integer> map) {
        return map.containsKey(word.toLowerCase());
    }

    /**
     * Returns the total count of words in the file.
     * 
     * @return the total word count
     */
    public int wordCount() {
        return totalWords;
    }

    /**
     * Returns the total number of characters in the file.
     * 
     * @return the total character count
     */
    public int characterCount() {
        return totalCharacters;
    }

    /**
     * Returns the total number of lines in the file.
     * 
     * @return the total line count
     */
    public int lineCount() {
        return totalLines;
    }

    /**
     * Returns a map of words and their usage count in the file.
     * 
     * @return the word usage map
     */
    public HashMap<String, Integer> wordUsageCount() {
        return fileWordMap;
    }

    /**
     * Returns the longest word used in the file.
     * 
     * @return the longest word
     */
    public String longestWordUsed() {
        return longestWord;
    }

    /**
     * Returns the dictionary map for external access.
     * 
     * @return the dictionary map
     */
    public HashMap<String, Integer> getDictionaryMap() {
        return dictionaryMap;
    }
}
