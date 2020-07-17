package com.endava.tutorialNinja.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.endava.tutorialNinja.EnvReader;

public class ProductComparePage {

	public static final String baseUrl = EnvReader.getBaseUrl() + "compare";
	private WebDriver driver;



	public ProductComparePage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}




}
