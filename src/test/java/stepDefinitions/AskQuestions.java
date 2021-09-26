package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobject.HelpPage;
import pageobject.HomePage;
import reusablecomponent.Base;
import reusablecomponent.GeneratePropertiesObject;

public class AskQuestions 
{
	WebDriver driver;
	Properties prop;
	Logger log=Logger.getLogger(AskQuestions.class);
	boolean result;
	boolean result2;
	
	@Given("^Users opens the browser$")
	public void user_opens_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver=Base.initializeDriver();
	    driver.manage().window().maximize();
	}
	@Given("^Navigate to the Url$")
	public void navigate_to_the_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		prop=GeneratePropertiesObject.generatePropObject();
	    driver.get(prop.getProperty("url"));
	}
	@When("^user click on help icon$")
	public void user_click_on_help_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    result=HomePage.clickHelpSection(driver, log);
	}

	@When("^ask help question \"([^\"]*)\"$")
	public void ask_help_question(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(result)
		{
	    result2=HelpPage.findHelpSection(driver, arg1, log);
		}
	}

	@Then("^It should show the FAQ related to that question$")
	public void it_should_show_the_FAQ_related_to_that_question() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(true, result2);
	}
	@Then("^close browser$")
	public void closes_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    driver=null;
	}
}
