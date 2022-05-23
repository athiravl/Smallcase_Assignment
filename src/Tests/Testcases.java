package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Functions.General;
import Functions.Urls;
import Pages.AmazonHomePage;
import Pages.AmazonProductPage;
import Pages.FlipkartHomePage;
import Pages.FlipkartMyCartPage;
import Pages.FlipkartProductListPage;

public class Testcases 
{
		
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	    
	}
	
	
    @Test(priority = 1)
	public void PrintPriceAfterAdditionOfQuantity() throws InterruptedException
	{
		
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();	     
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    General general = new General(driver);
    	general.PrintPriceOfTheItemInFlipkart();
	    
	    // Add to cart in guest mode and Go to cart.
    	FlipkartProductListPage fkPrdt = new FlipkartProductListPage(driver);
	    fkPrdt.addToCartInFlipkart();
	    
	    // Increase Quantity by 1.
	    FlipkartMyCartPage cart = new FlipkartMyCartPage(driver);
	    cart.increaseQuantity();
	    
	    Thread.sleep(10000);
	    
	    //general.WaitUntilTextAppearsInElement(cart.increasedQntyValue,"2");
	    
	    // Print the Price after addition of Quantity.
	    String totalPrice = cart.totalPriceOfProduct();
	    System.out.println("Price of the item in Flipkart after increasing the quantity:" + totalPrice);
	    
	    driver.quit();
		
	}
    
    @Test(priority = 2)
    public void VerifyWhichSiteIsGivingCheaperRate()
    {
    	
    	
	    WebDriver driver = new ChromeDriver();
	    
	    driver.manage().window().maximize();  
	    
    	General general = new General(driver);
    	
    	//Compare prices of the item in amazon and flipkart
    	general.FindTheCheaperRateForTheProduct();   	
    	
    	driver.quit();
    	
    }   

}
