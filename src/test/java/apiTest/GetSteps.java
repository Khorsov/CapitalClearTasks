package apiTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetSteps {
    @Given("I perform operation with GET endpoint {string}")
    public void iPerformOperationWithGETEndpoint(String url)throws Throwable {
    }

    @And("I use given query parameters")
    public void iUseGivenQueryParameters()throws Throwable {
        BDDStyledMethod.SimpleGetRequest();
    }

    @Then("I should see the list of data")
    public void iShouldSeeTheListOfData()throws Throwable {
    }


}
