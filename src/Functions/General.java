package Functions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.AmazonHomePage;
import Pages.AmazonProductPage;
import Pages.FlipkartHomePage;
import Pages.FlipkartProductListPage;

public class General 
{
	WebDriver driver;
	
	public General(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void ChildWindow()
	{
		for (String childWindow : driver.getWindowHandles()) 
		{
			driver.switchTo().window(childWindow);
		}
	}
	
	public void ParentWindow()
	{
		for (String parentWindow : driver.getWindowHandles()) 
		{
			driver.switchTo().window(parentWindow);
		}
	}
	
	public void WaitUntilTextAppearsInElement(By element, String text)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.attributeContains(element,"str",text));
		
	}
	
	
	public String PrintPriceOfTheItemInFlipkart()
    {    	
		
		driver.get(Urls.FLIPKART_URL); 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    String productName = "milton duo dlx 1000 thermosteel";
	    
	    //2. Search for any item
	    FlipkartHomePage fkHome = new FlipkartHomePage(driver);
	    fkHome.closeOverlay();
	    fkHome.search(productName);
	    
	    //3. Click on the First Item in the list.
	    FlipkartProductListPage fkPrdt = new FlipkartProductListPage(driver);
	    fkPrdt.firstProduct();
	    
	    General general = new General(driver);
	    general.ChildWindow();  //redirects to child window
	    
	    //4. Print Price of the Item
	    String price = fkPrdt.priceInFlipkart();
	    System.out.println("Price of the item in Flipkart:" + price);
	    
	    return price;   
    	
    }
	
	public String PrintPriceOfTheItemInAmazon()
    {    	
	    
		driver.get(Urls.AMAZON_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    String productName = "milton duo dlx 1000 thermosteel";
	    
	    //2. Search for any item
	    AmazonHomePage amHome = new AmazonHomePage(driver);	    
	    amHome.search(productName);
	    
	    //3. Click on the same Item in the list.
	    AmazonProductPage amPrdt = new AmazonProductPage(driver);
	    amPrdt.productSelection();
	    
	    General general = new General(driver);
	    general.ChildWindow();  //redirects to child window
	    
	    //4. Print Price of the Item
	    String price = amPrdt.priceInAmazon();
	    System.out.println("Price of the item in Amazon:" + price);
	    
	    return price;
	    	        	
    	
    }
	
	public void FindTheCheaperRateForTheProduct()
	{
		
		General general = new General(driver);
		
		
		String priceInAmazon = general.PrintPriceOfTheItemInAmazon();
		int priceInAm = Integer.parseInt(priceInAmazon.replaceAll(",", ""));
		
		driver.close();
		general.ParentWindow();
		
		String priceInFlipkart = general.PrintPriceOfTheItemInFlipkart();
		int priceInFk = Integer.parseInt(priceInFlipkart.replaceAll(",", ""));
		
		if(priceInAm > priceInFk)
		{
			
			System.out.println("Selected Item Has Cheaper Rate In Flipkart");
		}
		else if(priceInAm < priceInFk)
		{
			
			System.out.println("Selected Item Has Cheaper Rate In Amazon");
		}
		else
		{
			System.out.println("Selected Item Has Same Rate In Flipkart and Amazon");
		}
			
		
	}

}
