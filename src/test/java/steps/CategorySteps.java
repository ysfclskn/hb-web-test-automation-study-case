package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CategoryPage;

public class CategorySteps {

    CategoryPage categoryPage = new CategoryPage();

    @And("click random product and go product detail on category page")
    public void clickRandomProductAndGoProductDetailOnCategoryPage() {
        categoryPage.clickRandomProduct();
    }

    @Then("verify {string} search results on category page")
    public void verifySearchResultsOnCategoryPage(String keyword) {
        categoryPage.verifySearchResult(keyword);
    }
}
