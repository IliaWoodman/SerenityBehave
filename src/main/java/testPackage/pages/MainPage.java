package testPackage.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://selenium1py.pythonanywhere.com/ru/")
public class MainPage extends PageObject {


    // WebDriver driver;
/*
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }*/
    //language
    private By languageSelect = By.xpath("//select");
    private By executeLanguageButton = By.xpath("(//button)[1]");
    private By languageList = By.xpath("//option");//for findElements
    private String language = ("//option[@value = '%s']");


    private By registrationLink = By.xpath("//a[@id = 'login_link']");
    private By linkToMainPage = By.xpath("//a[text()='Oscar']");
    private By linkToBasket = By.xpath("(//a[text()='Посмотреть корзину'])[1]");
    private By allGoodsLink = By.xpath("(//a[text()='Все товары'])[1]");
    private By clothingLink = By.xpath("(//a[text()='Clothing'])[1]");
    private By offerLink = By.xpath("(//a[text()='Предложения'])[1]");
    private By searchField = By.xpath("//input[@id = 'id_q']");
    private By searchButton = By.xpath("//input[@value = 'Найти']");
    private By basketText = By.xpath("(//strong)[1]");
    //Books
    private By booksLink = By.xpath("(//a[text()='Books'])[1]");
    private By booksListOnPage = By.xpath("//li[@class = 'col-xs-6 col-sm-4 col-md-3 col-lg-3']");
    private By header = By.xpath("//h1");
    private By bookTitle = By.xpath("//li[@class = 'col-xs-6 col-sm-4 col-md-3 col-lg-3']/article/h3/a");
    private String bookTitleAsString = ("//li[@class = 'col-xs-6 col-sm-4 col-md-3 col-lg-3']/article/h3/a[@title = \"%s\"]");
    private String buttonAddToBasketByTitle = "//li[@class = 'col-xs-6 col-sm-4 col-md-3 col-lg-3']/article/h3/a[@title = \"%s\"]/ancestor::li//div[2]/form/button";
    public By priceBooksList = By.xpath("//li[@class = 'col-xs-6 col-sm-4 col-md-3 col-lg-3']/article/div[2]/p[1]");
    private By successBookTitle = By.xpath("(//div[@class = 'alertinner ']/strong)[1]");
    private By successNotification = By.xpath("(//div[@class = 'alertinner '])[1]");
    //Pagination
    public By paginationForward = By.xpath("//a[text() = 'вперед']");
    public By paginationBack = By.xpath("//a[text() = 'назад']");


    /////////////////////////////////////////Language/////////////////////////////////////////////////////////////////////////
    public void openSelect(){
        find(languageList).click();
    }
    public void chooseLanguage(String lang){
        find(By.xpath(String.format(language,lang))).click();
    }
    public void applyChoseLanguage(){
        find(executeLanguageButton).click();
    }
    public List<WebElementFacade> getLanguageList(){
        return findAll(languageList);
    }

    /////////////////////////////////////////Books/////////////////////////////////////////////////////////////////////////
    public void openBooksCatalog(){
        find(booksLink).click();
    }

    public List<WebElementFacade> getBooksList(){
        return findAll(booksListOnPage);
    }
    public String getBookHeader(){
        return find(header).getText();
    }
    public ArrayList<String> getBooksTitlesList(){
        List<WebElementFacade> list = new ArrayList<WebElementFacade>();
        list = findAll(bookTitle);
        ArrayList<String> titlesList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            titlesList.add(list.get(i).getText());
        }
        return titlesList;
    }
    public boolean findBookInList(String title, ArrayList<String> list){
        boolean result = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(title)){
                result = true;
            }
        }
        return result;
    }
    public ArrayList<String> getBooksPriceAsString(){
        List<WebElementFacade> list = new ArrayList<WebElementFacade>();
        ArrayList<String> priceList = new ArrayList<String>();
        String[] temp = new String[2];
        list = findAll(priceBooksList);
        for (int i = 0; i < list.size(); i++) {
            String[] s1 = (list.get(i).getText().split("[ ]"));
            //priceList.add(String.format("Price book №%d: ", i + 1) + s1[0].replace(",","."));
            priceList.add(s1[0].replace(",","."));
        }
        return priceList;
    }
    public ArrayList<Double> getBooksPriceAsDigit(){
        List<WebElementFacade> list = new ArrayList<WebElementFacade>();
        ArrayList<Double> priceList = new ArrayList<Double>();
        String[] temp = new String[2];
        list = findAll(priceBooksList);
        for (int i = 0; i < list.size(); i++) {
            String[] s1 = (list.get(i).getText().split("[ ]"));
            //priceList.add(String.format("Price book №%d: ", i + 1) + s1[0].replace(",","."));
            priceList.add(Double.parseDouble(s1[0].replace(",",".")));
        }
        return priceList;
    }

    public void addBookToBasketByTitle(String title){
        find(By.xpath(String.format(buttonAddToBasketByTitle,title))).click();
    }
    public String checkSuccessAddedIntoBasket(){
        String success = find(successNotification).getText().replaceAll("\\s{2,}", "");
        return success;
    }
    public void openBookByTitle(String title){
        find(By.xpath(String.format(bookTitleAsString,title))).click();
    }
    /////////////////////////////////////////Search/////////////////////////////////////////////////////////////////////////
    public void sendInSearchField(String title){
        find(searchField).sendKeys(title);
        find(searchField).sendKeys(Keys.ENTER);
    }
    /////////////////////////////////////////Pagination/////////////////////////////////////////////////////////////////////////

    public boolean checkPaginationBack(){
        if (find(paginationBack).isDisplayed()){
            return true;
        }else{return false;}

    }
    public boolean checkPaginationForward(){
        if (find(paginationForward).isDisplayed()){
            return true;
        }else{return false;}
    }
    public void clickPagination(String direction){
        if (direction.equals("forward")){
            find(paginationForward).click();
        }
        if (direction.equals("back")){
            find(paginationBack).click();
        }

    }



/*

    /////////////////////////////////////////BasketPage/////////////////////////////////////////////////////////////////////////
    public void goToBasket(){
        find(linkToBasket).click();
    }
    public String getBasketText(){
        return find(basketText).getText();
    }
    public BasketPage transferToBasket(){
        find(linkToBasket).click();
        return new BasketPage(driver);
    }
    /////////////////////////////////////////RegistrationPage/////////////////////////////////////////////////////////////////////////
    public RegistrationPage transferToRegistration(){
        find(registrationLink).click();
        return new RegistrationPage(driver);
    }
*/

}
