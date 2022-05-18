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
	String baseUrl;
	HomePage homePage;
	private WebDriver driver;
	
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	
	int pageloadtimeout;
	int elementDetectionTimeout;
	static {
		
	
		try {
			currentWorkingDirectory = System.getProperty("user.dir");
			configFileName =  String.format("%s/config/config.properties",currentWorkingDirectory);
			configProperties = ConfigFileUtils.readProperties(configFileName);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@BeforeClass
	public void invokeBrowser() throws Exception {
		browserType = configProperties.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);
		
		pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		cmnDriver.setPageloadTimeout(pageloadtimeout);		
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);
		
		baseUrl = configProperties.getProperty("baseUrl");
		cmnDriver.navigateToUrl(baseUrl);
		driver = cmnDriver.getDriver();
		homePage = new HomePage(driver);
		homePage.closeInitialButton();
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		cmnDriver.closeAllBrowser();
	}
}
