package uistore;

import org.openqa.selenium.By;

public class CartPageUI 
{
	public static By checkoutButton=By.id("checkout-link");
	public static By checkoutAmount=By.xpath("//div[@id='checkout-summary'] //li[@class='advance-amount highlight']");
	public static By checkoutProducts=By.xpath("//div[@class='product-name']");
}
