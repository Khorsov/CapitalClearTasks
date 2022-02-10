package projectTasks_Ikea.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectTasks_Ikea.pages.ShoppingCartPage;
import projectTasks_Ikea.utilities.BrowserUtils;
import projectTasks_Ikea.utilities.Driver;

public class ShoppingCartDiscountCodeNegative extends ShoppingCartPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    Actions action = new Actions(Driver.getDriver());
    JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
    boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='hnf-overlay']")));


    @Given("User on shopping cart page")
    public void user_on_can_the_main_page() {
        Driver.getDriver().get("https://www.ikea.com/us/en/shoppingcart/");
    }

    @Then("User can see correct amount of products added")
    public void user_can_see_correct_amount_of_products_added() {
        BrowserUtils.sleep(5);
        WebElement cart_icon = Driver.getDriver().findElement(By.xpath("/html/body/header/div/div/div/ul/li[5]/a/span"));
        //validate that 2 items are added to the cart
        //Assert.assertNotEquals( cart_icon.getAttribute("data-count") , "2");
        Assert.assertEquals(actualProductList.size(),expectedListOfProducts().size());
    }

    @Given("User can see Use A Discount Code button")
    public void user_can_see_use_a_discount_code_button() {
        if(invisible){
            useDiscountCodeBtn.isDisplayed();
        }
    }

    @When("User clicks on discount code button")
    public void user_clicks_on_discount_code_button() {
        //Click on "Use a discount code" link
        if(invisible){
            useDiscountCodeBtn.click();
        }
    }

    @When("User add incorrect discount code")
    public void user_add_incorrect_discount_code() {
        executor.executeScript("arguments[0].scrollIntoView(true);",Driver.getDriver().findElement(By.xpath("//*[@id='discountCode']")));
        BrowserUtils.sleep(5);
        action.moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id='discountCode']")),5,5).perform();
        inputDiscountCode.sendKeys(fakerData());
    }

    @When("User clicks Apply discount")
    public void user_clicks_apply_discount() {
        //click "Apply discount" button
        if(invisible){
            applyDiscountBtn.click();
        }
    }

    @Then("User can see invalid coupon code error message is displayed")
    public void user_can_see_invalid_coupon_code_error_message_is_displayed() {
        //Validate that "invalid coupon code" error message is displayed
        if (invisible) {
            Assert.assertTrue( invalidCouponMsg.isDisplayed() );
        }
    }

}
