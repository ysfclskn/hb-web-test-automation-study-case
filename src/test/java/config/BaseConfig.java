package config;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseConfig {

    public static BaseConfig getInstance() {
        return new BaseConfig();
    }

    String env = System.getProperty("env");
    String browser = System.getProperty("browser");
    String headless = System.getProperty("headless");
    String locale = System.getProperty("lang");
    String gridUrl = "";

    public String getUrl() {
        env = (env != null) ? env : "prod";
        String url = null;
        switch (env) {
            case "test" -> url = "";
            case "prod" -> url = "http://www.hepsiburada.com";
        }
        return url;
    }

    public String getLocale() {
        return locale != null ? locale : "tr";
    }

    public String getBrowser() {
        return (browser != null) ? browser : "chrome";
    }

    public Boolean getHeadless() {
        return (headless != null) ? Boolean.parseBoolean(headless) : false;
    }

    public URL getGridUrl() throws MalformedURLException {
        URL seleniumGridURL = new URL(gridUrl);
        return (gridUrl != null) ? seleniumGridURL : null;
    }
}
