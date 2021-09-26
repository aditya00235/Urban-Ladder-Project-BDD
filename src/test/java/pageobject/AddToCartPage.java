package pageobject;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablecomponent.ReusableMethods;
import uistore.AddToCartPageUI;
import uistore.HomePageUI;
import uistore.TrackOrderUI;

public class AddToCartPage 
{
	public static boolean searchforAddingInCart(WebDriver driver,Logger log,String email,String password,String searchitem) throws IOException
	{
		log.info("Product Searched");
		ReusableMethods.timelaps(driver);
		driver.findElement(AddToCartPageUI.productAfterSearch).click();
		ReusableMethods.timelaps(driver);
		driver.findElement(AddToCartPageUI.addToCartButton).click();
		log.info("Add to cart button clicked");
		ReusableMethods.timelaps(driver);
		boolean cartprogress=driver.findElement(AddToCartPageUI.checkoutProgressBar).isDisplayed();
		return cartprogress;
		
	}
	public static boolean cartRun(WebDriver driver,Logger log,String email,String password,String searchitem) throws InterruptedException
	{
		log.info("Cart progress bar displayed");
		Thread.sleep(2000L);
		ArrayList<WebElement> cartListItems=(ArrayList<WebElement>) driver.findElements(AddToCartPageUI.cartItems);
		for(int i=0;i<cartListItems.size();i++)
		{
			log.info("Cart item is "+cartListItems.get(i).getText());
		}
		
		return true;
	}
	
	
	public static boolean addProductToCart(WebDriver driver,Logger log,String email,String password,String searchitem) throws Exception
	{
		boolean result=false;
		if(ReusableMethods.getElements(TrackOrderUI.loginToTrackAllOrderButton, driver))
		{
		if(LoginPage.logIn(driver, log, email, password))
		{
			log.info("Successfully logged in");
			if(HomePage.searchItem(driver, searchitem, log))
			{
				boolean cartprogress=searchforAddingInCart(driver,log,email,password,searchitem);
				if(cartprogress)
				{
					return cartRun(driver,log,email,password,searchitem);
				}
				
			}
		}
		
		
		}
		else {
			if(HomePage.searchItem(driver, searchitem, log))
			{
				boolean cartprogress=searchforAddingInCart(driver,log,email,password,searchitem);
				if(cartprogress)
				{
					return cartRun(driver,log,email,password,searchitem);
				}
				
			}
			
		}
		
		return result;
	}

}
