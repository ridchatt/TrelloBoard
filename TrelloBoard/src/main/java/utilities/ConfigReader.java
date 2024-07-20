package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src\\main\\java\\resources\\config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found or unable to load.");
        }
    }

    public String getApiKey() {
        return properties.getProperty("apiKey");
    }

    public String getApiToken() {
        return properties.getProperty("apiToken");
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

}
