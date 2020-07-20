package com.endava.tutorialNinja.pageObject;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.endava.tutorialNinja.EnvReader;

public class CompareProductPage {

	private static final String baseUrl = EnvReader.getBaseUrl() + "compare";
	private WebDriver driver;
	private By comparisonProductName = By.cssSelector( "tbody:nth-child(2) > tr:nth-child(1) > td  a" );



	public CompareProductPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}


	public Set getProductNameInComparison () {
		List <WebElement> comparisonNamesListElements = driver.findElements( comparisonProductName );
		Set<String> comparisonNames = new TreeSet<>(  );

		for ( WebElement comparisonNameElement : comparisonNamesListElements) {
			comparisonNames.add( comparisonNameElement.getText() );

		}
		return comparisonNames;
	}

	public int getNumberOfProductsInComparison(){

			return getProductNameInComparison().size();

	}

}
