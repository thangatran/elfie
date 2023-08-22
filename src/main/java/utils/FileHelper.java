package utils;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface FileHelper {

    static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line = "";
            while (line != null) {
                fileContent.append(line);
                line = reader.readLine();
            }
            return fileContent.toString();
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file to string: " + e);
        }
    }
}
