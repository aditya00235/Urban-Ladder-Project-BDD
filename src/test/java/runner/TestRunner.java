package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src\\test\\resources\\featuresFiles"},
				glue= {"stepDefinitions"}
				)

public class TestRunner {
	
}

//public class TestRunner extends AbstractTestNGCucumberTests{
//
//}
