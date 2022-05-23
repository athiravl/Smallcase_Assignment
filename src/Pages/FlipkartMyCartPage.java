package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartMyCartPage 
{
	
	WebDriver driver;
	   
	   //Creating constructor to initialize the driver
	   public FlipkartMyCartPage(WebDriver driver)
	   {
		   this.driver = driver;
		   
	   }
	
	By addButton = By.xpath("(//button[@class='_23FHuj'])[2]");
    By totalPriceInFk = By.xpath("//span[@class='_2-ut7f _1WpvJ7']");    
    
    public By increasedQntyValue = By.xpath("//div[@class='_1AtVbE col-12-12']//input");
    
    // Method to increase quantity
    public void increaseQuantity()
    {
    	
    	driver.findElement(addButton).click();
    	
    }
    
    //Method to get the total price of the product after addition
    public String totalPriceOfProduct()
    {
    	
    	String totalPrice = driver.findElement(totalPriceInFk).getText();
    	String priceValue = totalPrice.substring(totalPrice.length() - 5);
    	return priceValue;
    	
    }
    
	
}
