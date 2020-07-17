package com.endava.tutorialNinja.pageObject;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.endava.tutorialNinja.EnvReader;

public class ProductCameraPage {

	public static final String baseUrl = EnvReader.getBaseUrl() + "category&path=33";

	private WebDriver driver;

	private By productList = By.cssSelector( "div.product-thumb" );
	private By productName = By.cssSelector( "div.product-thumb div.caption a" );
	private By addToCompareButton = By.cssSelector( "div.button-group button:nth-child(3)" );
	private By productCompareButton = By.cssSelector( "div.form-group a");

	public ProductCameraPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}


	public void addToCompare (String... productCameraNameList){
		WebDriverWait webDriverWait = new WebDriverWait( driver,5 );
		List<WebElement> productCameraListElements = webDriverWait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( productList ));

		for ( WebElement productCameraElement : productCameraListElements) {
			if ( Arrays.asList( productCameraNameList ).contains( productCameraElement.findElement( productName ).getText() ));
			productCameraElement.findElement( addToCompareButton ).click();
		}
	}

	public ProductComparePage accessProductComparePage(){
		WebDriverWait webDriverWait = new WebDriverWait( driver,10 );
		webDriverWait.until( ExpectedConditions.visibilityOfElementLocated( productCompareButton ) ).click();

		ProductComparePage productComparePage = new ProductComparePage(driver);
		return productComparePage;
	}

}
