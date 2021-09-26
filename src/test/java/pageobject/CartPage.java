package pageobject;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablecomponent.ReusableMethods;
import uistore.CartPageUI;
import uistore.HomePageUI;

public class CartPage 
{
	public static boolean checkoutProducts(WebDriver driver,Logger log,String email,String password) throws Exception
	{
		
				if(ReusableMethods.click(CartPageUI.checkoutButton, driver))
				{
					Thread.sleep(6000L);
					ArrayList<WebElement> checkoutProductsInCart=(ArrayList<WebElement>) driver.findElements(CartPageUI.checkoutProducts);
					ReusableMethods.timelaps(driver);
					for(int i=1;i<checkoutProductsInCart.size();i++)
					{
						log.info("Product "+ i +" : "+checkoutProductsInCart.get(i).getAttribute("outerText"));
					}
					ReusableMethods.timelaps(driver);
					if(ReusableMethods.getElements(CartPageUI.checkoutAmount, driver))
					{
					String finalPrice=driver.findElement(CartPageUI.checkoutAmount).getText();
					log.info("Total price at Checkout: "+finalPrice);
					return true;
					}
					
				}
			
		return false;
	}
}
