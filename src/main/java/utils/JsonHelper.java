package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Map;

public interface JsonHelper {

    static Map<String, Object> jsonFileToMap(String jsonFilePath) {
        String json = FileHelper.readFileToString(jsonFilePath);
        return jsonStringToMap(json);
    }

    static Map<String, Object> jsonStringToMap(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> devicesMap;
        try {
            devicesMap = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Cannot parse Json: " + jsonString + " to Object, ERROR: " + e.getMessage());
        }
        return devicesMap;
    }
}
