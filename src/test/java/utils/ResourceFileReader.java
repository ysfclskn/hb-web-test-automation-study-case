package utils;

import config.BaseConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ResourceFileReader {
    private final JSONParser parser = new JSONParser();
    private final BaseConfig baseConfig = new BaseConfig();

    public String getValidationData(String pageName, String key) {
        String resourcePath = "src/test/resources/";
        String filePath = resourcePath + "data/validations.json";
        JSONObject jsonObject;
        try {
            Object obj = parser.parse(new FileReader(filePath));
            jsonObject = (JSONObject) ((JSONObject) obj).get(baseConfig.getLocale());
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject tempObj = (JSONObject) jsonObject.get(pageName);
        return (String) tempObj.get(key);
    }
}
