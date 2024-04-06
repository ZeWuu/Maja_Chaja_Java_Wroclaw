package maja_chaja_java_wroclaw;

import java.util.List;
import java.util.Map;


public class BasketSplitter {
    private String path;
    private Map<String, List<String>> data;
    private Map<String, List<String>> finalGroups;

    public BasketSplitter(String absolutePathToConfigFile) {
        this.path = absolutePathToConfigFile;
    }

    public Map<String, List<String>> split(List<String> basket) {
        JsonAnalyzer parser = new JsonAnalyzer(path);
        data = parser.getJson();
       
        BasketAnalyzer analyzer = new BasketAnalyzer(basket, data);
        finalGroups = analyzer.analyze();

        return finalGroups;
    }
}
