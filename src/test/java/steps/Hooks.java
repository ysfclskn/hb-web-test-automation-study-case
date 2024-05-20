package steps;

import config.BaseConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {

    BaseConfig baseConfig = new BaseConfig();

    @Before
    public void setup() {
        Driver.setWebDriver();
        Driver.getDriver().get(baseConfig.getUrl());
        Driver.getDriver().manage().deleteAllCookies();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot));
        }
        Driver.closeDriver();
    }

}
