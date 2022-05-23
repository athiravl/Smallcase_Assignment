package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartHomePage 
{
   
   WebDriver driver;
   
   //Creating constructor to initialize the driver
   public FlipkartHomePage(WebDriver driver)
   {
	   this.driver = driver;
	   
   }
	
   By closeBtnInLogin = By.xpath("//button[@class='_2KpZ6l _2doB4z']");
   By searchFieldInFk = By.name("q");
   By searchGlassInFk = By.xpath("//button[@type='submit']");
   By firstProductInList = By.xpath("//div[@data-id='BOTDYUHPVF39FYFZ']");
   
   
   //Method for closing the sign in overlay
   public void closeOverlay()
   {
	   
	   driver.findElement(closeBtnInLogin).click();
   }
   
   //Method to search the item
   public void search(String product)
   {
	   driver.findElement(searchFieldInFk).sendKeys(product);
	   driver.findElement(searchGlassInFk).click();
   }
      
	
}
