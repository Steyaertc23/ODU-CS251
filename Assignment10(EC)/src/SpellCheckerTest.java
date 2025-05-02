import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.HashMap;

class SpellCheckerTest {

	private SpellChecker spellChecker;

    @BeforeEach
    public void setUp() {
        spellChecker = new SpellChecker();
        spellChecker.readFile("data/dictionary.txt");
    }

    @Test
    public void testRemoveNonAlphaNumeric() {
        String word = "{H2+<o>p}";
        String expected = "H2op";
        assertEquals(expected, spellChecker.removeNonAlphaNumeric(word));
    }

    @Test
    public void testWordExistMap_ExistsInDictionary() {
        spellChecker.getDictionaryMap().put("hello", 1);
        assertTrue(spellChecker.wordExistMap("hello", spellChecker.getDictionaryMap()));
    }

    @Test
    public void testWordExistMap_NotInDictionary() {
        assertFalse(spellChecker.wordExistMap("qwaz", spellChecker.getDictionaryMap()));
    }

    @Test
    public void testReadFile_LoadsDictionaryAndCountsWords() throws IOException {
        File dictionaryFile = new File("data/test/dictionary.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dictionaryFile))) {
            writer.write("hello\nworld\ntest");
        }
        spellChecker.readFile("data/test/dictionary.txt");

        HashMap<String, Integer> dictionaryMap = spellChecker.getDictionaryMap();
        assertTrue(dictionaryMap.containsKey("hello"));
        assertTrue(dictionaryMap.containsKey("world"));
        assertTrue(dictionaryMap.containsKey("test"));

        dictionaryFile.delete();
    }

    @Test
    public void testReadFile_ProcessTextFileAndCountWords() throws IOException {
        File textFile = new File("data/test/testfile.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Hello world!\nThis is a test.\nSome more text.");
        }

        spellChecker.readFile("data/test/testfile.txt");

        assertEquals(3, spellChecker.lineCount());
        assertEquals(9, spellChecker.wordCount());
        assertEquals(33, spellChecker.characterCount());
        assertEquals("hello", spellChecker.longestWordUsed());

        textFile.delete();
    }

    @Test
    public void testWordUsageCount() throws IOException {
        File textFile = new File("data/test/testfile.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Hello world!\nThis is a test.\nHello test.");
        }

        spellChecker.readFile("data/test/testfile.txt");

        HashMap<String, Integer> wordUsageCount = spellChecker.wordUsageCount();
        assertEquals(2, wordUsageCount.get("hello"));
        assertEquals(1, wordUsageCount.get("world"));
        assertEquals(2, wordUsageCount.get("test"));
        assertEquals(1, wordUsageCount.get("this"));
        assertEquals(1, wordUsageCount.get("is"));
        assertEquals(1, wordUsageCount.get("a"));

        textFile.delete();
    }

    @Test
    public void testLongestWordUsed() throws IOException {
        File textFile = new File("data/test/testfile.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Hello world!\nsuperficialities\nTest");
        }

        spellChecker.readFile("data/test/testfile.txt");

        assertEquals("superficialities", spellChecker.longestWordUsed());

        textFile.delete();
    }

}
