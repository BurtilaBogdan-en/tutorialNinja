package com.endava.tutorialNinja.pageObject;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralProductPage {


	protected WebDriver driver;

	protected By productList = By.cssSelector( "div.product-thumb" );
	protected By productName = By.cssSelector( "div.product-thumb div.caption a" );
	protected By addToCompareButton = By.cssSelector( "div.button-group button:nth-child(3)" );
	protected By productCompareButton = By.cssSelector( "div.form-group a");
	protected By body = By.cssSelector( "body" );


	public void addToCompare (String... productNamesList) throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait( driver,10 );
		List<WebElement> productListElements = webDriverWait.until( ExpectedConditions.visibilityOfAllElementsLocatedBy( productList ));

		for ( WebElement productElement : productListElements) {
			driver.findElement( body ).sendKeys( Keys.PAGE_DOWN );
			Thread.sleep( 2000 );
			if ( Arrays.asList( productNamesList ).contains( productElement.findElement( productName ).getText()));
			productElement.findElement( addToCompareButton ).click();

		}
	}

	public CompareProductPage accessProductComparePage(){
		WebDriverWait webDriverWait = new WebDriverWait( driver,50 );
		webDriverWait.until( ExpectedConditions.visibilityOfElementLocated( productCompareButton ) ).click();

		CompareProductPage compareProductPage = new CompareProductPage(driver);
		return compareProductPage;
	}

}
