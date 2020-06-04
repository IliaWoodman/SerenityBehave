package testPackage.steps.jeBehaveSteps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import testPackage.steps.SerenitySteps.MainPageSteps;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainBehaveSteps {
    @Steps
    MainPageSteps steps;

    @Given("I open main page")
    public void openMainPage() {
        steps.open_main_page();
    }

    @When("I open book's catalog")
    public void openBookCatalog() {
        steps.open_books_catalog();
    }
    @When("I sout text")
    public void printText(){
        System.out.println("QQQWEQWEQEQWQEQEEQWEQ");
    }

    @Then("I check that page have $booksAmount books")
    public void checkAmountBooksOnPage(int booksAmount) {
        steps.should_be_books_on_page(booksAmount);
    }


    @Then("I check that book with \"$title\" title book present on page")
    public void checkBooksPresentInList(String title) {
        steps.check_that_list_have_book_on_title(title, steps.get_all_books_titles_on_page());
    }

    // Given I open main page
    //When I open book's catalog
    // Then I check that books present on page
}
