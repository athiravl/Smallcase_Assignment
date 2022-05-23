package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonShoppingCartPage 
{
	
	   WebDriver driver;
	   
	   //Creating constructor to initialize the driver
	   public AmazonShoppingCartPage(WebDriver driver)
	   {
		   this.driver = driver;
		   
	   }
	   

	   By priceOfProductInCart = By.xpath("//span[@class='a-price sc-product-price']//span[@class='a-price-whole']");
	   
	   
	   //Method to fetch the price of product in Amazon
	   public String totalPriceInAmazon()
	   {
	    	String prdtPriceInAmazon = driver.findElement(priceOfProductInCart).getText();
	    	return prdtPriceInAmazon;
	   }
	
}
