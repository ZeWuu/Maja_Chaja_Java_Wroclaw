package maja_chaja_java_wroclaw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasketAnalyzerTest {

    private BasketAnalyzer basketAnalyzer;

    @BeforeEach
    public void setup() {
        List<String> basket = Arrays.asList("Cookies Oatmeal Raisin", "Cheese Cloth", "English Muffin");

        // Create a mock products map
        Map<String, List<String>> products = new HashMap<>();
        products.put("Cookies Oatmeal Raisin", Arrays.asList("Delivery Method 1"));
        products.put("Cheese Cloth", Arrays.asList("Delivery Method 1"));
        products.put("English Muffin", Arrays.asList("Delivery Method 2"));
        products.put("Ecolab - Medallion", Arrays.asList("Delivery Method 3"));

        basketAnalyzer = new BasketAnalyzer(basket, products);
    }

    @Test
    public void testAnalyze() {

        // Call the analyze method
        Map<String, List<String>> result = basketAnalyzer.analyze();

        // Verify the result
        Assertions.assertNotNull(result);
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsKey("Delivery Method 1"));
        Assertions.assertTrue(result.containsKey("Delivery Method 2"));
        Assertions.assertEquals(Arrays.asList("Cookies Oatmeal Raisin", "Cheese Cloth"),
                result.get("Delivery Method 1"));
        Assertions.assertEquals(Arrays.asList("English Muffin"), result.get("Delivery Method 2"));
    }
}