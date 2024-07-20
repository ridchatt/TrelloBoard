package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features/TrelloCRUDAPI.feature",
    glue = {"stepDefinitions"},
    monochrome=true,
    tags= "@api and @positive",
    plugin = {"pretty", "html:target/index.html"}
)
public class TestRunnerAPI {

}
