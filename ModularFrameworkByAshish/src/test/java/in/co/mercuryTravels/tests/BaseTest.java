package in.co.mercuryTravels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import in.co.mercuryTravels.pages.HomePage;

public class BaseTest {

	// Initialize home page like basic thing driver, url,browser type , open/close
	// browser

	CommonDriver cmnDriver;
	String browserType;
	String baseUrl;
	HomePage homePage;
	private WebDriver driver;

	// configuration file data fetch
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;

	int pageloadtimeout;
	int elementDetectionTimeout;

	// reports
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest extentTest;

	String reportFilename;

	static {

		try {
			currentWorkingDirectory = System.getProperty("user.dir");
			executionStartDate = DateUtils.getCurrentDateAndTime();
			configFileName = String.format("%s/config/config.properties", currentWorkingDirectory);
			configProperties = ConfigFileUtils.readProperties(configFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@BeforeSuite
	public void preSetup() {
		reportFilename = String.format("%s/reports/MercuryTravelTestReport-%s.html", currentWorkingDirectory,
				executionStartDate);
		htmlReporter = new ExtentHtmlReporter(reportFilename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass
	public void setup() throws Exception {
		extentTest = extent.createTest("Setup = set up the pre-requiesit to run automated test cases");

		browserType = configProperties.getProperty("browserType");
		extentTest.log(Status.INFO, "Browser invoked is " + browserType); // report log
		cmnDriver = new CommonDriver(browserType);

		pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
		extentTest.log(Status.INFO, "Page Load Timeout is " + pageloadtimeout); // report log
		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));
		extentTest.log(Status.INFO, "Implicit wait set is " + elementDetectionTimeout); // report log
		cmnDriver.setPageloadTimeout(pageloadtimeout);
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		baseUrl = configProperties.getProperty("baseUrl");
		extentTest.log(Status.INFO, "Base URL where the browser navigates to -" + baseUrl); // report log
		cmnDriver.navigateToUrl(baseUrl);
		driver = cmnDriver.getDriver();
		extentTest.log(Status.INFO, "Initializing all pages"); // report log
		homePage = new HomePage(driver);
		homePage.closeInitialButton();
	}

	@AfterClass
	public void cleanUp() throws Exception {
		cmnDriver.closeAllBrowser();
		extentTest = extent.createTest("Clean up - Clean process");
		extentTest.log(Status.INFO, "Closing all browser instances"); // report log
	}

	@AfterSuite
	public void postCleanUp() {
		extent.flush();
	}

}
