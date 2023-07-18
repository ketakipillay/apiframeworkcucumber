package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


/**
 * features attribute - Tells the run in which folder to find the feature files
 * glue - gives the package name in which step definitions are placed
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/",
glue={"stepDefinitions","hooks"},
plugin= {"utils.MyTestListener",
		"pretty:target/cucumber/cucumber.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"html:target/cucumber/report",
"json:target/cucumber/cucumber.json"})
public class TestRunner {

}
