package com.endava.tutorialNinja.pageObject;
import org.openqa.selenium.WebDriver;

import com.endava.tutorialNinja.EnvReader;

public class ProductCameraPage extends GeneralProductPage{

	public static final String baseUrl = EnvReader.getBaseUrl() + "category&path=33";

	public ProductCameraPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}

}
