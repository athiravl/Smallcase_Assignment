package Pages;

import org.openqa.selenium.By;

public class AmazonProductPage 
{

	By product = By.xpath("(//span[.='Milton Duo DLX 1000 Thermosteel 24 Hours Hot and Cold Water Bottle, 1 Litre, Silver'])[1]");
	By priceOfProductInAmazon = By.xpath("//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']");
	By addToCartButtonInAmazon = By.id("add-to-cart-button");
	By goToCartButtonInAmazon = By.id("sw-gtc");
	
}
