import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class HMTest {
    private MyHashMap<String> stringMap;
    private MyHashMap<Integer> intMap;

    @BeforeEach //Test data starter for evey Test
    public void setUp() {
        stringMap = new MyHashMap<>("key1", "value1");
        intMap = new MyHashMap<>("number", 100);
    }

    @Test //Proper initialization
    public void constructorTest() {
        assertEquals(1, stringMap.size());
        assertEquals("value1", stringMap.get("key1"));
        assertFalse(stringMap.isEmpty());
    }

    @Test //Adds a key and value and cheks for size
    public void newKeyTest() {
        stringMap.put("key2", "value2");
        assertEquals(2, stringMap.size());
        assertEquals("value2", stringMap.get("key2"));
    }

    @Test //Checks for a key that is already in if found
    public void getKeyTest() {
        assertEquals("value1", stringMap.get("key1"));
    }

    @Test //Tries to get a key that doesn't exist
    public void noKeyExistsTest() {
        assertNull(stringMap.get("nonexistent"));
    }

    @Test //Cheks if a certain key is found (true)
    public void constainsKeyTest() {
        assertTrue(stringMap.contains("key1"));
    }

    @Test //Check for a key that is not in
    public void containsNonExistingtKeyTest() {
        assertFalse(stringMap.contains("nonexistent"));
    }

    @Test //Replaicng value of a key
    public void replaceExistingKeyTest() {
        String oldValue = stringMap.replace("key1", "newvalue");
        assertEquals("value1", oldValue);
        assertEquals("newvalue", stringMap.get("key1"));
    }

    @Test //Trying to replace value to a key taht doesn't exist
    public void replaceNonExistentKeyTest() {
        assertNull(stringMap.replace("nonexistent", "value"));
    }

    @Test //Checks if size is correctly updated
    public void sizeAfterOperationsTest() {
        assertEquals(1, stringMap.size());
        stringMap.put("key2", "value2");
        assertEquals(2, stringMap.size());
        stringMap.replace("key1", "updated");
        assertEquals(2, stringMap.size());
    }

    @Test //Empty hashmap check
    public void isEmptyTest() {
        assertFalse(stringMap.isEmpty());
    }

    @Test //Cheking if collision is handeled properly
    public void collisionTest() {
        // These keys should cause a collision based on hashCode % 10
        stringMap.put("Cozmo", "first");
        stringMap.put("omzoC", "second");

        assertTrue(stringMap.contains("Cozmo"));
        assertTrue(stringMap.contains("omzoC"));
        assertEquals("first", stringMap.get("Cozmo"));
        assertEquals("second", stringMap.get("omzoC"));
        assertEquals(3, stringMap.size());
    }

    @Test //Testinf the HashMap iterator
    public void hmIterTest() {
        intMap.put("two", 200);
        intMap.put("three", 300);

        int sum = 0;
        java.util.Iterator<Integer> it = intMap.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        assertEquals(600, sum);
    }

    @Test //For each loop testing if working
    public void forEachHashTest() {
        stringMap.put("key2", "value2");
        stringMap.put("key3", "value3");

        int count = 0;
        for (String value : stringMap) {
            assertNotNull(value); //3 values is hash
            count++; //amount of read
        }
        assertEquals(3, count);
    }

    @Test //Testing mutiple operations once after another
    public void multpleOperationsTest() {
        MyHashMap<Integer> map = new MyHashMap<>("a", 1); //new Hashmap
        map.put("b", 2); //Adding key, values
        map.put("c", 3);

        assertEquals(3, map.size());
        assertTrue(map.contains("b"));
        assertEquals(2, (int) map.get("b"));

        map.replace("b", 20); //replacing b value
        assertEquals(20, (int) map.get("b"));

        map.put("d", 4);
        assertEquals(4, map.size()); //Making sure size updated
    }

    @Test //Null values put in hash map
    public void nullValsTest() {
        stringMap.put("nullkey", null);
        assertTrue(stringMap.contains("nullkey"));
        assertNull(stringMap.get("nullkey"));
    }
}
