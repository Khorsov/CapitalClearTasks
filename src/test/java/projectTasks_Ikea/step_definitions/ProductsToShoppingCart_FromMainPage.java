package projectTasks_Ikea.step_definitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import projectTasks_Ikea.pages.MainPage;
import projectTasks_Ikea.utilities.BrowserUtils;
import projectTasks_Ikea.utilities.ConfigurationReader;
import projectTasks_Ikea.utilities.Driver;

public class ProductsToShoppingCart_FromMainPage extends MainPage {
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),5);
    Actions action = new Actions(Driver.getDriver());
    JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
    boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='hnf-overlay']")));

    @Given("User is on the main page")
    public void user_is_on_the_main_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User is searching sofa out of searchbar")
    public void user_is_searching_sofa_out_of_searchbar() {
        //On the first page of search results, pick the 1st item in the list and add it to the cart
        if(invisible) {
            BrowserUtils.sleep(5);
            searchBar.sendKeys(addProduct1()+ Keys.ENTER);
        }
    }
    @Then("User picks first item from the list")
    public void user_picks_first_item_from_the_list() {
        if(invisible){
            executor.executeScript("arguments[0].scrollIntoView(true);",Driver.getDriver().findElement(By.xpath("//*[@id='search-results']/div[1]")));
            BrowserUtils.sleep(5);
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id='search-results']/div[1]/section/div/button")),20,20).perform();
            Assert.assertTrue(toShoppingCartBtn1.isEnabled());
            toShoppingCartBtn1.click();
        }
    }

    @When("User is searching table out of searchbar")
    public void user_is_searching_table_out_of_searchbar() {
        //Using search bar at the top of the page - search for "table"
        if(invisible){
            searchBar.clear();
            searchBar.sendKeys(addProduct2()+Keys.ENTER);
        }
    }
    @Then("User picks third item from the list")
    public void user_picks_third_item_from_the_list() {
        if(invisible){
            executor.executeScript("arguments[0].scrollIntoView(true);",Driver.getDriver().findElement(By.xpath("//*[@id='search-results']/div[3]")));
            BrowserUtils.sleep(5);
            action.moveToElement(Driver.getDriver().findElement(By.xpath("//*[@id='search-results']/div[3]/section/div/button")),20,20).perform();
            BrowserUtils.sleep(5);
            Assert.assertTrue(toShoppingCartBtn2.isEnabled());
            toShoppingCartBtn2.click();
        }
    }
}

