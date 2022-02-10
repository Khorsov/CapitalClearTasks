package projectTasks_Ikea.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectTasks_Ikea.utilities.Driver;

public class MainPage {
    public MainPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    static String product1 = "sofa";
    static String product2 = "table";
    public static String addProduct1() {
        String result = product1;
        return result;
    }
    public static String addProduct2() {
        String rst = product2;
        return rst;
    }
    public String getActualTitleName() {
        String str = Driver.getDriver().getTitle();
        return str;
    }
    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchBar;
    @FindBy(xpath = "//*[@id='search-results']/div[1]/section/div/button")
    public WebElement toShoppingCartBtn1;
    @FindBy(xpath = "//*[@id='search-results']/div[3]/section/div/button")
    public WebElement toShoppingCartBtn2;
    @FindBy(xpath = "//span[class='hnf-header__cart-counter']")
    public WebElement shoppingCartBtn;
}
