package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",
glue= {"stepDefinition"},
plugin = {"pretty",
		 "json:target/report.json",
		 "junit:target/report.xml"
})



public class TestRunner {

}
