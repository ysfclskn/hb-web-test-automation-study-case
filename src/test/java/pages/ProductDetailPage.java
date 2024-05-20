package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.PageHelper;
import utils.ResourceFileReader;

public class ProductDetailPage extends PageHelper {

    public ProductDetailPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    ResourceFileReader resourceFileReader = new ResourceFileReader();

    @FindBy(id = "productReviews")
    private WebElement productReviewsLink;

    @FindBy(css = "div[itemprop='review']:first-child [class*='thumbsUp']")
    private WebElement firstReviewThumbsUpButton;

    public void clickReviewTab() {
        switchToNewWindow();
        clickElement(productReviewsLink);
    }

    public void clickFirstReviewThumbsUpButton() {
        clickElement(firstReviewThumbsUpButton);
    }

    public void verifyReviewFeedbackSuccessfulMessage() {
        String feedbackSuccessfulMessage = "//div[@itemprop = \"review\"][%s]//span[text() = \"%s\"]";
        scrollUntilElementVisible(findWithXpathAndVars(feedbackSuccessfulMessage, "1", resourceFileReader.getValidationData("product_detail_page", "review_useful_feedback_successfully_message")));
    }

}
