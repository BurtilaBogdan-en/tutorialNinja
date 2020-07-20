package com.endava.tutorialNinja.pageObject;
import org.openqa.selenium.WebDriver;
import com.endava.tutorialNinja.EnvReader;


public class ProductLaptopsPage extends GeneralProductPage{

	public static final String baseUrl = EnvReader.getBaseUrl() + "category&path=18";

	public ProductLaptopsPage( WebDriver driver ) {
		this.driver = driver;
	}

	public void load (){
		driver.get( baseUrl );
	}

}
