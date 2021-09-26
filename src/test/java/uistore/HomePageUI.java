package uistore;

import org.openqa.selenium.By;

public class HomePageUI 
{
	public static By searchBox=By.id("search");
	public static By searchButton=By.id("search_button");
	public static By trackOrder=By.linkText("Track Order");
	public static By navBar=By.id("topnav_wrapper");
	public static By helpIcon=By.linkText("Help");
	public static By bulkOrder=By.linkText("Bulk Orders");
	public static By navItems=By.xpath("//span[@class='topnav_itemname']");
	public static By paymentMethodsAvailable=By.xpath("//img[@class='we-accept']");
	public static By weAccept=By.xpath("(//div[@class='category-heading'])[6]");
	public static By customerStories=By.xpath("//a[@class='button button-with-border']");
	public static By cart=By.xpath("(//span[@class='header-icon'])[2]");
	public static By wishList=By.xpath("(//span[@class='header-icon'])[1]");
}
