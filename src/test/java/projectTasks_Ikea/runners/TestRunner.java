package projectTasks_Ikea.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import projectTasks_Ikea.utilities.Driver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "projectTasks_Ikea/step_definitions",
        dryRun = false
)
public class TestRunner {

    @AfterClass
    public static void teardown() {
        Driver.closeDriver();
    }
}
