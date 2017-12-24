/**
* Unit Test for own implemented HashMap.
*/
package hashmap;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MerHashMapTest {

    private MerHashMap merHashMap;
    private final int NUM_ELEMENTS = 200000;

    @Before
    public void setUp() {
        merHashMap = new MerHashMap();
    }

    @Test
    public void testHashMapPut() {
        merHashMap.put("Test1", "Test1Value");
    }

    @Test
    public void testPutGet() {
        String key = "TestPutGet";
        String value = "TestPutGetValue";

        merHashMap.put(key, value);
        String result = merHashMap.get(key);
        assertEquals(value, result);
    }

    @Test
    public void testHashMapCollisions() {
        // Initialize HashMap
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            merHashMap.put(Integer.toString(i), Integer.toString(i));
        }

        // Test all values of the get method
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            String value = merHashMap.get(Integer.toString(i));
            assertEquals(Integer.toString(i), value);
        }
    }

    @After
    public void cleanUp() {
        merHashMap = null;
    }

}
