package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ProductDetailPage;

public class ProductDetailSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();
    
    @And("click review tab on product detail page")
    public void clickReviewTabOnProductDetailPage() {
        productDetailPage.clickReviewTab();
    }

    @And("click thumbs up button of first review on product detail page")
    public void clickThumbsUpButtonOfFirstReviewOnProductDetailPage() {
        productDetailPage.clickFirstReviewThumbsUpButton();
    }

    @Then("verify review feedback successful message on product detail page")
    public void verifyReviewFeedbackSuccessfulMessageOnProductDetailPage() {
        productDetailPage.verifyReviewFeedbackSuccessfulMessage();
    }
}
