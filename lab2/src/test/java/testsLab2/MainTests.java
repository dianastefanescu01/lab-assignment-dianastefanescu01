package testsLab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import com.google.common.collect.Lists;


public class MainTests {
    @Test
    void testListNotEmpty() {
        List<String> items = Lists.newArrayList("red", "blue", "brown");
        assertFalse(items.isEmpty(), "List should not be empty");
    }

    @Test
    void testListSize() {
        List<String> items = Lists.newArrayList("red", "blue", "brown");
        assertEquals(3, items.size(), "List should contain 3 items");
    }

}
