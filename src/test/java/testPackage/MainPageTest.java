package testPackage;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import testPackage.steps.SerenitySteps.MainPageSteps;


@RunWith(SerenityRunner.class)
public class MainPageTest {

    @Steps
    MainPageSteps steps;

    @Managed
    WebDriver driver;


/*    @Test
    public void checkThatLangChooseCorrect() {
        mainPage.openSelect();
        mainPage.chooseLanguage("ru");
        mainPage.applyChoseLanguage();
        mainPage.getBasketText();
        Assert.assertEquals(mainPage.getBasketText(), "Всего в корзине:");
    }*/

/*    @Test
    public void checkAmountLanguages() {

        mainPage.openSelect();
        mainPage.getLanguageList();
        Assert.assertEquals(mainPage.getLanguageList().size(), 21);
    }*/
/*


    @Test
    public void checkAmountBooksOnPage() {
        steps.open_main_page();
        steps.open_books_catalog();
        steps.should_be_books_on_page(20);
*/
/*
        Assert.assertEquals(testPackage.steps.get_book_header(), "Books");
        Assert.assertEquals(testPackage.steps.get_books_list().size(), 20);*//*


    }

    @Test
    public void checkTitleBook() {
        steps.open_main_page();
        steps.open_books_catalog();
        steps.should_be_books_on_page(20);
        steps.check_that_list_have_book_on_title("The shellcoder's handbook", steps.get_all_books_titles_on_page());
        //Assert.assertTrue(testPackage.steps.find_book_in_list("Hacking Exposed Wireless",testPackage.steps.get_all_books_titles_on_page()));
    }
*/

/*    @Test
    public void checkCorrectPrice() {
        mainPage.openBooksCatalog();
        ArrayList<Double> list = mainPage.getBooksPriceAsDigit();
        Assert.assertEquals(list.get(0), 9.99);
        Assert.assertTrue(list.get(list.size() - 1) > list.get(0));
    }*/
/*

    @Test
    public void addBookToBasketAndCheck() {
        String bookTitle = "Coders at Work";
        String expectedResult = String.format("%s был добавлен в вашу корзину.", bookTitle);
        mainPage.openBooksCatalog();
        mainPage.addBookToBasketByTitle(bookTitle);
        String actualResult = mainPage.checkSuccessAddedIntoBasket();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkThatAllBooksHavePrice() {
        mainPage.openBooksCatalog();
        Assert.assertEquals(mainPage.getBooksPriceAsString().size(), 20);
    }

    */
/*    @Test
        public void checkPaginationButton() throws InterruptedException {
            mainPage.openBooksCatalog();
            JavascriptExecutor jse = (JavascriptExecutor);
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Assert.assertFalse(mainPage.checkPaginationBack());
            Assert.assertTrue(mainPage.checkPaginationForward());
            mainPage.clickPagination("forward");
            Assert.assertTrue(mainPage.checkPaginationBack());
        }*//*

    @Test
    public void checkSearchResult() {
        mainPage.sendInSearchField("Hackers");
        Assert.assertEquals(mainPage.getBooksList().size(), 12);
    }
*/


}
