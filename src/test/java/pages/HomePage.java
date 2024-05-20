package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.PageHelper;

public class HomePage extends PageHelper {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookieButton;

    @FindBy(css = "i[class*=\"searchBoxOld\"]")
    private WebElement searchIcon;

    @FindBy(css = "div[class*=\"SearchBoxOld\"] input")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class, 'searchBoxOld') and text()='ARA']")
    private WebElement searchButton;

    public void searchWithKeyword(String keyword) {
        clickElement(searchIcon);
        fillText(searchInput, keyword, true);
        clickElement(searchButton);
    }

    public void clickAcceptCookieButton() {
        verifyElementVisible(acceptCookieButton);
        clickElement(acceptCookieButton);
        verifyElementInvisible(acceptCookieButton);
    }

}
