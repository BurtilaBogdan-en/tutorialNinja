package com.endava.tutorialNinja;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

//import com.endava.sockShop.dataGeneration.DataGeneration;
import com.endava.tutorialNinja.manager.DriverManager;

public class TestBaseClass {

	protected WebDriver driver;
//	protected Faker faker = new Faker();
//	protected DataGeneration dataGeneration = new DataGeneration();

	@BeforeEach
	public void setupDriver() {
		driver = DriverManager.getWebDriver();

	}

	@AfterEach
	public void tearDownDriver() throws Exception {
		Thread.sleep( 2000 );
//		takeSnapShot( driver, "C://Users//bburtila//Desktop/ss.jpeg" );
//		driver.quit();
	}

//	public void takeSnapShot( WebDriver webdriver, String fileWithPath ) throws Exception {
//		TakesScreenshot scrShot = ( (TakesScreenshot) webdriver );
//		File SrcFile = scrShot.getScreenshotAs( OutputType.FILE );
//		File DestFile = new File( fileWithPath );
//		FileUtils.copyFile( SrcFile, DestFile );

//	}

}
