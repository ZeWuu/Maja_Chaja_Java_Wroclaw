package maja_chaja_java_wroclaw;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

public class JsonAnalyzer {
    private final Gson gson;
    private String path;

    public JsonAnalyzer(String absolutePathToConfigFile) {
        this.path = absolutePathToConfigFile;
        this.gson = new Gson();
    }

    // This method reads the JSON file and returns its content as a Map<String, List<String>> object
    // The JSON file contains a map where the key is a product name and the value is a list of delivery methods
    // The method uses the Gson library to parse the JSON file
    
    public Map<String, List<String>> getJson() {
        try {
            Type type = new TypeToken<Map<String, List<String>>>() {
            }.getType();
            return gson.fromJson(new FileReader(path), type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
