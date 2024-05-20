package utils;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class PageHelper {

    static WebDriver driver = Driver.getDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public WebElement getRandomItemFromList(List<WebElement> elements) {
        Random rnd = new Random();
        return elements.get(rnd.nextInt(elements.size()));
    }

    public void fillText(WebElement element, String text, boolean clear) {
        if (clear) {
            element.clear();
        }
        element.sendKeys(text);
    }

    public WebElement findWithXpathAndVars(String locator, Object... vars) {
        return driver.findElement(By.xpath(String.format(locator, vars)));
    }

    public void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }

    public void scrollUntilElementVisible(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
         wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void verifyElementInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void verifyElementText(WebElement element, String expectedText) {
        Assertions.assertEquals(element.getText(), expectedText);
    }
}
