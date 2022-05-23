package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductPage 
{
	
	WebDriver driver;
	   
	   //Creating constructor to initialize the driver
	   public AmazonProductPage(WebDriver driver)
	   {
		   this.driver = driver;
		   
	   }

	By product = By.xpath("(//span[.='Milton Duo DLX 1000 Thermosteel 24 Hours Hot and Cold Water Bottle, 1 Litre, Silver'])[1]");
	By priceOfProductInAmazon = By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
	By addToCartButtonInAmazon = By.id("add-to-cart-button");
	By goToCartButtonInAmazon = By.id("sw-gtc");
	
	
	//Method to select the product
    public void productSelection()
    {
    	driver.findElement(product).click();
    	
    }
    
    //Method to fetch the price of product in Amazon
    public String priceInAmazon()
    {
    	String prdtPriceInAmazon = driver.findElement(priceOfProductInAmazon).getText();
    	return prdtPriceInAmazon;
    }
    
    //Method to add to cart
    public void addToCartInAmazon()
    {
    	driver.findElement(addToCartButtonInAmazon).click();
    	
    }
    
    
    
}
