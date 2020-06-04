package testPackage.steps.SerenitySteps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import testPackage.pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class MainPageSteps  {
    MainPage page;
    @Step
    public void open_main_page(){
        page.open();
    }

    @Step
    public void open_books_catalog(){
        page.openBooksCatalog();
    }
    @Step("Open book with name {0}")//Coders at Work
    public void open_book_by_title(String title){
        page.openBookByTitle(title);
    }
    @Step
    public void add_book_in_basket_by_title(String title){
        page.addBookToBasketByTitle(title);
    }
    @Step
    public void check_that_book_added_in_basket(){
        page.checkSuccessAddedIntoBasket();
    }
    @Step
    public void send_in_search_field(String title){
        page.sendInSearchField(title);
    }
    @Step
    public String get_book_header(){
        return page.getBookHeader();
    }
    @Step
    public List<WebElementFacade> get_books_list(){
        return page.getBooksList();
    }
    @Step
    public boolean find_book_in_list(String title, ArrayList<String> list){
        return page.findBookInList(title,list);
    }
    @Step
    public ArrayList<String> get_all_books_titles_on_page(){
        return page.getBooksTitlesList();
    }
    @Step
    public void should_be_books_on_page(int amount){
        Assertions.assertThat(page.getBooksList()).as("We have incorrect number").hasSize(amount);
    }
    @Step
    public void check_that_list_have_book_on_title(String title, ArrayList<String> list){
        Assertions.assertThat(page.findBookInList(title, list)).isTrue();
    }
}
