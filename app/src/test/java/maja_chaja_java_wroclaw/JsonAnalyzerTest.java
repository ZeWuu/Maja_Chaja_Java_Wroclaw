package maja_chaja_java_wroclaw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonAnalyzerTest {

    private JsonAnalyzer jsonAnalyzer;

    @BeforeEach
    public void setup() {
        jsonAnalyzer = new JsonAnalyzer("src/test/resources/config.json");
    }

    @Test
    public void testGetJson() {
        Map<String, List<String>> result = jsonAnalyzer.getJson();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(6, result.size());
        Assertions.assertTrue(result.containsKey("Cookies Oatmeal Raisin"));
        Assertions.assertTrue(result.containsKey("Cheese Cloth"));
        Assertions.assertTrue(result.containsKey("English Muffin"));
        Assertions.assertTrue(result.containsKey("Ecolab - Medallion"));
        Assertions.assertTrue(result.containsKey("Chocolate - Unsweetened"));
        Assertions.assertTrue(result.containsKey("Shrimp - 21/25, Peel And Deviened"));
    }
}