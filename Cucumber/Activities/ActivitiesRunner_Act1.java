package testRunner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "features",
	    glue = {"stepDefinitions"},
	    tags = "@activity1",
	    plugin = {"pretty"},
	    monochrome = true
	)
public class ActivitiesRunner_Act1 {

}
