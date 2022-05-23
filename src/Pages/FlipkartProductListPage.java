package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlipkartProductListPage 
{
	
	WebDriver driver;
	   
	   //Creating constructor to initialize the driver
	   public FlipkartProductListPage(WebDriver driver)
	   {
		   this.driver = driver;
		   
	   }
	
	By firstProductInList = By.xpath("//div[@data-id='BOTDYUHPVF39FYFZ']");
	By priceOfProductInFk = By.xpath("//div[@class='_30jeq3 _16Jk6d']");
    By addToCartButtonInFk = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
    //Method to select first product
    public void firstProduct()
    {
    	driver.findElement(firstProductInList).click();
    	
    }
    
    //Method to get the price of the product
    public String priceInFlipkart()
    {
    	
    	String prdtPriceInFk = driver.findElement(priceOfProductInFk).getText();
    	String priceval = prdtPriceInFk.substring(prdtPriceInFk.length() - 5);
    	return priceval;
    	
    }
    
    //Method for add to cart
    public void addToCartInFlipkart()
    {
    	driver.findElement(addToCartButtonInFk).click();
    	
    }
    
    
}
