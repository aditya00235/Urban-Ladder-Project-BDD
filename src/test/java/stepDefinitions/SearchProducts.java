package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobject.HomePage;
import reusablecomponent.Base;
import reusablecomponent.GeneratePropertiesObject;

public class SearchProducts 
{
	WebDriver driver;
	Properties prop;
	Logger log=Logger.getLogger(SearchProducts.class);
	boolean result;
	
	@Given("^User opens the browser$")
	public void user_opens_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver=Base.initializeDriver();
	    driver.manage().window().maximize();
	}

	@Given("^Navigate to the URL$")
	public void navigate_to_the_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		prop=GeneratePropertiesObject.generatePropObject();
	    driver.get(prop.getProperty("url"));
	}

	@When("^user fills the search text box with \"([^\"]*)\" and click on searchbutton$")
	public void user_fills_the_search_text_box_with_and_click_on_searchbutton(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    result=HomePage.searchItem(driver, arg1, log);
	}

	@Then("^It shows the products related to searched item$")
	public void it_shows_the_products_related_to_searched_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(true,result);
	    log.info("Related products shown");
	    
	}

	@Then("^closes browser$")
	public void closes_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    driver=null;
	}
}
