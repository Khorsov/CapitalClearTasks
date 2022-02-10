package projectTasks_Ikea.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectTasks_Ikea.utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage {
    public ShoppingCartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = " //div[@data-testid='product_contents_19389835']")
    public WebElement Product1;
    @FindBy(xpath = "//div[@data-testid='product_contents_70294339']")
    public WebElement Product2;
    @FindBy(xpath = "//div[starts-with(@itemtype,'http://schema.org/Product')]")
    public List<WebElement> actualProductList;
    @FindBy(xpath = "//span[@class='cart-ingka-accordion-item-header__title']")
    public WebElement useDiscountCodeBtn;
    ////*[@id="SEC_cart-coupon"]/form/div[3]/button/span/span
    @FindBy(xpath = "//span[contains(text(), 'Apply discount')]")
    public WebElement applyDiscountBtn;
    @FindBy(xpath = "//*[@id='discountCode']")
    public WebElement inputDiscountCode;
    @FindBy(xpath = "//span[contains(text(),'added an invalid coupon code. Please try again')]")
    public WebElement invalidCouponMsg;


    public String fakerData(){
        Faker fakerData = new Faker();
        // How to set up specific amount of char (15)
        String discountCode = String.valueOf(fakerData.code());
        return discountCode;
    }
    public List<WebElement> expectedListOfProducts(){
        List<WebElement> listOfProductsExpected= new ArrayList<>() ;
        listOfProductsExpected.add(Product1);
        listOfProductsExpected.add(Product2);
        return listOfProductsExpected;
    }

}
