package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonHomePage 
{
	WebDriver driver;
	   
	   //Creating constructor to initialize the driver
	   public AmazonHomePage(WebDriver driver)
	   {
		   this.driver = driver;
		   
	   }
	   
	
	   By searchBoxInAm = By.id("twotabsearchtextbox");
	   By searchGlassInAm = By.id("nav-search-submit-button");
	
	   //Method to search the item
	   public void search(String product)
	   {
		   driver.findElement(searchBoxInAm).sendKeys(product);
		   driver.findElement(searchGlassInAm).click();
	   }
	   
	   

}
