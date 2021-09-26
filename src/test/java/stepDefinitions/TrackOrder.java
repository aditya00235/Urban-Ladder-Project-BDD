package stepDefinitions;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageobject.HomePage;
import pageobject.TrackOrderPage;
import reusablecomponent.Base;
import reusablecomponent.GeneratePropertiesObject;

public class TrackOrder 
{
	WebDriver driver;
	Properties prop;
	Logger log=Logger.getLogger(SearchProducts.class);
	boolean result;
	boolean result2;
	
	@Given("^Opens the browser$")
	public void opens_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver=Base.initializeDriver();
	    driver.manage().window().maximize();
	}

	@Given("^Go to URL$")
	public void go_to_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		prop=GeneratePropertiesObject.generatePropObject();
	    driver.get(prop.getProperty("url"));
	}

	@When("^user click on track order icon$")
	public void user_click_on_track_order_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    result =HomePage.trackOrderIcon(driver, log);
	    
	}

	@When("^fills the details \"([^\"]*)\" and \"([^\"]*)\" on track order page$")
	public void fills_the_details_and_on_track_order_page(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   if(result)
	   {
		   result2=TrackOrderPage.trackOrder(driver, arg1, arg2, log);
	   }
	}

	@Then("^It shows the tracking details$")
	public void it_shows_the_tracking_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(true, result2);
	}

	@Then("^closes browsers$")
	public void closes_browsers() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.close();
	    driver=null;
	}

}
