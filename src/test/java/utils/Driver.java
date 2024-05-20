package utils;

import config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    static ChromeOptions chromeOptions = new ChromeOptions();

    public static void setWebDriver() {
        switch (BaseConfig.getInstance().getBrowser()) {
            case "chrome":
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--disable-notifications");
                if (BaseConfig.getInstance().getHeadless()) chromeOptions.addArguments("--headless");
                try {
                    driver.set(new RemoteWebDriver(BaseConfig.getInstance().getGridUrl(), chromeOptions));
                } catch (Exception e) {
                    System.out.println("RemoteWebDriver not found. Using local web browser.");
                    driver.set(new ChromeDriver(chromeOptions));
                }
                break;
            case "firefox":
                driver.set(new FirefoxDriver());
                break;
            default:
                throw new IllegalArgumentException("Not defined browser: " + BaseConfig.getInstance().getBrowser());
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void closeDriver() {
        getDriver().quit();
    }
}