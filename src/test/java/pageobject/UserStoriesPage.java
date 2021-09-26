package pageobject;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import reusablecomponent.ReusableMethods;
import uistore.UserStoriesPageUI;

public class UserStoriesPage 
{
	public static boolean checkUserStories(WebDriver driver,Logger log) throws Exception
	{
		if(HomePage.checkUserStories(driver, log))
		{
			ReusableMethods.timelaps(driver);
			ArrayList<WebElement> customerStory=(ArrayList<WebElement>) driver.findElements(UserStoriesPageUI.customerStories);
			for(int i=0;i<customerStory.size();i++)
			{
				log.info("Story "+ i +"  "+customerStory.get(i).getText());
			}
			return true;
		}
		return false;
	}
}
