package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
	public static WebDriver driver = null;	
	
	@BeforeTest
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	    
	}
	
	@BeforeMethod
	public void navigation()
	{
        
		driver = new ChromeDriver();
	    driver.manage().window().maximize();	 
		
	}
	
	
    @Test(priority = 1)
	public void PrintPriceAfterAdditionOfQuantity() throws InterruptedException
	{
		   
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    General general = new General(driver);
	    general.Navigate(Urls.FLIPKART_URL);
    	general.PrintPriceOfTheItemInFlipkart();
	    
	    // Add to cart in guest mode and Go to cart.
    	FlipkartProductListPage fkPrdt = new FlipkartProductListPage(driver);
	    fkPrdt.addToCartInFlipkart();
	    
	    // Increase Quantity by 1.
	    FlipkartMyCartPage cart = new FlipkartMyCartPage(driver);
	    cart.increaseQuantity();
	    
	    Thread.sleep(general.Sleep);
	    
	    //general.WaitUntilTextAppearsInElement(cart.increasedQntyValue,"2");
	    
	    // Print the Price after addition of Quantity.
	    String totalPrice = cart.totalPriceOfProduct();
	    System.out.println("Price of the item in Flipkart after increasing the quantity:" + totalPrice);
	    
		
	}
    
    @Test(priority = 2)
    public void VerifyWhichSiteIsGivingCheaperRate()
    {
    	    	 
	    
    	General general = new General(driver);
    	general.Navigate(Urls.AMAZON_URL);
    	
    	//Compare prices of the item in amazon and flipkart
    	general.FindTheCheaperRateForTheProduct();   	
    	
    	
    }   

    @AfterMethod
    public void tearDown()
    {
    	
    	driver.quit();
    	
    }
}
