package com.endava.tutorialNinja.pageObject;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.tutorialNinja.EnvReader;


public class ProductLaptopsPage {

	public static final String baseUrl = EnvReader.getBaseUrl() + "category&path=18";

	private WebDriver driver;

	private By productList = By.cssSelector( "div.product-thumb" );
	private By productName = By.cssSelector( "div.product-thumb div.caption a" );
	private By addToCompareButton = By.cssSelector( "div.button-group button:nth-child(3)" );
	private By productCompareButton = By.cssSelector( "div.form-group a");
	private By body = By.cssSelector( "body" );

	public ProductLaptopsPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}


		public void addToCompare (String... productLaptopsNameList) throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait( driver,10 );
		List<WebElement> productLaptopListElements = webDriverWait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( productList ));

		for ( WebElement productLaptopElement : productLaptopListElements) {
			driver.findElement( body ).sendKeys( Keys.PAGE_DOWN );
			Thread.sleep( 2000 );
		if ( Arrays.asList( productLaptopsNameList ).contains( productLaptopElement.findElement( productName ).getText() ));
			productLaptopElement.findElement( addToCompareButton ).click();

		}
	}

	public ProductComparePage accessProductComparePage(){
		WebDriverWait webDriverWait = new WebDriverWait( driver,50 );
		webDriverWait.until( ExpectedConditions.visibilityOfElementLocated( productCompareButton ) ).click();

		ProductComparePage productComparePage = new ProductComparePage(driver);
		return productComparePage;
	}

}
