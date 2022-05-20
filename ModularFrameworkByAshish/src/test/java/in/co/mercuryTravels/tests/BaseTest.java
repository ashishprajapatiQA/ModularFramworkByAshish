package in.co.mercuryTravels.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import in.co.mercuryTravels.pages.HomePage;

public class BaseTest {

	// Initialize home page like basic thing driver, url,browser type , open/close
	// (everytime je basic details repeat/reuse/required karvani hoy te )
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

	String screenshotFilename;
	ScreenshotControl screenshotControl;

	static {

		try {
			// configuration file access code
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

		initializeReports();

	}

	@BeforeClass
	public void setup() throws Exception {

		invokeBrowser();
		getDriverInstance();
		initializeApplicationPages();
		initializeScreenshotVariable();
		closeInitialButtonOnHomepage();

	}

	@AfterClass
	public void cleanUp() throws Exception {
		closeAllBrowserInstances();

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();

		String screenShoFilename = String.format("%s/screenshot/%s-%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartDate);

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test case pass " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test case fail " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);
		} else {
			extentTest.log(Status.SKIP, "Test case skipped " + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenShoFilename);
			extentTest.addScreenCaptureFromPath(screenShoFilename);
		}
	}

	@AfterSuite
	public void postCleanUp() {
		extent.flush();
	}

	private void initializeReports() {
		// TODO Auto-generated method stub
		// report code
		reportFilename = String.format("%s/reports/MercuryTravelTestReport-%s.html", currentWorkingDirectory,
				executionStartDate);
		htmlReporter = new ExtentHtmlReporter(reportFilename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	private void invokeBrowser() throws Exception {
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
	}

	private void getDriverInstance() throws Exception {
		driver = cmnDriver.getDriver();

	}

	private void initializeApplicationPages() {
		extentTest.log(Status.INFO, "Initializing all pages"); // report log
		homePage = new HomePage(driver);
	}

	private void initializeScreenshotVariable() {
		screenshotControl = new ScreenshotControl(driver); // we need driver instance for it so we declare here

	}

	private void closeInitialButtonOnHomepage() throws Exception {
		homePage.closeInitialButton();

	}

	private void closeAllBrowserInstances() throws Exception {
		cmnDriver.closeAllBrowser();
		extentTest = extent.createTest("Clean up - Clean process");
		extentTest.log(Status.INFO, "Closing all browser instances"); // report log

	}
}
