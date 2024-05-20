package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.PageHelper;

import java.util.List;

public class CategoryPage extends PageHelper {

    public CategoryPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBys(@FindBy(css = "li[class*='productListContent']"))
    private List<WebElement> productList;

    @FindBy(css = "h1[class*=\"searchResultSummaryBar\"]")
    private WebElement searchResultText;

    public void clickRandomProduct() {
        clickElement(getRandomItemFromList(productList));
    }

    public void verifySearchResult(String keyword) {
        verifyElementText(searchResultText, keyword);
    }

}
