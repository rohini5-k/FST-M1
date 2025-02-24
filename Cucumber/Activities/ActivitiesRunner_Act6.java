package testRunner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "features",
	    glue = {"stepDefinitions"},
	    tags = "@activity2",
	    plugin = {"pretty", 
	    		  "html:Reports/HTML_Report.html",
	    		  "junit:Reports/XML_Report.xml",
	    	      "json:Reports/JSON_Report.json"},
	    monochrome = true
	)
public class ActivitiesRunner_Act6 {

}
