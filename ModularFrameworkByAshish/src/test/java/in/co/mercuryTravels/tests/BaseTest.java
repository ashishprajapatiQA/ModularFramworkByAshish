package in.co.mercuryTravels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigFileUtils;
import in.co.mercuryTravels.pages.HomePage;

public class BaseTest {
	
	// Initialize home page like basic thing driver, url,browser type , open/close browser  
	
	CommonDriver cmnDriver;
	String browserType;
	String url = "https://www.mercurytravels.co.in/";
	HomePage homePage;
	private WebDriver driver;
	
	static String configFileName;
	static Properties configProperties;
	static {
		try {
			configProperties = ConfigFileUtils.readProperties(configFileName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@BeforeClass
	public void invokeBrowser() throws Exception {
		browserType = configProperties.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);
		cmnDriver.setPageloadTimeout(60);
		cmnDriver.setElementDetectionTimeout(1000000);
		cmnDriver.navigateToUrl(url);
		driver = cmnDriver.getDriver();
		homePage = new HomePage(driver);
		homePage.closeInitialButton();
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowser();
	}
}
