package maja_chaja_java_wroclaw;

import java.util.List;
import java.util.Map;

public class BasketSplitter {
    private String path;
    private Map<String, List<String>> data;

    public BasketSplitter(String absolutePathToConfigFile) {
        this.path = absolutePathToConfigFile;

    }

    public Map<String, List<String>> split(List<String> basket) {
        JsonAnalyzer parser = new JsonAnalyzer(path);
        data = parser.getJson();
        // for (Map.Entry<String, List<String>> entry : data.entrySet()) {
        // System.out.println("Key: " + entry.getKey());
        // System.out.print("Values: ");
        // for (String value : entry.getValue()) {
        // System.out.print(value + ", ");
        // }
        // System.out.println();
        // }
        BasketAnalyzer analizer = new BasketAnalyzer(basket, data);
        analizer.analyze();
        
        return null;
    }
}
