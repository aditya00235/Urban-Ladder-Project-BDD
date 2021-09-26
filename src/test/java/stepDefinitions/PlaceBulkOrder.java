package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobject.BulkOrderPage;
import pageobject.HomePage;
import reusablecomponent.Base;
import reusablecomponent.GeneratePropertiesObject;

public class PlaceBulkOrder 
{
	WebDriver driver;
	Properties prop;
	Logger log=Logger.getLogger(SearchProducts.class);
	boolean result;
	boolean result2;
	
	@Given("^Open browser$")
	public void open_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=Base.initializeDriver();
	    driver.manage().window().maximize();
	}

	@Given("^Go to the URL$")
	public void go_to_the_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		prop=GeneratePropertiesObject.generatePropObject();
	    driver.get(prop.getProperty("url"));
	}

	@When("^user click on bulk order section$")
	public void user_click_on_bulk_order_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    result=HomePage.clickBulkOrder(driver, log);
	}

	@Then("^It should show the form to be filled to contact for bulk order$")
	public void it_should_show_the_form_to_be_filled_to_contact_for_bulk_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    if(result)
	    {
	    	result2=BulkOrderPage.placeBulkOrder(driver, log);
	    }
	    Assert.assertEquals(true,result2);
	}

	@Then("^close the browser$")
	public void close_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    driver=null;
	}
}
