package in.co.mercuryTravels.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.implementation.CommonDriver;
import in.co.mercuryTravels.pages.HomePage;

public class BaseTest {
	
	// Initialize home page 
	
	CommonDriver cmnDriver;
	String browserType = "chrome";
	String url = "https://www.mercurytravels.co.in/";
	HomePage homePage;
	private WebDriver driver;

	@BeforeClass
	public void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver(browserType);
		cmnDriver.setPageloadTimeout(60);
		cmnDriver.setElementDetectionTimeout(20);
		cmnDriver.navigateToUrl(url);
		homePage = new HomePage(driver);
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowser();
	}
}
