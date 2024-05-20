package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @When("search with {string} keyword on on homepage")
    public void searchWithKeywordOnHomepage(String keyword) {
        homePage.searchWithKeyword(keyword);
    }

    @Given("click accept cookie button on homepage")
    public void clickAcceptCookieButtonOnHomepage() {
        homePage.clickAcceptCookieButton();
    }
}
