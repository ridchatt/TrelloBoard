package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features/TrelloCRUDUI.feature",
    glue = {"stepDefinitions"},
    monochrome=true,
    plugin = {"pretty", "html:target/index.html"},
    tags= "@ui and @positive"
)
public class TestRunnerUI {

}
